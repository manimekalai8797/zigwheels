package com.kgisl.zigwheels.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Team
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamid;

    private String teamname;
    
  

    /**
     * @return the teamid
     */
    public Long getTeamid() {
        return teamid;
    }

    /**
     * @param teamid the teamid to set
     */
    public void setTeamid(Long teamid) {
        this.teamid = teamid;
    }

    /**
     * @return the teamname
     */
    public String getTeamname() {
        return teamname;
    }

    /**
     * @param teamname the teamname to set
     */
    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }
}