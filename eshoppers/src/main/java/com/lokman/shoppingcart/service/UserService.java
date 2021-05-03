package com.lokman.shoppingcart.service;

import com.lokman.shoppingcart.domain.User;
import com.lokman.shoppingcart.dto.LoginDTO;
import com.lokman.shoppingcart.dto.UserDTO;

public interface UserService {
	public void saveUser(UserDTO userDTO);

	User verifyUser(LoginDTO loginDTO);

}
