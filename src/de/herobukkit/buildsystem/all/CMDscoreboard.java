package de.herobukkit.buildsystem.all;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
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
						FileConfiguration config = Main.getInstance().getConfig();
						config.set("Buildsystem.Toggle.Scoreboard", true);
						Main.getInstance().saveConfig();
						for (Player all : Bukkit.getOnlinePlayers()) {
							ScoreboardClass.sendScoreboard(all);
						}
						player.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix.System")) + " §8| §7The Scoreboard was §aenabled§7!");
					} else if (args[0].equalsIgnoreCase("off")) {
						FileConfiguration config = Main.getInstance().getConfig();
						config.set("Buildsystem.Toggle.Scoreboard", false);
						Main.getInstance().saveConfig();
						for (Player all : Bukkit.getOnlinePlayers()) {
							all.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
						}
						player.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix.System")) + " §8| §7The Scoreboard was §cdisabled§7!");
						
					} else {
						player.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix.System")) + " §8| §7Please use §9/sb <On/Off>§7!");
					}
					
					
				} else {
					player.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix.System")) + " §8| §7Please use §9/sb <On/Off>§7!");
				}
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix.System")) + " §8| §cInsufficient permissions!");
			}
			
		}
	}
		return false;

  }
	

}
