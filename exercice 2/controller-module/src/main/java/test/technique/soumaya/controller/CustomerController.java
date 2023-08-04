package test.technique.soumaya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import test.technique.soumaya.dto.CustomerDto;
import test.technique.soumaya.exception.CustomerException;
import test.technique.soumaya.services.ICustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	@GetMapping({ "" })
	public ResponseEntity<CustomerDto> loadCustomer(@RequestParam(name = "last_name") String last_name)
			throws CustomerException {

		CustomerDto customerDto = customerService.loadCustomerByLastName(last_name);

		return new ResponseEntity<>(customerDto, HttpStatus.OK);
	}
	
	@PutMapping({ "/{customer_id}" })
	public ResponseEntity<CustomerDto> updateCustomer(@RequestHeader(value="key") String authorization,  @PathVariable("customer_id") Long customer_id, @RequestBody CustomerDto customerDto)
			throws CustomerException {

		customerDto.setCustomer_id(customer_id);
		CustomerDto customerUpdatedDto = customerService.updateCustomer(customerDto, authorization);

		return new ResponseEntity<>(customerUpdatedDto, HttpStatus.OK);
	}
	
	@GetMapping({ "/age/average" })
	public ResponseEntity<Double> findAverageAge() {
		
		Double average = customerService.findAverageAge();

		return new ResponseEntity<>(average, HttpStatus.OK);
	}
	
	

}
