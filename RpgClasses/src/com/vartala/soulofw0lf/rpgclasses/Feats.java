package com.vartala.soulofw0lf.rpgclasses;

import org.bukkit.entity.Player;

public class Feats {
	
	public static Boolean isPatk(Player p){
		Boolean hasFeat = false;
		if (RpgClasses.playerConfig.getBoolean(p.getName() + ".Feats.Power Attack") == true){
			hasFeat = true;
		}
		return hasFeat;
	}
	//you can just do 
	//return RpgClasses.playerConfig.getBoolean(p.getName() + ".Feats.Arcane Armor Training")
	public static Boolean isArcArmTrain(Player p){
		Boolean hasFeat = false;
		if (RpgClasses.playerConfig.getBoolean(p.getName() + ".Feats.Arcane Armor Training") == true){
			hasFeat = true;
		}
		return hasFeat;
	}
	public static Boolean isArcArmMast(Player p){
		Boolean hasFeat = false;
		if (RpgClasses.playerConfig.getBoolean(p.getName() + ".Feats.Arcane Armor Mastery") == true){
			hasFeat = true;
		}
		return hasFeat;
	}
	public static Boolean isArcStrike(Player p){
		Boolean hasFeat = false;
		if (RpgClasses.playerConfig.getBoolean(p.getName() + ".Feats.Arcane Strike") == true){
			hasFeat = true;
		}
		return hasFeat;
	}
	public static Boolean isArmorProfL(Player p){
		Boolean hasFeat = false;
		if (RpgClasses.playerConfig.getBoolean(p.getName() + ".Feats.Light Armor Proficiency") == true){
			hasFeat = true;
		}
		return hasFeat;
	}
	public static Boolean isArmorProfM(Player p){
		Boolean hasFeat = false;
		if (RpgClasses.playerConfig.getBoolean(p.getName() + ".Feats.Medium Armor Proficiency") == true){
			hasFeat = true;
		}
		return hasFeat;
	}
}
