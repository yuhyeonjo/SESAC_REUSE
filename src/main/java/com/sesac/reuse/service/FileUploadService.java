package com.sesac.reuse.service;

import com.sesac.reuse.model.entity.ItemImage;
import com.sesac.reuse.repository.ItemImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileUploadService {

    private final ItemImageRepository itemImageRepository;

    @Value("${com.sesac.reuse.upload.path}")// import 시에 springframework으로 시작하는 Value
    private String uploadPath;

    @Autowired
    public FileUploadService(ItemImageRepository itemImageRepository) {
        this.itemImageRepository = itemImageRepository;
    }



//    public void uploadFile(MultipartFile file) throws IOException {
//        if (!file.isEmpty()) {
//            ItemImage itemImage = new ItemImage();
//            itemImage.setImage_name(file.getOriginalFilename());
//            itemImage.setImage_path(uploadPath);
//            itemImage.setImage_id(itemImage.getImage_id());
//
//            itemImageRepository.save(itemImage);
//        } else {
//            throw new IllegalArgumentException("File is empty");
//        }
//    }
}
