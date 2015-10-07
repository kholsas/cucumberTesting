package customer.steps;

import com.psybergate.testing.cucumber.entity.Customer;
import com.psybergate.testing.cucumber.service.CustomerService;
import com.psybergate.testing.cucumber.service.CustomerServiceImpl;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by Kholofelo Maloma on 07  October  2015.
 */
public class CustomerSearchSteps {

    CustomerService customerService = new CustomerServiceImpl();
    Set<Customer> resultList = new HashSet<>();

    @Given(".+customer with a name '(.+)', and id number '(\\d+)', and surname '(.+)', with identity number '(.+)', and aged '(\\d+)' this year$")
    public void addCustomer(String firstName, int id, String lastName, String identity, int age) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setIdentityNumber(identity);
        customer.setAge(age);
        customerService.addCustomer(customer);
    }

    @When("^the user searches for customers with age between (\\d+) and (\\d+)$")
    public void executeSearch(int minAge, int maxAge) {
        List<Customer> customerList = customerService.getCustomerWithAgeBetween(minAge, maxAge);

        resultList.addAll(customerList);
    }

    @Then("^(\\d+) customers should have been found$")
    public void testReturnedNumberOfCustomers(final int total) {
        assertThat(resultList.size(), equalTo(total));
    }

    //customer 1 should have a name 'Kholofelo'
    @Then("customer (\\d+) should have a name '(.+)'$")
    public void verifyPositionByAge(int position, String name) {
        assertThat(((Customer)resultList.toArray()[position - 1]).getFirstName(), equalTo(name));
    }

    @When("^the user retrieves all customers$")
    public void testGetAllCustomers() {
        resultList.addAll(customerService.getAllCustomers());
    }

    @Then("^(\\d+) customers should be found$")
    public void verifyNumberOfAllCustomers(final int num) {
        assertThat(resultList.size(), equalTo(num));
    }
}
