package main.capturetheflag;
import com.google.errorprone.annotations.Var;
import main.utils.Constants;
import main.utils.Variables;
import org.bukkit.Color;
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

    private String name; // Name of the map, makes it easier to interact with when using commands

    private SpawnLocation[] spawns;

    public Map (int team_count, String map_name, int[] beginning, int[] end) {
        // Maximum supported teams is 4 so when trying to generate more return
        // Also return when less than 2 teams would be generated
        if (team_count > 4 || team_count < 2) {
            return;
        }

        teams = new GameTeam[team_count];
        name = map_name;
        begins = beginning;
        ends = end;
        spawns = new SpawnLocation[team_count + 1];

        for (int i = 0; i < teams.length; i++) {
            teams[i] = new GameTeam(Constants.teamColors[i]);
        }
    }

    public SpawnLocation getSpectatorSpawn() {
        return spawns[spawns.length - 1];
    }

    public SpawnLocation getTeamsSpawn(GameTeam team) {
        for (int i = 0; i < spawns.length - 1; i++) {
            if (spawns[i].getTeam() == team) {
                return spawns[i];
            }
        }
        return null;
    }

    // Create a spawn for a team with teams color
    public void createSpawn(int[] coords, Color teamColor) {
        for (int i = 0; i < spawns.length - 1; i++) {
            if (Constants.teamColors[i] == teamColor) {
                spawns[i] = new SpawnLocation(coords, teams[i]);
                break;
            }
        }
    }

    public void createSpawn(int[] coords) {
        // Create spectators spawn
        spawns[spawns.length - 1] = new SpawnLocation(coords);
    }

    public Player[] getParticipatingPlayers() {
        return participatingPlayers;
    }

    public boolean isPlayerParticipating(Player player) {
        for (Player participatingPlayer : participatingPlayers) {
            if (participatingPlayer == player) {
                return true;
            }
        }
        return false;
    }

    public void addPlayerAsParticipator(Player player) {
        Player[] tmp = new Player[participatingPlayers.length + 1];
        System.arraycopy(participatingPlayers, 0, tmp, 0, participatingPlayers.length);
        tmp[participatingPlayers.length] = player;
        participatingPlayers = tmp;
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
    // Attention! When the player is not assigned to a team returns null
    public GameTeam getPlayersTeam(Player player) {
        for (GameTeam team : teams) {
            if (team.isPlayerMember(player)) {
                return team;
            }
        }
        return null;
    }

    // A method to check if a block is part of the map
    public boolean isBlockInMap(Block block) {
        if (begins[0] <= block.getX() && block.getX() >= ends[0]) {
            if (begins[1] <= block.getY() && block.getY() >= ends[1]) {
                return begins[2] <= block.getZ() && block.getZ() >= ends[2];
            }
        }
        return false;
    }

    public void tpPlayersToStart() {
        // TODO create a way to teleport everyone to their start position
    }

    public void fillLootChests() {
        // TODO call fillchest() on all lootchests
        for (LootChest lootchest : lootchests) {
            lootchest.fillchest();
        }
    }

}
