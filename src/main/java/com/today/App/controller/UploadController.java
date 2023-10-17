package com.today.App.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@RestController
@RequestMapping("/api")
public class UploadController {
    /**
     * 文件上传
     */
    @PostMapping("/upload")
    public void upload(
            @RequestPart("file") MultipartFile file,
            @RequestPart("image") MultipartFile image,
            @RequestPart("photos") MultipartFile[] photos
    ) throws IOException {
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            file.transferTo(new File("/Users/likui/Desktop/Java/file/" + fileName));
        }
        if (!image.isEmpty()) {
            String imgName = image.getOriginalFilename();
            image.transferTo(new File("/Users/likui/Desktop/Java/file/image/" + imgName));
        }
        for (MultipartFile photo : photos) {
            if (!photo.isEmpty()) {
                String imgName = photo.getOriginalFilename();
                photo.transferTo(new File("/Users/likui/Desktop/Java/file/image/" + imgName));
            }
        }
    }
}