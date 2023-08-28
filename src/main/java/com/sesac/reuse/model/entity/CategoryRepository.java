package com.sesac.reuse.model.entity;

import com.sesac.reuse.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
