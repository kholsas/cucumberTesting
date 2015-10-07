package com.psybergate.testing.cucumber.data;

import com.psybergate.testing.cucumber.entity.Customer;

import java.util.List;

/**
 * Created by Kholofelo Maloma on 07  October  2015.
 */
public interface CustomerManager {
    void saveCustomer(Customer customer);
    List<Customer> fetchCustomers();

    Customer fetchCustomerWithID(long id);

    List<Customer> fetchCustomerWithAges(int minAge, int maxAge);
}
