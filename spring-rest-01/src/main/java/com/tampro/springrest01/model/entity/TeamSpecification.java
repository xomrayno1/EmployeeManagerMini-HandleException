package com.tampro.springrest01.model.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.tampro.springrest01.entity.Team;
import com.tampro.utils.Constant;

public class TeamSpecification implements Specification<Team>{

	private final int sortKey;
	private final String searchName;
	private final boolean isAsc;
	
	public TeamSpecification(int sortKey, String searchName, boolean isAsc) {
		super();
		this.sortKey = sortKey;
		this.searchName = searchName;
		this.isAsc = isAsc;
	}

	@Override
	public Predicate toPredicate(Root<Team> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		// TODO Auto-generated method stub
		List<Predicate> predicates = new LinkedList<Predicate>();
		if(searchName != null && !searchName.trim().isEmpty()){
			String search  = "%"+searchName.trim()+"%";
			Predicate predicateSearch = criteriaBuilder.like(root.get("name"), search);
			predicates.add(predicateSearch);
		}
		Path path = null ;
		switch (sortKey) {
			case Constant.SORT_BY_TEAM_NAME:
				path = root.get("name");
				break;
			default:
				path = root.get("id");
				break;
		}
		if(isAsc) {
			query.orderBy(criteriaBuilder.asc(path));
		}else {
			query.orderBy(criteriaBuilder.desc(path));
		}
		return criteriaBuilder.and(predicates.toArray(new Predicate[] {}));
	}

}
