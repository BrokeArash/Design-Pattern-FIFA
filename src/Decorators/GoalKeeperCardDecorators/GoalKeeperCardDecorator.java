package Decorators.GoalKeeperCardDecorators;

import Models.GoalKeeperInterface;

public interface GoalKeeperCardDecorator extends GoalKeeperInterface {

    int getPrice();

    int getDiving();

    int getHandling();

    int getReflex();

    int getPositioning();

    int getKicking();

    int getSpeed();
}
