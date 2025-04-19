package Decorators.PlayerDecorators;

import Models.PlayerCard;
import Models.PlayerInterface;

public class HeroPlayerCardDecorator implements PlayerCardDecorator {
    PlayerInterface card;

    public HeroPlayerCardDecorator(PlayerInterface card) {
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
        return 150_000_000;
    }

    @Override
    public int getShooting() {
        return card.getShooting() + 4;
    }

    @Override
    public int getPace() {
        return card.getPace() + 2;
    }

    @Override
    public int getDribbling() {
        return card.getDribbling() + 2;
    }

    @Override
    public int getPhysic() {
        return card.getPhysic() + 1;
    }

    @Override
    public int getPassing() {
        return card.getPassing() + 1;
    }

    @Override
    public int getDefending() {
        return card.getDefending() + 2;
    }


}
