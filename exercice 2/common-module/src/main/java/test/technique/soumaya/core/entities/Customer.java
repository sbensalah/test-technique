package test.technique.soumaya.core.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


import lombok.Data;

@Entity
@Table(name = Customer.CUSTOMERS)
@Data
public class Customer {
	
	public static final String CUSTOMERS = "CUSTOMERS";
	
	public static final String CUSTOMERS_SEQ = "CUSTOMERS_SEQ";
	
	@Id
	@SequenceGenerator(name = CUSTOMERS_SEQ, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = CUSTOMERS_SEQ)
	private Long customer_id;
	
	private String last_name;
	
	private Integer age;
	

}
