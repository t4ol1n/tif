package client;

import java.util.List;

import javax.xml.ws.Service;

import com.example.customerservice.Customer;
import com.example.customerservice.CustomerService;
import com.example.customerservice.CustomerServiceService;
import com.example.customerservice.NoSuchCustomerException;

import org.springframework.security.core.context.SecurityContextHolder;

import org.junit.Assert;

public class JaxWsClient {
    public static void main(String[] args) throws NoSuchCustomerException {
        
        CustomerServiceService customerServiceService = new CustomerServiceService();
        CustomerService customerService = customerServiceService.getCustomerServicePort();

        // Anonymous should not be able to read customers
        try {
            List<Customer> customersByName = customerService.getCustomersByName("Test");
            Customer customer = customersByName.get(0);
            Assert.fail("Anonymous should not be allowed to read customers");
        } catch (Exception e) {
            System.out.println("Anonymous request was correctly denied. Errormessage: " + e.getMessage());
        }
        
        // Alex should not be able to read customers
        CredentialsInjector.inject(customerService, "alex", "alexspassword");
        try {
            List<Customer> customersByName = customerService.getCustomersByName("Test");
            Customer customer = customersByName.get(0);
            Assert.fail("Alex should not be allowed to read customers");
        } catch (Exception e) {
            System.out.println("Alex´s request was correctly denied. Error Message: " + e.getMessage());
        }

        // Bob should be able to read customers but not to update
        CredentialsInjector.inject(customerService, "bob", "bobspassword");
        try {
            List<Customer> customersByName = customerService.getCustomersByName("Test");
            Customer customer = customersByName.get(0);
            System.out.println("Bob was able to load the customer " + customer.getName());
        } catch (Exception e) {
            Assert.fail("Bob should be allowed to read customers");
        }
        CredentialsInjector.inject(customerService, "bob", "bobspassword");
        try {
            Customer customer = new Customer();
            customerService.updateCustomer(customer );
            Assert.fail("Bob should not be allowed to update a customer");
        } catch (Exception e) {
            System.out.println("Bob´s request was correctly denied");
        }
       
        
        // Jim should be allowed to read and update customers
        CredentialsInjector.inject(customerService, "jim", "jimspassword");
        try {
            List<Customer> customersByName = customerService.getCustomersByName("Test");
            Customer customer = customersByName.get(0);
            System.out.println("Jim was able to load the customer " + customer.getName());
        } catch (Exception e) {
            Assert.fail("Jim should be allowed to read customers");
        }

        CredentialsInjector.inject(customerService, "jim", "jimspassword");
        try {
            Customer customer = new Customer();
            customerService.updateCustomer(customer );
            System.out.println("Jim was able to update the customer");
        } catch (Exception e) {
            Assert.fail("Jim should be allowed to update a customer");
        }
    }
}
