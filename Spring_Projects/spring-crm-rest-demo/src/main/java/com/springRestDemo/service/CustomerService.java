package com.springRestDemo.service;

import java.util.List;

import com.springRestDemo.DAO.ICustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springRestDemo.entity.Customer;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private ICustomerDAO ICustomerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return ICustomerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		ICustomerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		return ICustomerDAO.getCustomer(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		ICustomerDAO.deleteCustomer(id);
	}
}





