package za.co.kholofelo.testing.cucumber.service;

import za.co.kholofelo.testing.cucumber.entity.Customer;

import java.util.List;

/**
 * Created by Kholofelo Maloma on 07  October  2015.
 */
public interface CustomerService {

    void addCustomer(Customer customer);

    Customer getCustomer(long id);
    List<Customer> getAllCustomers();

    List<Customer> getCustomerWithAgeBetween(int minAge , int maxAge);
}
