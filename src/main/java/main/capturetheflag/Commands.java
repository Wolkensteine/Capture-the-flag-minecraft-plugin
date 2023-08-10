package main.capturetheflag;

import com.google.errorprone.annotations.Var;
import main.utils.Variables;
import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            if (args.length < 1) {
                return false;
            } else {
                Player player = (Player) sender;
                switch (args[0].toLowerCase()) {
                    case "pos1":
                        // Set the first position for creating a map
                        Variables.pos1[0] = (int) player.getLocation().getX();
                        Variables.pos1[1] = (int) player.getLocation().getY();
                        Variables.pos1[2] = (int) player.getLocation().getZ();
                        break;
                    case "pos2":
                        // Set the second position for creating a map
                        Variables.pos2[0] = (int) player.getLocation().getX();
                        Variables.pos2[1] = (int) player.getLocation().getY();
                        Variables.pos2[2] = (int) player.getLocation().getZ();
                        break;
                    case "create":
                        // Create something
                        if (args.length < 2) {
                            // As this command needs information about what should be created return when not enough args are present
                            return false;
                        } else {
                            switch (args[1].toLowerCase()) {
                                case "map":
                                    // Check if the argument for how many teams there are on the map is set and if the name parameter is there
                                    if (args.length < 4) {
                                        return false;
                                    } else {
                                        if (Variables.pos1 != null && Variables.pos2 != null && Variables.pos1 != Variables.pos2) {
                                            // Define temporary variables which will store the lowest and highest values for a coordinate, so they can be passed to the map class
                                            int[] tmpsmall = new int[3];
                                            int[] tmpbig = new int[3];

                                            // Determine which of the coords is smaller and set it for the lowest value the other will be set to the highest
                                            for (int i = 0; i < 3; i++) {
                                                if (Variables.pos1[i] < Variables.pos2[i]) {
                                                    tmpsmall[i] = Variables.pos1[i];
                                                    tmpbig[i] = Variables.pos2[i];
                                                } else {
                                                    tmpbig[i] = Variables.pos1[i];
                                                    tmpsmall[i] = Variables.pos2[i];
                                                }
                                            }

                                            // Create map object and add it to the maps array
                                            // If maps array is empty just create it else append to it
                                            if (Variables.maps.length == 0) {
                                                Variables.maps = new Map[1];
                                                Variables.maps[0] = new Map(Integer.parseInt(args[2]), args[3], tmpsmall, tmpbig);
                                                Variables.currentMap = Variables.maps[0];
                                                player.sendMessage("You have created the first map, it was set as the active map.");
                                            } else {
                                                Map[] tmp = new Map[Variables.maps.length + 1];
                                                System.arraycopy(Variables.maps, 0, tmp, 0, Variables.maps.length);
                                                tmp[Variables.maps.length] = new Map(Integer.parseInt(args[2]), args[3], tmpsmall, tmpbig);
                                                Variables.maps = tmp;
                                                player.sendMessage("You have created the " + Variables.maps.length + " map.");
                                            }
                                        } else {
                                            // Pos1 and Pos2 are not set
                                            player.sendMessage("You need to first define the volume of the map by using '/CTF pos1' and '/CTF pos2' in the corners of the volume.");
                                        }
                                    }
                                    break;
                                case "flagspot":
                                    // Checks if all arguments are set (type and team)
                                    if (args.length < 4) {
                                        return false;
                                    } else {
                                        // TODO create a flag spot
                                    }
                                    break;
                                case "lootchest":
                                    // TODO create a loot-chest
                                    break;
                                case "spawnpoint":
                                    // Checks if all argument team is set
                                    // If team left empty it will be assumed as a spectators spawn
                                    if (args.length < 3) {
                                        int[] tmp = {(int) player.getLocation().getX(), (int) player.getLocation().getY(), (int) player.getLocation().getZ()};
                                        Variables.currentMap.createSpawn(tmp);
                                    } else {
                                        String tmp = args[2].toLowerCase();
                                        int[] tmp2 = {(int) player.getLocation().getX(), (int) player.getLocation().getY(), (int) player.getLocation().getZ()};
                                        switch (tmp) {
                                            case "red":
                                                Variables.currentMap.createSpawn(tmp2, Color.RED);
                                                break;
                                            case "blue":
                                                Variables.currentMap.createSpawn(tmp2, Color.BLUE);
                                                break;
                                            case "green":
                                                Variables.currentMap.createSpawn(tmp2, Color.GREEN);
                                                break;
                                            case "orange":
                                                Variables.currentMap.createSpawn(tmp2, Color.ORANGE);
                                                break;
                                        }
                                    }
                                    break;
                            }
                        }
                        break;
                    case "start":
                        // Call the kit promt for all players that used the participate command
                        KitSelection.kitpromt(Variables.currentMap.getParticipatingPlayers());
                        // TODO start the game
                        // Teleport all players to their startpositions
                        // Give a random player of each team the flag of that team to place down
                        // Fill loot chests
                        break;
                    case "participate":
                        Variables.currentMap.addPlayerAsParticipator(player);
                        break;
                    default:
                        return false;
                }
            }
        } else {
            sender.sendMessage("Only players can execute this command!");
        }
        return true;
    }
}
