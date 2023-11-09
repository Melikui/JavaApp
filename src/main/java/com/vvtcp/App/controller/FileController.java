package com.vvtcp.App.controller;

import com.vvtcp.App.util.JSONResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@RestController
@RequestMapping("/api")
public class FileController {
    /**
     * 文件上传
     */
    @PostMapping("/upload")
    public JSONResult upload(
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
            image.transferTo(new File("/Users/likui/Desktop/Java/file/" + imgName));
        }
        for (MultipartFile photo : photos) {
            if (!photo.isEmpty()) {
                String imgName = photo.getOriginalFilename();
                photo.transferTo(new File("/Users/likui/Desktop/Java/file/" + imgName));
            }
        }
        return JSONResult.ok("上传成功!");
    }
    @PostMapping("/download")
    public void download() {
        System.out.println("文件下载");
    }
}