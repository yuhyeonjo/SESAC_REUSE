package com.sesac.reuse;

import com.sesac.reuse.model.entity.Category;
import com.sesac.reuse.model.entity.Item;
import com.sesac.reuse.model.idgenerator.ItemCustomIdGenerator;
import com.sesac.reuse.service.ItemService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureHttpGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static com.sesac.reuse.model.enumType.CategoryId.A;
import static com.sesac.reuse.model.enumType.CategoryId.B;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ItemServiceTest {


    @Autowired
    private ItemService itemService;


    // 아이템 조회
//    @Test
//    public void getItem() {
//        Optional<Item> item = itemService.getItem("A001");
//        // Optional 객체가 값을 가지고 있다면 true, 값이 없다면 false 리턴
//        Assertions.assertTrue(item.isPresent());
//    }
//
//    // 아이템 목록 조회
//    @Test
//    public void getItemList() {
//        List<Item> itemList = itemService.getItemList();
//        assertThat(itemList).hasSize(306);
//    }

    // 카테고리별 아이템 조회
//    @Test
//    public void getItemsByCategory() {
//        List<Item> itemList = itemService.getItemsByCategoryId("A");
//        assertThat(itemList).hasSize(46);
//    }

    // 아이템 추가
//    @Test
//    public void createItem() {
//        Item newItem = new Item();
//        newItem.setItem_id("A047");
//        newItem.setItem_name("A047 name");
//        newItem.setRecyclable(Boolean.TRUE);
//        newItem.setRecycle_info("A047 info");
//        newItem.setCategory(Category.builder().category_id(A).build());
//
//        itemService.createItem(newItem);
//        Assertions.assertNotNull(newItem);
//    }


    // 아이템 수정
//    @Test
//    public void updateItem() {
//        Item updateItem = new Item();
//        updateItem.setItem_id("A047");
//        updateItem.setItem_name("A047 name");
//        updateItem.setRecyclable(Boolean.TRUE);
//        updateItem.setRecycle_info("A047 수정2 info");
//        updateItem.setCategory(Category.builder().category_id(B).build());
//
//        itemService.updateItem(updateItem);
//        Assertions.assertNotNull(updateItem);
//    }


    // 아이템 삭제
//    @Test
//    public void deleteItem() {
//        itemService.deleteItem("A047");
//    }
    

}
