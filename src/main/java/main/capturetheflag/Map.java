package main.capturetheflag;
import org.bukkit.block.Block;
import org.bukkit.entity.*;

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

    // The following variable stores the player objects of all players online at game start, which wanted to participate in the game
    private Player[] participatingPlayers;

    public Map (int team_count, Player[] players) {
        flags = new Flag[team_count];
        teams = new GameTeam[team_count];
        participatingPlayers = players;
    }

    public boolean isPlayerParticipating(Player player) {
        for (Player participatingPlayer : participatingPlayers) {
            if (participatingPlayer == player) {
                return true;
            }
        }
        return false;
    }

    public void addFlags(Flag[] created_flags) {
        flags = created_flags;
    }

    public void replaceTeamObject(int team_index, GameTeam new_team) {
        teams[team_index] = new_team;
    }

    public void addFlagSpot(int[] coords, String type, GameTeam team) {
        FlagSpot[] tmp = new FlagSpot[flagSpots.length + 1];
        System.arraycopy(flagSpots, 0, tmp, 0, flagSpots.length);
        tmp[flagSpots.length] = new FlagSpot(coords, team, type);
        flagSpots = tmp;
    }

    public boolean isFlagSpot(int[] coords) {
        boolean tmp = false;
        for (FlagSpot flagSpot : flagSpots) {
            if (flagSpot.getCoords() == coords) {
                tmp = true;
            }
        }
        return tmp;
    }

    // Get a flag object
    public Flag getFlag(int index) {
        return flags[index];
    }

    // Check if a player is in a team without needing the team object
    public boolean inPlayerInTeam(Player player, int team_index) {
        return teams[team_index].isPlayerMember(player);
    }

    // Get the team a player is assigned to
    // Attention! When the player is not assigned to a team returns team0
    // This should not be a problem, when checking before if a player is playing the game.
    public GameTeam getPlayersTeam(Player player) {
        for (GameTeam team : teams) {
            if (team.isPlayerMember(player)) {
                return team;
            }
        }
        return teams[0];
    }

    // A method to check if a block is part of the map
    public boolean isBlockInMap(Block block) {
        if (begins[0] <= block.getX() && block.getX() >= ends[0]) {
            if (begins[1] <= block.getY() && block.getY() >= ends[1]) {
                if (begins[2] <= block.getZ() && block.getZ() >= ends[2]) {
                    return true;
                }
            }
        }
        return false;
    }

}
