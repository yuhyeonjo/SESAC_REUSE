package com.sesac.reuse;

import com.sesac.reuse.model.entity.Item;
import com.sesac.reuse.model.entity.ItemCustomKeyEntity;
import com.sesac.reuse.model.idgenerator.ItemCustomIdGenerator;
import com.sesac.reuse.repository.ItemRepository;
import com.sesac.reuse.service.ItemService;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.query.spi.QueryImplementor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import javax.persistence.Query;

import java.io.Serializable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ItemCustomIdGeneratorTest {


    private ItemCustomIdGenerator itemCustomIdGenerator;
    private SharedSessionContractImplementor session;
    private ItemCustomKeyEntity itemCustomKeyEntity;
    private Item item;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemRepository itemRepository;


    // item_id에 대한 마지막 번호 추출
//    @Test
//    public void findLastItemIdByCategoryId() {
//        Item item = itemService.getItem("A001");
//        ItemCustomKeyEntity itemCustomKeyEntity = new ItemCustomKeyEntity();
//        itemCustomKeyEntity.setId("1");
//        itemCustomKeyEntity.setItem(item);
//        Serializable id = itemCustomIdGenerator.generate(session, item);
//        System.out.println(id);
//    }


    @BeforeEach
    public void setup() {
        itemCustomIdGenerator = new ItemCustomIdGenerator();
        session = mock(SharedSessionContractImplementor.class);
        ItemCustomKeyEntity itemCustomKeyEntity = new ItemCustomKeyEntity();
        item = itemService.getItem("A001");
        itemCustomKeyEntity.setItem(item);
    }

    @Test
    public void testGenerateId() {

        // Mockito 설정
        QueryImplementor query = mock(QueryImplementor.class);
        when(session.createQuery(anyString())).thenReturn(query);
        when(query.getSingleResult()).thenReturn(1);

        Item item = itemService.getItem("A001");
        ItemCustomKeyEntity itemCustomKeyEntity = new ItemCustomKeyEntity();
        itemCustomKeyEntity.setId("1");
        itemCustomKeyEntity.setItem(item);
        Serializable id = itemCustomIdGenerator.generate(session, itemCustomKeyEntity);
        System.out.println(id);
    }

    // findLastItemIdByCategoryId 쿼리 : 카테고리별 마지막 번호 추출
    @Test
    public void queryTest() {
        int num = Integer.parseInt(itemRepository.findLastItemIdByCategoryId("A"));
        Assertions.assertEquals(num, 46);
        System.out.println(num);
    }
}
