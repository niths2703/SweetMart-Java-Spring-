package com.sweetmart.service;

import com.sweetmart.exception.LoginException;
import com.sweetmart.exception.SweetItemException;
import com.sweetmart.model.CurrentUserSession;
import com.sweetmart.model.Customer;
import com.sweetmart.model.SweetItem;
import com.sweetmart.model.SweetOrder;
import com.sweetmart.repo.CustomerDao;
import com.sweetmart.repo.SessionDao;
import com.sweetmart.repo.SweetItemDao;
import com.sweetmart.repo.SweetOrderDao;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SweetItemServiceImpl implements SweetItemService {

	@Autowired
	private SweetItemDao sweetdao;

	@Autowired
	private SessionDao sdao;

	@Autowired
	private SweetOrderDao sweetOrderDao;

	@Autowired
	private CustomerDao cDao;

	@Override
	public SweetItem addSweetItem(SweetItem s, String Customerkey){

		if (Customerkey.length() != 4) {

			throw new LoginException("key is not valid ");

		}

		CurrentUserSession loginedcustomer = sdao.findByUuid(Customerkey);

		if (loginedcustomer != null) {

			Optional<Customer> customer = cDao.findById(loginedcustomer.getUserId());

			List<SweetOrder> sweetOrderList = customer.get().getSweetOrders();

			if (sweetOrderList.size() == 0) {
				SweetOrder sd = new SweetOrder();
				sd.getSweetItems().add(s);

				sd.setCustomer(customer.get());
				sd.setOrderedDate(LocalDate.now());
				s.setSweetOrder(sd);


        //    if (sweetOrderList == null) {
//                SweetOrder sd = new SweetOrder();
//                sd.getSweetItems().add(s);
//
//                sd.setCustomer(customer.get());
//                sd.setOrderedDate(LocalDate.now());
//                s.setSweetOrder(sd);
//
//
//                SweetItem sweetItem = sweetdao.save(s);
//
//                return sweetItem;

				SweetItem sweetItem = sweetdao.save(s);

				return sweetItem;

				// sweetOrderDao.save(sd);

			} 
			else if (LocalDate.now().compareTo(sweetOrderList.get(sweetOrderList.size()-1).getOrderedDate())>0){

				SweetOrder sd = new SweetOrder();
				sd.getSweetItems().add(s);


				sd.setCustomer(customer.get());
				sd.setOrderedDate(LocalDate.now());
				s.setSweetOrder(sd);


//            } else if ((LocalDate.now().compareTo(sweetOrderList.get(sweetOrderList.size() - 1).getOrderedDate()) > 0)) {
//
//
//                SweetOrder sd = new SweetOrder();
//                sd.getSweetItems().add(s);
//
//                sd.setCustomer(customer.get());
//                sd.setOrderedDate(LocalDate.now());
//                s.setSweetOrder(sd);
//
//
//                SweetItem sweetItem = sweetdao.save(s);
//
//                return sweetItem;
//            } else if ((LocalDate.now().compareTo(sweetOrderList.get(sweetOrderList.size() - 1).getOrderedDate()) == 0)) {
//
//                sweetOrderList.get(sweetOrderList.size() - 1).getSweetItems().add(s);
//
                s.setSweetOrder(sweetOrderList.get(sweetOrderList.size() - 1));
            sweetOrderList.get(sweetOrderList.size() - 1).getSweetItems().add(s);

          //  sweetOrderDao.save(  sweetOrderList.get(sweetOrderList.size() - 1));

				SweetItem sweetItem = sweetdao.save(s);

				return sweetItem;
			} 
			else if ((LocalDate.now().compareTo(sweetOrderList.get(sweetOrderList.size() - 1).getOrderedDate()) == 0)) {

				sweetOrderList.get(sweetOrderList.size() - 1).getSweetItems().add(s);

				s.setSweetOrder(sweetOrderList.get(sweetOrderList.size() - 1));

				SweetItem sweetItem = sweetdao.save(s);
				// cDao.save(customer.get());


				return sweetItem;
			}
			
			else throw new SweetItemException("Can't be added");
		} 
		else throw new LoginException("customer not loggined first logged in ");
	}


                //cDao.save(customer.get());

                return sweetItem ;
//            }
//
//
////            SweetItem sweetItem = sweetdao.save(s);
//
//  return null ;


        } else {
            throw new LoginException("customer not loggined first logged in ");
        }


    }

    @Override
    public SweetItem UpdateSweetItem(SweetItem s, String Customerkey) throws SweetItemException {
        if (Customerkey.length() != 4) {
            throw new LoginException("key is not valid ");
        }

        CurrentUserSession loginedcustomer = sdao.findByUuid(Customerkey);

        if (loginedcustomer == null) throw new LoginException("User Not logedin");

        else {

	@Override
	public SweetItem UpdateSweetItem(SweetItem s, String Customerkey) {
		if (Customerkey.length() != 4) {
			throw new LoginException("key is not valid ");
		}

		CurrentUserSession loginedcustomer = sdao.findByUuid(Customerkey);

		if (loginedcustomer == null)
			throw new LoginException("User Not logedin");

		else {

//            Optional<SweetItem> currs = sweetdao.findById(s.getSweetItemId());
//
//            currs.get().setQuantity(s.getQuantity());
//
//            return sweetdao.save(currs.get());


            Optional<Customer> customer = cDao.findById(loginedcustomer.getUserId());

            List<SweetOrder> sweetOrderList = customer.get().getSweetOrders();

            for (SweetOrder o :
                    sweetOrderList) {

                List<SweetItem> sweetItems =  o.getSweetItems();

                for (SweetItem sItem :
                        sweetItems) {
                    if (sItem.getSweetItemId() == s.getSweetItemId()) {


                        sItem.setQuantity(s.getQuantity());

                        return sweetdao.save(sItem);


                    }


                }


            }

            throw new SweetItemException("item not found ");

			Optional<Customer> customer = cDao.findById(loginedcustomer.getUserId());

			List<SweetOrder> sweetOrderList = customer.get().getSweetOrders();

			for (SweetOrder o : sweetOrderList) {

				List<SweetItem> sweetItems = (List<SweetItem>) o.getSweetItems();

				for (SweetItem sItem : sweetItems) {
					if (sItem.getSweetItemId() == s.getSweetItemId()) {

						sItem.setQuantity(s.getQuantity());

						return sweetdao.save(sItem);

					}

				}

			}

                List<SweetItem> sweetItems =  o.getSweetItems();

			throw new SweetItemException("item not found ");

		}
	}

	@Override
	public SweetItem DeleteSweetItem(Integer SweetItemId, String Customerkey) {

		if (Customerkey.length() != 4) {
			throw new LoginException("key is not valid ");
		}

		CurrentUserSession loginedcustomer = sdao.findByUuid(Customerkey);

		if (loginedcustomer == null)
			throw new LoginException("User Not logedin");

		else {
			Optional<Customer> customer = cDao.findById(loginedcustomer.getUserId());

			List<SweetOrder> sweetOrderList = customer.get().getSweetOrders();

			for (SweetOrder o : sweetOrderList) {

				List<SweetItem> sweetItems = (List<SweetItem>) o.getSweetItems();

				for (SweetItem sItem : sweetItems) {
					if (sItem.getSweetItemId() == SweetItemId) {

						sweetdao.delete(sItem);

						return sItem;

					}

				}

			}

			throw new SweetItemException("item not found ");

		}

	}

	@Override
	public List<SweetItem> AllSweetItem(String Customerkey){

		if (Customerkey.length() != 4) {
			throw new LoginException("key is not valid ");
		}

		CurrentUserSession loginedcustomer = sdao.findByUuid(Customerkey);

		if (loginedcustomer == null)
			throw new LoginException("User Not logedin");

		else {
			Optional<Customer> customer = cDao.findById(loginedcustomer.getUserId());

			List<SweetOrder> sweetOrderList = customer.get().getSweetOrders();
			List<SweetItem> totalItemsyet = null;

			for (SweetOrder o : sweetOrderList) {

				List<SweetItem> sweetItems = (List<SweetItem>) o.getSweetItems();

				for (SweetItem sItem : sweetItems) {
					totalItemsyet.add(sItem);

				}

			}

			if (totalItemsyet.size() == 0) {
				throw new SweetItemException("not sweet item found by this customer ");
			}

			return totalItemsyet;
		}

	}

}
