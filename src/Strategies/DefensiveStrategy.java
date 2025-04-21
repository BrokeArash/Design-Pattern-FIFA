package Strategies;

import Models.PlayerInterface;

public class DefensiveStrategy implements PlayStyle {

    PlayerInterface card;

    public DefensiveStrategy(PlayerInterface card) {
        this.card = card;
    }

    @Override
    public int getOverall() {
        int sum = card.getDefending() + card.getPhysic() + card.getPassing();
        return sum / 3;
    }

    @Override
    public int getPrice() {
        return 4_000_000;
    }

    @Override
    public String getName() {
        return "defensive";
    }
}
