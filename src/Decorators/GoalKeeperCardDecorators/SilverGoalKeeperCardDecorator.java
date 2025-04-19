package Decorators.GoalKeeperCardDecorators;

import Models.GoalKeeperCard;
import Models.GoalKeeperInterface;

public class SilverGoalKeeperCardDecorator implements GoalKeeperCardDecorator {

    GoalKeeperInterface card;

    public SilverGoalKeeperCardDecorator(GoalKeeperInterface card) {
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
    public int getDiving() {
        return card.getDiving() + 2;
    }

    @Override
    public int getHandling() {
        return card.getHandling() + 2;
    }

    @Override
    public int getReflex() {
        return card.getReflex() + 4;
    }

    @Override
    public int getPositioning() {
        return card.getPositioning() + 2;
    }

    @Override
    public int getKicking() {
        return card.getKicking() + 3;
    }

    @Override
    public int getSpeed() {
        return card.getSpeed() + 1;
    }
}
