package main.capturetheflag;

import main.utils.Variables;
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
                        Variables.pos1[0] = (int) player.getLocation().getX();
                        Variables.pos1[1] = (int) player.getLocation().getY();
                        Variables.pos1[2] = (int) player.getLocation().getZ();
                        break;
                    case "pos2":
                        Variables.pos2[0] = (int) player.getLocation().getX();
                        Variables.pos2[1] = (int) player.getLocation().getY();
                        Variables.pos2[2] = (int) player.getLocation().getZ();
                        break;
                    case "create":
                        if (args.length < 2) {
                            return false;
                        } else {
                            switch (args[1].toLowerCase()) {
                                case "map":
                                    break;
                                case "flagspot":
                                    break;
                                case "lootchest":
                                    break;
                                case "spawnpoint":
                                    break;
                            }
                        }
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
