package Models;

import Strategies.BalancedStrategy;
import Strategies.PlayStyle;

public class PlayerCard implements PlayerInterface {
    private final String name;
    private final String nationality;
    private final int shooting;
    private final int pace;
    private final int dribbling;
    private final int physic;
    private final int passing;
    private final int defending;
    private PlayStyle style;


    public PlayerCard(String name, String nationality, int shooting, int pace,
                      int dribbling, int physic, int passing, int defending) {

        this.name = name;
        this.nationality = nationality;
        this.shooting = shooting;
        this.pace = pace;
        this.dribbling = dribbling;
        this.physic = physic;
        this.passing = passing;
        this.defending = defending;
        this.style = new BalancedStrategy(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getNationality() {
        return nationality;
    }

    @Override
    public int getShooting() {
        return shooting;
    }

    @Override
    public int getPace() {
        return pace;
    }

    @Override
    public int getDribbling() {
        return dribbling;
    }

    @Override
    public int getPhysic() {
        return physic;
    }

    @Override
    public int getPassing() {
        return passing;
    }

    @Override
    public int getDefending() {
        return defending;
    }

    @Override
    public int getOverall() {
        return style.getOverall();
    }

    public PlayStyle getStyle() {
        return style;
    }

    public void setStyle(PlayStyle style) {
        this.style = style;
    }

    @Override
    public int getPrice () {
        int sum = (shooting + pace + dribbling + physic + passing + defending)/6;
        return sum * 10_000_000;
    }
}
