package za.co.kholofelo.testing.cucumber.data;

import za.co.kholofelo.testing.cucumber.entity.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kholofelo Maloma on 07  October  2015.
 */
public class CustomerManagerImpl implements CustomerManager {

    private Map<Long, Customer> database = new HashMap<>();

    @Override
    public void saveCustomer(Customer customer) {
        database.put(customer.getId(), customer);
    }

    @Override
    public List<Customer> fetchCustomers() {
        return new ArrayList<>(database.values());
    }

    @Override
    public Customer fetchCustomerWithID(long id) {
        return database.get(Long.valueOf(id));
    }

    @Override
    public List<Customer> fetchCustomerWithAges(int minAge, int maxAge) {
        List<Customer> result = new ArrayList<>();
        for (final Customer customer : database.values()) {
            if (customer.getAge() >= minAge && customer.getAge() <= maxAge) {
                result.add(customer);
            }
        }
        return result;
    }
}
