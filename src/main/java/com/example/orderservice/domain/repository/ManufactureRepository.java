package com.example.orderservice.domain.repository;

import com.example.orderservice.domain.entity.manufacture.Manufacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufactureRepository extends JpaRepository<Manufacture, Long> {
}
