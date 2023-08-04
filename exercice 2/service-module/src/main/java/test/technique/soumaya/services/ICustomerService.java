package test.technique.soumaya.services;

import test.technique.soumaya.dto.CustomerDto;
import test.technique.soumaya.exception.CustomerException;

public interface ICustomerService {

	CustomerDto loadCustomerByLastName(final String last_name) throws CustomerException;
	
	CustomerDto updateCustomer(final CustomerDto customerDto, final String authorization) throws CustomerException;
	
	public Double findAverageAge();
	
}
