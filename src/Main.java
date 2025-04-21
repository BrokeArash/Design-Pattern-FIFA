import Builders.GoalKeeperCardBuilder;
import Builders.PlayerCardBuilder;
import Decorators.GoalKeeperCardDecorators.*;
import Decorators.PlayerDecorators.*;
import Directors.Director;
import Models.*;
import Strategies.AggressiveStrategy;
import Strategies.BalancedStrategy;
import Strategies.DefensiveStrategy;
import Strategies.PlayStyle;
import java.util.Scanner;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Card card;
        while (true) {
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
                System.out.println();
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
                        switch (position) {
                            case "gk" -> {
                                card = Barcelona.getGoalie();
                                card = decorateGoalKeeper((GoalKeeperInterface) card, decoration);
                                Barcelona.changeGoalie((GoalKeeperInterface) card);
                            }
                            case "cb" -> {
                                card = Barcelona.getDefender();
                                card = decoratePlayer((PlayerInterface) card, decoration);
                                Barcelona.changeDefender((PlayerInterface) card);
                            }
                            case "st" -> {
                                card = Barcelona.getStriker();
                                card = decoratePlayer((PlayerInterface) card, decoration);
                                Barcelona.changeStriker((PlayerInterface) card);
                            }
                        }
                        Barcelona.spendMoney(card.getPrice());
                        break;
                    case SetPlayStyle:
                        Matcher setPlayStyle = Regexes.SetPlayStyle.getMatcher(input);
                        position = setPlayStyle.group("position");
                        String playStyle = setPlayStyle.group("style");
                        if (position.equals("st")) {
                            PlayerInterface thisCard = Barcelona.getStriker();
                            setStrategy(playStyle, thisCard);
                        } else if (position.equals("cb")) {
                            PlayerInterface thisCard = Barcelona.getDefender();
                            setStrategy(playStyle, thisCard);
                        } else {
                            break;
                        }
                        break;
                    case ShowLineup:
                        try {
                            System.out.print("striker: " +
                                    Barcelona.getStriker().getName() + " " +
                                    Barcelona.getStriker().getNationality() + " " +
                                    Barcelona.getStriker().getShooting() + " " +
                                    Barcelona.getStriker().getPace() + " " +
                                    Barcelona.getStriker().getDribbling() + " " +
                                    Barcelona.getStriker().getPhysic() + " " +
                                    Barcelona.getStriker().getPassing() + " " +
                                    Barcelona.getStriker().getDefending() + " ");
                            System.out.println(Barcelona.getStriker().getStyle().getName());
                        } catch (Exception error) {
                            System.out.println("striker: ");
                        }
                        try {
                            System.out.println("center back: " +
                                    Barcelona.getDefender().getName() + " " +
                                    Barcelona.getDefender().getNationality() + " " +
                                    Barcelona.getDefender().getShooting() + " " +
                                    Barcelona.getDefender().getPace() + " " +
                                    Barcelona.getDefender().getDribbling() + " " +
                                    Barcelona.getDefender().getPhysic() + " " +
                                    Barcelona.getDefender().getPassing() + " " +
                                    Barcelona.getDefender().getDefending() + " " +
                                    Barcelona.getDefender().getStyle().getName());
                        } catch (Exception error) {
                            System.out.println("center back: ");
                        }
                        try {
                            System.out.println("goal keeper: " +
                                    Barcelona.getGoalie().getName() + " " +
                                    Barcelona.getGoalie().getNationality() + " " +
                                    Barcelona.getGoalie().getDiving() + " " +
                                    Barcelona.getGoalie().getHandling() + " " +
                                    Barcelona.getGoalie().getReflex() + " " +
                                    Barcelona.getGoalie().getPositioning() + " " +
                                    Barcelona.getGoalie().getKicking() + " " +
                                    Barcelona.getGoalie().getSpeed());
                        } catch (Exception error) {
                            System.out.println("goal keeper: ");
                        }
                        break;
                    case ShowMoney:
                        System.out.println(Barcelona.getMoney());
                        break;
                    case CalculateTeamPower:
                        PlayerInterface st = Barcelona.getStriker();
                        PlayerInterface cb = Barcelona.getDefender();
                        GoalKeeperInterface gk = Barcelona.getGoalie();
                        int stOverall = 0;
                        int cbOverall = 0;
                        int gkOverall = 0;
                        try {
                            stOverall = st.getOverall();
                        } catch (Exception ignored) {}
                        try {
                            cbOverall = cb.getOverall();
                        } catch (Exception ignored) {}
                        try {
                            gkOverall = gk.getOverall();
                        } catch (Exception ignored){}
                        int sum = (stOverall + cbOverall + gkOverall)/3;

                        Barcelona.setOverall(sum);
                        System.out.println(sum);
                        break;
                    case Soot:
                        if (Barcelona.getOverall() > 90) {
                            System.out.println("Visca Barca");
                        } else if (Barcelona.getOverall() == 90) {
                            System.out.println("draw");
                        } else {
                            System.out.println("Hala Madrid");
                        }
                        System.exit(0);
                }
            }
        }
    }

    private static void setStrategy(String playStyle, PlayerInterface thisCard) {
        if (playStyle.equals("aggressive")) {
            PlayStyle aggressiveStrategy = new AggressiveStrategy(thisCard);
            thisCard.setStyle(aggressiveStrategy);
            Barcelona.spendMoney(aggressiveStrategy.getPrice());
        } else if (playStyle.equals("defensive")) {
            PlayStyle defensiveStrategy = new DefensiveStrategy(thisCard);
            thisCard.setStyle(defensiveStrategy);
            Barcelona.spendMoney(defensiveStrategy.getPrice());
        } else {
            PlayStyle balancedStrategy = new BalancedStrategy(thisCard);
            thisCard.setStyle(balancedStrategy);
            Barcelona.spendMoney(balancedStrategy.getPrice());
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