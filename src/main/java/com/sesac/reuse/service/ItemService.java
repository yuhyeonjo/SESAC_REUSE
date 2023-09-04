package com.sesac.reuse.service;

import com.sesac.reuse.model.entity.ItemImage;
import com.sesac.reuse.repository.CategoryRepository;
import com.sesac.reuse.model.entity.Item;
import com.sesac.reuse.repository.ItemImageRepository;
import com.sesac.reuse.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ItemService {

    private final CategoryRepository categoryRepository;
    private final ItemRepository itemRepository;
    private final ItemImageRepository itemImageRepository;


    @Value("${com.sesac.reuse.upload.path}")// import 시에 springframework으로 시작하는 Value
    private String uploadPath;

    @Autowired
    public ItemService(CategoryRepository categoryRepository, ItemRepository itemRepository, ItemImageRepository itemImageRepository) {
        this.categoryRepository = categoryRepository;
        this.itemRepository = itemRepository;
        this.itemImageRepository = itemImageRepository;
    }

    // 카테고리별 아이템 조회
//    public List<Item> getItemsByCategoryId(String category_id) {
//        return itemRepository.getItemsByCategoryId(category_id);
//    }

    // 아이템 조회
    public Item getItem(String itemId) {
        Optional<Item> item = itemRepository.findById(itemId);
        Optional<ItemImage> itemImage = itemImageRepository.findByItemId(itemId);
        if (item.isPresent()) {
            return item.get();
        } else {
            throw new RuntimeException();
        }
    }


    // 아이템 생성
    public Item createItem(Item item) {

        Item newItem = Item.builder()
                .id(item.getId())
                .name(item.getName())
                .recyclable(item.getRecyclable())
                .recycleInfo(item.getRecycleInfo())
                .category(item.getCategory())
                .createdAt(LocalDateTime.now())
                .build();

        return itemRepository.save(newItem);
    }


    // 아이템 수정
    public Item updateItem(Item item) {
        Optional<Item> optional = itemRepository.findById(item.getId());

        return optional.map(entityItem -> {
                    // data -> update
                    entityItem.setId(item.getId())
                            .setName(item.getName())
                            .setRecycleInfo(item.getRecycleInfo())
                            .setRecyclable(item.getRecyclable())
                            .setCategory(item.getCategory());
                    return itemRepository.save(entityItem);
                })
                .orElseThrow(() -> new RuntimeException("Update error"));
    }


    // 아이템 삭제
    public void deleteItem(String item_id) {
        itemRepository.deleteById(item_id);
    }

    // 아이템 목록 조회
    public Page<Item> getList(int page) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createdAt");
        Pageable pageable = PageRequest.of(page, 10, sort);
        return itemRepository.findAll(pageable);
    }
    
    // 이미지 파일 조회
//    public ItemImage getItemImage(String item_id) {
//        Optional<ItemImage> itemImage = itemImageRepository.findByItemId(item_id);
//        if (itemImage.isPresent()) {
//            return itemImage.get();
//        } else {
//            throw new RuntimeException();
//        }
//    }

    //

}
