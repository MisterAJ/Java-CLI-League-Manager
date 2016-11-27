package com.teamtreehouse.model;

import java.util.TreeMap;
import java.util.Map;

class Teams {
    private static Map<String, Team> mTeams = new TreeMap<>();
    private static int mMaxTeams;

    static String createTeam(String teamName, String coachName){
        Team team = new Team(teamName, coachName);
        mTeams.put(teamName, team);
        return String.format("\nThe team %s has been created, %s is their coach\n", teamName, coachName);
    }

    static void printTeamList(){
        System.out.println(mTeams.keySet());
        System.out.print("\n");
    }

    static Team getTeam(String teamName){
        return mTeams.get(teamName);
    }

    static void leagueBalanceReport(){
        for (Team team : mTeams.values()){
            System.out.println(team.getTeamName());
            team.printExperienceReport();
            team.getHeightReport();
            System.out.println("\n-------------------------------\n");
        }


    }

    static int getMaxTeams() {
        return mMaxTeams;
    }

    static int getTeamCount(){
        return mTeams.size();
    }

    static void setMaxTeams(int mMaxTeams) {
        Teams.mMaxTeams = mMaxTeams;
    }
}
