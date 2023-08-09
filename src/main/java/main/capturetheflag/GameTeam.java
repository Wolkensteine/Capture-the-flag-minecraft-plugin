package main.capturetheflag;

import org.bukkit.Color;
import org.bukkit.entity.Player;

public class GameTeam {

    // The following variable stores the members of a team
    private Player members;

    // Defines the team colour
    final Color color;

    public GameTeam (Color team_color) {
        color = team_color;
    }

}
