package com.vartala.soulofw0lf.rpgclasses;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tutSkip implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		Player player = (Player)sender;
		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + player.getName() + " class.select");
		player.sendMessage("You can now use </class select> to pick your class!");
		return true;
	}

}
