package com.sesac.reuse.service;

import com.sesac.reuse.repository.CategoryRepository;
import com.sesac.reuse.model.entity.Item;
import com.sesac.reuse.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final CategoryRepository categoryRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(CategoryRepository categoryRepository, ItemRepository itemRepository) {
        this.categoryRepository = categoryRepository;
        this.itemRepository = itemRepository;
    }

    // 카테고리별 아이템 조회
//    public List<Item> getItemsByCategoryId(String category_id) {
//        return itemRepository.getItemsByCategoryId(category_id);
//    }

    // 아이템 조회
    public Item getItem(String item_id) {
        Optional<Item> item = itemRepository.findById(item_id);
        if (item.isPresent()) {
            return item.get();
        } else {
            throw new RuntimeException();
        }
    }

    // 아이템 생성
    public Item createItem(Item item) {

        Item newItem = Item.builder()
                .item_id(item.getItem_id())
                .item_name(item.getItem_name())
                .recyclable(item.getRecyclable())
                .recycle_info(item.getRecycle_info())
                .category(item.getCategory())
                .build();

        return itemRepository.save(newItem);
    }


    // 아이템 수정
    public Item updateItem(Item item) {
        Optional<Item> optional = itemRepository.findById(item.getItem_id());

        return optional.map(entityItem -> {
                    // data -> update
                    entityItem.setItem_id(item.getItem_id())
                            .setItem_name(item.getItem_name())
                            .setRecycle_info(item.getRecycle_info())
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
        Pageable pageable = PageRequest.of(page, 10);
        return itemRepository.findAll(pageable);
    }

}
