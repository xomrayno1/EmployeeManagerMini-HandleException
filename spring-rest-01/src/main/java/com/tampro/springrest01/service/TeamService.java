package com.tampro.springrest01.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.tampro.springrest01.entity.Team;
import com.tampro.springrest01.model.request.CreateTeamRequest;

public interface TeamService {
	Team createTeam(CreateTeamRequest createTeamRequest);
	Team updateTeam(Team team);
	void deleteTeam(Team team);
	List<Team> getAll();
	Team getById(long id);
	Team getByCode(String code);
	boolean isTeamExistsByCode(String code);
	
	Page<Team> doPagingSortSearch(String searchName,int keySort ,boolean isAsc, int pageSize , int pageNumber );

}
