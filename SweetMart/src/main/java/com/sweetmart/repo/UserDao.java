package com.sweetmart.repo;

import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sweetmart.model.User;

@Repository
public interface UserDao extends JpaRepository<User,Integer>{

	public Optional<User> findByMobile(String mob);
}
