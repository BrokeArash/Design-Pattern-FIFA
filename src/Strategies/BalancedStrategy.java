package Strategies;

import Models.PlayerInterface;

public class BalancedStrategy implements PlayStyle {

    PlayerInterface card;

    public BalancedStrategy(PlayerInterface card) {
        this.card = card;
    }

    @Override
    public int getOverall() {
        int sum = card.getDefending() + card.getPace() + card.getPassing() +
                card.getDribbling() + card.getPhysic() + card.getShooting();
        System.out.println(card.getDefending() + " " + card.getPace() + " " + card.getPassing() + " " +
                card.getDribbling() + " " + card.getPhysic() + " " + card.getShooting());
        return sum / 6;
    }

    @Override
    public int getPrice() {
        return 3_000_000;
    }

    @Override
    public String getName() {
        return "balanced";
    }
}
