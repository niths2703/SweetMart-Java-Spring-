package com.sweetmart.repo;

import com.sweetmart.model.SweetOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SweetOrderDao extends JpaRepository<SweetOrder ,Integer> {
}
