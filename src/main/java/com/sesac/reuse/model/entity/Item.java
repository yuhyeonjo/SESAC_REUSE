package com.sesac.reuse.model.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

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
    @Column(name= "item_id")
    private String id;

    @Column(name = "item_name")
    private String name;

    @Column(name = "recycle_info")
    private String recycleInfo;

    private Boolean recyclable;

    private LocalDateTime createdAt;

    @ManyToOne // Item N : 1 Category
    @JoinColumn(name = "category_id")
    @Enumerated(EnumType.STRING)
    private Category category;


    @OneToOne(mappedBy = "item", cascade = CascadeType.ALL)
    private ItemImage itemImage;


}
