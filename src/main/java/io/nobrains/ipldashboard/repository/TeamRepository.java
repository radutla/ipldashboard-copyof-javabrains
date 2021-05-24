package io.nobrains.ipldashboard.repository;

import io.nobrains.ipldashboard.model.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long>
{
    Team findByTeamName (String teamName);
}
