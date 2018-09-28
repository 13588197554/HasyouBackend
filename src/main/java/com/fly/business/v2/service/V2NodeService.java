package com.fly.business.v2.service;

import com.fly.pojo.V2Node;
import com.fly.pojo.vo.Page;

import java.util.List;

/**
 * @author david
 * @date 03/08/18 19:34
 */
public interface V2NodeService {
    List<V2Node> findAll();

    Page findByPage(Integer p, Integer count, Page page);

    V2Node findDetail(String id, Integer p, Integer count);

    List<V2Node> searchNode(String keywords);
}
