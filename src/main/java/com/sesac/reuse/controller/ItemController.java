package com.sesac.reuse.controller;

import com.sesac.reuse.model.entity.Category;
import com.sesac.reuse.model.entity.Item;
import com.sesac.reuse.model.entity.ItemImage;
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
    @GetMapping("/detail/{itemId}")
    public String getItem(@PathVariable("itemId") String itemId, Model model){
        Item itemDetail = itemService.getItem(itemId);
        model.addAttribute("itemDetail", itemDetail);
        return "admin/itemDetail";
    }

    // 아이템 삭제
    @GetMapping("/remove/{itemId}")
    public String deleteItem(@PathVariable("itemId") String itemId){
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
    @GetMapping("/update/{itemId}")
    public String updateItem(@PathVariable("itemId") String itemId, Model model){
        Item itemDetail = itemService.getItem(itemId);
        List<Category> categories = categoryService.getCategoryList();
        Map<String, String> itemCustomIdList = itemCustomIdSevice.getItemCustomIdList();
        model.addAttribute("categories", categories);
        model.addAttribute("itemCustomIdList", itemCustomIdList);
        model.addAttribute("itemDetail", itemDetail);
        return "admin/itemUpdate";
    }

    // 아이템 수정
    @PostMapping("/update/{itemId}")
    public String updateItem(@PathVariable("itemId") String itemId, Item updateItem){
        updateItem.setCreatedAt(LocalDateTime.now());

        if(!itemId.equals(updateItem.getId())) { // 기존 item_id 와 다르면 삭제하고 다시 추가
            itemService.deleteItem(itemId);
            itemService.createItem(updateItem);
            return "redirect:/item";
        } else { // 기존 item_id 와 같으면 수정
            Item item = itemService.updateItem(updateItem);
            return "redirect:/item/detail/" + itemId;
        }

    }


}
