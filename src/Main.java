import Builders.Builder;
import Builders.GoalKeeperCardBuilder;
import Builders.PlayerCardBuilder;
import Decorators.GoalKeeperCardDecorators.*;
import Decorators.PlayerDecorators.*;
import Directors.Director;
import Models.*;
import Strategies.PlayStyle;

import java.util.Scanner;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Card card;
        while (true) {
            System.out.println(Barcelona.getMoney());
            String input = scanner.nextLine();
            Regexes matchedCommand = null;
            for (Regexes command : Regexes.values()) {
                Matcher matcher = command.getMatcher(input);
                if (matcher != null && matcher.matches()) {
                    matchedCommand = command;
                    break;
                }
            }

            Director director = new Director();

            if (matchedCommand == null) {
                System.out.println("kir");
            } else {
                switch (matchedCommand) {

                    case BuildPlayer:
                        Matcher buildPlayer = matchedCommand.getMatcher(input);
                        String name = buildPlayer.group("name");
                        String nationality = buildPlayer.group("nationality");
                        int shooting = Integer.parseInt(buildPlayer.group("shooting"));
                        int pace = Integer.parseInt(buildPlayer.group("pace"));
                        int dribbling = Integer.parseInt(buildPlayer.group("dribbling"));
                        int physic = Integer.parseInt(buildPlayer.group("physic"));
                        int passing = Integer.parseInt(buildPlayer.group("passing"));
                        int defending = Integer.parseInt(buildPlayer.group("defending"));
                        PlayerData data = new PlayerData(
                                name, nationality, shooting, pace, dribbling, physic, passing, defending);

                        PlayerCardBuilder playerCardBuilder = new PlayerCardBuilder();
                        director.buildCardPlayer(playerCardBuilder, data);
                        PlayerCard newCard = playerCardBuilder.getCard();
                        Barcelona.getAvailableCards().add(newCard);
                        break;
                    case BuildGoalie:
                        Matcher buildGoalie = Regexes.BuildGoalie.getMatcher(input);
                        name = buildGoalie.group("name");
                        nationality = buildGoalie.group("nationality");
                        int diving = Integer.parseInt(buildGoalie.group("diving"));
                        int handling = Integer.parseInt(buildGoalie.group("handling"));
                        int reflex = Integer.parseInt(buildGoalie.group("reflex"));
                        int positioning = Integer.parseInt(buildGoalie.group("positioning"));
                        int kicking = Integer.parseInt(buildGoalie.group("kicking"));
                        int speed = Integer.parseInt(buildGoalie.group("speed"));
                        GoalieData goalieData = new GoalieData(
                                name, nationality, diving, handling, reflex, positioning, kicking, speed);
                        GoalKeeperCardBuilder goalKeeperCardBuilder = new GoalKeeperCardBuilder();
                        director.buildGoaliePlayer(goalKeeperCardBuilder, goalieData);
                        GoalKeeperCard goalKeeperCard = (GoalKeeperCard) goalKeeperCardBuilder.getCard();
                        Barcelona.getAvailableCards().add(goalKeeperCard);
                        break;
                    case Buy:
                        Matcher buy = Regexes.Buy.getMatcher(input);
                        String playerName = buy.group("playerName");
                        card = null;
                        for (Card card1 : Barcelona.getAvailableCards()) {
                            if (card1.getName().equals(playerName)) {
                                card = card1;
                                break;
                            }
                        }

                        if (card == null) {
                            break;
                        } else if (Barcelona.getMoney() < card.getPrice()) {
                            System.out.println("8 - 2 ");
                            break;
                        }

                        Barcelona.spendMoney(card.getPrice());
                        Barcelona.getTeamPlayers().add(card);
                        Barcelona.getAvailableCards().remove(card);
                        break;
                    case Sell:
                        Matcher sell = Regexes.Sell.getMatcher(input);
                        playerName = sell.group("playerName");
                        card = null;
                        for (Card card1 : Barcelona.getTeamPlayers()) {
                            if (card1.getName().equals(playerName)) {
                                card = card1;
                                break;
                            }
                        }

                        if (card == null) {
                            break;
                        }
                        Barcelona.spendMoney(-(card.getPrice() / 2));
                        Barcelona.getTeamPlayers().remove(card);
                        Barcelona.getAvailableCards().add(card);
                        break;
                    case Select:
                        Matcher select = Regexes.Select.getMatcher(input);
                        String position = select.group("position");
                        playerName = select.group("playerName");
                        card = null;
                        for (Card card1 : Barcelona.getTeamPlayers()) {
                            if (card1.getName().equals(playerName)) {
                                card = card1;
                                break;
                            }
                        }

                        if (card == null) {
                            break;
                        } else if (position.equals("gk")) {
                            Barcelona.changeGoalie((GoalKeeperCard) card);
                        } else if (position.equals("cb")) {
                            Barcelona.changeDefender((PlayerCard) card);
                        } else if (position.equals("st")) {
                            Barcelona.changeStriker((PlayerCard) card);
                        } else {
                            break;
                        }
                        break;
                    case SetDecoration:
                        Matcher setDecoration = Regexes.SetDecoration.getMatcher(input);
                        position = setDecoration.group("position");
                        String decoration = setDecoration.group("decoration");
                        card = null;
                        if (position.equals("gk")) {
                            card = Barcelona.getGoalie();
                            card = decorateGoalKeeper((GoalKeeperInterface) card, decoration);
                            Barcelona.changeGoalie((GoalKeeperInterface) card);
                        } else if (position.equals("cb")) {
                            card = Barcelona.getDefender();
                            card = decoratePlayer((PlayerInterface) card, decoration);
                            Barcelona.changeDefender((PlayerInterface) card);
                        } else if (position.equals("st")) {
                            card = Barcelona.getStriker();
                            System.out.println(((PlayerInterface) card).getDefending());
                            card = decoratePlayer((PlayerInterface) card, decoration);
                            System.out.println(((PlayerInterface) card).getDefending());
                            Barcelona.changeStriker((PlayerInterface) card);
                        }
                        Barcelona.spendMoney(card.getPrice());
                        break;
                    case Soot:

                }
            }


        }


    }

    private static PlayerInterface decoratePlayer(PlayerInterface card, String decoration) {

        switch (decoration) {
            case "bronze":
                card = new BronzePlayerCardDecorator(card);
                return card;

            case "silver":
                card = new SilverPlayerCardDecorator(card);
                return card;

            case "gold":
                card = new GoldPlayerCardDecorator(card);
                return card;

            case "hero":
                card = new HeroPlayerCardDecorator(card);
                return card;

            case "icon":
                card = new IconPlayerCardDecorator(card);
                return card;

            default:
                return null;
        }
    }

    private static GoalKeeperInterface decorateGoalKeeper(GoalKeeperInterface card, String decoration) {
        switch (decoration) {
            case "bronze":
                card = new BronzeGoalKeeperCardDecorator(card);
                return card;
            case "silver":
                card = new SilverGoalKeeperCardDecorator(card);
                return card;
            case "gold":
                card = new GoldGoalKeeperCardDecorator(card);
                return card;
            case "hero":
                card = new HeroGoalKeeperCardDecorator(card);
                return card;
            case "icon":
                card = new IconGoalKeeperCardDecorator(card);
                return card;
            default:
                return null;
        }
    }
}