package Decorators.PlayerDecorators;

import Models.PlayerInterface;
import Strategies.AggressiveStrategy;
import Strategies.DefensiveStrategy;
import Strategies.PlayStyle;

public class IconPlayerCardDecorator implements PlayerCardDecorator{
    PlayerInterface card;

    public IconPlayerCardDecorator(PlayerInterface card) {
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
        return 200_000_000;
    }

    @Override
    public int getShooting() {
        return card.getShooting() + 5;
    }

    @Override
    public int getPace() {
        return card.getPace() + 3;
    }

    @Override
    public int getDribbling() {
        return card.getDribbling() + 2;
    }

    @Override
    public int getPhysic() {
        return card.getPhysic();
    }

    @Override
    public int getPassing() {
        return card.getPassing() + 2;
    }

    @Override
    public int getDefending() {
        return card.getDefending() + 5;
    }

    @Override
    public int getOverall() {
        if (getStyle() instanceof AggressiveStrategy) {
            return (getDribbling() + getPace() + getShooting())/3;
        } else if (getStyle() instanceof DefensiveStrategy) {
            return (getDefending() + getPassing() + getPhysic())/3;
        } else {
            return (getDribbling() + getPace() + getShooting() + getDefending() + getPassing() + getPhysic())/6;
        }
    }

    @Override
    public PlayStyle getStyle() {
        return card.getStyle();
    }

    @Override
    public void setStyle(PlayStyle style) {
        card.setStyle(style);
    }


}
