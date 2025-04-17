package Directors;

import Builders.Builder;
import Models.Card;

public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Card buildCard() {
        this.builder.addName();
        this.builder.addNationality();

        return this.builder.getCard();
    }
}
