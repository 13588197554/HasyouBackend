package com.fly.business.file.service.impl;

import com.fly.business.file.dao.FileDao;
import com.fly.business.file.service.FileService;
import com.fly.enums.StatusEnum;
import com.fly.exception.FileUploadException;
import com.fly.pojo.FlyFile;
import com.fly.util.FileUtil;
import com.fly.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FileServiceImpl implements FileService {

    @Autowired
    private FileDao fd;

    @Override
    public FlyFile save(MultipartFile multipartFile, FlyFile file) throws FileUploadException {
        file = FileUtil.upload(multipartFile, file);
        file.setId(Util.getUUid());
//        file.setCreateTime(Util.getCurrentSqlTimestamp());
//        file.setUpdateTime(Util.getCurrentSqlTimestamp());
        file.setStatus(StatusEnum.ACTIVE.getName());
        fd.save(file);
        return file;
    }

    @Override
    public List<FlyFile> uploads(MultipartFile[] multipartFiles) throws FileUploadException {
        ArrayList<FlyFile> files = new ArrayList<>();
        FlyFile flyFile = new FlyFile();
        for (MultipartFile file : multipartFiles) {
            flyFile = this.save(file, flyFile);
            files.add(flyFile);
        }
        return files;
    }

    @Override
    public List<FlyFile> findAll() {
        List<FlyFile> files = fd.findAll();
        return files;
    }

    @Override
    public FlyFile findById(String id) {
        Optional<FlyFile> op = fd.findById(id);
        if (op.isPresent()) {
            return op.get();
        }
        return null;
    }

    @Override
    public List<FlyFile> findByTitle(String title) {
        return fd.findByTitle(title);
    }

    @Override
    public FlyFile upload(MultipartFile multipartFile) {
        return null;
    }

}
