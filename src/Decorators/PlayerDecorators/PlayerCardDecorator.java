package Decorators.PlayerDecorators;

import Models.Card;
import Models.PlayerCard;
import Models.PlayerInterface;
import Strategies.PlayStyle;

public interface PlayerCardDecorator extends PlayerInterface {

    public int getPrice();

    public int getShooting();

    public int getPace();

    public int getDribbling();

    public int getPhysic();

    public int getPassing();

    public int getDefending();



}
