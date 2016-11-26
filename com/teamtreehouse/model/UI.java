package com.teamtreehouse.model;

public class UI {
    // Main Menu
    public void mainMenu(String leagueName){
        String menu;
        Boolean menuBool = true;
        System.out.println("Welcome to the team builder for " + leagueName + "!");
        while (menuBool){
             menu = Prompter.prompt("Would you like to:  Add a (T)eam?\n"
                                    + "                    Add a (P)layer?\n"
                                    + "                    (R)emove a Player?\n"
                                    + "                    (Q)uit?");
             if (menu.equalsIgnoreCase("t")){
                 UI.teamMenu();
             }
             if (menu.equalsIgnoreCase("p")){
                 // TODO Player Menu
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

}
