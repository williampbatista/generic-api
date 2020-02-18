package br.com.tarz.genericapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.tarz.genericapi.resource.CustomerResource;

@Service
public class CustomerService {

	public CustomerResource customerMok() {
		return new CustomerResource(1, 2, "document", "personType", "name", "tradeName", "email");
	}
	
	public List<CustomerResource> listCustomerMok(){
		List<CustomerResource> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(customerMok());
		}
		return list;
	}

	public Iterable<CustomerResource> findAll() {
		return listCustomerMok();
	}

	public Optional<CustomerResource> findOne(Integer id) {
		return Optional.of(customerMok());
	}

	public Page<CustomerResource> findByFilter(Object filter, Pageable pageable) {
		Page<CustomerResource> page = new PageImpl<>(listCustomerMok());
		return page;
	}

	public CustomerResource save(CustomerResource resource) {
		resource.setId(1);
		return resource;
	}

	public void delete(Integer id) {
	}

}
