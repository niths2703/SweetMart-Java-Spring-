package com.sweetmart.service;
import com.sweetmart.dto.LoginDTO;
import com.sweetmart.exception.LoginException;
import com.sweetmart.model.User;

public interface LoginService {
	
	public String logIntoAccount(LoginDTO dto)throws LoginException;

	public String logOutFromAccount(String key)throws LoginException;
	
	
	// check for credentials of user
	public User checkForCrendentialsService(String key) throws LoginException;
	

}
