package Decorators.GoalKeeperCardDecorators;

import Models.GoalKeeperCard;
import Models.GoalKeeperInterface;

public class BronzeGoalKeeperCardDecorator implements GoalKeeperCardDecorator {

    GoalKeeperInterface card;

    public BronzeGoalKeeperCardDecorator(GoalKeeperInterface card) {
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
    public int getDiving() {
        return card.getDiving();
    }

    @Override
    public int getHandling() {
        return card.getHandling() + 1;
    }

    @Override
    public int getReflex() {
        return card.getReflex() + 3;
    }

    @Override
    public int getPositioning() {
        return card.getPositioning();
    }

    @Override
    public int getKicking() {
        return card.getKicking();
    }

    @Override
    public int getSpeed() {
        return card.getSpeed() + 2;
    }
}
