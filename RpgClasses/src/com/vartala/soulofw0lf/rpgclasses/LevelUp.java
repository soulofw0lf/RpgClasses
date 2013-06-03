package com.vartala.soulofw0lf.rpgclasses;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class LevelUp {
	RpgClasses Rpgc;
	public LevelUp(RpgClasses rpgc){
		this.Rpgc = rpgc;
	}
	public static void getNewLevel(Player p, String Class){
		Integer level = p.getLevel();
		Integer newlevel = level + 1;
		p.setLevel(newlevel);
		Integer oldSpHit = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.SpHit");
		Integer oldAC = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Armor");
		Integer oldFort = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Fort");
		Integer oldHealth = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Health");
		Integer oldRhit = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.RHit");
		Integer oldRef = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Reflex");
		Integer oldSpeed = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Speed");
		Integer oldHit = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Hit");
		Integer oldWill = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Will");
		Stats.getAll(p);
		Integer newSpHit = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.SpHit");
		Integer newAC = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Armor");
		Integer newFort = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Fort");
		Integer newHealth = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Health");
		Integer newRhit = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.RHit");
		Integer newRef = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Reflex");
		Integer newSpeed = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Speed");
		Integer newHit = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Hit");
		Integer newWill = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Will");
		ArrayList<Integer> oldstats = new ArrayList<Integer>();
		oldstats.add(oldSpHit);
		oldstats.add(oldAC);
		oldstats.add(oldFort);
		oldstats.add(oldHealth);
		oldstats.add(oldHit);
		oldstats.add(oldRef);
		oldstats.add(oldRhit);
		oldstats.add(oldSpeed);
		oldstats.add(oldWill);
		ArrayList<String> statnames = new ArrayList<String>();
		statnames.add("Spell Hit");
		statnames.add("Armor Class");
		statnames.add("Fortitude");
		statnames.add("Health");
		statnames.add("Hit");
		statnames.add("Reflex");
		statnames.add("Ranged Hit");
		statnames.add("Speed");
		statnames.add("Will");
		ArrayList<Integer> newstats = new ArrayList<Integer>();
		newstats.add(newSpHit);
		newstats.add(newAC);
		newstats.add(newFort);
		newstats.add(newHealth);
		newstats.add(newHit);
		newstats.add(newRef);
		newstats.add(newRhit);
		newstats.add(newSpeed);
		newstats.add(newWill);
		for (int i=0;i<oldstats.size();i++) {
            Integer change = newstats.get(i) - oldstats.get(i);
            if (change >=1){
            	p.sendMessage("§eYour §2" + statnames.get(i) + "§e has increased by §2" + change + "§e!!!");
            	RpgClasses.firePlayer(p);
            }
		}
	
		
	}
}
