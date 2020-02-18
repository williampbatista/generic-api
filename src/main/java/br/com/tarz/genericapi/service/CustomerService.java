package br.com.tarz.genericapi.service;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.tarz.genericapi.resource.CustomerResource;

@Service
public class CustomerService {

	public Iterable<CustomerResource> findAll() {
		return null;
	}

	public Optional<CustomerResource> findOne(Integer id) {
		return null;
	}

	public Page<CustomerResource> findByFilter(Object filter, Pageable pageable) {
		return null;
	}

	public CustomerResource save(CustomerResource resource) {
		resource.setId(1);
		return resource;
	}

	public void delete(Integer id) {
	}

}
