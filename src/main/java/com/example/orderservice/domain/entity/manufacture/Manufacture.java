package com.example.orderservice.domain.entity.manufacture;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "manufacture")
@Entity
public class Manufacture {

        @Id
        @Column(name = "id", nullable = false)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "name", nullable = false)
        private String name;

        @Column(name = "email", nullable = false, unique = true)
        @Email
        private String email;

        @Column(name = "phone", nullable = false)
        @Size(min = 10, max = 15)
        private String phone;

        @Column(name = "address", nullable = false)
        private String address;

        @Column(name = "city", nullable = false)
        private String city;

        @Column(name = "state", nullable = false)
        private String state;

        @Column(name = "country", nullable = false)
        private String country;

        @Column(name = "postal_code", nullable = false)
        private String postal_code;

        @Column(name = "newsletter_subscribed", nullable = false)
        private Boolean newsletter_subscribed;

        public Manufacture CopyObject(Manufacture manufacture) {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(this, Manufacture.class);
        }
}
