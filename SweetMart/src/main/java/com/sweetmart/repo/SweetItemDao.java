package com.sweetmart.repo;

import com.sweetmart.model.SweetItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SweetItemDao extends JpaRepository<SweetItem,Integer> {
}
