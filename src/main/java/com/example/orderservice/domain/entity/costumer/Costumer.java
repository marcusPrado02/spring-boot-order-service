package com.example.orderservice.domain.entity.costumer;

import com.example.orderservice.domain.entity.manufacture.Manufacture;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;


@AllArgsConstructor
@Getter
@Setter
@Table(name = "costumer")
@Entity
public class Costumer {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    @NotNull
    private String fisrtName;

    @Column(name = "last_name", nullable = false)
    @NotNull
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    @NotNull
    @Email
    private String email;

    @Column(name = "phone", nullable = false)
    @NotNull
    @Size(min = 10, max = 15)
    private String phone;

    // TODO: Resolve the Address, City, State, and Country classes
    @Column(name = "address", nullable = false)
    private Address address;

    @Column(name = "city", nullable = false)
    private City city;

    @Column(name = "state", nullable = false)
    private State state;

    @Column(name = "country", nullable = false)
    private Country country;

    @Column(name = "postal_code", nullable = false)
    private String postal_code;

    @Column(name = "newsletter_subscribed", nullable = false)
    private Boolean newsletter_subscribed;

    @Column(name = "loyalty_points", nullable = false)
    private int loyalty_points;

    @Column(name = "referral_code", nullable = false, unique = true)
    private String referral_code;

    @Column(name = "referred_by", nullable = false)
    private String referred_by;

    public Manufacture CopyObject(Manufacture manufacture) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, Manufacture.class);
    }

}