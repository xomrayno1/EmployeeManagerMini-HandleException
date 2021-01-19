package com.tampro.springrest01.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tampro.springrest01.entity.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long>{
	@Override
	List<Team> findAll();
	
	Team findByCode(String code);
}
