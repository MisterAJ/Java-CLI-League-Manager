package com.teamtreehouse.model;

import java.util.HashMap;
import java.util.Map;

public class Teams {
    private static Map<String, Team> mTeams = new HashMap<>();

    public static String createTeam(String teamName, String coachName){
        Team team = new Team(teamName, coachName);
        mTeams.put(teamName, team);
        String print = String.format("\nThe team %s has been created, %s is their coach\n", teamName, coachName);
        return print;
    }

    public static void printTeamList(){
        System.out.println(mTeams.keySet());
    }

    public static Team getTeam(String teamName){
        return mTeams.get(teamName);
    }
}
