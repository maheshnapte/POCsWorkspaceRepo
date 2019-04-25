package springrestAr.com.mah;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import springrestAr.com.mah.model.Customer;

@Component
public class CustomerDAOImpl implements CustomerDAO {

	JdbcTemplate jdbcTemplate;

	private final String SQL_FIND_CUSTOMER = "select * from CUSTOMER1 where CUSTOMER_ID = ?";
	private final String SQL_DELETE_CUSTOMER = "delete from CUSTOMER1 where CUSTOMER_ID = ?";
	private final String SQL_UPDATE_CUSTOMER = "update CUSTOMER1 set first_name = ?, last_name = ?, age  = ? where id = ?";
	private final String SQL_GET_ALL = "select * from CUSTOMER1";
	private final String SQL_INSERT_CUSTOMER = "insert into CUSTOMER1(CUSTOMER_ID, CUSTOMER_NAME, ADDR_FK, WALLET_FK) values(?,?,?,?)";

	
	@Autowired
	public CustomerDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
/*	public Person getPersonById(Long id) {
		
		//jdbcTemplate.up
		return jdbcTemplate.queryForObject(SQL_FIND_PERSON, new Object[] { id }, new PersonMapper());
	}

	public List<Person> getAllPersons() {
		List<Person> personList = jdbcTemplate.query(SQL_GET_ALL, new PersonMapper());
		System.out.println("personList: " + personList);
		return personList;
	}*/
	
	
	@Override
	public Customer getCustomerById(Integer id) {
		// TODO Auto-generated method stub
		//return jdbcTemplate.queryForObject(SQL_FIND_CUSTOMER, new Object[] { id }, new CustomrMapper());
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer> customerList = jdbcTemplate.query(SQL_GET_ALL, new CustomerMapper());
		System.out.println("customerList: " + customerList);
		return customerList;
	}

	@Override
	public boolean deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(SQL_INSERT_CUSTOMER, customer.getId(), customer.getName(), customer.getAddressId(),
				customer.getWalletId()) > 0;		
	}

}
