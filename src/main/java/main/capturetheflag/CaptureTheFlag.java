package main.capturetheflag;

import main.capturetheflag.listeners.BlockEventListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class CaptureTheFlag extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new BlockEventListener(), this); // Add BlockEventListener
        Objects.requireNonNull(this.getCommand("CTF")).setExecutor(new Commands()); // Add the main command
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
