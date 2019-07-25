package com.kgisl.zigwheels.controller;

import java.util.List;

import com.kgisl.zigwheels.model.Team;
import com.kgisl.zigwheels.service.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * TeamController
 */

@CrossOrigin(origins = "*")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@RestController
@RequestMapping("/api/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    // @Autowired
    // private ModelMapper modelMapper;

    @PostMapping(value = "/", headers = "Accept=application/json")
    public ResponseEntity<Team> createTeam(@RequestBody Team team) {
        Team actualTeam = teamService.createTeam(team);
        HttpHeaders headers = new HttpHeaders();
        // headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(team.getTeamid()).toUri());
        return new ResponseEntity<>(actualTeam, headers, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public @ResponseBody ResponseEntity<List<Team>> all() {
        return new ResponseEntity<>(teamService.getTeams(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Team> getTeamById(@PathVariable("id") long id) {
        Team team = teamService.findByTeamId(id);
        if (team == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", headers = "Accept=application/json")
    public ResponseEntity<Team> updateTeam(@PathVariable("id") long id, @RequestBody Team currentTeam) {
        Team team = teamService.updateTeam(id, currentTeam);
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", headers = "Accept=application/json")
    public ResponseEntity<Team> deleteTeam(@PathVariable("id") Long id) {
        Team user = teamService.findByTeamId(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        teamService.deleteTeamById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}