package com.example.orderservice.domain.entity.common;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import org.jetbrains.annotations.NotNull;

import java.sql.Timestamp;

public abstract class BaseEntity {


    @Column(name = "guid", nullable = false, unique = true)
    @NotNull
    @Size(min = 36, max = 36)
    private String GUID;

    @Column(name = "created_at", nullable = false)
    @NotNull
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false)
    @NotNull
    private Timestamp updatedAt;

    @Column(name = "created_by", nullable = false)
    @NotNull
    private String createdBy;

    @Column(name = "updated_by", nullable = false)
    @NotNull
    private String updatedBy;

}