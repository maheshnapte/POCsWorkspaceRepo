package springrestAr.com.mah;

import java.util.List;

import springrestAr.com.mah.model.Customer;

public interface CustomerDAO {

	Customer getCustomerById(Integer id);

	List<Customer> getAllCustomers();

	boolean deleteCustomer(Customer customer);

	boolean updateCustomer(Customer customer);

	boolean createCustomer(Customer customer);
}
