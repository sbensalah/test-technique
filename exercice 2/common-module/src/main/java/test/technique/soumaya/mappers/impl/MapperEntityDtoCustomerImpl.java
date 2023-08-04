package test.technique.soumaya.mappers.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import test.technique.soumaya.core.entities.Customer;
import test.technique.soumaya.dto.CustomerDto;
import test.technique.soumaya.mappers.IMapperEntityDto;

@Component
public class MapperEntityDtoCustomerImpl implements IMapperEntityDto<Customer, CustomerDto>  {
	
	@Override
	public CustomerDto mapEntityToDto(Customer entity) {
		if (entity == null) {
			return null;
		}
		CustomerDto dto = new CustomerDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
    public void mapDtoToEntity(CustomerDto d, Customer e){
		
    	if(d == null) {
    		return;
    	}
    	BeanUtils.copyProperties(d, e);
	}

}
