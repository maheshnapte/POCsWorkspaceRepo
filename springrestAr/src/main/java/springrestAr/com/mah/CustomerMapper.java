package springrestAr.com.mah;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import springrestAr.com.mah.model.Customer;

public class CustomerMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		customer.setId(resultSet.getInt("CUSTOMER_ID"));
		customer.setName(resultSet.getString("CUSTOMER_NAME"));
		customer.setAddressId(resultSet.getInt("ADDR_FK"));
		customer.setWalletId(resultSet.getInt("WALLET_FK"));
		
		
		return customer;
		
	}

	

}
