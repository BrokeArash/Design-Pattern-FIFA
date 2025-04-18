package Models;

import java.util.ArrayList;

public class Barcelona {
    private static int money = 1_000_000_000;
    private static PlayerCard striker;
    private static PlayerCard defender;
    private static GoalKeeperCard goalie;
    private static ArrayList<Card> availableCards = new ArrayList<>();
    private static ArrayList<Card> teamPlayers = new ArrayList<>();

    public static int getMoney() {
        return money;
    }

    public static void spendMoney(int money) {
        Barcelona.money -= money;
    }

    public static PlayerCard getStriker() {
        return striker;
    }

    public static void changeStriker(PlayerCard striker) {
        Barcelona.striker = striker;
    }

    public static PlayerCard getDefender() {
        return defender;
    }

    public static void changeDefender(PlayerCard defender) {
        Barcelona.defender = defender;
    }

    public static GoalKeeperCard getGoalie() {
        return goalie;
    }

    public static void changeGoalie(GoalKeeperCard goalie) {
        Barcelona.goalie = goalie;
    }

    public static ArrayList<Card> getAvailableCards() {
        return availableCards;
    }

    public static ArrayList<Card> getTeamPlayers() {
        return teamPlayers;
    }
}
