package Builders;

import Models.Card;
import Models.PlayerCard;

public class PlayerCardBuilder implements Builder {

    private PlayerCard playerCard;
    @Override
    public void addName() {

    }

    @Override
    public void addNationality() {

    }

    @Override
    public Card getCard() {
        return playerCard;
    }
}
