package de.herobukkit.buildsystem.all;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class CMDhelp implements CommandExecutor{
	
	
	public boolean onCommand (CommandSender sender, Command cmd, String labels, String[] args) {
		
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("help") || cmd.getName().equalsIgnoreCase("hilfe") || cmd.getName().equalsIgnoreCase("?")) {
			if (sender instanceof Player) {
				if (p.hasPermission("build.admin")) {
					p.sendMessage("§7");
					p.sendMessage("§7");
					p.sendMessage("§7");
					p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §7-x-x-x-x-x-§aHilfecenter§7-x-x-x-x-x-x-");
					p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §7You are a §4Administrator§7,");
					p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §7Commands:");
					p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §9/build §8» §7GM1 shortcut");
					p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §9/jumpto [Player] §8» §7Warp to a Player");
					p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §9/hide [Player] §8» §7Vanish yourself or others");
					p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §9/show [Player] §8» §7Unvanish yourself or others");
					p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §7-x-x-x-x-x-§aHilfecenter§7-x-x-x-x-x-x-");
					p.sendMessage("§7");
				}else if (p.hasPermission("build.team")) {
					p.sendMessage("§7");
					p.sendMessage("§7");
					p.sendMessage("§7");
					p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §7-x-x-x-x-x-§aHilfecenter§7-x-x-x-x-x-x-");
					p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §7You are a §4Administrator§7,");
					p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §7Commands:");
					p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §9/build §8» §7GM1 shortcut");
					p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §9/jumpto [Player] §8» §7Warp to a Player");
					p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §9/hide §8» §7Vanish yourself or others");
					p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §9/show §8» §7Unvanish yourself or others");
					p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §7-x-x-x-x-x-§aHilfecenter§7-x-x-x-x-x-x-");
					p.sendMessage("§7");
				} else {
					p.sendMessage("§7");
					p.sendMessage("§7");
					p.sendMessage("§7");
					p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §7-x-x-x-x-x-§aHilfecenter§7-x-x-x-x-x-x-");
					p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §7On the §9Buildserver §7 only §eBuilders");
					p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §7can build. As a §aVisitor");
					p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §7you can only spectate.");
					p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §7-x-x-x-x-x-§aHilfecenter§7-x-x-x-x-x-x-");
					p.sendMessage("§7");
				}
			}
			
		} else {
			p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §7Use §9/help §7!");
		}
		return false;
		
	}
	
    
	

}
