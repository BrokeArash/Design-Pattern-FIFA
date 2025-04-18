package Models;

public class PlayerCard implements Card {
    private final String name;
    private final String nationality;
    private final int shooting;
    private final int pace;
    private final int dribbling;
    private final int physic;
    private final int passing;
    private final int defending;

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
    }

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

    public int getPrice () {
        int sum = (shooting + pace + dribbling + physic + passing + defending)/6;
        return sum * 10_000_000;
    }
}
