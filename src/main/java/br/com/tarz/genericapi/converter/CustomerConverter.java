package br.com.tarz.genericapi.converter;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import br.com.tarz.genericapi.entity.Customer;
import br.com.tarz.genericapi.resource.CustomerResource;
import lombok.var;

public class CustomerConverter {
	public static CustomerResource toDto(final Customer entity) {
		if (entity != null) {
			final var dto = new CustomerResource();
			dto.setId(entity.getId());
			dto.setDocument(entity.getDocument());
			dto.setPersonType(entity.getPersonType());
			dto.setName(entity.getName());
			dto.setTradeName(entity.getTradeName());
			dto.setEmail(entity.getEmail());
			dto.setStatus(entity.getStatus());
			dto.setCode(entity.getCode());
			dto.setStatusId(entity.getStatus().getId());
			dto.setStatusDesc(entity.getStatus().getDescricao());
			return dto;
		}
		return null;
	}

	public static Customer toEntity(final CustomerResource dto) {
		if (dto != null) {
			var entity = new Customer();
			entity.setDocument(dto.getDocument());
			entity.setPersonType(dto.getPersonType());
			entity.setName(dto.getName());
			entity.setTradeName(dto.getTradeName());
			entity.setEmail(dto.getEmail());
			entity.setCreateDate(Calendar.getInstance().getTime());
			entity.setUpdateDate(Calendar.getInstance().getTime());
			entity.setStatus(dto.getStatus());
			entity.setCode(dto.getCode());
			return entity;
		}
		return null;
	}

	public static CustomerResource toDto(final Optional<Customer> optional) {
		return optional.isPresent() ? toDto(optional.get()) : null;
	}

	public static Optional<CustomerResource> toOptionalDto(final Optional<Customer> optional) {
		return Optional.ofNullable(toDto(optional));
	}

	public static List<CustomerResource> toListDto(final List<Customer> entities) {
		return entities.stream().map(s -> toDto(s)).collect(Collectors.toList());
	}

	public static List<CustomerResource> toListDto(final Iterable<Customer> entities) {
		return StreamSupport.stream(entities.spliterator(), false).map(s -> toDto(s)).collect(Collectors.toList());
	}

	public static List<CustomerResource> toListDto2(final Iterable<CustomerResource> entities) {
		return StreamSupport.stream(entities.spliterator(), false).collect(Collectors.toList());
	}
}
