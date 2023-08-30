package com.sesac.reuse;

import com.sesac.reuse.model.entity.Item;
import com.sesac.reuse.model.entity.ItemImage;
import com.sesac.reuse.repository.ItemImageRepository;
import com.sesac.reuse.repository.ItemRepository;
import com.sesac.reuse.service.FileUploadService;
import com.sesac.reuse.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@SpringBootTest
public class FileUploadTest {

    @Autowired
    private ItemImageRepository itemImageRepository;

    @Autowired
    private FileUploadService fileUploadService;


    // 파일 업로드
//    @Test
//    public void uploadFile() throws IOException {
//
//        MultipartFile file = new MockMultipartFile(
//                "file",           // RequestParam 이름
//                "A001.jpg",       // 파일 이름
//                MediaType.TEXT_PLAIN_VALUE, // 파일 유형
//                "Hello, World!".getBytes() // 파일 내용
//        );
//        if (!file.isEmpty()) {
//            ItemImage itemImage = new ItemImage();
//            itemImage.setImage_name("A001.jpg");
//            itemImage.setImage_path("C:\\upload");
//            itemImage.setItem(Item.builder().item_id("A001").build());
//
//            itemImageRepository.save(itemImage);
//        } else {
//            throw new IllegalArgumentException("File is empty");
//        }
//    }

}
