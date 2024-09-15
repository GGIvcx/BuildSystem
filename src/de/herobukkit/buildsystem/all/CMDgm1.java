package de.herobukkit.buildsystem.all;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class CMDgm1  implements CommandExecutor{
	
	
	public boolean onCommand (CommandSender sender, Command cmd, String labels, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("build")) {
			if (sender instanceof Player) {
				Player p = (Player)sender;
				if(p.hasPermission("build.team")){
					if(args.length == 0) {
						//for (Player all : Bukkit.getOnlinePlayers()) {
						//	ScoreboardClass.sendScoreboard(all);
						//}
						p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §7Now you can §eBuild");
						p.setGameMode(GameMode.CREATIVE);
						} else {
							p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §7Use §e/build");
						}
					
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §cInsufficient permissions!");
				}
				
			}
			
		}
		return false;
		
		
 }
	

}
