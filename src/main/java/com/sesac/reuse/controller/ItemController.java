package com.sesac.reuse.controller;

import com.sesac.reuse.model.entity.Category;
import com.sesac.reuse.model.entity.Item;
import com.sesac.reuse.model.entity.ItemImage;
import com.sesac.reuse.service.CategoryService;
import com.sesac.reuse.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private CategoryService categoryService;

    // 아이템 목록
    @GetMapping("")
    public String getItemList(Model model, @RequestParam(value="page", defaultValue="0") int page){
        Page<Item> itemPaging = itemService.getList(page);
        model.addAttribute("itemPaging", itemPaging);
        return "admin/itemList";
    }

    // 아이템 조회
    @GetMapping("/detail/{item_id}")
    public String getItem(@PathVariable("item_id") String item_id, Model model){
        Item itemDetail = itemService.getItem(item_id);
//        ItemImage itemImage = itemService.getItemImage(item_id);
        model.addAttribute("itemDetail", itemDetail);
//        model.addAttribute("itemImage", itemImage);
        return "admin/itemDetail";
    }

    // 아이템 삭제
    @GetMapping("/remove/{item_id}")
    public String deleteItem(@PathVariable("item_id") String item_id){
        itemService.deleteItem(item_id);
        return "redirect:/item";
    }

    // 아이템 추가
    @GetMapping("/register")
    public String addItem(){
        return "admin/addItem";
    }

    // 아이템 수정 페이지 이동
    @GetMapping("/update/{item_id}")
    public String updateItem(@PathVariable("item_id") String item_id, Model model){
        Item itemDetail = itemService.getItem(item_id);
        List<Category> categories = categoryService.getCategoryList();
        model.addAttribute("categories", categories);
        model.addAttribute("itemDetail", itemDetail);
        return "admin/itemUpdate";
    }

    // 아이템 수정
    @PostMapping("/update/{item_id}")
    public String updateItem(@PathVariable("item_id") String item_id, Item updateItem){
        itemService.updateItem(updateItem);
        return "redirect:/item/detail/" + item_id;
    }


}
