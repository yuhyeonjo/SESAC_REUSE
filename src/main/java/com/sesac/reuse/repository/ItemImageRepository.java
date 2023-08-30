package com.sesac.reuse.repository;

import com.sesac.reuse.model.entity.ItemImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemImageRepository extends JpaRepository<ItemImage, Long> {
    
    // 아이템 이미지 조회
//    @Query("SELECT i FROM ItemImage i WHERE i.item = :item_id")
//    Optional<ItemImage> findByItemId(@Param("item_id") String item_id);

}
