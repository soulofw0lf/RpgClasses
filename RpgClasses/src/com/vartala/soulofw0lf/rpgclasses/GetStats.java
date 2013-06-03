package com.vartala.soulofw0lf.rpgclasses;

import java.util.ArrayList;
import org.bukkit.entity.Player;

public class GetStats {

	public static Integer getAC(Player p){
		Integer ac = 0;
		ac = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Armor");
		return ac;
	}
	public static Integer getBaB(Player p){
		Integer bab = 0;
		bab = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.BaB");
		return bab;
	}
	public static Integer getHit(Player p){
		Integer ac = 0;
		ac = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Hit");
		return ac;
	}
	public static Integer getReflex(Player p){
		Integer ac = 0;
		ac = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Reflex");
		return ac;
	}
	public static Integer getFort(Player p){
		Integer ac = 0;
		ac = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Fort");
		return ac;
	}
	public static Integer getWill(Player p){
		Integer ac = 0;
		ac = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Will");
		return ac;
	}
	public static Integer getRhit(Player p){
		Integer ac = 0;
		ac = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Rhit");
		return ac;
	}
	public static Integer getSpHit(Player p){
		Integer ac = 0;
		ac = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.SpHit");
		return ac;
	}
	public static Integer getCrit(Player p){
		Integer crit = 0;
		crit = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.Crit");
		return crit;
	}
	public static Integer getCritmult(Player p){
		Integer critmult = 0;
		critmult = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.CritMult");
		return critmult;
	}
	public static Integer getDr(Player p){
		Integer dr = 0;
		if (RpgClasses.playerConfig.getInt(p.getName() + ".Stats.DR") != 0){
		dr = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.DR");
		}
		return dr;
	}
	public static ArrayList<String> getDrType(Player p){
		ArrayList<String> drtype = new ArrayList<String>();
		if (RpgClasses.playerConfig.getString(p.getName() + ".Stats.DrType") != null){
			for (String key : RpgClasses.playerConfig.getConfigurationSection(p.getName() + ".Stats.DrType").getKeys(false)){
				if (RpgClasses.playerConfig.getBoolean(p.getName() + ".Stats.DrType." + key) == true){
					drtype.add(key);
				}
			}
		}
		return drtype;
	}
	public static ArrayList<String> getDmgType(Player p){
		ArrayList<String> dmgtype = new ArrayList<String>();
		if (RpgClasses.playerConfig.getString(p.getName() + ".Stats.DmgType") != null){
			for (String key : RpgClasses.playerConfig.getConfigurationSection(p.getName() + ".Stats.DmgType").getKeys(false)){
				if (RpgClasses.playerConfig.getBoolean(p.getName() + ".Stats.DmgType." + key) == true){
					dmgtype.add(key);
				}
			}
		}
		return dmgtype;
	}
	public static ArrayList<String> getElemResType(Player p){
		ArrayList<String> elemtype = new ArrayList<String>();
		if (RpgClasses.playerConfig.getString(p.getName() + ".Stats.ElemResType") != null){
			for (String key : RpgClasses.playerConfig.getConfigurationSection(p.getName() + ".Stats.ElemResType").getKeys(false)){
				if (RpgClasses.playerConfig.getBoolean(p.getName() + ".Stats.ElemResType." + key) == true){
					elemtype.add(key);
				}
			}
		}
		return elemtype;
	}
	public static ArrayList<String> getElemDmgType(Player p){
		ArrayList<String> elemdmgtype = new ArrayList<String>();
		if (RpgClasses.playerConfig.getString(p.getName() + ".Stats.ElemDmgType") != null){
			for (String key : RpgClasses.playerConfig.getConfigurationSection(p.getName() + ".Stats.ElemDmgType").getKeys(false)){
				if (RpgClasses.playerConfig.getBoolean(p.getName() + ".Stats.ElemDmgType." + key) == true){
					elemdmgtype.add(key);
				}
			}
		}
		return elemdmgtype;
	}
	public static Integer getMaxDmg(Player p){
		Integer maxd = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.MaxDmg");
		return maxd;
	}
	public static Integer getMinDmg(Player p){
		Integer mind = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.MinDmg");
		return mind;
	}
	public static Integer getMaxElemDmg(Player p){
		Integer maxE = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.MaxElemDmg");
		return maxE;
	}
	public static Integer getMinElemDmg(Player p){
		Integer minE = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.MinElemDmg");
		return minE;
	}
	public static Integer getElemRes(Player p){
		Integer elemres = RpgClasses.playerConfig.getInt(p.getName() + ".Stats.ElemRes");
		return elemres;
	}
	
}
