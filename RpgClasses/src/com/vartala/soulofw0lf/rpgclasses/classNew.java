package com.vartala.soulofw0lf.rpgclasses;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class classNew implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		Player player = (Player)sender;
		if (args.length <= 0){
			player.sendMessage("Please use </class select> to pick your class!");
			return true;
		}
		if (args[0].equalsIgnoreCase("select")){
			if (!(player.hasPermission("class.select"))){
				player.sendMessage("You don't have permission to perform this command!");
				return true;
			}
		ClassViewer.classSelector(player);
		return true;
		}
		player.sendMessage("Please use </class select> to pick your class!");
		return true;
	}

}
