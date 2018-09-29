package com.fly.business.file.service.impl;

import com.alibaba.fastjson.JSON;
import com.fly.business.file.service.TagService;
import com.fly.common.dao.TagDao;
import com.fly.common.dao.TagObjectDao;
import com.fly.enums.StatusEnum;
import com.fly.pojo.FlyTag;
import com.fly.util.RedisUtil;
import com.fly.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao td;
    @Autowired
    private TagObjectDao tod;
    @Autowired
    private RedisUtil jedis;

    @Value("${TAG_KEY}")
    private String CONFIG_TAG_KEY;

    @Override
    public FlyTag save(FlyTag tag) {
        // if already existed
        List<FlyTag> tags = td.findByNameAndTagType(tag.getTagName(), tag.getTagType());
        if (tags.size() > 0) {
            return tags.get(0);
        }

        String pid = tag.getPid();
        if (pid == null) {
            pid = "0";
        }

        tag.setId(Util.getUUid());
        tag.setPid(pid);
        tag.setStatus(StatusEnum.ACTIVE.getName());
        tag.setCreateTime(Util.getCurrentSqlTimestamp());
        tag.setUpdateTime(Util.getCurrentSqlTimestamp());
        td.save(tag);

        // update into redis
        jedis.hset(CONFIG_TAG_KEY, tag.getId(), JSON.toJSON(tag).toString());

        return tag;
    }

    @Override
    public List<FlyTag> findAll() {
        if (jedis.exists(CONFIG_TAG_KEY)) {
            // from redis
            ArrayList<FlyTag> tags = new ArrayList<>();
            Map<String, String> tagJsons = jedis.hgetAll(CONFIG_TAG_KEY);
            Iterator<String> iterator = tagJsons.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                String value = tagJsons.get(key);
                tags.add(JSON.parseObject(value, FlyTag.class));
            }
            return tags;
        }

        // from mysql
        List<FlyTag> tags = td.findAll();

        // update into redis
        for (FlyTag tag : tags) {
            jedis.hset(CONFIG_TAG_KEY, tag.getId(), JSON.toJSON(tag).toString());
        }

        return tags;
    }

    @Override
    public FlyTag findById(String id) {
        if (jedis.hexists(CONFIG_TAG_KEY, id)) {
            String value = jedis.hget(CONFIG_TAG_KEY, id);
            return JSON.parseObject(value, FlyTag.class);
        }
        Optional<FlyTag> op = td.findById(id);
        if (op.isPresent()) {
            return op.get();
        }
        return null;
    }

    @Override
    public List<FlyTag> find(String tagType) {
        List<FlyTag> tags = td.findByTagType(tagType);
        Map<String, FlyTag> map = new HashMap<>();
        List<String> tagIds = new ArrayList<>();
        for (FlyTag tag : tags) {
            if ("0".equals(tag.getPid())) {
                map.put(tag.getId(), tag);
                continue;
            }

            tagIds.add(tag.getId());
        }

        List<Map<String, Object>> countArr = tod.countByIds(tagIds);
        Map<String, Long> countMap = new HashMap<>();
        countArr.forEach((Map<String, Object> m) -> {
            String id = (String) m.get("tag_id");
            Object o = m.get("COUNT(1)");
            Long value = Long.valueOf(o.toString());
            countMap.put(id, value);
        });

        for (FlyTag tag : tags) {
            if (!"0".equals(tag.getPid())) {
                Long subjectCount = countMap.get(tag.getId());
                if (subjectCount == null) {
                    subjectCount = 0L;
                }
                tag.setSubjectCount(subjectCount);
                FlyTag parent = map.get(tag.getPid());
                List<FlyTag> children = parent.getChildren();
                children.add(tag);
            }
        }
        return Util.getValuesFromMap(map);
    }

    @Override
    public void deleteById(String id) {
        if (jedis.hexists(CONFIG_TAG_KEY, id)) {
            jedis.hdel(CONFIG_TAG_KEY, id);
        }

        td.deleteById(id);
    }
}
