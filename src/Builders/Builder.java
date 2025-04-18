package Builders;

import Models.Card;

public interface Builder {
    public void setName(String name);
    public void setNationality(String nationality);
    public Card getCard();
}
