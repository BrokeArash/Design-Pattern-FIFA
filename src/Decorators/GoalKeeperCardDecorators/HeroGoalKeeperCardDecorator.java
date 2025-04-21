package Decorators.GoalKeeperCardDecorators;

import Models.GoalKeeperInterface;

public class HeroGoalKeeperCardDecorator implements GoalKeeperCardDecorator {

    GoalKeeperInterface card;

    public HeroGoalKeeperCardDecorator(GoalKeeperInterface card) {
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
    public int getDiving() {
        return card.getDiving() + 4;
    }

    @Override
    public int getHandling() {
        return card.getHandling() + 2;
    }

    @Override
    public int getReflex() {
        return card.getReflex() + 2;
    }

    @Override
    public int getPositioning() {
        return card.getPositioning() + 1;
    }

    @Override
    public int getKicking() {
        return card.getKicking() + 1;
    }

    @Override
    public int getSpeed() {
        return card.getSpeed() + 2;
    }

    @Override
    public int getOverall() {
        return card.getOverall();
    }
}
