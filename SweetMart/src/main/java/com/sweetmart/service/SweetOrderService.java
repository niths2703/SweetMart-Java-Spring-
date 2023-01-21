package com.sweetmart.service;
import com.sweetmart.dto.SweetOrderDTO;
import com.sweetmart.exception.SweetOrderException;
import com.sweetmart.model.SweetOrder;
import com.sweetmart.model.User;

public interface SweetOrderService {
	
	 
	public SweetOrder createSweetOrderService(User user, SweetOrderDTO sweetOrderDTO)  throws SweetOrderException;
	
	public SweetOrder updateNewSweetItemInSweetOrderService(User user, SweetOrderDTO sweetOrderDTO) throws SweetOrderException;

//	public SweetOrder deleteSweetorderbyId(Integer id, String key);
//
//	public List<SweetOrder> getallSweetorder(String key);
//
//
//    public SweetOrder addsweetorder()
//    public SweetOrder deleteSweetorderbyId(Integer id ,String key) throws SweetOrderException, LoginException ;
//    public List<SweetOrder> getallSweetorder( String key)  throws SweetOrderException, LoginException ;
//
//    public Integer getTotalCostOfOrder(Integer id ,String key) throws SweetOrderException, LoginException ;
//	public Integer getTotalCostOfOrder(Integer id, String key);



    // add ORder service ---->
//    key ---> authenti  >> User
//       List<SweetItem>   sweetItems = new ArrayList<>()
//      List of Prodsuct and Price for each -->{ obj --> sweetItems -->
//                    SweetItemDao.save()



    //      SwettOrde sOrder ---> //

    //      SweetOrderDAO  --->

}
