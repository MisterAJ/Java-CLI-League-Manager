package com.teamtreehouse.model;

import java.util.HashMap;
import java.util.Map;

class Teams {
    private static Map<String, Team> mTeams = new HashMap<>();

    static String createTeam(String teamName, String coachName){
        Team team = new Team(teamName, coachName);
        mTeams.put(teamName, team);
        return String.format("\nThe team %s has been created, %s is their coach\n", teamName, coachName);
    }

    static void printTeamList(){
        System.out.println(mTeams.keySet());
    }

    static Team getTeam(String teamName){
        return mTeams.get(teamName);
    }
}
