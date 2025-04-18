package Models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Regexes {

    BuildPlayer("build player (?<name>\\S+) (?<nationality>\\S+) (?<shooting>\\d+) (?<pace>\\d+)" +
            " (?<dribbling>\\d+) (?<physic>\\d+) (?<passing>\\d+) (?<defending>\\d+)"),
    BuildGoalie("build goalie (?<name>\\S+) (?<nationality>\\S+) (?<diving>\\d+) (?<handling>\\d+)" +
            " (?<reflex>\\d+) (?<positioning>\\d+) (?<kicking>\\d+) (?<speed>\\d+)"),
    Buy("buy (?<playerName>\\S+)"),
    Sell("sell (?<playerName>\\S+)"),
    Select("select (?<position>(st|cb|gk)) (?<playerName>\\S+)"),
    SetDecoration("set decoration (?<position>(st|cb|gk)) (?<decoration>(bronze|silver|gold|hero|icon))"),
    SetPlayStyle("set play style (?<position>(st|cb)) (?<style>(aggressive|defensive|balanced))"),
    ShowLineup("show lineup"),
    ShowMoney("show money"),
    CalculateTeamPower("calculate team power"),
    Soot("soot");

    private final String pattern;

    Regexes(String pattern) {
        this.pattern = pattern;
    }

    public Matcher getMatcher(String input) {
        Matcher matcher = Pattern.compile(this.pattern).matcher(input);
        if (matcher.matches()) {
            return matcher;
        }
        return null;
    }

}
