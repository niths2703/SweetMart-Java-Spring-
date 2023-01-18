package com.sweetmart.service;
import com.sweetmart.dto.LoginDTO;
import com.sweetmart.exception.LoginException;

public interface LoginService {
	
	public String logIntoAccount(LoginDTO dto)throws LoginException;

	public String logOutFromAccount(String key)throws LoginException;

}
