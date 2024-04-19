package com.jonathan.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.UUID;

/**
 * Alibaba Cloud OSS tools
 */
@Component
public class AliOSSUtils {

//    @Value("${aliyun.oss.endpoint}")
//    private String endpoint ;
//    @Value("${aliyun.oss.accessKeyId}")
//    private String accessKeyId ;
//    @Value("${aliyun.oss.accessKeySecret}")
//    private String accessKeySecret ;
//    @Value("${aliyun.oss.bucketName}")
//    private String bucketName ;

    @Autowired
    private AliOSSProperties aliOSSProperties;

    /**
     * Implement uploading image to OSS
     */
    public String upload(MultipartFile file) throws IOException {
        //Get Alibaba Cloud OSS parameters
        String endpoint = aliOSSProperties.getEndpoint();
        String accessKeyId = aliOSSProperties.getAccessKeyId();
        String accessKeySecret = aliOSSProperties.getAccessKeySecret();
        String bucketName = aliOSSProperties.getBucketName();

        // Get the input stream of the uploaded file
        InputStream inputStream = file.getInputStream();

        // Avoid file overwriting
        String originalFilename = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));

        //Upload files to OSS
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(bucketName, fileName, inputStream);

        //File access path
        String url = endpoint.split("//")[0] + "//" + bucketName + "." + endpoint.split("//")[1] + "/" + fileName;
        //Close ossClient
        ossClient.shutdown();
        return url;//Return the path uploaded to oss
    }

}
