package com.tampro.springrest01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tampro.springrest01.entity.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> , JpaSpecificationExecutor<Team>{
	@Override
	List<Team> findAll();
	
	Team findByCode(String code);
}
