package com.kgisl.zigwheels.controller;

import com.kgisl.zigwheels.model.Team;

/**
 * TeamBuilder
 */
public class TeamBuilder {
    private Team team = new Team();
    
    public TeamBuilder id(long l)
    {
        team.setTeamid(l);
        return this;
    }
    public TeamBuilder name(String name)
    {
        team.setTeamname(name);
        return this;
    }
    public Team build()
    {
        return team;
    }

}