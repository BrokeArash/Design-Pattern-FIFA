package Builders;

import Models.Card;
import Models.GoalKeeperCard;

public class GoalKeeperCardBuilder implements Builder{

    private String name;
    private String nationality;
    private int diving;
    private int handling;
    private int reflex;
    private int positioning;
    private int kicking;
    private int speed;


    public void setDiving(int diving) {
        this.diving = diving;
    }

    public void setHandling(int handling) {
        this.handling = handling;
    }

    public void setReflex(int reflex) {
        this.reflex = reflex;
    }

    public void setPositioning(int positioning) {
        this.positioning = positioning;
    }

    public void setKicking(int kicking) {
        this.kicking = kicking;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public Card getCard() {
        return new GoalKeeperCard(name, nationality, diving, handling, reflex, positioning, kicking, speed);
    }
}
