package com.example.orderservice.domain.entity.order;

import com.example.orderservice.domain.entity.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "order_items")
@Entity
public class OrderItem extends BaseEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "order_id", nullable = false)
    private Long order_id;

    @Column(name = "product_id", nullable = false)
    private Long product_id;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "unit_price", nullable = false)
    private BigDecimal unit_price;

    @Column(name = "subtotal", nullable = false)
    private BigDecimal subtotal;

    @Column(name = "tax")
    private BigDecimal tax;

    @Column(name = "discount")
    private BigDecimal discount;

    @Column(name = "total", nullable = false)
    private BigDecimal total;

    // TODO: Resolve the ShippingMethod class
    @Column(name = "shipping_method", nullable = false)
    private String shipping_method;

    @Column(name = "shipping_cost", nullable = false)
    private BigDecimal shipping_cost;

    @Column(name = "shipping_date")
    private Date delivered;

    @Column(name = "delivery_date")
    private Date delivery_date;

    @Column(name = "returned", nullable = false)
    private boolean returned;

    @Column(name = "return_date")
    private Date return_date;

    // TODO: Resolve the ReturnReason class
    @Column(name = "return_reason")
    private String return_reason;

    public OrderItem CopyObject(OrderItem manufacture) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, OrderItem.class);
    }
}