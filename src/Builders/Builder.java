package Builders;

import Models.Card;

public interface Builder {
    public void addName();
    public void addNationality();
    public Card getCard();
}
