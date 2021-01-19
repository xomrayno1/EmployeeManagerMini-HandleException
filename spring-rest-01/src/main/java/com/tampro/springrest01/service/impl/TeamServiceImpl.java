package com.tampro.springrest01.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.springrest01.entity.Team;
import com.tampro.springrest01.model.request.CreateTeamRequest;
import com.tampro.springrest01.repository.TeamRepository;
import com.tampro.springrest01.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService{
	@Autowired
	TeamRepository teamRepo;
	
	@Override
	public Team createTeam(CreateTeamRequest createTeamRequest) {
		// TODO Auto-generated method stub
		Team team = new Team();
		team.setCode(createTeamRequest.getCode());
		team.setName(createTeamRequest.getName());
		return teamRepo.save(team);
	}

	@Override
	public Team updateTeam(Team team) {
		// TODO Auto-generated method stub
		return teamRepo.save(team);
	}

	@Override
	public void deleteTeam(Team team) {
		// TODO Auto-generated method stub
		teamRepo.delete(team);
	}

	@Override
	public List<Team> getAll() {
		// TODO Auto-generated method stub
		return teamRepo.findAll();
	}

	@Override
	public Team getById(long id) {
		// TODO Auto-generated method stub
		return teamRepo.findById(id).orElse(null);
	}

 

	@Override
	public boolean isTeamExistsByCode(String code) {
		// TODO Auto-generated method stub
		return (teamRepo.findByCode(code) != null) ? true : false ; 
	}

}
