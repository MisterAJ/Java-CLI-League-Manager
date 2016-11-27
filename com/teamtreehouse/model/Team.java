package com.teamtreehouse.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Team implements Comparable<Team>, Serializable {
    private static final long serialVersionUID = 1L;

    private String mTeamName;
    private String mCoach;
    private Map<String, Player> mPlayers = new TreeMap<>();

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
        for (Player player : mPlayers.values()){
            String print = String.format("%s %s | Height: %s | Previous Experience: %s",
                    player.getFirstName(),
                    player.getLastName(),
                    player.getHeightInInches(),
                    player.isPreviousExperience());
            System.out.println(print);
        }
    }

    void printRoster(){
        for (Player player : mPlayers.values()){
            String print = String.format("%s %s",
                    player.getFirstName(),
                    player.getLastName());
            System.out.println(print);
        }
    }

    void removePlayer(String playerName){
        Player player = mPlayers.get(playerName);
        mPlayers.remove(playerName);
        Players.addPlayer(playerName, player);
        String print = String.format("%s has been removed from team %s", playerName, mTeamName);
        System.out.println(print);
    }

    // TODO Create method to find league average height dynamically
    void getHeightReport(){
        List<String> belowAverage = new ArrayList();
        List<String> average = new ArrayList(); // League average is 41-43 inches
        List<String> aboveAverage = new ArrayList();
        for (Player player : mPlayers.values()){
            String playerName = player.getFullName();
            if (player.getHeightInInches() <= 41){
                belowAverage.add(playerName);
            }
            if (player.getHeightInInches() >= 43){
                aboveAverage.add(playerName);
            }
            if (player.getHeightInInches() == 42 ){
                average.add(playerName);
            }
            // TODO Learn how to check equality to range 41-43
        }
        System.out.println("Players Below Average Height:");
        System.out.println(belowAverage);
        System.out.println("Players of Average Height:");
        System.out.println(average);
        System.out.println("Players Above Average Height:");
        System.out.println(aboveAverage);
    }

    int getPlayerCount(){
        return mPlayers.size();
    }

    void printExperienceReport(){
        ArrayList<String> hasExperience = new ArrayList<>();
        ArrayList<String> noExperience = new ArrayList<>();
        Double xp = 0.0;
        for (Player player : mPlayers.values()){
            if (player.isPreviousExperience()){
                hasExperience.add(player.getFullName());
                xp += 1;
            }
            if (! player.isPreviousExperience()){
                noExperience.add(player.getFullName());
            }
        }
        Double balance = (xp / mPlayers.size());
        System.out.printf("Team Experience Balance is %s - 0.5 Indicates an even Balance - " +
                        "Above 0.5 means you have more Experienced Players than Inexperienced players",
                        Math.round(balance));
        System.out.println("Players with Experience: ");
        System.out.println(hasExperience);
        System.out.println("Players without Experience");
        System.out.println(noExperience);
    }

    String getTeamName() {
        return mTeamName;
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
