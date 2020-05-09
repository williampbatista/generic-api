package br.com.tarz.genericapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import br.com.tarz.genericapi.converter.CustomerConverter;
import br.com.tarz.genericapi.entity.Customer;
import br.com.tarz.genericapi.filter.CustomerFilter;
import br.com.tarz.genericapi.repository.CustomerRepository;
import br.com.tarz.genericapi.resource.CustomerResource;
import br.com.tarz.genericapi.specification.CustomerSpecification;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;

	public Iterable<CustomerResource> findAll() {
		return CustomerConverter.toListDto(repository.findAll());
	}

	public Optional<CustomerResource> findOne(Integer id) {
		return CustomerConverter.toOptionalDto(repository.findById(id));
	}

	public Page<CustomerResource> findByFilter(CustomerFilter filter, Pageable pageable) {
		return repository.findAll(getSpecification(filter), pageable).map(Customer -> CustomerConverter.toDto(Customer)); 
	}

	public CustomerResource save(CustomerResource dto){
		return CustomerConverter.toDto(repository.save(CustomerConverter.toEntity(dto)));
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	private Specification<Customer> getSpecification(CustomerFilter filter) {
		if (filter != null) {
			Specification<Customer> spec = Specification.where((filter.getId() == null) ? null : CustomerSpecification.isNotNullId());
			spec = (filter.getId() == null) ? spec : spec.and(CustomerSpecification.equalId(filter.getId()));
			spec = (CollectionUtils.isEmpty(filter.getIds()) ? spec : spec.and(CustomerSpecification.inIds(filter.getIds())));
			spec = (filter.getDocument() == null)  ? spec : spec.and(CustomerSpecification.equalDocument(filter.getDocument()));
			spec = (StringUtils.isEmpty(filter.getName())) ? spec : spec.and(CustomerSpecification.likeName(filter.getName()));
			spec = (StringUtils.isEmpty(filter.getTradeName())) ? spec : spec.and(CustomerSpecification.likeTradeName(filter.getTradeName()));			
			
			return spec;
		}
		return null;
	}
	

}
