package com.tampro.springrest01.model.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.tampro.springrest01.entity.Employee;
import com.tampro.utils.Constant;

public class EmployeeSpecification implements Specification<Employee>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String searchKey;
	private final int sortKey;
	private final boolean isAscSort;
	public EmployeeSpecification(String searchKey, int sortKey, boolean isAscSort) {
		 
		this.searchKey = searchKey;
		this.sortKey = sortKey;
		this.isAscSort = isAscSort;
	}
	@Override
	public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
		// TODO Auto-generated method stub
		
		 List<Predicate> predicates = new LinkedList<>(); 

//	        // filter by customer_type
//	        if (cusTypId != null && !cusTypId.trim().isEmpty()) {
//	            Root<CustomerType> cusTypeRoot = cq.from(CustomerType.class);
//	            predicates.add(cb.equal(cusTypeRoot.get("cusTypId"), cusTypId));
//	            predicates.add(cb.equal(root.get("cusTypId"), cusTypeRoot.get("cusTypId")));
//	        }

//	        //filter by position
//	        if (posId != null && !posId.trim().isEmpty()) {
//	            Root<Position> posRoot = cq.from(Position.class);
//	            predicates.add(cb.equal(posRoot.get("posId"), posId));
//	            predicates.add(cb.equal(root.get("posId"), posRoot.get("posId")));
//	        }

//	        //filter by contractor
//	        if (conId != null && !conId.trim().isEmpty()) {
//	            Root<Contractor> conRoot = cq.from(Contractor.class);
//	            predicates.add(cb.equal(conRoot.get("conId"), conId));
//	            predicates.add(cb.equal(root.get("conId"), conRoot.get("conId")));
//	        }

	        // Search by employee by code, firstname [search key]
	        if (searchKey != null && !searchKey.trim().isEmpty()) {
	            String wrapSearch = "%" + searchKey.trim() + "%";
	            Predicate empCode = cb.like(root.get("code"), wrapSearch);
	            Predicate empName = cb.like(root.get("firstName"), wrapSearch);
	            Predicate search = cb.or(empCode, empName);
	            predicates.add(search);
	        }

	        //sort
	        Path orderClause;
	        switch (sortKey) {
	            case Constant.SORT_BY_EMPLOYEE_CODE:
	                orderClause = root.get("code");
	                break;
	            case Constant.SORT_BY_EMPLOYEE_DATE_OF_BIRTH:
	                orderClause = root.get("birthDay");
	                break;
	            default: //sort by employee firstName
	                orderClause = root.get("firstName");
	        }

	        if (isAscSort) {
	            cq.orderBy(cb.asc(orderClause));
	        } else {
	            cq.orderBy(cb.desc(orderClause));
	        }
	        return cb.and(predicates.toArray(new Predicate[]{}));
	}
	public String getSearchKey() {
		return searchKey;
	}
	public int getSortKey() {
		return sortKey;
	}
	public boolean isAscSort() {
		return isAscSort;
	}
	
	
}
