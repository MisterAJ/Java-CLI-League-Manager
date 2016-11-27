package com.teamtreehouse.model;

import java.io.Serializable;

public class Player implements Comparable<Player>, Serializable {
    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;
    private int heightInInches;
    private boolean previousExperience;

    Player(String firstName, String lastName, int heightInInches, boolean previousExperience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.heightInInches = heightInInches;
        this.previousExperience = previousExperience;
    }

    String getFirstName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }

    String getFullName(){
        return String.format("%s %s",firstName, lastName);
    }

    int getHeightInInches() {
        return heightInInches;
    }

    boolean isPreviousExperience() {
        return previousExperience;
    }

    @Override
    public int compareTo(Player other) {
        // We always want to sort by last name then first name
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;

        Player player = (Player) o;

        if (heightInInches != player.heightInInches) return false;
        if (previousExperience != player.previousExperience) return false;
        return firstName.equals(player.firstName) && lastName.equals(player.lastName);

    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + heightInInches;
        result = 31 * result + (previousExperience ? 1 : 0);
        return result;
    }
}
