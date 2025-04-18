package Models;

import java.util.ArrayList;

public class Barcelona {
    private static int money = 1_000_000_000;
    private static PlayerCard striker;
    private static PlayerCard defender;
    private static GoalKeeperCard goalie;
    private static ArrayList<PlayerCard> BenchStriker = new ArrayList<>();
    private static ArrayList<PlayerCard> BenchDefender = new ArrayList<>();
    private static ArrayList<GoalKeeperCard> BenchGoalie = new ArrayList<>();
    private static ArrayList<Card> availableCards = new ArrayList<>();
    private static ArrayList<Card> teamPlayers = new ArrayList<>();

    public int getMoney() {
        return money;
    }

    public void spendMoney(int money) {
        Barcelona.money -= money;
    }

    public PlayerCard getStriker() {
        return striker;
    }

    public void changeStriker(PlayerCard striker) {
        Barcelona.striker = striker;
    }

    public PlayerCard getDefender() {
        return defender;
    }

    public void changeDefender(PlayerCard defender) {
        Barcelona.defender = defender;
    }

    public GoalKeeperCard getGoalie() {
        return goalie;
    }

    public void changeGoalie(GoalKeeperCard goalie) {
        Barcelona.goalie = goalie;
    }

    public static ArrayList<PlayerCard> getBenchStriker() {
        return BenchStriker;
    }

    public static ArrayList<PlayerCard> getBenchDefender() {
        return BenchDefender;
    }

    public static ArrayList<GoalKeeperCard> getBenchGoalie() {
        return BenchGoalie;
    }

    public static ArrayList<Card> getAvailableCards() {
        return availableCards;
    }

    public static ArrayList<Card> getTeamPlayers() {
        return teamPlayers;
    }
}
