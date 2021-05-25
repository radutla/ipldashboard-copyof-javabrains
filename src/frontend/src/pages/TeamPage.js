import {React, useEffect, useState} from 'react';
import { useParams } from 'react-router-dom';

import { MatchDetailsCard } from '../components/MatchDetailsCard.js';
import { MatchSmallCard } from '../components/MatchSmallCard.js';

export const TeamPage = () => {

const [team, setTeam] = useState({matches : []});
const { teamName } = useParams();
useEffect (
        () => {
            const fetchMatches = async () => {
            const response = await fetch(`http://localhost:8080/teams/${teamName}`);
            const data = await response.json();
            setTeam(data);
           };
        fetchMatches();
        }, [teamName]

);
    if(!team || !team.teamName){
    return <h1> Team Not found </h1>
    }

  return (
    <div className="TeamPage">
      <h1> {team.teamName} </h1>
      <MatchDetailsCard match={team.matches[0]} teamName={team.teamName}/>
      {team.matches.slice(1).map(match => <MatchSmallCard match={match} teamName={team.teamName}/> )}

    </div>
  );
}