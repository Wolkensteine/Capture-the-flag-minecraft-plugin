package main.capturetheflag;

public class Map {

    // The following 2 arrays define the volume in which the map is
    // begins[0] would be the beginning x-position
    // begins[1] would be the beginning y-position
    // begins[2] would be the beginning z-position
    // ends[0] would be the ending x-position
    // ends[1] would be the ending y-position
    // ends[2] would be the ending z-position
    private int[] begins;
    private int[] ends;

    // This is an array of flags, which internally store which team they're for and where they are placed
    // TODO create class Flag
    private Flag[] flags;

    // The following array saves the different places where a flag can be placed, the home spots as well as the ones where they're placed when captured
    // TODO create FlagSpot class
    private FlagSpot[] flagSpots;

    // The following array stores the teams which internally store data about the players, colour and so on
    // TODO create class GameTeam
    private GameTeam[] teams;

    // The following array stores the positions of loot-chests which have to be filled before starting the game with items
    private LootChest[] lootchests;

    public Map () {

    }

    public Flag getFlag(int index) {
        return flags[index];
    }

}
