import com.teamtreehouse.model.Players;
import com.teamtreehouse.model.Prompter;
import com.teamtreehouse.model.UI;

public class LeagueManager {

    public static void main(String[] args) {
        String leagueName = Prompter.prompt("What is the name of your league?");
        Players.load();
        Players.loadListToMap();
        UI.mainMenu(leagueName);
        System.out.println("Thank you for using the Team Treehouse Techdegree Soccer League Organizer!");
        System.out.println("#java");
    }

}
