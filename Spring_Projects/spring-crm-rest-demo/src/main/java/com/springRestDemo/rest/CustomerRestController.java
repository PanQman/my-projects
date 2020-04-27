package com.springRestDemo.rest;

import com.springRestDemo.entity.Customer;
import com.springRestDemo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private ICustomerService IcustomerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return IcustomerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){
        Customer customer = IcustomerService.getCustomer(customerId);
        if (customer == null){
            throw new CustomerNotFoundException("Customer id not found - " + customerId);
        } else
            return customer;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer){
        IcustomerService.saveCustomer(customer);
        return customer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer){
        IcustomerService.saveCustomer(customer);
        return customer;
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId){
        Customer customer = IcustomerService.getCustomer(customerId);

        if (customer == null) {
            throw new CustomerNotFoundException("Customer id not found - " + customerId);
        } else {
            IcustomerService.deleteCustomer(customerId);
            return "Deleted cutomer id - " + customerId;
        }
    }

}
