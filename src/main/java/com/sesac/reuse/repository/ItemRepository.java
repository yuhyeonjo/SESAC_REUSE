package com.sesac.reuse.repository;

import com.sesac.reuse.model.entity.Category;
import com.sesac.reuse.model.enumType.CategoryId;
import com.sesac.reuse.model.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {

//    // 카테고리 별 아이템 조회
//    // select * from item where category_id = ?
//    @Query("SELECT i FROM Item i WHERE i.category.category_id = :categoryId")
//    List<Item> getItemsByCategoryId(@Param("category_id") String categoryId);

    // 페이징 처리
    Page<Item> findAll(Pageable pageable);
}