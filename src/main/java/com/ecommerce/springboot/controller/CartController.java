package com.ecommerce.springboot.controller;

import com.ecommerce.springboot.model.Cart;
import com.ecommerce.springboot.payload.CartDTO;
import com.ecommerce.springboot.repositories.CartRepository;
import com.ecommerce.springboot.service.CartService;
import com.ecommerce.springboot.util.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CartController {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private AuthUtil authUtil;
    @Autowired
    private CartService cartService;

    @PostMapping("/carts/products/{productId}/quantity/{quantity}")
    public ResponseEntity<CartDTO> addProductToCart(@PathVariable Long productId,
                                                    @PathVariable Integer quantity) {
        CartDTO cartDTO = cartService.addProductToCart(productId, quantity);
        return new ResponseEntity<CartDTO>(cartDTO, HttpStatus.CREATED);
    }

    @GetMapping("/carts")
    public ResponseEntity<List<CartDTO>> getCarts() {
        List<CartDTO> cartDTOs = cartService.getAllCarts();
        return new ResponseEntity<List<CartDTO>>(cartDTOs, HttpStatus.FOUND);
    }

    @GetMapping("/carts/users/cart")
    public ResponseEntity<CartDTO> getCartById(){
        String emailID = authUtil.loggedInEmail();
        Cart cart = cartRepository.findCartByEmail(emailID);
        Long cartID = cart.getCartId();
        CartDTO cartDTO = cartService.getCart(emailID, cartID);
        return new ResponseEntity<CartDTO>(cartDTO, HttpStatus.OK);
    }

    @PutMapping("/cart/products/{productId}/quantity/{operation}")
    public ResponseEntity<CartDTO> updateCartProduct(@PathVariable Long productId,
                                                     @PathVariable String operation) {

        CartDTO cartDTO = cartService.updateProductQuantityInCart(productId,
                operation.equalsIgnoreCase("delete") ? -1 : 1);

        return new ResponseEntity<CartDTO>(cartDTO, HttpStatus.OK);
    }

    @DeleteMapping("/carts/{cartID}/product/{productID}")
    public ResponseEntity<String> deleteProductFromCart(@PathVariable Long cartID,
                                                        @PathVariable Long productID) {
        String status = cartService.deleteProductFromCart(cartID, productID);

        return new ResponseEntity<String>(status, HttpStatus.OK);
    }
}
