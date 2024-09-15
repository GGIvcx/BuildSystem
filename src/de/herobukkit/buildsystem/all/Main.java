package de.herobukkit.buildsystem.all;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import de.herobukkit.buildsystem.all.Main;

public class Main extends JavaPlugin implements Listener {
	
	private static Main instance;
	
	@EventHandler
	public void onEnable(){
		
		instance = this;
		
		getCommand("build").setExecutor(new CMDgm1());
		getCommand("?").setExecutor(new CMDhelp());
		getCommand("hilfe").setExecutor(new CMDhelp());
		getCommand("help").setExecutor(new CMDhelp());
		getCommand("hide").setExecutor(new CMDhide());
		getCommand("show").setExecutor(new CMDshow());
		getCommand("jumpto").setExecutor(new CMDjumpto());
		getCommand("sb").setExecutor(new CMDscoreboard());
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
		this.getConfig().addDefault("Buildsystem.Prefix", "&6BuildSystem");
		
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		System.out.println("[BuildSystem] config.yml succesfully (re)loaded");
    }
}
