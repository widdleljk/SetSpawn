package me.skycraftalfieedyvean.setspawn;

import me.skycraftalfieedyvean.setspawn.commands.SetSpawnCommand;
import me.skycraftalfieedyvean.setspawn.commands.SpawnCommand;
import me.skycraftalfieedyvean.setspawn.listeners.SetSpawnListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class SetSpawn extends JavaPlugin {
    private static SetSpawn plugin;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new SetSpawnListener(this), this);

        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));

        plugin = this;

        getConfig().options().copyDefaults();
        saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static SetSpawn getPlugin() {
        return plugin;
    }
}
