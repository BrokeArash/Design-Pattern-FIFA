package Models;

import Strategies.PlayStyle;

public interface PlayerInterface extends Card{

    int getShooting();

    int getPace();

    int getDribbling();

    int getPhysic();

    int getPassing();

    int getDefending();

    int getOverall();

    PlayStyle getStyle();

    void setStyle(PlayStyle style);

}
