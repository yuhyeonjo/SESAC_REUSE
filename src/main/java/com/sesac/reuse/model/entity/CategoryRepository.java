package com.sesac.reuse.model.entity;

import com.sesac.reuse.model.entity.Category;
import com.sesac.reuse.model.enumType.CategoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
//    Category getOne(CategoryId category_id);
}
