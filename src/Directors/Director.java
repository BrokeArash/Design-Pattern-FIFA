package Directors;

import Builders.Builder;
import Builders.GoalKeeperCardBuilder;
import Builders.PlayerCardBuilder;
import Models.Card;
import Models.GoalieData;
import Models.PlayerCard;
import Models.PlayerData;

public class Director {


    public void buildCardPlayer (PlayerCardBuilder builder, PlayerData data) {
        builder.setName(data.name());
        builder.setNationality(data.nationality());
        builder.setShooting(data.shooting());
        builder.setPace(data.pace());
        builder.setDribbling(data.dribbling());
        builder.setPhysic(data.physic());
        builder.setPassing(data.passing());
        builder.setDefending(data.defending());
    }
    public void buildGoaliePlayer (GoalKeeperCardBuilder builder, GoalieData data) {
        builder.setName(data.name());
        builder.setNationality(data.nationality());
        builder.setDiving(data.diving());
        builder.setHandling(data.handling());
        builder.setReflex(data.reflex());
        builder.setPositioning(data.positioning());
        builder.setKicking(data.kicking());
        builder.setSpeed(data.speed());
    }
}
