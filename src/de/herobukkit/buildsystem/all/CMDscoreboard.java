package de.herobukkit.buildsystem.all;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class CMDscoreboard implements CommandExecutor{
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("sb")){
		if(sender instanceof Player){
			Player player = (Player) sender;
			if(player.hasPermission("build.team")){
				if(args.length == 1){
					if (args[0].equalsIgnoreCase("on")) {
						ScoreboardClass.sendScoreboard(player);
						player.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §7The Scoreboard was §aenabled §7for you!");
					} else if (args[0].equalsIgnoreCase("off")) {
						player.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §7The Scoreboard was §cdisabled §7for you!");
						player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
						
					} else {
						player.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §7Please use §9/sb <On/Off>§7!");
					}
					
					
				} else {
					player.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §7Please use §9/sb <On/Off>§7!");
				}
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §cInsufficient permissions!");
			}
			
		}
	}
		return false;

  }
	

}
