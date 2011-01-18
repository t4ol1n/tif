package server;

import java.util.Collections;
import java.util.List;

import javax.annotation.security.RolesAllowed;

import com.example.customerservice.Customer;
import com.example.customerservice.CustomerService;
import com.example.customerservice.NoSuchCustomerException;

public class CustomerServiceImpl implements CustomerService {

    @RolesAllowed("ROLE_ADMIN")
    @Override
    public void updateCustomer(Customer customer) {
        // TODO Auto-generated method stub
        
    }

    @RolesAllowed("ROLE_USER")
    @Override
    public List<Customer> getCustomersByName(String name) throws NoSuchCustomerException {
        Customer customer = new Customer();
        return Collections.singletonList(customer);
    }

}
