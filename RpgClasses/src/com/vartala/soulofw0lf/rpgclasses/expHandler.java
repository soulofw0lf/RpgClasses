package com.vartala.soulofw0lf.rpgclasses;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class expHandler implements CommandExecutor {
	RpgClasses Rpgc;
	public expHandler(RpgClasses rpgc){
		this.Rpgc = rpgc;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (args[0].equalsIgnoreCase("here")){
			Player player = (Player)sender;
			Double X = player.getLocation().getX();
			Double Y = player.getLocation().getY();
			Double Z = player.getLocation().getZ();
			String world = player.getLocation().getWorld().getName();
			this.Rpgc.getConfig().set("Location.X", X);
			this.Rpgc.getConfig().set("Location.Y", Y);
			this.Rpgc.getConfig().set("Location.Z", Z);
			this.Rpgc.getConfig().set("Location.World", world);
			this.Rpgc.saveConfig();
			return true;
		}


		if (Bukkit.getPlayer(args[0]) != null){
			Player p = Bukkit.getPlayer(args[0]);
			Integer addExp = Integer.parseInt(args[1]);
			Integer oldExp = RpgClasses.playerConfig.getInt(p.getName() + ".Experience");
			Integer newExp = addExp + oldExp;
			RpgClasses.playerConfig.set(p.getName() + ".Experience", newExp);
			try {
				RpgClasses.playerConfig.save(new File("plugins/RpgClasses/Players.yml"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			XpReq.checkLvL(p, newExp);
			return true;
		}
		return false;
	}

}
