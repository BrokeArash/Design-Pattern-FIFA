package Strategies;

import Models.PlayerInterface;

public class AggressiveStrategy implements PlayStyle {


    PlayerInterface card;

    public AggressiveStrategy(PlayerInterface card) {
        this.card = card;
    }

    @Override
    public int getOverall() {
        int sum = card.getDribbling() + card.getPace() + card.getShooting();
        return sum / 3;
    }

    @Override
    public int getPrice() {
        return 5_000_000;
    }

    @Override
    public String getName() {
        return "aggressive";
    }
}
