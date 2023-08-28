package com.sesac.reuse;

import com.sesac.reuse.model.entity.Category;
import com.sesac.reuse.model.entity.Item;
import com.sesac.reuse.model.enumType.CategoryId;
import com.sesac.reuse.service.ItemService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static com.sesac.reuse.model.enumType.CategoryId.A;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ItemServiceTest {

    @Autowired
    private ItemService itemService;

    // 아이템 조회
//    @Test
//    public void getItem() {
//
//        Optional<Item> item = itemService.getItem("A001");
//        // Optional 객체가 값을 가지고 있다면 true, 값이 없다면 false 리턴
//        Assertions.assertTrue(item.isPresent());
//
//    }
//
//    // 아이템 목록 조회
//    @Test
//    public void getItemList() {
//        List<Item> itemList = itemService.getItemList();
//        assertThat(itemList).hasSize(306);
//    }

//    // 카테고리별 아이템 조회
//    @Test
//    public void getItemsByCategory() {
//        List<Item> itemList = itemService.getItemsByCategoryId("A");
//        assertThat(itemList).hasSize(46);
//    }




}
