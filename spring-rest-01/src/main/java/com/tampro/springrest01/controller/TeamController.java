	package com.tampro.springrest01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tampro.springrest01.entity.Team;
import com.tampro.springrest01.exception.ApplicationException;
import com.tampro.springrest01.model.request.CreateTeamRequest;
import com.tampro.springrest01.response.APIResponse;
import com.tampro.springrest01.response.APIStatus;
import com.tampro.springrest01.service.TeamService;

@RestController
@RequestMapping("/api/v1/teams")
public class TeamController {
	@Autowired
	private TeamService teamService;
	
	@GetMapping
	public ResponseEntity<APIResponse> getAllTeam(){
		List<Team> listTeam = teamService.getAll();
		if(listTeam.isEmpty()) {
			return new ResponseEntity<APIResponse>(HttpStatus.NO_CONTENT);
		}
		APIResponse<List<Team>> apiResponse =
					 new APIResponse<List<Team>>(listTeam,APIStatus.OK);
		return new ResponseEntity<APIResponse>(apiResponse,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<APIResponse> getTeam(@PathVariable("id") long id){
		Team team = teamService.getById(id);
		if(team == null) {
			return new ResponseEntity<APIResponse>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<APIResponse>(
				new APIResponse<Team>(team, APIStatus.OK),
				HttpStatus.OK);
	}
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<APIResponse> createTeam(@Validated @RequestBody CreateTeamRequest createTeamRequest){
		if(teamService.isTeamExistsByCode(createTeamRequest.getCode())) {
			throw new ApplicationException(APIStatus.ERR_CODE_EXISTS);	 
		}else {		
			Team team = teamService.createTeam(createTeamRequest);
			return new ResponseEntity<APIResponse>(
					new APIResponse<Team>(team, APIStatus.CREATED),
					HttpStatus.CREATED);
		}
	}
	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<APIResponse> updateTeam(@Validated @RequestBody Team teamRequest){
		Team team = teamService.getById(teamRequest.getId());
		if(team == null) {
			throw new ApplicationException(APIStatus.ERR_EMPLOYEE_ID_NOT_EXISTS); 
		}
		if(team.getCode() != null) {
			team.setName(teamRequest.getCode());
		}
		if(team.getName() != null) {
			team.setName(teamRequest.getName());
		}
		Team teamUpdate = teamService.updateTeam(team);
		return new ResponseEntity<APIResponse>(
				new APIResponse<Team>(teamUpdate, APIStatus.OK),
				HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmp(@PathVariable("id") long id){
		Team team = teamService.getById(id);
		if(team == null) {
			throw new ApplicationException(APIStatus.ERR_EMPLOYEE_ID_NOT_EXISTS); 
		}else {
			teamService.deleteTeam(team);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	 
}
