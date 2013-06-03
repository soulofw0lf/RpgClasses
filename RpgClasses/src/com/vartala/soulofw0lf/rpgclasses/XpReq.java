package com.vartala.soulofw0lf.rpgclasses;

import org.bukkit.entity.Player;

public class XpReq {


	public static void checkLvL(Player p, Integer xp){
		if (p.getLevel() == 1){
			if (xp >= 3000){
				String Class = RpgClasses.playerConfig.getString(p.getName() + ".Class");
				LevelUp.getNewLevel(p, Class);
			}
		}
		if (p.getLevel() == 2){
			if (xp >= 7500){
				String Class = RpgClasses.playerConfig.getString(p.getName() + ".Class");
				LevelUp.getNewLevel(p, Class);
			}
		}
		if (p.getLevel() == 3){
			if (xp >= 14000){
				String Class = RpgClasses.playerConfig.getString(p.getName() + ".Class");
				LevelUp.getNewLevel(p, Class);
			}
		}
		if (p.getLevel() == 4){
			if (xp >= 23000){
				String Class = RpgClasses.playerConfig.getString(p.getName() + ".Class");
				LevelUp.getNewLevel(p, Class);
			}
		}
		if (p.getLevel() == 5){
			if (xp >= 35000){
				String Class = RpgClasses.playerConfig.getString(p.getName() + ".Class");
				LevelUp.getNewLevel(p, Class);
			}
		}
		if (p.getLevel() == 6){
			if (xp >= 53000){
				String Class = RpgClasses.playerConfig.getString(p.getName() + ".Class");
				LevelUp.getNewLevel(p, Class);
			}
		}
		if (p.getLevel() == 7){
			if (xp >= 77000){
				String Class = RpgClasses.playerConfig.getString(p.getName() + ".Class");
				LevelUp.getNewLevel(p, Class);
			}
		}
		if (p.getLevel() == 8){
			if (xp >= 115000){
				String Class = RpgClasses.playerConfig.getString(p.getName() + ".Class");
				LevelUp.getNewLevel(p, Class);
			}
		}
		if (p.getLevel() == 9){
			if (xp >= 160000){
				String Class = RpgClasses.playerConfig.getString(p.getName() + ".Class");
				LevelUp.getNewLevel(p, Class);
			}
		}
		if (p.getLevel() == 10){
			if (xp >= 235000){
				String Class = RpgClasses.playerConfig.getString(p.getName() + ".Class");
				LevelUp.getNewLevel(p, Class);
			}
		}
		if (p.getLevel() == 11){
			if (xp >= 330000){
				String Class = RpgClasses.playerConfig.getString(p.getName() + ".Class");
				LevelUp.getNewLevel(p, Class);
			}
		}
		if (p.getLevel() == 12){
			if (xp >= 475000){
				String Class = RpgClasses.playerConfig.getString(p.getName() + ".Class");
				LevelUp.getNewLevel(p, Class);
			}
		}
		if (p.getLevel() == 13){
			if (xp >= 665000){
				String Class = RpgClasses.playerConfig.getString(p.getName() + ".Class");
				LevelUp.getNewLevel(p, Class);
			}
		}
		if (p.getLevel() == 14){
			if (xp >= 955000){
				String Class = RpgClasses.playerConfig.getString(p.getName() + ".Class");
				LevelUp.getNewLevel(p, Class);
			}
		}
		if (p.getLevel() == 15){
			if (xp >= 1350000){
				String Class = RpgClasses.playerConfig.getString(p.getName() + ".Class");
				LevelUp.getNewLevel(p, Class);
			}
		}
		if (p.getLevel() == 16){
			if (xp >= 1900000){
				String Class = RpgClasses.playerConfig.getString(p.getName() + ".Class");
				LevelUp.getNewLevel(p, Class);
			}
		}
		if (p.getLevel() == 17){
			if (xp >= 2700000){
				String Class = RpgClasses.playerConfig.getString(p.getName() + ".Class");
				LevelUp.getNewLevel(p, Class);
			}
		}
		if (p.getLevel() == 18){
			if (xp >= 3850000){
				String Class = RpgClasses.playerConfig.getString(p.getName() + ".Class");
				LevelUp.getNewLevel(p, Class);
			}
		}
		if (p.getLevel() == 19){
			if (xp >= 5350000){
				RpgClasses.playerConfig.set(p.getName() + ".Experience", 5350000);
				String Class = RpgClasses.playerConfig.getString(p.getName() + ".Class");
				LevelUp.getNewLevel(p, Class);
			}
		}
		if (p.getLevel() == 20){
			if (xp >= 5350000){
				RpgClasses.playerConfig.set(p.getName() + ".Experience", 5350000);
			}
		}
	}
}
