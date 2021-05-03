package com.lokman.shoppingcart.repository;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import com.lokman.shoppingcart.domain.User;

public class UserRepositoryImpl implements UserRepository {

	private static final Set<User> USERS = new CopyOnWriteArraySet<>();
	@Override
	public void save(User user) {
		USERS.add(user);

	}
	@Override
	public User findByName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
