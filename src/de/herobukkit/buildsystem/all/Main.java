package de.herobukkit.buildsystem.all;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import de.herobukkit.buildsystem.all.Main;

public class Main extends JavaPlugin implements Listener {
	
	private static Main instance;
	
	public static ArrayList<Player> vanish = new ArrayList<Player>();
	
	@EventHandler
	public void onEnable(){
		
		instance = this;
		
		getCommand("build").setExecutor(new CMDgm1());
		getCommand("spec").setExecutor(new CMDgm3());
		getCommand("?").setExecutor(new CMDhelp());
		getCommand("hilfe").setExecutor(new CMDhelp());
		getCommand("help").setExecutor(new CMDhelp());
		getCommand("hide").setExecutor(new CMDhide());
		getCommand("show").setExecutor(new CMDshow());
		getCommand("jumpto").setExecutor(new CMDjumpto());
		getCommand("sb").setExecutor(new CMDscoreboard());
		getCommand("vanish").setExecutor(new CMDvanish());
		getServer().getPluginManager().registerEvents(new Events(), this);
		
		initConfig();
		
		System.out.println("[BuildSystem] geladen");
	}
	
	public static Main getInstance() {
		return instance;
	}
	
	public void initConfig(){

		this.reloadConfig();			
		
		this.getConfig().options().header("Here you can configure some stuff in my plugin");
		this.getConfig().addDefault("Buildsystem.ServerName", "&9&lBuildserver");
		this.getConfig().addDefault("Buildsystem.Prefix.System", "&6BuildSystem");
		
		this.getConfig().addDefault("Buildsystem.Toggle.Scoreboard", true);
		
		this.getConfig().addDefault("Buildsystem.Prefix.Admin", "&4Admin");
		this.getConfig().addDefault("Buildsystem.Prefix.Builder", "&eBuilder");
		this.getConfig().addDefault("Buildsystem.Prefix.Visitor", "&aVisitor");
		
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		System.out.println("[BuildSystem] config.yml succesfully (re)loaded");
    }
}
