package com.example.orderservice.domain.entity.product;

import com.example.orderservice.domain.entity.common.BaseEntity;
import com.example.orderservice.domain.entity.manufacture.Manufacture;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
@Entity
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "origin")
    private String origin;

    @Column(name = "category")
    private String category;

    @Column(name = "sub_category")
    private String sub_category;

    public Manufacture CopyObject(Manufacture manufacture) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, Manufacture.class);
    }
}
