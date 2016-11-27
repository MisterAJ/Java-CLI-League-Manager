package com.teamtreehouse.model;

import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;

public class Team implements Comparable<Team>, Serializable {
    private static final long serialVersionUID = 1L;

    private static String mTeamName;
    private String mCoach;
    private static Map<String, Player> mPlayers = new HashMap<>();

    Team(String teamName, String coachName) {
        mTeamName = teamName;
        mCoach = coachName;
    }

    public static void addPlayer(String firstAndLast, Player player){
        mPlayers.put(firstAndLast, player);
        String print = String.format("%s has been added to team %s", firstAndLast, mTeamName);
        System.out.println(print);
    }

    public static void printPlayerList(){
        System.out.println(mPlayers.keySet());
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
