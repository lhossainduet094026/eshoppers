package com.lokman.shoppingcart.service;

import com.lokman.shoppingcart.domain.Cart;
import com.lokman.shoppingcart.domain.User;

public interface CartService {
Cart getCartByUser(User currentUser);
}
