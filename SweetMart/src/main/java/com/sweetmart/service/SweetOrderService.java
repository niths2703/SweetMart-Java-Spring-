package com.sweetmart.service;
import com.sweetmart.model.SweetOrder;

import java.util.List;

public interface SweetOrderService {

	public SweetOrder deleteSweetorderbyId(Integer id, String key);

	public List<SweetOrder> getallSweetorder(String key);

	public Integer getTotalCostOfOrder(Integer id, String key);

}
