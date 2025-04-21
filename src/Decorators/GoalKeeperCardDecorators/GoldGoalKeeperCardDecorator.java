package Decorators.GoalKeeperCardDecorators;

import Models.GoalKeeperInterface;

public class GoldGoalKeeperCardDecorator implements GoalKeeperCardDecorator {

    GoalKeeperInterface card;

    public GoldGoalKeeperCardDecorator(GoalKeeperInterface card) {
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
    public int getDiving() {
        return card.getDiving() + 3;
    }

    @Override
    public int getHandling() {
        return card.getHandling();
    }

    @Override
    public int getReflex() {
        return card.getReflex() + 3;
    }

    @Override
    public int getPositioning() {
        return card.getPositioning() + 4;
    }

    @Override
    public int getKicking() {
        return card.getKicking() + 3;
    }

    @Override
    public int getSpeed() {
        return card.getSpeed() + 1;
    }

    @Override
    public int getOverall() {
        return (getDiving() + getHandling() + getReflex() + getPositioning() + getKicking() + getSpeed())/6;
    }
}
