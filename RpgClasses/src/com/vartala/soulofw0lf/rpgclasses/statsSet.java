package com.vartala.soulofw0lf.rpgclasses;
import java.io.File;
import java.io.IOException;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;


public class statsSet {
	public static void statSaver(Player p, String string, Integer str1, Integer dex1, Integer con1, Integer intel1, Integer wis1, Integer cha1){
		p.sendMessage("Congrats " + p.getName() + " on selecting the class " + string + "\n" + "Strength = " + str1 + "\n"+ "Dexterity = " + dex1 + "\n"+ "Constitution = " + con1 + "\n"+ "Intelligence = " + intel1 + "\n"+ "Wisdom = " + wis1 + "\n"+ "Charisma = " + cha1 + "\n");
		RpgClasses.playerConfig.set(p.getName() + ".Stats.Strength", str1);
		RpgClasses.playerConfig.set(p.getName() + ".Stats.Dexterity", dex1);
		RpgClasses.playerConfig.set(p.getName() + ".Stats.Constitution", con1);
		RpgClasses.playerConfig.set(p.getName() + ".Stats.Intelligence", intel1);
		RpgClasses.playerConfig.set(p.getName() + ".Stats.Wisdom", wis1);
		RpgClasses.playerConfig.set(p.getName() + ".Stats.Charisma", cha1);
		RpgClasses.playerConfig.set(p.getName() + ".Class", string);
		try {
			RpgClasses.playerConfig.save(new File("plugins/RpgClasses/Players.yml"));
		} catch (IOException e) {}
		Stats.getAll(p);

	}
	public static void logStats(Player p){
		final Player player = p;
		new BukkitRunnable(){

			@Override
			public void run(){
				Stats.getAll(player);
			}

		}.runTaskLater(RpgClasses.plugin, 6);
	}
}
