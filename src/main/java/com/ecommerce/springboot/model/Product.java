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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    @NotBlank
    @Size(min=3, message="Product name must contain at least 3 characters")
    private String productName;
    private String image;
    @NotBlank
    @Size(min=3, message="Product description must contain at least 3 characters")
    private String description;
    private Integer quantity;
    private double price;
    private double discount;
    private double specialPrice;
    @ManyToOne
    @JoinColumn(name = "category_id") // so this is saying the Product class is the owning class, it holds the foreign key in column named category_id
    private Category category;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User user;

    @OneToMany(mappedBy = "product", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private List<CartItem> products = new ArrayList<>();
}
