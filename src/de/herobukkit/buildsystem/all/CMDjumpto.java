package de.herobukkit.buildsystem.all;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import net.md_5.bungee.api.ChatColor;

public class CMDjumpto implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String labels, String[] args) {
		if (cmd.getName().equalsIgnoreCase("jumpto")) {
			if (sender instanceof Player) {
				Player player = (Player)sender;
				if(player.hasPermission("build.team")){
				if (args.length == 1){
					String Name = args[0];
					if (Bukkit.getPlayer(Name) != null){
						Player target = (Player)Bukkit.getPlayer(Name);
						player.teleport(target);
						player.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §eYou where warped to §6" + target.getName());
						return true;
					} else {
						
					}
					
				} else {
					player.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §cTo many or to little argument!");
                    return false;
				}
				
				
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §cInsufficiend permissions!");
			}
			}
		}
		
		return false;
	}

}
