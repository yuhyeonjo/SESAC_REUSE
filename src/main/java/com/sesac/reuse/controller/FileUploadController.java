package com.sesac.reuse.controller;

import com.sesac.reuse.model.entity.ItemImage;
import com.sesac.reuse.repository.ItemImageRepository;
import com.sesac.reuse.service.FileUploadService;
import com.sesac.reuse.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

//@Controller
//public class FileUploadController {
//
//    private final FileUploadService fileUploadService;
//
//    @Autowired
//    public FileUploadController(FileUploadService fileUploadService) {
//        this.fileUploadService = fileUploadService;
//    }
//
//
//    @PostMapping("/upload")
//    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
//        try {
//            fileUploadService.uploadFile(file);
//            return "upload-success"; // 업로드 성공 페이지
//        } catch (IOException e) {
//            return "upload-failure"; // 업로드 실패 페이지
//        }
//    }
//}
