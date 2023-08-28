package com.sesac.reuse.model.entity;

import com.sesac.reuse.model.enumType.CategoryId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class Item {

    @Id
    private String item_id;

    private String item_name;

    private String recycle_info;

    private Boolean recyclable;

    @ManyToOne // Item N : 1 Category
    @JoinColumn(name = "category_id")
    private Category category;

}
