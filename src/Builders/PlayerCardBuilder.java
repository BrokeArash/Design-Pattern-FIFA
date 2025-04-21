package Builders;

import Models.PlayerCard;

public class PlayerCardBuilder implements Builder {

    private String name;
    private String nationality;
    private int shooting;
    private int pace;
    private int dribbling;
    private int physic;
    private int passing;
    private int defending;

    public void setShooting(int shooting) {
        this.shooting = shooting;
    }

    public void setPace(int pace) {
        this.pace = pace;
    }

    public void setDribbling(int dribbling) {
        this.dribbling = dribbling;
    }

    public void setPhysic(int physic) {
        this.physic = physic;
    }

    public void setPassing(int passing) {
        this.passing = passing;
    }

    public void setDefending(int defending) {
        this.defending = defending;
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
    public PlayerCard getCard() {
        return new PlayerCard(name, nationality, shooting, pace, dribbling,
                physic, passing, defending);
    }
}
