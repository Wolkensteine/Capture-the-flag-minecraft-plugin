package main.capturetheflag;

import main.capturetheflag.listeners.BlockEventListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class CaptureTheFlag extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new BlockEventListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
