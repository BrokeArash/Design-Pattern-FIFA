package Models;

public class PlayerCard implements Card {
    private String name;
    private String nationality;
    private int shooting;
    private int pace;
    private int dribbling;
    private int physic;
    private int passing;
    private int defending;

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public int getShooting() {
        return shooting;
    }

    public int getPace() {
        return pace;
    }

    public int getDribbling() {
        return dribbling;
    }

    public int getPhysic() {
        return physic;
    }

    public int getPassing() {
        return passing;
    }

    public int getDefending() {
        return defending;
    }
}
