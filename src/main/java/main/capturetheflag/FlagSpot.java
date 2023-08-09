package main.capturetheflag;

public class FlagSpot {

    // Stores position
    private int[] coords;

    // Stores type
    // Can be placeable_op or placeable_ho
    // placeable_op is for the opponent team (so capturing a flag)
    // placeable_ho is for the home team (so the base position of a flag)
    private String type;

    // Stores the team to which the spot belongs
    private GameTeam team;

    public FlagSpot () {

    }

}
