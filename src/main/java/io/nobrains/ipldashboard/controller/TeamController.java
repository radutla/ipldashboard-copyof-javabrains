package io.nobrains.ipldashboard.controller;

import io.nobrains.ipldashboard.model.Team;
import io.nobrains.ipldashboard.repository.MatchRepository;
import io.nobrains.ipldashboard.repository.TeamRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController
{

    TeamRepository teamRepository;
    MatchRepository matchRepository;


    public TeamController (TeamRepository teamRepository, MatchRepository matchRepository)
    {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    @GetMapping("/teams/{teamName}")
    public Team getTeamInfo (@PathVariable String teamName)
    {
        Team team = teamRepository.findByTeamName(teamName);
        team.setMatches(matchRepository.findLatestMatchesByTeam(teamName, 4));
        return team;
    }

}