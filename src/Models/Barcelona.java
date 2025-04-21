package Models;

import java.util.ArrayList;

public class Barcelona {
    private static int money = 1_000_000_000;
    private static int overall = 0;
    private static PlayerInterface striker;
    private static PlayerInterface defender;
    private static GoalKeeperInterface goalie;
    private static ArrayList<Card> availableCards = new ArrayList<>();
    private static ArrayList<Card> teamPlayers = new ArrayList<>();

    public static int getMoney() {
        return money;
    }

    public static void spendMoney(int money) {
        Barcelona.money -= money;
    }

    public static PlayerInterface getStriker() {
        return striker;
    }

    public static void changeStriker(PlayerInterface striker) {
        Barcelona.striker = striker;
    }

    public static PlayerInterface getDefender() {
        return defender;
    }

    public static void changeDefender(PlayerInterface defender) {
        Barcelona.defender = defender;
    }

    public static GoalKeeperInterface getGoalie() {
        return goalie;
    }

    public static void changeGoalie(GoalKeeperInterface goalie) {
        Barcelona.goalie = goalie;
    }

    public static ArrayList<Card> getAvailableCards() {
        return availableCards;
    }

    public static ArrayList<Card> getTeamPlayers() {
        return teamPlayers;
    }

    public static int getOverall() {
        return overall;
    }

    public static void setOverall(int overall) {
        Barcelona.overall = overall;
    }
}
