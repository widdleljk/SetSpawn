package me.widdleljk.setspawnupdate;

import me.widdleljk.setspawnupdate.commands.SpawnCommand;
import me.widdleljk.setspawnupdate.listeners.SetSpawnListener;
import org.bukkit.plugin.java.JavaPlugin;
import me.widdleljk.setspawnupdate.commands.SetSpawnCommand;

public final class SetSpawnUpdate extends JavaPlugin {
    private static SetSpawnUpdate plugin;

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

    public static SetSpawnUpdate getPlugin() {
        return plugin;
    }
}
