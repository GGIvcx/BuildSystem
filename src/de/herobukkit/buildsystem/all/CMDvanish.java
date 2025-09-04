package de.herobukkit.buildsystem.all;

import org.bukkit.Effect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDvanish implements CommandExecutor{
	
public boolean onCommand(CommandSender sender, Command cmd, String labels, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("vanish")) {
			if (sender instanceof Player){
				
				Player p = (Player)sender;
				
				if(p.hasPermission("build.team")) {

						if(Main.vanish.contains(p)) {
							Main.vanish.remove(p);
							Vanish.showPlayer(p, args);
							
							if(args.length == 0) {
								for(int i=0;i<=10;i++){
									p.getWorld().playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 0);
								}
							}
						} else {
							Main.vanish.add(p);
							Vanish.hidePlayer(p, args);
							
							if(args.length == 0) {
								for(int i=0;i<=10;i++){
									p.getWorld().playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 0);
								}
							}
							
						}
				
					
				} else {
					p.sendMessage("§6" + Main.getInstance().getConfig().getString("BuildSystem.Prefix.System") + "§8 | §7You need to be §eBuilder §7or higher");
				}
			}
		
		}

		return false;
		}

}
