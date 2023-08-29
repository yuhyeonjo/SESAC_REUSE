package com.sesac.reuse.model.entity;

import com.sesac.reuse.model.enumType.CategoryId;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class Category {

    @Id
    @Enumerated(EnumType.STRING)
    private CategoryId category_id;

    private String name;

    // Category 1 : N Item
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<Item> itemList;

}
