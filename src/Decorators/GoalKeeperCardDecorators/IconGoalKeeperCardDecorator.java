package Decorators.GoalKeeperCardDecorators;

import Models.GoalKeeperInterface;

public class IconGoalKeeperCardDecorator implements GoalKeeperCardDecorator {

    GoalKeeperInterface card;

    public IconGoalKeeperCardDecorator(GoalKeeperInterface card) {
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
    public int getDiving() {
        return card.getDiving() + 5;
    }

    @Override
    public int getHandling() {
        return card.getHandling() + 3;
    }

    @Override
    public int getReflex() {
        return card.getReflex() + 2;
    }

    @Override
    public int getPositioning() {
        return card.getPositioning();
    }

    @Override
    public int getKicking() {
        return card.getKicking() + 2;
    }

    @Override
    public int getSpeed() {
        return card.getSpeed() + 5;
    }

    @Override
    public int getOverall() {
        return (getDiving() + getHandling() + getReflex() + getPositioning() + getKicking() + getSpeed())/6;
    }
}
