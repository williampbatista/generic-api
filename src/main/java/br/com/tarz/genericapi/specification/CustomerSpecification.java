package br.com.tarz.genericapi.specification;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import br.com.tarz.genericapi.entity.Customer;

@SuppressWarnings("serial")
public class CustomerSpecification {
	private static final String ID = "id";
	private static final String DOCUMENT = "document";
	private static final String NAME = "name";
	private static final String TRADE_NAME = "trade_name";

	public static Specification<Customer> isNotNullId() {
		return new Specification<Customer>() {
			@Override
			public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.isNotNull(root.get(ID));
			}
		};
	}

	public static Specification<Customer> equalId(Integer id) {
		return new Specification<Customer>() {
			@Override
			public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get(ID), id);
			}
		};
	}

	public static Specification<Customer> inIds(List<Integer> ids) {
		return new Specification<Customer>() {
			@Override
			public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Expression<List<Integer>> idsExpression = root.get(ID);
				return cb.in(idsExpression).value(ids);
			}
		};
	}

	public static Specification<Customer> equalDocument(Integer document) {
		return new Specification<Customer>() {
			@Override
			public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get(DOCUMENT), document);
			}
		};
	}

	public static Specification<Customer> likeName(String name) {
		return new Specification<Customer>() {
			@Override
			public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.like(root.get(NAME), StringUtils.join("%", name, "%"));
			}
		};
	}

	public static Specification<Customer> likeTradeName(String tradeName) {
		return new Specification<Customer>() {
			@Override
			public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.like(root.get(TRADE_NAME), StringUtils.join("%", tradeName, "%"));
			}
		};
	}
}
