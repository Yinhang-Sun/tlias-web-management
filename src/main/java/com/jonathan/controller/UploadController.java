package com.jonathan.controller;

import com.jonathan.pojo.Result;
import com.jonathan.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    @Autowired
    private AliOSSUtils aliOSSUtils;

    //Local Storage
    @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
        log.info("File upload: {}, {}, {}", username, age, image);
        //Get the original file name
        String originalFilename = image.getOriginalFilename();

        //Construct the unique filename, uuid
        int index = originalFilename.lastIndexOf(".");
        String extname = originalFilename.substring(index);
        String newFileName = UUID.randomUUID().toString() + extname;
        log.info("New file name: {}", newFileName);

        //Store the file in the server's disk directory: /Users/yinhang_sun/Downloads/img/
        image.transferTo(new File("/Users/yinhang_sun/Downloads/img/" + newFileName));

        return Result.success();
    }

//    //Alibaba Cloud OSS
//    @PostMapping("/upload")
//    public Result upload(MultipartFile image) throws IOException {
//        log.info("File upload, file name: {}", image.getOriginalFilename());
//
//        //Call Alibaba Cloud OSS tool class to upload files
//        String url = aliOSSUtils.upload(image);
//        log.info("File upload completed, url for file access: {}", url);
//
//        return Result.success(url);
//    }
}
