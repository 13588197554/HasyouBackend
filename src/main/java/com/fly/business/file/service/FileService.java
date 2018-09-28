package com.fly.business.file.service;

import com.fly.exception.FileUploadException;
import com.fly.pojo.FlyFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    FlyFile save(MultipartFile multipartFile, FlyFile file) throws FileUploadException;

    List<FlyFile> findAll();

    FlyFile findById(String id);

    List<FlyFile> findByTitle(String title);

    FlyFile upload(MultipartFile multipartFile);

    List<FlyFile> uploads(MultipartFile[] multipartFiles) throws FileUploadException;
}
