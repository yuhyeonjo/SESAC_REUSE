package com.sesac.reuse.controller;

import com.sesac.reuse.model.entity.Item;
import com.sesac.reuse.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("") // /admin/item
    // ResponseEntity 사용해서 응답의 상태 코드, 헤더 및 본문 지정가능
    public ResponseEntity<String> createItem(@RequestBody Item item) {
        return ResponseEntity.ok("Item created successfully");
    }

    @GetMapping("{item_id}") // /admin/item/A001
    public Optional<Item> getItem(@PathVariable String item_id) {
        return itemService.getItem(item_id);
    }

    @PutMapping("") // /api/item
    public Item updateItem(@RequestBody Item item) {
        return itemService.updateItem(item);
    }

    @DeleteMapping("{item_id}") // /admin/item/A001
    public void deleteItem(@PathVariable String item_id) {
        itemService.deleteItem(item_id);
    }

    @GetMapping
    public List<Item> getItemList() {
        return itemService.getItemList();
    }

}
