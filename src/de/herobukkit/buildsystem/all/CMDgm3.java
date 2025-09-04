package de.herobukkit.buildsystem.all;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class CMDgm3 implements CommandExecutor{
	
public boolean onCommand (CommandSender sender, Command cmd, String labels, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("spec")) {
			if (sender instanceof Player) {
				Player p = (Player)sender;
				if(p.hasPermission("build.team")){
					if(args.length == 0) {
						p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix.System")) + " §8| §7Changed to §eSpectator");
						p.setGameMode(GameMode.SPECTATOR);
						} else {
							p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix.System")) + " §8| §7Use §e/spec");
						}
					
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix.System")) + " §8| §cInsufficient permissions!");
				}
				
			}
			
		}
		return false;
		
		
 }
}
