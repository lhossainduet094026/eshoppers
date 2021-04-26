package com.lokman.shoppingcart.service;

import com.lokman.shoppingcart.domain.User;
import com.lokman.shoppingcart.dto.UserDTO;
import com.lokman.shoppingcart.repository.UserRepository;

public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public void saveUser(UserDTO userDTO) {
		String encryptedPassword = encryptPassword(userDTO.getPassword());
		User user = new User();
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setEmail(userDTO.getEmail());
		user.setPassword(encryptedPassword);
		user.setUsername(userDTO.getUsername());
		
		userRepository.save(user);
		
	}

	private String encryptPassword(String password) {
		// code will later
		return null;
	}

}
