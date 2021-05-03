package com.lokman.shoppingcart.repository;

import com.lokman.shoppingcart.domain.User;

public interface UserRepository {
	void save(User user);

	User findByName(String username);
}
