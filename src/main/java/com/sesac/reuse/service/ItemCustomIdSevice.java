package com.sesac.reuse.service;

import com.sesac.reuse.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemCustomIdSevice {
    @Autowired
    private ItemRepository itemRepository;

    public String generateId(String categoryId) {
        int lastId = Integer.parseInt(itemRepository.findLastItemIdByCategoryId(categoryId));
        return categoryId + String.format("%03d", lastId + 1);
    }

}
