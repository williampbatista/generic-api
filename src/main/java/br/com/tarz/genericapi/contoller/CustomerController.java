package br.com.tarz.genericapi.contoller;

import java.net.URI;

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
	CustomerService service;

	@GetMapping
	public Page<CustomerResource> get(CustomerFilter filter, Pageable pageable) {
		Page<CustomerResource> customers = service.findByFilter(filter, pageable);
		return customers;
	}

	@GetMapping(value="/{id}")
	public ResponseEntity<CustomerResource> get(@PathVariable Integer id){
		CustomerResource  resource = service.findOne(id).get();
		return ResponseEntity.ok(resource);
	}

	@PostMapping
	public ResponseEntity<CustomerResource> post(@Valid @RequestBody CustomerResource resource,
			UriComponentsBuilder uriBuilder) {
		resource.setId(1);
		URI path = uriBuilder.path("/api/customer/{id}").buildAndExpand(resource.getId()).toUri();
		return ResponseEntity.created(path).body(resource);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CustomerResource> put(@RequestBody CustomerResource resource, @PathVariable Integer id) {
		return ResponseEntity.ok().body(resource);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable Integer id) {
		return ResponseEntity.ok().build();
	}

}
