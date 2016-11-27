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
                 removeMenu();
             }
             if (menu.equalsIgnoreCase("q")){
                 menuBool = false;
             }
             // TODO Balance Report Menu
        }
    }

    private static void teamMenu(){
        String name = Prompter.prompt("What is the name of the Team?");
        String coach = Prompter.prompt("What is the name of the coach?");
        Teams.createTeam(name, coach);
        Teams.printTeamList();
    }

    private static void playerMenu(){
        Teams.printTeamList();
        String team = Prompter.prompt("Which team would you like to add to?");
        Team teamObj = Teams.getTeam(team);
        Players.listPlayers();
        String playerPrompt = String.format("Which player would you like to add to team %s?", team);
        String player = Prompter.prompt(playerPrompt);
        teamObj.printPlayerList();
        Player playerObj = Players.getPlayer(player);
        teamObj.addPlayer(player,playerObj);
        // TODO BUG User adding to last Team in the list only
    }

    private static void removeMenu(){
        Teams.printTeamList();
        String team = Prompter.prompt("Which team would you like to add to?");
        Team teamObj = Teams.getTeam(team);
        teamObj.printPlayerList();
        String playerPrompt = String.format("Which player would you like to remove from team %s?", team);
        String player = Prompter.prompt(playerPrompt);
        teamObj.removePlayer(player);

    }

}
