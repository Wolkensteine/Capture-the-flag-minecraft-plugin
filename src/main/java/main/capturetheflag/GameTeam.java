package main.capturetheflag;

import org.bukkit.Color;
import org.bukkit.entity.Player;

public class GameTeam {

    // The following variable stores the members of a team
    private final Player[] members;

    // Defines the team colour
    private final Color color;

    public GameTeam (Color team_color, Player[] team_members) {
        // Assigning values to the variables
        // The team members will be either randomly assigned on game start or via a game command
        color = team_color;
        members = team_members;
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
