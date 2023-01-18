package com.sweetmart.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sweetmart.model.CurrentUserSession;

public interface SessionDao extends JpaRepository<CurrentUserSession, Integer> {

	
	public  CurrentUserSession  findByUuid(String uuid);
}
