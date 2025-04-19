package Decorators.GoalKeeperCardDecorators;

import Models.Card;
import Models.GoalKeeperInterface;

public interface GoalKeeperCardDecorator extends GoalKeeperInterface {

    public int getPrice();

    public int getDiving();

    public int getHandling();

    public int getReflex();

    public int getPositioning();

    public int getKicking();

    public int getSpeed();
}
