package com.teamtreehouse.model;

import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;

public class Team implements Comparable<Team>, Serializable {
    private static final long serialVersionUID = 1L;

    private String mTeamName;
    private String mCoach;
    private Map<String, Player> mPlayers = new HashMap<>();

    Team(String teamName, String coachName) {
        mTeamName = teamName;
        mCoach = coachName;
    }

    void addPlayer(String playerName, Player player){
        mPlayers.put(playerName, player);
        String print = String.format("%s has been added to team %s", playerName, mTeamName);
        System.out.println(print);
    }

    void printPlayerList(){
        System.out.println(mPlayers.keySet());
    }

    void removePlayer(String playerName){
        Player player = mPlayers.get(playerName);
        mPlayers.remove(playerName);
        Players.addPlayer(playerName, player);
        String print = String.format("%s has been removed from team %s", playerName, mTeamName);
        System.out.println(print);
    }

    public String getTeamName() {
        return mTeamName;
    }

    public String getCoach() {
        return mCoach;
    }

    @Override
    public int compareTo(Team other) {
        // We always want to sort by last name then first name
        return 0;
    }


    @Override
    public int hashCode() {
        int result = mTeamName.hashCode();
        result = 31 * result + mCoach.hashCode();
        return result;
    }
}
