package com.sesac.reuse.service;

import com.sesac.reuse.model.entity.Item;
import com.sesac.reuse.model.entity.ItemImage;
import com.sesac.reuse.repository.ItemImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
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

//    @Transactional
//    public ItemImage saveFile(ItemImage itemImage) {
//        itemImage = ItemImage.builder()
//                .name(itemImage.getName())
//                .path(itemImage.getPath())
//                .item(Item.builder().item_id(itemImage.getItem().getItem_id()).build())
//                .build();
//        return itemImageRepository.save(itemImage);
//    }
//
//    @Transactional
//    public ItemImage getFile(Long id) {
//        ItemImage itemImage = itemImageRepository.findById(id).get();
//
////        ItemImage fileDto = FileDto.builder()
////                .id(id)
////                .origFilename(file.getOrigFilename())
////                .filename(file.getFilename())
////                .filePath(file.getFilePath())
////                .build();
//        return itemImage;
//    }



//    public void uploadFile(MultipartFile file) throws IOException {
//        if (!file.isEmpty()) {
//            ItemImage itemImage = new ItemImage();
//            itemImage.setName(file.getOriginalFilename());
//            itemImage.setPath(uploadPath);
//            itemImage.setItem(itemImage.getImage_id());
//
//            itemImageRepository.save(itemImage);
//        } else {
//            throw new IllegalArgumentException("File is empty");
//        }
//    }
}
