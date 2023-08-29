package com.sesac.reuse.controller;

import com.sesac.reuse.model.entity.Item;
import com.sesac.reuse.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("")
    public String getItemList(Model model, @RequestParam(value="page", defaultValue="0") int page){
        Page<Item> itemPaging = itemService.getList(page);
        model.addAttribute("itemPaging", itemPaging);
        return "admin/itemList";
    }

    @GetMapping("/detail/{item_id}")
    public String getItem(@PathVariable("item_id") String item_id, Model model){
        Item itemDetail = itemService.getItem(item_id);
        model.addAttribute("itemDetail", itemDetail);
        return "admin/itemDetail";
    }

    @GetMapping("/remove/{item_id}")
    public String deleteItem(@PathVariable("item_id") String item_id){
        itemService.deleteItem(item_id);
        return "redirect:/item";
    }

    @GetMapping("/register")
    public String addItem(){
        return "admin/addItem";
    }


}
