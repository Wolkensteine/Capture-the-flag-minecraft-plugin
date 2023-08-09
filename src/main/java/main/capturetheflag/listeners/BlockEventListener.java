package main.capturetheflag.listeners;

import main.capturetheflag.CaptureTheFlag;
import main.utils.Variables;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockEventListener implements Listener {

    @EventHandler
    public void BlockBreak(BlockBreakEvent e) {
        // Handle the event if the block is part of the current map
        if (Variables.currentMap.isBlockInMap(e.getBlock())) {

        }
    }

    @EventHandler
    public void BlockPlace(BlockPlaceEvent e) {
        // Handle the event if the block is part of the current map
        if (Variables.currentMap.isBlockInMap(e.getBlock())) {

        }
    }

    @EventHandler
    public void BlockExplode(BlockExplodeEvent e) {
        // Handle the event if the block is part of the current map
        if (Variables.currentMap.isBlockInMap(e.getBlock())) {

        }
    }

}
