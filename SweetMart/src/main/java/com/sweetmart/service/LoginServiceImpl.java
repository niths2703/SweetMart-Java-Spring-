package com.sweetmart.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sweetmart.dto.LoginDTO;
import com.sweetmart.exception.LoginException;
import com.sweetmart.model.Administrator;
import com.sweetmart.model.CurrentUserSession;
import com.sweetmart.model.Customer;
import com.sweetmart.model.User;
import com.sweetmart.repo.AdminDao;
import com.sweetmart.repo.CustomerDao;
import com.sweetmart.repo.SessionDao;
import com.sweetmart.repo.UserDao;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private CustomerDao cDao;
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private SessionDao sDao;
	
	@Override
	public String logIntoAccount(LoginDTO dto)throws LoginException{
		
		
		Optional<User> existingUser = userDao.findByMobile(dto.getMobile());
		
		if(!existingUser.isPresent()) {
			
			throw new LoginException("Please Enter a valid mobile number");
		}
		
		Optional<CurrentUserSession> currenrsession = sDao.findById(existingUser.get().getUserID());
		
		if(currenrsession.isPresent()) {
			throw new LoginException("User already Logged In with this number");
		}
		
		if(existingUser.get().getPassword().equals(dto.getPassword())) {
			
			String key;
			
			if(dto.getType().equals("Admin")) {
				key= RandomString.make(6);				
			}
			
			else {
				 key= RandomString.make(4);
			}
			
			CurrentUserSession curr = new CurrentUserSession(existingUser.get().getUserID(),key,existingUser.get().getType(),LocalDateTime.now());
			
			sDao.save(curr);

			return curr.toString();
		}
		
		else throw new LoginException("Please Enter a valid password");
	}

	@Override
	public String logOutFromAccount(String key)throws LoginException {
		
		CurrentUserSession validCustomerSession = sDao.findByUuid(key);
		
		
		if(validCustomerSession == null) {
			throw new LoginException("User Not Logged In with this number");
			
		}
		
		sDao.delete(validCustomerSession);
		
		return "Logged Out !";
	}
	
	
	
	
	@Override
	public User checkForCrendentialsService(String key) throws LoginException {
		// TODO Auto-generated method stub
       CurrentUserSession currentUserSession =  sDao.findByUuid(key);
		 
		 if(currentUserSession != null) {   
			      Optional<User> user  =   userDao.findById(currentUserSession.getUserId());
			        if(user != null) {
			        	   return  user.get();
			        }else {
			        	 throw new LoginException("You are not logined Yet !");
			        }
		 }else {
			    throw new LoginException("You are not logined Yet !");
		 }
		 
	        
	}

}
