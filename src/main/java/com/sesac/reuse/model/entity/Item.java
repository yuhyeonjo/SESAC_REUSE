package com.sesac.reuse.model.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

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

    private LocalDateTime createdAt;

    @ManyToOne // Item N : 1 Category
    @JoinColumn(name = "category_id")
    @Enumerated(EnumType.STRING)
    private Category category;



//    @OneToOne(mappedBy = "item", cascade = CascadeType.ALL)
//    private ItemImage itemImage;


}
