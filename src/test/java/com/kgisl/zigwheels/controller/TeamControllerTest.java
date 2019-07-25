package com.kgisl.zigwheels.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.kgisl.zigwheels.model.Team;
import com.kgisl.zigwheels.service.TeamService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * TeamController
 */

@RunWith(MockitoJUnitRunner.class)

public class TeamControllerTest {

  @Mock
  private TeamService teamService;

  @InjectMocks
  private TeamController teamController;

  public static List<Team> expected;
  public Team team1 = new TeamBuilder().id(1L).name("mahesh").build();
  public Team team2 = new TeamBuilder().id(2L).name("aravinth").build();

  @Test
  public void createTeamTest() {
    when(teamService.createTeam(team1)).thenReturn(team1);
    teamController.createTeam(team1);
  }

  @Test
  public void allTest() {
    expected = Arrays.asList(team1, team2);
    System.out.println(expected);
    when(teamService.getTeams()).thenReturn(expected);
    ResponseEntity<List<Team>> actual = teamController.all();
    assertNotNull(actual);
    assertEquals(expected, actual.getBody());
    assertEquals(HttpStatus.OK, actual.getStatusCode());
  }

  @Test
  public void getTeamByIdTest() {
    Long id = 1L;
    when(teamService.findByTeamId(id)).thenReturn(null);
    ResponseEntity<Team> actual = teamController.getTeamById(id);
    assertNotNull(actual);
  }

  @Test
  public void updateTeamTest() {
    Team edit = new TeamBuilder().name("shanmugam").build();
    Long id = 1L;
    // when(teamService.updateTeam(id, team1)).thenReturn(team1);
    ResponseEntity<Team> actual = teamController.updateTeam(id, edit);
    assertNotNull(actual);
    System.out.println("Actual is  "+actual.getBody());
    System.out.println("expected-->" + expected);
    // assertEquals(edit, actual.getBody());
  }

  @Test
  public void deleteTeamTest() {
    Long id = 1L;
    when(teamService.findByTeamId(id)).thenReturn(team1);
    teamController.deleteTeam(id);
    verify(teamService).deleteTeamById(id);
  }
}