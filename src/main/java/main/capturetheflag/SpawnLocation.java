package main.capturetheflag;

import org.bukkit.scoreboard.Team;

public class SpawnLocation {

    // Store the coordinates of the spawn location
    int[] coords;

    // Store the team for which the spawn was made
    GameTeam team = null;

    public SpawnLocation(int[] coordinates, GameTeam gTeam) {
        team = gTeam;
        coords = coordinates;
    }

    public SpawnLocation(int[] coordinates) {
        coords = coordinates;
    }

    public GameTeam getTeam() {
        return team;
    }

}
