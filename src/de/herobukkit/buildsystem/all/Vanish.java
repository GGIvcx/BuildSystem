package de.herobukkit.buildsystem.all;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Vanish {
	
	public static void hidePlayer (Player player, String[] args) {
		if(args.length == 0) {
			if (player.hasPermission("build.admin")) {
				for (Player all : Bukkit.getOnlinePlayers()) {
					all.hidePlayer(player);
					if(all.hasPermission("build.team")) {
						all.showPlayer(player);
					}
				}
				player.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix.System")) + " §8| §7You are now §3vanished");
				player.setPlayerListName("§4Admin §8§ §7" + player.getName() + " §8| §9V");
			} else if(player.hasPermission("build.team")) {
				for (Player all : Bukkit.getOnlinePlayers()) {
					all.hidePlayer(player);
					if(all.hasPermission("build.team")) {
						all.showPlayer(player);
					}
				}
				player.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix.System")) + " §8| §7You are now §3vanished");
				player.setPlayerListName("§eBuilder §8§ §7" + player.getName() + " §8| §9V");
			}
		} else if(args.length == 1) {
			if(player.hasPermission("build.admin")){
				Player target = Bukkit.getPlayer(args[0]);
				if(target != null){
					if(target.hasPermission("build.admin")) {
						target.setPlayerListName("§4Admin §8§ §7" + target.getName() + " §8| §9V");
						for (Player all : Bukkit.getOnlinePlayers()) {
							all.hidePlayer(target);
							if(all.hasPermission("build.team")) {
								all.showPlayer(target);
							}
							
						}
						player.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix.System")) + " §8| §7The Player §e" + target.getName() + " §7is §3vanished §7now");
					} else if(target.hasPermission("build.team")) {
						target.setPlayerListName("§eBuilder §8§ §7" + target.getName() + " §8| §9V");
						for (Player all : Bukkit.getOnlinePlayers()) {
							all.hidePlayer(target);
							if(all.hasPermission("build.team")) {
								all.showPlayer(target);
							}
							
						}
					} else {
						target.setPlayerListName("§7Spec §8§ §7" + target.getName() + " §8| §9V");
						for (Player all : Bukkit.getOnlinePlayers()) {
							all.hidePlayer(target);
							if(all.hasPermission("build.team")) {
								all.showPlayer(target);
							}
							
						}
					}
				}
			} 
				
			
		}
	}
	
	public static void showPlayer (Player player, String[] args) {
		if(args.length == 0) {
			if (player.hasPermission("build.admin")) {
				player.setPlayerListName("§4Admin §8§ §7" + player.getName());
				player.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix.System")) + " §8| §7You are now §3unvanished");
				for (Player all : Bukkit.getOnlinePlayers()) {
					all.showPlayer(player);
				}
			} else if (player.hasPermission("build.team")) {
				player.setPlayerListName("§eBuilder §8§ §7" + player.getName());
				player.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix.System")) + " §8| §7You are now §3unvanished");
				for (Player all : Bukkit.getOnlinePlayers()) {
					all.showPlayer(player);
				}
			}
		} else if(args.length == 1) {
			if(player.hasPermission("build.admin")) {
				Player target = Bukkit.getPlayer(args[0]);
				if(target != null){
					if(target.hasPermission("build.admin")) {
						target.setPlayerListName("§4Admin §8§ §7" + target.getName());
						for (Player all : Bukkit.getOnlinePlayers()) {
							all.showPlayer(target);
							
						}	
					} else if (target.hasPermission("build.team")){
						target.setPlayerListName("§eBuilder §8§ §7" + target.getName());
						for (Player all : Bukkit.getOnlinePlayers()) {
							all.showPlayer(target);
							
						}
					} else {
						target.setPlayerListName("§7Spec §8§ §7" + target.getName());
						for (Player all : Bukkit.getOnlinePlayers()) {
							all.showPlayer(target);
							
						}
					}
				}
			}
		}
	}

}
