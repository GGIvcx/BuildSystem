package de.herobukkit.buildsystem.all;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import net.md_5.bungee.api.ChatColor;



public class ScoreboardClass {
	
	
	public static void sendScoreboard(Player player) {
		
		
		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective objective = board.getObjective("aaa") != null ? board.getObjective("aaa") : board.registerNewObjective("aaa", "bbb");
		
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.ServerName")));
		objective.getScore("         ").setScore(16);
		objective.getScore("§7Status:").setScore(15);
		if(player.hasPermission("build.admin")) {
			objective.getScore("§8 » §4Administrator").setScore(14);
		} else if(player.hasPermission("build.team")) {
			objective.getScore("§8 » §eBuilder").setScore(14);
		} else {
			objective.getScore("§8 » §aVisitor").setScore(14);
		}
		objective.getScore("     ").setScore(12);
		objective.getScore("§7Name:").setScore(11);
		objective.getScore("§8 » §e" + player.getName()).setScore(10);
		objective.getScore("        ").setScore(9);
		player.setScoreboard(board);
	}
	
	

}
