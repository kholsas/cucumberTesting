package com.psybergate.testing.cucumber.service;

import com.psybergate.testing.cucumber.data.CustomerManager;
import com.psybergate.testing.cucumber.data.CustomerManagerImpl;
import com.psybergate.testing.cucumber.entity.Customer;

import java.util.List;

/**
 * Created by Kholofelo Maloma on 07  October  2015.
 */
public class CustomerServiceImpl implements CustomerService {

    private CustomerManager customerManager = new CustomerManagerImpl();

    @Override
    public void addCustomer(Customer customer) {
        customerManager.saveCustomer(customer);
    }

    @Override
    public Customer getCustomer(long id) {
        return customerManager.fetchCustomerWithID(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerManager.fetchCustomers();
    }

    @Override
    public List<Customer> getCustomerWithAgeBetween(int minAge, int maxAge) {
        return customerManager.fetchCustomerWithAges(minAge, maxAge);
    }
}
