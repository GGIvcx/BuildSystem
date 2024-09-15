package de.herobukkit.buildsystem.all;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.help.HelpTopic;

import net.md_5.bungee.api.ChatColor;

public class Events implements Listener {
	
	public static ArrayList<Player> derprefix = new ArrayList<Player>();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if (p.hasPermission("build.admin")){
			p.setGameMode(GameMode.CREATIVE);
			p.setPlayerListName("§4Admin §8» §7" + p.getName());
			p.sendTitle("§6Welcome","§4Administrator §7" + p.getName());
			e.setJoinMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §7Administrator §4" + p.getName() + " §7joined the game");
		} else if (p.hasPermission("build.team")){
			//for (Player all : Bukkit.getOnlinePlayers()) {
			//	ScoreboardClass.sendScoreboard(all);
			//}
			p.setPlayerListName("§eBuilder §8» §7" + p.getName());
			p.setGameMode(GameMode.CREATIVE);
			e.setJoinMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §7Builder §e" + p.getName() + " §7joined the game");
			p.sendTitle("§6Welcome","§eBuilder §7" + p.getName());			
		} else {
			//for (Player all : Bukkit.getOnlinePlayers()) {
			//	ScoreboardClass.sendScoreboard(all);
			//}
			p.setGameMode(GameMode.SPECTATOR);
			p.setPlayerListName("§7Spec §8» §7" + p.getName());
			e.setJoinMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §7Visitor §8" + p.getName() + " §7joined the game");
			p.sendTitle("§6Welcome","§7" + p.getName());
		}
		//Push scoreboard on join
		ScoreboardClass.sendScoreboard(p);
		
		//for (Player all : Bukkit.getOnlinePlayers()) {
		//	ScoreboardClass.sendScoreboard(all);
		//}
		
	}
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		//for (Player all : Bukkit.getOnlinePlayers()) {
		//	ScoreboardClass.sendScoreboard(all);
		//}
		Player p = e.getPlayer();
		if (p.hasPermission("build.admin")){
			e.setQuitMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §7Administrator §4" + p.getName() + " §7left the game");
		} else if (p.hasPermission("build.team")){
			e.setQuitMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §7Builder §e" + p.getName() + " §7left the game");
		} else {
			e.setQuitMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §7Visitor §8" + p.getName() + " §7left the game");
			}
		}
	@EventHandler(priority = EventPriority.NORMAL)
    public void onfalseCommand(PlayerCommandPreprocessEvent event) {
    	if (!(event.isCancelled())) {
    		Player p = event.getPlayer();
    		String msg = event.getMessage().split(" ")[0];
    		HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(msg);
    		if (topic == null) {
    			p.sendMessage(ChatColor.translateAlternateColorCodes ('&', Main.getInstance().getConfig().getString("Buildsystem.Prefix")) + " §8| §7Unknown command");
    			event.setCancelled(true);
    		}
    	}
    }
}

