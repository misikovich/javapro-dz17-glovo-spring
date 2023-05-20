package com.misikovich.javaprodz17glovospring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("order")
public class OrderEntity {
    @Id
    private Long id;
    private Date date;
    private double cost;
    private List<Long> products;

}
