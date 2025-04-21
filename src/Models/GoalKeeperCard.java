package Models;

public class GoalKeeperCard implements GoalKeeperInterface {

    private String name;
    private String nationality;
    private int diving;
    private int handling;
    private int reflex;
    private int positioning;
    private int kicking;
    private int speed;

    public GoalKeeperCard(String name, String nationality, int diving, int handling,
                          int reflex, int positioning, int kicking, int speed) {
        this.name = name;
        this.nationality = nationality;
        this.diving = diving;
        this.handling = handling;
        this.reflex = reflex;
        this.positioning = positioning;
        this.kicking = kicking;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public int getDiving() {
        return diving;
    }

    public int getHandling() {
        return handling;
    }

    public int getReflex() {
        return reflex;
    }

    public int getPositioning() {
        return positioning;
    }

    public int getKicking() {
        return kicking;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public int getOverall() {
        return (diving + handling + reflex + positioning + kicking + speed)/6;
    }

    @Override
    public int getPrice() {
        int sum = (diving + handling + reflex + positioning + kicking + speed)/6;
        return sum * 10_000_000;
    }
}
