package br.com.tarz.genericapi.contoller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.tarz.genericapi.filter.CustomerFilter;
import br.com.tarz.genericapi.resource.CustomerResource;
import br.com.tarz.genericapi.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;

	@GetMapping
	public ResponseEntity<Page<CustomerResource>> get(CustomerFilter filter, Pageable pageable) {	
		Page<CustomerResource> customer = service.findByFilter(filter, pageable.previousOrFirst());
		return ResponseEntity.ok().body(customer);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Optional<CustomerResource>> get(@PathVariable Integer id){
		Optional<CustomerResource> customer = service.findOne(id);
		return ResponseEntity.ok(customer);
	}

	@PostMapping
	public ResponseEntity<CustomerResource> post(@Valid @RequestBody CustomerResource customer, UriComponentsBuilder uriBuilder){
		customer = service.save(customer);
		URI path = uriBuilder.path("/api/customer/{id}").buildAndExpand(customer.getId()).toUri();
		return ResponseEntity.created(path).body(customer);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CustomerResource> put(@RequestBody CustomerResource customer, @PathVariable Integer id){
		customer.setId(id);
		service.save(customer);
		return ResponseEntity.ok().body(customer);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}

}
