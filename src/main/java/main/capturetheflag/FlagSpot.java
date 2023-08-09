package main.capturetheflag;

public class FlagSpot {

    // Stores position
    private final int[] coords;

    // Stores type
    // Can be placeable_op or placeable_ho
    // placeable_op is for the opponent team (so capturing a flag)
    // placeable_ho is for the home team (so the base position of a flag)
    private final String type;

    // Stores the team to which the spot belongs
    private final GameTeam team;

    public FlagSpot (int[] given_coords, GameTeam assigned_team, String assigned_type) {
        // Defining variables which are given via a command
        coords = given_coords;
        type = assigned_type;
        team = assigned_team;
    }

    public int[] getCoords() {
        return coords;
    }

    public String getType() {
        return type;
    }

    public GameTeam getTeam() {
        return team;
    }

}
