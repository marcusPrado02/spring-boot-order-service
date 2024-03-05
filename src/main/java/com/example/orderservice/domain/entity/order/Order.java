package com.example.orderservice.domain.entity.order;


import com.example.orderservice.domain.entity.manufacture.Manufacture;
import com.example.orderservice.domain.entity.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    @Id
    @Column(name = "id", nullable = false)
    private  Long Id;
    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "order_date", nullable = false)
    private Date orderDate;

    @Column(name = "total_amount", nullable = false)
    private BigDecimal totalAmount;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "shipping_address", nullable = false)
    private String shippingAddress;

    @Column(name = "billing_address", nullable = false)
    private String billingAddress;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    @Column(name = "payment_status", nullable = false)
    private String paymentStatus;

    @Column(name = "shipping_method", nullable = false)
    private String shippingMethod;

    @Column(name = "shipping_status", nullable = false)
    private String shippingStatus;

    @Column(name = "shipping_tracking_number", nullable = false)
    private String shippingTrackingNumber;

    @Column(name = "note", nullable = false)
    private String note;

    @Column(name = "discount", nullable = false)
    private BigDecimal discount;

    @Column(name = "tax", nullable = false)
    private BigDecimal tax;

    @Column(name = "shipping_fee", nullable = false)
    private BigDecimal shippingFee;

    @Column(name = "coupon_code", nullable = false)
    private String couponCode;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "delivery_date", nullable = false)
    private Date deliveryDate;

    @Column(name = "fl_delivered", nullable = false)
    private Boolean delivered;

    public Manufacture CopyObject(Manufacture manufacture) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, Manufacture.class);
    }
}