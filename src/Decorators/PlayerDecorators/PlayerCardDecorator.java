package Decorators.PlayerDecorators;

import Models.Card;
import Models.PlayerCard;
import Models.PlayerInterface;
import Strategies.PlayStyle;

public interface PlayerCardDecorator extends PlayerInterface {

    int getPrice();

    int getShooting();

    int getPace();

    int getDribbling();

    int getPhysic();

    int getPassing();

    int getDefending();



}
