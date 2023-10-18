package me.widdleljk.setspawnupdate.commands;

import me.widdleljk.setspawnupdate.SetSpawnUpdate;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
    private final SetSpawnUpdate plugin;

    public SpawnCommand(SetSpawnUpdate plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            Location location = (Location) plugin.getConfig().get("spawn");

            if (location != null) {
                player.teleport(location);

                player.sendMessage("You are have been teleported to spawn!");
            } else {
                player.sendMessage("§cThere is no spawn point set\n§cPlease contact us on discord!");
            }
        }

        return true;
    }
}
