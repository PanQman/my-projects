package com.springdemo.controller.dao;

import com.springdemo.entity.Customer;
import java.util.List;

public interface ICustomerDAO {

    public List<Customer> getCustomers();

    public void insertOrUpdateCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);
}
