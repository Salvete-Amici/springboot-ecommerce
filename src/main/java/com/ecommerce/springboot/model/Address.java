package com.ecommerce.springboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @NotBlank
    @Size(min = 10, message = "must be at least 10 characters")
    private String street;

    @NotBlank
    @Size(min = 5, message = "must be at least 5 characters")
    private String buildingName;

    @NotBlank
    @Size(min = 5, message = "must be at least 5 characters")
    private String city;

    @NotBlank
    @Size(min = 2, message = "must be at least 2 characters")
    private String state;

    @NotBlank
    @Size(min = 2, message = "must contain at least 2 characters")
    private String country;

    @NotBlank
    @Size(min = 5, message = "must contain at least 5 characters")
    private String postalCode ;

    @ToString.Exclude
    @ManyToMany(mappedBy = "addresses")
    private List<User> users = new ArrayList<>();

    public Address(String street, String buildingName, String city, String state, String country, String postalCode) {
        this.street = street;
        this.buildingName = buildingName;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
    }
}
