package com.sweetmart.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sweetmart.model.Administrator;
import com.sweetmart.model.User;

@Repository
public interface AdminDao extends JpaRepository<Administrator,Integer>{

}
