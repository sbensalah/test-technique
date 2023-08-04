package test.technique.soumaya.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.technique.soumaya.core.entities.Customer;
import test.technique.soumaya.core.repositories.ICustomerRepository;
import test.technique.soumaya.dto.CustomerDto;
import test.technique.soumaya.exception.CustomerException;
import test.technique.soumaya.mappers.IMapperEntityDto;
import test.technique.soumaya.services.ICustomerService;
import test.technique.soumaya.utils.Utils;

@Service
public class CustomerServiceImpl implements ICustomerService {

    private static final String MAGIC_KEY = "Magic_key";
    private static final Integer MAJOR_AGE = 18;
    
    
	@Autowired
	ICustomerRepository customerRepository;
	
	@Autowired
	private IMapperEntityDto<Customer, CustomerDto> mapperEntityDtoCustomer;

	@Override
	public CustomerDto loadCustomerByLastName(final String last_name) throws CustomerException {
		if (last_name.isEmpty() || (last_name == null)) {
			throw new CustomerException(String.format("The last_name is empty [%s] ", last_name));
		}
		Optional<Customer> oCustomer = customerRepository.findBylast_name(last_name);
		if (!oCustomer.isPresent()) {
			throw new CustomerException(String.format("No customer with last name [%s] ", last_name));
		}
		Customer customer = oCustomer.get();
		return mapperEntityDtoCustomer.mapEntityToDto(customer);
	}
	
	@Override
	public CustomerDto updateCustomer(CustomerDto customerDto, String authorization) throws CustomerException {
		if(!authorization.equals(MAGIC_KEY)) {
			throw new CustomerException("The force is not with you !");
		}
		if((customerDto != null) &&  (customerDto.getAge() < MAJOR_AGE)) {
			throw new CustomerException(String.format("The customer is not an adult age : [%s] ", customerDto.getAge().toString()));
		}
		Optional<Customer> oCustomer = customerRepository.findById(customerDto.getCustomer_id());
		if(!oCustomer.isPresent()) {
			throw new CustomerException(String.format("No customer with id [%s] ", customerDto.getCustomer_id().toString()));
		}
		Customer customer = oCustomer.get();
		mapperEntityDtoCustomer.mapDtoToEntity( customerDto ,customer);
		Customer createdCustomer = customerRepository.save(customer);
		return mapperEntityDtoCustomer.mapEntityToDto(createdCustomer);
	}
	
	@Override
	public Double findAverageAge() {
		List<Integer> ages = StreamSupport.stream(customerRepository.findAll().spliterator(), false).map(c -> c.getAge()).collect(Collectors.toList());
		double averageAge = ages.stream().mapToDouble(d -> d).average().orElse(0.0);
		return Utils.round(averageAge,1);
	}		

}
