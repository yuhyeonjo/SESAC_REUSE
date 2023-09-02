package com.sesac.reuse.controller;

import com.sesac.reuse.model.entity.Category;
import com.sesac.reuse.model.entity.Item;
import com.sesac.reuse.service.CategoryService;
import com.sesac.reuse.service.ItemCustomIdSevice;
import com.sesac.reuse.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ItemCustomIdSevice itemCustomIdSevice;

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
    public String deleteItem(@PathVariable("item_id") String itemId){
        itemService.deleteItem(itemId);
        return "redirect:/item";
    }

    // 아이템 추가
    @GetMapping("/register")
    public String addItem(Model model){
        List<Category> categories = categoryService.getCategoryList();
        Map<String, String> itemCustomIdList = itemCustomIdSevice.getItemCustomIdList();
        model.addAttribute("categories", categories);
        model.addAttribute("itemCustomIdList", itemCustomIdList);
        return "admin/addItem";
    }

    @PostMapping("/register")
    public String addItem(Item item){
        itemService.createItem(item);
        return "redirect:/item";
    }

    // 아이템 수정 페이지 이동
    @GetMapping("/update/{item_id}")
    public String updateItem(@PathVariable("item_id") String item_id, Model model){
        Item itemDetail = itemService.getItem(item_id);
        List<Category> categories = categoryService.getCategoryList();
        Map<String, String> itemCustomIdList = itemCustomIdSevice.getItemCustomIdList();
        model.addAttribute("categories", categories);
        model.addAttribute("itemCustomIdList", itemCustomIdList);
        model.addAttribute("itemDetail", itemDetail);
        return "admin/itemUpdate";
    }

    // 아이템 수정
//    @PostMapping("/update/{item_id}")
//    public String updateItem(@PathVariable("item_id") String item_id, Item updateItem){
//        updateItem.setCreated_at(LocalDateTime.now());
////        System.out.println(itemId);
////        System.out.println(updateItem.getItem_id());
////        System.out.println(updateItem.getItem_name());
////        System.out.println(updateItem.getCategory());
////        System.out.println(updateItem.getRecyclable());
////        System.out.println(updateItem.getRecycle_info());
////        System.out.println(updateItem.getCreated_at());
//        System.out.println("ItemController.updateItem" + updateItem);
//        Item item = itemService.updateItem(updateItem);
//        return "redirect:/item/detail/" + item.getItem_id();
//    }


}
