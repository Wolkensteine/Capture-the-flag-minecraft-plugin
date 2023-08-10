package main.capturetheflag;

import org.bukkit.Color;
import org.bukkit.entity.Player;

public class GameTeam {

    // The following variable stores the members of a team
    private Player[] members;

    // Defines the team colour
    private final Color color;

    public GameTeam (Color team_color) {
        color = team_color;
    }

    // When starting the game this will be used to add the players to the teams
    public void addPlayers(Player[] players) {
        members = players;
    }

    public Color getColor() {
        return color;
    }

    public boolean isPlayerMember(Player player) {
        boolean tmp = false;
        for (Player member : members) {
            if (member == player) {
                tmp = true;
                break;
            }
        }
        return tmp;
    }

}
