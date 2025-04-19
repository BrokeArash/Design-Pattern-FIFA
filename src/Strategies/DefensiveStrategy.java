package Strategies;

import Decorators.PlayerDecorators.PlayerCardDecorator;

public class DefensiveStrategy implements PlayStyle {
    PlayerCardDecorator card;

    public DefensiveStrategy(PlayerCardDecorator card) {
        this.card = card;
    }


    @Override
    public void setPlayStyle() {

    }
}
