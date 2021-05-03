package com.lokman.shoppingcart.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.lokman.shoppingcart.domain.User;
import com.lokman.shoppingcart.dto.LoginDTO;
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
		try {
			var digest = MessageDigest.getInstance("SHA-256");
			var bytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));
			return bytesToHex(bytes);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Unable to encrypt password", e);
		}

	}

	private String bytesToHex(byte[] hash) {

		StringBuilder hexString = new StringBuilder();
		for (byte b : hash) {
			String hex = Integer.toHexString(0xff & b);
			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);

		}
		return hexString.toString();
	}

	@Override
	public User verifyUser(LoginDTO loginDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
