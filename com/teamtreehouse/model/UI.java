package com.teamtreehouse.model;

public class UI {
    // Main Menu
    public static void mainMenu(String leagueName){
        String menu;
        Boolean menuBool = true;
        System.out.println("Welcome to the team builder for " + leagueName + "!");
        while (menuBool){
             menu = Prompter.prompt("Would you like to:  Add a (T)eam?\n"
                                    + "                    Add a (P)layer?\n"
                                    + "                    (R)emove a Player?\n"
                                    + "                    (Q)uit?");
             if (menu.equalsIgnoreCase("t")){
                 teamMenu();
             }
             if (menu.equalsIgnoreCase("p")){
                 playerMenu();
             }
             if (menu.equalsIgnoreCase("r")){
                 // TODO Remove Player Menu
             }
             if (menu.equalsIgnoreCase("q")){
                 menuBool = false;
             }
             // TODO Balance Report Menu
        }
    }

    public static void teamMenu(){
        String name = Prompter.prompt("What is the name of the Team?");
        String coach = Prompter.prompt("What is the name of the coach?");
        Teams.createTeam(name, coach);
        // TODO Create method to print out currently registered teams
    }

    public static void playerMenu(){
        // TODO Print List of Registered Teams
        String team = Prompter.prompt("Which team would you like to add to?");
        // TODO Print List of Unregistered Players
        String playerPrompt = String.format("Which player would you like to add to team %s?", team);
        String player = Prompter.prompt(playerPrompt);
        // TODO Make method to return Player by Full name
        // TODO Create method to print player list for selected team
        Player playerObj = Players.getPlayer(player);
        Team.addPlayer(player,playerObj);
    }

}
