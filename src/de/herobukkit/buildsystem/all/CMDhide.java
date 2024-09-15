package de.herobukkit.buildsystem.all;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class CMDhide implements CommandExecutor{
	
	
	public boolean onCommand (CommandSender sender, Command cmd, String labels, String[] args) {
		
		
		if(cmd.getName().equalsIgnoreCase("hide")) {
			if (sender instanceof Player) {
				Player p = (Player)sender;
				if(p.hasPermission("build.team")){
					if(args.length == 0) {
						if (p.hasPermission("build.admin")) {
						p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §7You are now §3vanished");
						p.setPlayerListName("§4Admin §8» §7" + p.getName() + " §8| §9V");
						for (Player all : Bukkit.getOnlinePlayers()) {
							all.hidePlayer(p);
							if(all.hasPermission("build.team")) {
								all.showPlayer(p);
							}
						}
						} else if(p.hasPermission("build.team")) {
							p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §7You are now §3vanished");
							p.setPlayerListName("§eBuilder §8» §7" + p.getName() + " §8| §9V");
							for (Player all : Bukkit.getOnlinePlayers()) {
								all.hidePlayer(p);
								if(all.hasPermission("build.team")) {
									all.showPlayer(p);
								}
							}
						}
					} else if(args.length == 1) {
						if(p.hasPermission("build.admin")){
						Player target = Bukkit.getPlayer(args[0]);
						if(target != null){
							
							if(target.hasPermission("build.admin")) {
								
								target.setPlayerListName("§4Admin §8» §7" + target.getName() + " §8| §9V");
								for (Player all : Bukkit.getOnlinePlayers()) {
									all.hidePlayer(target);
									if(all.hasPermission("build.team")) {
										all.showPlayer(target);
									}
									
								}
							p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §7The Player §e" + target.getName() + " §7is §3vanished §7now");
						} else if(target.hasPermission("build.team")) {
							target.setPlayerListName("§eBuilder §8» §7" + target.getName() + " §8| §9V");
							for (Player all : Bukkit.getOnlinePlayers()) {
								all.hidePlayer(target);
								if(all.hasPermission("build.team")) {
									all.showPlayer(target);
								}
								
							}
							
						} else {
							target.setPlayerListName("§7Spec §8» §7" + target.getName() + " §8| §9V");
							for (Player all : Bukkit.getOnlinePlayers()) {
								all.hidePlayer(target);
								if(all.hasPermission("build.team")) {
									all.showPlayer(target);
								}
								
							}
						}
						} else
							p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §cThe Player §e" + args[0] + " §ccould not be found");
						} else
							p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §cInsufficiend permissions!");
					} else
						p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §7Use §9/hide <Player>§7!");
					
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §cInsufficiend permissions!");
				}
				
			}
			
		}
		return false;
		
		
	}
	

}