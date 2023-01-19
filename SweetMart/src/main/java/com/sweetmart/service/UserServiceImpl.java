package com.sweetmart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sweetmart.exception.UserException;
import com.sweetmart.model.Administrator;
import com.sweetmart.model.CurrentUserSession;
import com.sweetmart.model.Customer;
import com.sweetmart.model.User;
import com.sweetmart.model.type;
import com.sweetmart.repo.AdminDao;
import com.sweetmart.repo.CustomerDao;
import com.sweetmart.repo.SessionDao;
import com.sweetmart.repo.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao udao;

	@Autowired
	private AdminDao adminDao;

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private SessionDao sdao;

	@Override
	public User registerUser(User user) {
		User u = udao.save(user);

		if (user.getType().equals(type.Admin)) {
			Administrator admin = new Administrator();

			admin.setId(u.getUserID());
			admin.setPassword(u.getPassword());
			admin.setUser(u);
			admin.setMobile(u.getMobile());

			adminDao.save(admin);
		} 
		else {
			Customer cus = new Customer();

			cus.setCustomerID(u.getUserID());
			cus.setMobile(u.getMobile());
			cus.setPass(u.getPassword());
			cus.setUser(u);

			customerDao.save(cus);
		}

		return u;
	}

	@Override
	public User updateuser(User user, String key) {
		CurrentUserSession currentUserSession = sdao.findByUuid(key);

		if (currentUserSession == null)
			throw new UserException("User Not logedin");

		else {
			Optional<User> user2 = udao.findById(user.getUserID());

			if (!user2.isPresent())
				throw new UserException("User Not present with this id");

			else {
				return udao.save(user);
			}
		}
	}

	@Override
	public User deleteUser(int uid, String key) {
		CurrentUserSession currentUserSession = sdao.findByUuid(key);

		if (currentUserSession == null)
			throw new UserException("User Not logedin");

		else {
			Optional<User> user = udao.findById(uid);

			if (user.isEmpty())
				throw new UserException("User Not present with this id");

			else {
				if (key.length() == 6) {
					udao.delete(user.get());
					
					return user.get();
				} 
				else throw new UserException("Only Admin can perform this task");
			}
		}
	}

	@Override
	public List<User> getAllUser(String key) {
		CurrentUserSession currentUserSession = sdao.findByUuid(key);

		if (currentUserSession == null)
			throw new UserException("Login First");

		else {
			if (key.length() == 6) {
				return udao.findAll();
			} 
			else throw new UserException("Only Admin can perform this task");
		}
	}

}
