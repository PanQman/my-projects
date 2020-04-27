package com.springdemo.service;

import com.springdemo.entity.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);
}
