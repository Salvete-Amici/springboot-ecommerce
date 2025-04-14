package com.ecommerce.springboot.service;

import com.ecommerce.springboot.payload.CartDTO;
import jakarta.transaction.Transactional;

import java.util.List;

public interface CartService {
    public CartDTO addProductToCart(Long productId, Integer quantity);

    List<CartDTO> getAllCarts();

    CartDTO getCart(String emailID, Long cartID);

    @Transactional // if any part of the method fails, the transaction will be rolled back, ensuring data integrity
    CartDTO updateProductQuantityInCart(Long productId, Integer quantity);

    String deleteProductFromCart(Long cartId, Long productId);

    void updateProductInCarts(Long cartId, Long productId);
}
