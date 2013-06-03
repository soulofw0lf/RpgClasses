package com.vartala.soulofw0lf.rpgclasses;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.entity.Player;

public class DamageClass {
	
	public static Integer pvpdamage(Player p1, Player p2){
		Integer dmg = 0;
		Boolean Critical = false;
		Boolean Hit = false;
		Boolean dmgr = true;
		Boolean elemr = true;
		Integer ac = GetStats.getAC(p2);
		Integer hit = GetStats.getHit(p1);
		Integer Bab = GetStats.getBaB(p1);
		if (Feats.isPatk(p1) == true){
			if (Bab >= 1){
				hit = hit -1;
				}
			if (Bab >= 4){
				hit = hit -1;
				}
			if (Bab >= 8){
				hit = hit -1;
				}
			if (Bab >= 12){
				hit = hit -1;
				}
			if (Bab >= 16){
				hit = hit -1;
				}
			if (Bab >= 20){
				hit = hit -1;
				}
		}
		Random rand = new Random();
		Integer  n = rand.nextInt(20)+1;
		Integer totalhit = n + hit;
		if (totalhit >= ac){
			Hit = true;
		}
		Integer crit = GetStats.getCrit(p1);
		Integer critMult = 1;
		if (n >= crit){
			Random rand1 = new Random();
			Integer  n1 = rand1.nextInt(20)+1;
			Hit = true;
			if(n1 + hit >= ac){
			Critical = true;
			critMult = GetStats.getCritmult(p1);
			}
		}
		Integer dr = GetStats.getDr(p2);
		Integer dmgmax = GetStats.getMaxDmg(p1);
		Integer dmgmin = GetStats.getMinDmg(p1);
		Integer elemmindmg = GetStats.getMinElemDmg(p1);
		Integer elemmaxdmg = GetStats.getMaxElemDmg(p1);
		Integer elemres = GetStats.getElemRes(p2);
		Integer dmgrand = dmgmax - dmgmin;
		Random dmgrandom = new Random();
		Integer dmgrandadd = dmgrandom.nextInt(dmgrand) + 1;
		dmg = dmgmin + dmgrandadd;
		if (Feats.isPatk(p1) == true){
			if (Bab >= 1){
				dmg = dmg +2;
				}
			if (Bab >= 4){
				dmg = dmg +2;
				}
			if (Bab >= 8){
				dmg = dmg +2;
				}
			if (Bab >= 12){
				dmg = dmg +2;
				}
			if (Bab >= 16){
				dmg = dmg +2;
				}
			if (Bab >= 20){
				dmg = dmg +2;
				}
		}
		Integer critdmg = dmg * critMult; 
		if (Critical == true){
			dmg = dmg + critdmg;
		}
		ArrayList<String> drtype = GetStats.getDrType(p2);
		ArrayList<String> dmgtype = GetStats.getDmgType(p1);
		for (int i=0;i<drtype.size();i++) {
			String source = drtype.get(i);
			if (dmgtype.contains(source)){
				dmgr = true;
			}
		}
		if (dmgr == false){
			dmg = dmg - dr;
			if (dmg <= 0){
				dmg = 0;
			}
		}
		Integer elemdiff = elemmaxdmg - elemmindmg;
		Integer totalelem = 0;
		if (elemdiff >= 1){
		Random elemrand = new Random();
		Integer elemrand1 = elemrand.nextInt(elemdiff) + 1;
		totalelem = elemmindmg + elemrand1;
		}
		ArrayList<String> restype = GetStats.getElemResType(p2);
		ArrayList<String> elemtype = GetStats.getElemDmgType(p1);
		for (int i=0;i<restype.size();i++) {
			String source = restype.get(i);
			if (elemtype.contains(source)){
				elemr = false;
			}
		}
		
		if (elemr == false){
			totalelem = totalelem - elemres;
			if (totalelem <= 0){
				totalelem = 0;
			}
		}
		dmg = dmg + totalelem;
		if (Hit == false){
			dmg = 0;
		}
		if (Critical == true){
		p1.sendMessage("§6Critical Hit: §4" + dmg + "!!");
		}
		return dmg;
	}
}
