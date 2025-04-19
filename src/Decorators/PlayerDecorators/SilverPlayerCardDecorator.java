package Decorators.PlayerDecorators;

import Models.Card;
import Models.PlayerCard;
import Models.PlayerInterface;
import Strategies.PlayStyle;

public class SilverPlayerCardDecorator implements PlayerCardDecorator {
    PlayerInterface card;


    public SilverPlayerCardDecorator(PlayerInterface card) {
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
        return 70_000_000;
    }



    @Override
    public int getShooting() {
        return card.getShooting() + 2;
    }

    @Override
    public int getPace() {
        return card.getPace() + 2;
    }

    @Override
    public int getDribbling() {
        return card.getDribbling() + 4;
    }

    @Override
    public int getPhysic() {
        return card.getPhysic() + 2;
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
