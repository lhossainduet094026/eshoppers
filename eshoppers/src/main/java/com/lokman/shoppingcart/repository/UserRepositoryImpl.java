package com.lokman.shoppingcart.repository;

import java.util.Iterator;
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
		if (username != null) {
			Iterator<User> it = USERS.iterator();
			while (it.hasNext()) {
				User user = it.next();
				if (user.getFirstName().equals(username)) {
					return user;
				}
			}
		}
		return null;
	}
}
