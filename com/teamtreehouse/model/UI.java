package com.teamtreehouse.model;

public class UI {
    // Main Menu
    // TODO Handle exceptions from incorrect inputs
    public static void mainMenu(String leagueName) {
        String menu;
        Boolean menuBool = true;
        System.out.println("Welcome to the team builder for the " + leagueName + " 5 on 5 Soccer League!");
        while (menuBool) {
            menu = Prompter.prompt("Would you like to:  Add a (T)eam?\n"
                                            + "                    Add a (P)layer?\n"
                                            + "                    (R)emove a Player?\n"
                                            + "                    (V)iew balance reports?\n"
                                            + "                    (Q)uit?");
            if (menu.equalsIgnoreCase("t")) {
                teamMenu();
            }
            if (menu.equalsIgnoreCase("p")) {
                playerMenu();
            }
            if (menu.equalsIgnoreCase("r")) {
                removeMenu();
            }
            if (menu.equalsIgnoreCase("v")) {
                reportsMenu();
            }
            if (menu.equalsIgnoreCase("q")) {
                menuBool = false;
            }

        }
    }

    private static void teamMenu() {
        if (Teams.getmMaxTeams() > Teams.getTeamCount()) {
            String name = Prompter.prompt("What is the name of the Team?");
            String coach = Prompter.prompt("What is the name of the coach?");
            Teams.createTeam(name, coach);
            Teams.printTeamList();
        } else {
            System.out.println("Sorry, there are not enough players in the league to support and more Teams\n");
        }
    }

    private static void playerMenu() {
        Boolean bool = true;
        Teams.printTeamList();
        String team = Prompter.prompt("Which team would you like to add to?");
        Team teamObj = Teams.getTeam(team);
        while (bool) {
            Players.listPlayers();
            String playerPrompt = String.format("Which player would you like to add to team %s? " +
                    "Please Enter First and Last Name.", team);
            String player = Prompter.prompt(playerPrompt);
            teamObj.printPlayerList();
            Player playerObj = Players.getPlayer(player);
            teamObj.addPlayer(player, playerObj);
            bool = Prompter.promptForBoolean("Would you like to add another player to this team? Y/N");
        }
    }

    private static void removeMenu() {
        Teams.printTeamList();
        String team = Prompter.prompt("Which team would you like to add to?");
        Team teamObj = Teams.getTeam(team);
        teamObj.printPlayerList();
        String playerPrompt = String.format("Which player would you like to remove from team %s? " +
                "Please Enter First and Last Name.", team);
        String player = Prompter.prompt(playerPrompt);
        teamObj.removePlayer(player);
    }

    private static void reportsMenu() {
        String menu = Prompter.prompt("Which report would you like to see? (L)eague or (T)eam?");
        if (menu.equalsIgnoreCase("l")) {
            Teams.leagueBalanceReport();
        }
        if (menu.equalsIgnoreCase("t")) {
            Teams.printTeamList();
            String team = Prompter.prompt("Which team would you like to view?");
            Team teamObj = Teams.getTeam(team);
            teamObj.getHeightReport();
            teamObj.printExperienceReport();
            Boolean bool = Prompter.promptForBoolean("Would you like to Print a team roster? Y/N");
            if (bool){
                teamObj.printRoster();
            }
        }
    }

}
