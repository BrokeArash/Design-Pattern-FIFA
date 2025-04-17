package Builders;

import Models.Card;
import Models.GoalKeeperCard;

public class GoalKeeperCardBuilder implements Builder {

    private GoalKeeperCard goalKeeperCard;

    @Override
    public void addName() {

    }

    @Override
    public void addNationality() {

    }

    @Override
    public Card getCard() {
        return goalKeeperCard;
    }

}
