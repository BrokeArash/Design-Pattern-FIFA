package Decorators.PlayerDecorators;

import Models.PlayerCard;
import Models.PlayerData;
import Models.PlayerInterface;

public class BronzePlayerCardDecorator implements PlayerCardDecorator {

    PlayerInterface card;

    public BronzePlayerCardDecorator(PlayerInterface card) {
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
        return 50_000_000;
    }

    @Override
    public int getShooting() {
        return card.getShooting();
    }

    @Override
    public int getPace() {
        return card.getPace() + 1;
    }

    @Override
    public int getDribbling() {
        return card.getDribbling() + 3;
    }

    @Override
    public int getPhysic() {
        return card.getPhysic();
    }

    @Override
    public int getPassing() {
        return card.getPassing();
    }

    @Override
    public int getDefending() {
        return card.getDefending() + 2;
    }
}
