package com.springdemo.service;


import com.springdemo.controller.dao.ICustomerDAO;
import com.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerDAO IcustomerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return IcustomerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        IcustomerDAO.insertOrUpdateCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int id) {
        return IcustomerDAO.getCustomer(id);
    }

    @Override
    @Transactional
    public void deleteCustomer(int id) {
        IcustomerDAO.deleteCustomer(id);
    }

}
