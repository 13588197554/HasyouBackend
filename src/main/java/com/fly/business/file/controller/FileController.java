package com.fly.business.file.controller;

import com.fly.business.file.service.FileService;
import com.fly.exception.FileUploadException;
import com.fly.pojo.FlyFile;
import com.fly.pojo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 *  file service
 */
@Controller
@RequestMapping("/file")
public class FileController extends BasicController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    @ResponseBody
    public FlyFile upload(@RequestParam("file") MultipartFile multipartFile) {
        return fileService.upload(multipartFile);
    }

    @PostMapping("/more/upload")
    @ResponseBody
    public Result uploads(@RequestParam("file") MultipartFile[] multipartFiles, Result<List<FlyFile>> result) throws FileUploadException {
        List<FlyFile> files = fileService.uploads(multipartFiles);
        return result.ok(files);
    }

    /**
     * single file limit 100M
     * @return
     */
    @PostMapping("/save")
    @ResponseBody
    public Result save(@RequestParam("file") MultipartFile multipartFile, FlyFile file) throws FileUploadException {
        Result<FlyFile> result = new Result<>();
        FlyFile flyFile = fileService.save(multipartFile, file);
        return result.ok(flyFile);
    }

    @GetMapping("/all")
    @ResponseBody
    public Result findAll() {
        Result<List> result = new Result<>();
        List<FlyFile> files = fileService.findAll();
        return result.ok(files);
    }

    @GetMapping("/getByTitle/{title}")
    @ResponseBody
    public Result findById(@PathVariable String title) {
        Result result = new Result<>();
        List<FlyFile> files = fileService.findByTitle(title);
        return result.ok(files);
    }

    @GetMapping("/getOne/{id}")
    @ResponseBody
    public Result getOne(@PathVariable("id") String id) {
        FlyFile file = fileService.findById(id);
        Result<FlyFile> result = new Result<>();
        return result.ok(file);
    }

}
