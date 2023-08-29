package com.sesac.reuse.controller;

import com.sesac.reuse.model.entity.Item;
import com.sesac.reuse.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
}
