package Decorators.PlayerDecorators;

import Models.PlayerCard;
import Models.PlayerInterface;

public class GoldPlayerCardDecorator implements  PlayerCardDecorator {

    PlayerInterface card;

    public GoldPlayerCardDecorator(PlayerInterface card) {
        this.card = card;
    }

    @Override
    public String getName() {
        return card.getName();
    }

    @Override
    public String getNationality() {
        return card.getNationality();
    }

    @Override
    public int getPrice() {
        return 100_000_000;
    }

    @Override
    public int getShooting() {
        return card.getShooting() + 3;
    }

    @Override
    public int getPace() {
        return card.getPace();
    }

    @Override
    public int getDribbling() {
        return card.getDribbling() + 3;
    }

    @Override
    public int getPhysic() {
        return card.getPhysic() + 4;
    }

    @Override
    public int getPassing() {
        return card.getPassing() + 3;
    }

    @Override
    public int getDefending() {
        return card.getDefending() + 1;
    }


}
