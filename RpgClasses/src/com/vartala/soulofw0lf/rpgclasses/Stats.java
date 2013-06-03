package com.vartala.soulofw0lf.rpgclasses;

import java.io.File;
import java.io.IOException;

import org.bukkit.entity.Player;

public class Stats {
	public static void getAll(Player p){
		String c = RpgClasses.playerConfig.getString(p.getName() + ".Class");
		if (c.equalsIgnoreCase("New")){
			return;
		}
		getSphit(p,c);
		getRangedHit(p,c);
		getHit(p,c);
		getHealth(p,c);
		//getSpeed(p,c);
		getAC(p,c);
		getFort(p,c);
		getReflex(p,c);
		getWill(p,c);
		getMinDmg(p,c);
		getMaxDmg(p,c);
		getBaB(p,c);
		try {
			RpgClasses.playerConfig.save(new File("plugins/RpgClasses/Players.yml"));
		} catch (IOException e) {}
	}
	public static void getBaB(Player p, String Class){
		Integer level = p.getLevel();
		Integer Bab = RpgClasses.classConfig.getInt(Class + ".Bonuses." + level + ".BaB");
		RpgClasses.playerConfig.set(p.getName() + ".Stats.BaB", Bab);
	}
	public static void getMinDmg(Player p, String Class){
		Integer level = p.getLevel();
		Integer stats = 0;
		Integer classbonus = 0;
		Integer basemin = 0;
		Integer minDmg = 0;
		if (RpgClasses.classConfig.getString(Class + ".PrimHitStat").equalsIgnoreCase("Strength")){
			Integer str = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Strength");
			stats = (str - 10) / 2;
		}
		if (RpgClasses.classConfig.getString(Class + ".PrimHitStat").equalsIgnoreCase("Dexterity")){
			Integer dex = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Dexterity");
			stats = (dex - 10) / 2;
		}
		if (RpgClasses.classConfig.getInt(Class + ".Bonuses." + level + ".Damage") != 0){
			classbonus = RpgClasses.classConfig.getInt(Class + ".Bonuses." + level + ".Damage");
		}
		if (RpgClasses.playerConfig.getString(p.getName() + ".WeaponType").equalsIgnoreCase("Unarmed")){
			basemin = 1;
		} else {
			basemin = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Equipped.MinDmg");
		}
		
		minDmg = stats + classbonus + basemin;
		RpgClasses.playerConfig.set(p.getName() + ".Stats.MinDmg", minDmg);
	}
	public static void getMaxDmg(Player p, String Class){
		Integer level = p.getLevel();
		Integer stats = 0;
		Integer classbonus = 0;
		Integer basemax = 0;
		Integer maxDmg = 0;
		if (RpgClasses.classConfig.getString(Class + ".PrimHitStat").equalsIgnoreCase("Strength")){
			Integer str = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Strength");
			stats = (str - 10) / 2;
		}
		if (RpgClasses.classConfig.getString(Class + ".PrimHitStat").equalsIgnoreCase("Dexterity")){
			Integer dex = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Dexterity");
			stats = (dex - 10) / 2;
		}
		if (RpgClasses.classConfig.getInt(Class + ".Bonuses." + level + ".Damage") != 0){
			classbonus = RpgClasses.classConfig.getInt(Class + ".Bonuses." + level + ".Damage");
		}
		if (RpgClasses.playerConfig.getString(p.getName() + ".WeaponType").equalsIgnoreCase("Unarmed")){
			basemax = 3;
		} else {
			basemax = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Equipped.MaxDmg");
		}
		
		maxDmg = stats + classbonus + basemax;
		RpgClasses.playerConfig.set(p.getName() + ".Stats.MaxDmg", maxDmg);
	}
	public static void getSphit(Player p, String Class){
		Integer level = p.getLevel();
		Integer casterstat = 0;
		Integer misc = 0;
		if (RpgClasses.classConfig.getString(Class + ".PrimSpHitStat").equalsIgnoreCase("Intelligence")){
			Integer intell = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Intelligence");
			casterstat = (intell - 10) / 2;
		}
		if (RpgClasses.classConfig.getString(Class + ".PrimSpHitStat").equalsIgnoreCase("Wisdom")){
			Integer wis = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Wisdom");
			casterstat = (wis - 10) / 2;
		}
		if (RpgClasses.classConfig.getString(Class + ".PrimSpHitStat").equalsIgnoreCase("Charisma")){
			Integer cha = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Charisma");
			casterstat = (cha - 10) / 2;
		}
		if (RpgClasses.playerConfig.contains(p.getName() + ".Stats.Misc.SpHit")){
			misc = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Misc.SpHit");
		}
		Integer Spellhit = level + casterstat + misc;
		RpgClasses.playerConfig.set(p.getName() + ".Stats.SpHit", Spellhit);


	}
	public static void getRangedHit(Player p, String Class){
		String level = Integer.toString(p.getLevel());
		Integer Bab = RpgClasses.classConfig.getInt(Class + ".Bonuses." + level + ".BaB");
		Integer stats = 0;
		Integer misc = 0;
		if (RpgClasses.classConfig.getString(Class + ".RangedHitStat").equalsIgnoreCase("Strength")){
			Integer str = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Strength");
			stats = (str - 10) / 2;
		}
		if (RpgClasses.classConfig.getString(Class + ".RangedHitStat").equalsIgnoreCase("Dexterity")){
			Integer dex = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Dexterity");
			stats = (dex - 10) / 2;
		}
		if (RpgClasses.playerConfig.contains(p.getName() + ".Stats.Misc.RHit")){
			misc = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Misc.RHit");
		}
		Integer equipped = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Equipped.RHit");
		Integer hitbonus = Bab + stats + misc + equipped;
		RpgClasses.playerConfig.set(p.getName() + ".Stats.RHit", hitbonus);

	}
	public static void getHit(Player p, String Class){
		String level = Integer.toString(p.getLevel());
		Integer Bab = RpgClasses.classConfig.getInt(Class + ".Bonuses." + level + ".BaB");
		Integer stats = 0;
		Integer misc = 0;
		if (RpgClasses.classConfig.getString(Class + ".PrimHitStat").equalsIgnoreCase("Strength")){
			Integer str = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Strength");
			stats = (str - 10) / 2;
		}
		if (RpgClasses.classConfig.getString(Class + ".PrimHitStat").equalsIgnoreCase("Dexterity")){
			Integer dex = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Dexterity");
			stats = (dex - 10) / 2;
		}
		if (RpgClasses.playerConfig.contains(p.getName() + ".Stats.Misc.Hit")){
			misc = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Misc.Hit");
		}
		Integer equipped = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Equipped.Hit");
		Integer hitbonus = Bab + stats + misc + equipped;
		RpgClasses.playerConfig.set(p.getName() + ".Stats.Hit", hitbonus);

	}
	public static void getHealth(Player p, String Class){
		Integer level = p.getLevel();
		Integer hitdie = RpgClasses.classConfig.getInt(Class + ".Hitdie");
		Integer con = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Constitution");
		Integer misc = 0;
		if (RpgClasses.playerConfig.contains(p.getName() + ".Stats.Misc.Hp")){
			misc = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Misc.Hp");
		}
		Integer conBonus = (con - 10) /2;
		Integer classHp = (hitdie + conBonus) * level;
		Integer newHp = classHp + misc;
		p.setMaxHealth(newHp);
		RpgClasses.playerConfig.set(p.getName() + ".Stats.Health", newHp);

	}
	public static void getSpeed(Player p, String Class){
		String level = Integer.toString(p.getLevel());
		Double base = 0.05;
		Double misc = 0.00;
		if (RpgClasses.playerConfig.contains(p.getName() + ".Stats.Misc.Speed")){
			misc = RpgClasses.playerConfig.getDouble(p.getName() + ".Stats.Misc.Speed");
		}
		Double cspeed = RpgClasses.classConfig.getDouble(Class + ".Bonuses." + level + ".Speed");
		Double equipped = RpgClasses.playerConfig.getDouble(p.getName() + ".Stats.Equipped.Speed");
		Double newspeed = base + misc + cspeed + equipped;
		String speedconvert = (String)newspeed.toString();
		Float speed = Float.parseFloat(speedconvert);
		if (speed >= 1){
			speed = 1f;
		}
		p.setWalkSpeed(speed);
		RpgClasses.playerConfig.set(p.getName() + ".Stats.Speed", speed);
	}
	public static void getAC(Player p, String Class){
		
		String level = Integer.toString(p.getLevel());
		Integer base = 10;
		Integer misc = 0;
		Integer dex = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Dexterity");
		Integer dexbonus = (dex - 10) /2;
		Integer carmor = RpgClasses.classConfig.getInt(Class + ".Bonuses." + level + ".Armor");
		if (RpgClasses.playerConfig.contains(p.getName() + ".Stats.Misc.Armor")){
			misc = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Misc.Armor");
		}
		
		Integer equipped = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Equipped.Armor");
		if ((equipped == 4) || (equipped == 5)){
			if (dexbonus >= 6){
				dexbonus = 6;
			}
		}
		if (equipped == 6){
			if (dexbonus >= 5){
				dexbonus = 5;
			}
		}
		if (equipped == 7){
			if (dexbonus >= 4){
				dexbonus = 4;
			}
		}
		if (equipped == 8){
			if (dexbonus >= 3){
				dexbonus = 3;
			}
		}
		if (equipped == 9){
			if (dexbonus >= 2){
				dexbonus = 2;
			}
		}
		if (equipped == 10){
			if (dexbonus >= 1){
				dexbonus = 1;
			}
		}
		if (equipped == 11){
			if (dexbonus >= 0){
				dexbonus = 0;
			}
		}
		
		Integer armor = base + misc + dexbonus + carmor + equipped;
		RpgClasses.playerConfig.set(p.getName() + ".Stats.Armor", armor);
		
	}
	public static void getReflex(Player p, String Class){
		String level = Integer.toString(p.getLevel());
		Integer misc = 0;
		Integer ref = RpgClasses.classConfig.getInt(Class + ".Bonuses." + level + ".Reflex");
		Integer dex = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Dexterity");
		if (RpgClasses.playerConfig.contains(p.getName() + ".Stats.Misc.Reflex")){
			misc = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Misc.Reflex");
		}
		Integer dexbonus = (dex - 10) /2;
		Integer refBonus = ref + dexbonus + misc;
		RpgClasses.playerConfig.set(p.getName() + ".Stats.Reflex", refBonus);

	}
	public static void getWill(Player p, String Class){
		String level = Integer.toString(p.getLevel());
		Integer misc = 0;
		Integer will = RpgClasses.classConfig.getInt(Class + ".Bonuses." + level + ".Will");
		Integer wisdom = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Wisdom");
		if (RpgClasses.playerConfig.contains(p.getName() + ".Stats.Misc.Will")){
			misc = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Misc.Will");
		}
		Integer wisdombonus = (wisdom - 10) /2;
		Integer willBonus = will + wisdombonus + misc;
		RpgClasses.playerConfig.set(p.getName() + ".Stats.Will", willBonus);

	}
	public static void getFort(Player p, String Class){
		String level = Integer.toString(p.getLevel());
		Integer misc = 0;
		Integer fort = RpgClasses.classConfig.getInt(Class + ".Bonuses." + level + ".Fort");
		Integer con = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Constitution");
		if (RpgClasses.playerConfig.contains(p.getName() + ".Stats.Misc.Fort")){
			misc = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Misc.Fort");
		}
		Integer conBonus = (con - 10) /2;
		Integer fortBonus = fort + conBonus + misc;
		RpgClasses.playerConfig.set(p.getName() + ".Stats.Fort", fortBonus);

	}
}
