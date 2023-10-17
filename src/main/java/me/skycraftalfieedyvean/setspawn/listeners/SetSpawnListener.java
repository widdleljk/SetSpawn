package me.skycraftalfieedyvean.setspawn.listeners;

import me.skycraftalfieedyvean.setspawn.SetSpawn;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class SetSpawnListener implements Listener {
    private final SetSpawn plugin;

    public SetSpawnListener(SetSpawn plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        Location location = (Location) plugin.getConfig().get("spawn");

        if(location != null) {
            player.teleport(location);

            player.sendMessage("You have been teleported to the spawn point.");
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e) {
        Location location = (Location) plugin.getConfig().get("spawn");
        if (location != null) {
            e.setRespawnLocation(location);
        }
    }
}
