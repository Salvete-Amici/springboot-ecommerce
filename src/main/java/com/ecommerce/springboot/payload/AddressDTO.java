package com.ecommerce.springboot.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
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
}
