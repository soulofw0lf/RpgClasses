package com.vartala.soulofw0lf.rpgclasses;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ClassViewer {	
	
	public static void classSelector(Player p){
		Inventory inv = Bukkit.createInventory(null, 9, "Class Selector:");
		//tank item
		ItemStack melee = new ItemStack(267);
		ItemMeta meleeim = melee.getItemMeta();
		meleeim.setDisplayName("§4Melee Classes");
		ArrayList<String> mellore = new ArrayList<String>();
		mellore.add("§FThese classes prefer close quarters combat");
		mellore.add("§Fand consist of tanks and dps.");
		mellore.add("Classes:");
		mellore.add("§2Fighter - Dps");
		mellore.add("§6Warrior - Tank");
		mellore.add("§CRogue - Dps(PvP)");
		meleeim.setLore(mellore);
		melee.setItemMeta(meleeim);
		inv.setItem(1, melee);
		//caster item
		ItemStack caster = new ItemStack(377);
		ItemMeta casterim = caster.getItemMeta();
		casterim.setDisplayName("§3Caster Classes");
		ArrayList<String> castlore = new ArrayList<String>();
		castlore.add("§FThese classes prefer magic over martial");
		castlore.add("§Fprowess and consist of dps and utility.");
		castlore.add("Classes:");
		castlore.add("§5Sorcerer - Dps");
		castlore.add("§DWizard - Utility");
		castlore.add("§3Summoner - Dps");
		casterim.setLore(castlore);
		caster.setItemMeta(casterim);
		inv.setItem(3, caster);
		//healer item
		ItemStack healer = new ItemStack(322);
		ItemMeta healerim = healer.getItemMeta();
		healerim.setDisplayName("§CHealer Classes");
		ArrayList<String> heallore = new ArrayList<String>();
		heallore.add("§FThese classes prefer the healling");
		heallore.add("§Farts over death and bloodshed.");
		heallore.add("Classes:");
		heallore.add("§BPriest - Single target healer");
		heallore.add("§ACleric - Aoe heals");
		heallore.add("§EOracle - Utility / Heals");
		healerim.setLore(heallore);
		healer.setItemMeta(healerim);
		inv.setItem(5, healer);
		//ranged item
		ItemStack ranged = new ItemStack(261);
		ItemMeta rangedim = ranged.getItemMeta();
		rangedim.setDisplayName("§3Ranged Dps Classes");
		ArrayList<String> ranglore = new ArrayList<String>();
		ranglore.add("§FThese classes fight from a distance");
		ranglore.add("§Fand consist of ranged tanks and dps.");
		ranglore.add("Classes:");
		ranglore.add("§2Ranger - Dps");
		ranglore.add("§4Sniper - Dps");
		ranglore.add("§3Hunter - Tank");
		rangedim.setLore(ranglore);
		ranged.setItemMeta(rangedim);
		inv.setItem(7, ranged);
		p.openInventory(inv);
	}
	
	public static void meleeSelector(Player p){
		Inventory inv = Bukkit.createInventory(null, 9, "Melee Classes:");
		//tank item
		ItemStack melee = new ItemStack(276);
		ItemMeta meleeim = melee.getItemMeta();
		meleeim.setDisplayName("§2Fighter");
		ArrayList<String> mellore = new ArrayList<String>();
		mellore.add("§FFighters are masters of martial weapons");
		mellore.add("§Fusing powerful attacks to devestate");
		mellore.add("§Fmultiple enemies at one time!");
		mellore.add("§1Primary stats:");
		mellore.add("§CStength");
		mellore.add("§5Dexterity");
		mellore.add("§6Constitution");
		meleeim.setLore(mellore);
		melee.setItemMeta(meleeim);
		inv.setItem(1, melee);
		//caster item
		ItemStack caster = new ItemStack(311);
		ItemMeta casterim = caster.getItemMeta();
		casterim.setDisplayName("§6Warrior");
		ArrayList<String> castlore = new ArrayList<String>();
		castlore.add("§FWarriors are the toughest of all melee");
		castlore.add("§Fclasses. Prefering to stand toe to toe");
		castlore.add("§Fwith their enemies, and keeping their");
		castlore.add("§Fallies from being harmed.");
		castlore.add("§1Primary Stats:");
		castlore.add("§CConstitution");
		castlore.add("§5Strength");
		castlore.add("§6Dexterity");
		casterim.setLore(castlore);
		caster.setItemMeta(casterim);
		inv.setItem(3, caster);
		//healer item
		ItemStack healer = new ItemStack(373);
		ItemMeta healerim = healer.getItemMeta();
		healerim.setDisplayName("§CRogue");
		ArrayList<String> heallore = new ArrayList<String>();
		heallore.add("§FRogues are quick and subtle,");
		heallore.add("§Fprefering striking from the shadows");
		heallore.add("§Fover direct confrontation.");
		heallore.add("§1Primary Stats:");
		heallore.add("§CDexterity");
		heallore.add("§5Strength");
		heallore.add("§6Constitution");
		healerim.setLore(heallore);
		healer.setItemMeta(healerim);
		Short poison = 8196;
		healer.setDurability(poison);
		inv.setItem(5, healer);
		//ranged item
		ItemStack ranged = new ItemStack(152);
		ItemMeta rangedim = ranged.getItemMeta();
		rangedim.setDisplayName("Previous Menu");
		ArrayList<String> ranglore = new ArrayList<String>();
		ranglore.add("§FNot happy with these class selections?");
		ranglore.add("§FClick here to return to the previous");
		ranglore.add("§FMenu");
		rangedim.setLore(ranglore);
		ranged.setItemMeta(rangedim);
		inv.setItem(7, ranged);
		p.openInventory(inv);
	}
	public static void casterSelector(Player p){
		Inventory inv = Bukkit.createInventory(null, 9, "Caster Classes:");
		//tank item
		ItemStack melee = new ItemStack(385);
		ItemMeta meleeim = melee.getItemMeta();
		meleeim.setDisplayName("§5Sorcerer");
		ArrayList<String> mellore = new ArrayList<String>();
		mellore.add("§FThe sorcerer is a spontaneous");
		mellore.add("§Fspell caster. Able to use whatever");
		mellore.add("§Fspells they know at any time without");
		mellore.add("§Fpreperation.");
		mellore.add("§1Primary Stats:");
		mellore.add("§CCharisma");
		mellore.add("§5Dexterity");
		mellore.add("§6Constitution");
		meleeim.setLore(mellore);
		melee.setItemMeta(meleeim);
		inv.setItem(1, melee);
		//caster item
		ItemStack caster = new ItemStack(403);
		ItemMeta casterim = caster.getItemMeta();
		casterim.setDisplayName("§DWizard");
		ArrayList<String> castlore = new ArrayList<String>();
		castlore.add("§FThe Wizard is the undisputed master of");
		castlore.add("§Fthe arcane arts. With the right spells");
		castlore.add("§Fprepared they can acomplish anything!");
		castlore.add("§1Primary Stats:");
		castlore.add("§CIntelligence");
		castlore.add("§5Dexterity");
		casterim.setLore(castlore);
		caster.setItemMeta(casterim);
		inv.setItem(3, caster);
		//healer item
		ItemStack healer = new ItemStack(383);
		ItemMeta healerim = healer.getItemMeta();
		healerim.setDisplayName("§3Summoner");
		ArrayList<String> heallore = new ArrayList<String>();
		heallore.add("§FThe Summoner is a master of minions.");
		heallore.add("§FUsing melee to fight along side");
		heallore.add("§Fthe monsters they summon into battle!");
		heallore.add("§1Primary Stats:");
		heallore.add("§CStrength");
		heallore.add("§5Wisdom");
		heallore.add("§6Constitution");
		healerim.setLore(heallore);
		healer.setItemMeta(healerim);
		Short egg = 57;
		healer.setDurability(egg);		
		inv.setItem(5, healer);
		//ranged item
		ItemStack ranged = new ItemStack(152);
		ItemMeta rangedim = ranged.getItemMeta();
		rangedim.setDisplayName("Previous Menu");
		ArrayList<String> ranglore = new ArrayList<String>();
		ranglore.add("§FNot happy with these class selections?");
		ranglore.add("§FClick here to return to the previous");
		ranglore.add("§FMenu");
		rangedim.setLore(ranglore);
		ranged.setItemMeta(rangedim);
		inv.setItem(7, ranged);
		p.openInventory(inv);
	}
	public static void healerSelector(Player p){
		Inventory inv = Bukkit.createInventory(null, 9, "Healer Classes:");
		//tank item
		ItemStack melee = new ItemStack(399);
		ItemMeta meleeim = melee.getItemMeta();
		meleeim.setDisplayName("§BPriest");
		ArrayList<String> mellore = new ArrayList<String>();
		mellore.add("§FThe priest is a healer that prefers");
		mellore.add("§Fto focus their divine talents on a");
		mellore.add("§Fsingle individual.");
		mellore.add("§1Primary Stats:");
		mellore.add("§CIntelligence");
		mellore.add("§5Constitution");
		mellore.add("§6Strength");
		meleeim.setLore(mellore);
		melee.setItemMeta(meleeim);
		inv.setItem(1, melee);
		//caster item
		ItemStack caster = new ItemStack(384);
		ItemMeta casterim = caster.getItemMeta();
		casterim.setDisplayName("§ACleric");
		ArrayList<String> castlore = new ArrayList<String>();
		castlore.add("§FThe cleric is a radiant beacon of ");
		castlore.add("§Fdivine energy. Their holy powers");
		castlore.add("§Fwash over allies, keeping them");
		castlore.add("§Fhealthy and strong.");
		castlore.add("§1Primary Stats:");
		castlore.add("§CWisdom");
		castlore.add("§5Strength");
		castlore.add("§6Constitution");
		casterim.setLore(castlore);
		caster.setItemMeta(casterim);
		inv.setItem(3, caster);
		//healer item
		ItemStack healer = new ItemStack(381);
		ItemMeta healerim = healer.getItemMeta();
		healerim.setDisplayName("§EOracle");
		ArrayList<String> heallore = new ArrayList<String>();
		heallore.add("§FOracle's believe that blood is");
		heallore.add("§Fthe key to divine magic. These mysterious");
		heallore.add("§Fhealers use the blood of their enemies to");
		heallore.add("§Fheal their allies.");
		heallore.add("§1Primary Stats:");
		heallore.add("§CCharisma");
		heallore.add("§5Dexterity");
		heallore.add("§6Constitution");
		healerim.setLore(heallore);
		healer.setItemMeta(healerim);
		inv.setItem(5, healer);
		//ranged item
		ItemStack ranged = new ItemStack(152);
		ItemMeta rangedim = ranged.getItemMeta();
		rangedim.setDisplayName("Previous Menu");
		ArrayList<String> ranglore = new ArrayList<String>();
		ranglore.add("§FNot happy with these class selections?");
		ranglore.add("§FClick here to return to the previous");
		ranglore.add("§FMenu");
		rangedim.setLore(ranglore);
		ranged.setItemMeta(rangedim);
		inv.setItem(7, ranged);
		p.openInventory(inv);
	}
	public static void rangedSelector(Player p){
		Inventory inv = Bukkit.createInventory(null, 9, "Ranged Classes:");
		//tank item
		ItemStack melee = new ItemStack(6);
		ItemMeta meleeim = melee.getItemMeta();
		meleeim.setDisplayName("§2Ranger");
		ArrayList<String> mellore = new ArrayList<String>();
		mellore.add("§FRangers use the powers of nature to");
		mellore.add("§Fimbue their bows with devestating spells");
		mellore.add("§Fand abilities.");
		mellore.add("§1Primary Stats:");
		mellore.add("§CCharisma");
		mellore.add("§5Dexterity");
		mellore.add("§6Constitution");
		meleeim.setLore(mellore);
		melee.setItemMeta(meleeim);
		inv.setItem(1, melee);
		//caster item
		ItemStack caster = new ItemStack(261);
		ItemMeta casterim = caster.getItemMeta();
		casterim.setDisplayName("§4Sniper");
		ArrayList<String> castlore = new ArrayList<String>();
		castlore.add("§FSnipers are the masters of patience");
		castlore.add("§Fand precision. Waitting in silence");
		castlore.add("§Ffor the perfect shot, that when");
		castlore.add("§Ftaken, never misses!");
		castlore.add("§1Primary Stats:");
		castlore.add("§CDexterity");
		castlore.add("§5Constitution");
		castlore.add("§6Intelligence");
		casterim.setLore(castlore);
		caster.setItemMeta(casterim);
		inv.setItem(3, caster);
		//healer item
		ItemStack healer = new ItemStack(122);
		ItemMeta healerim = healer.getItemMeta();
		healerim.setDisplayName("§3Hunter");
		ArrayList<String> heallore = new ArrayList<String>();
		heallore.add("§FHunters spend their time training");
		heallore.add("§Fcreatures to battle for them. A hunter");
		heallore.add("§Fhappily sits back throwing axes into");
		heallore.add("§Fbattle while their pets keep their foes");
		heallore.add("§Fdistracted");
		heallore.add("§1Primary Stats:");
		heallore.add("§CStength");
		heallore.add("§5Wisdom");
		heallore.add("§6Dexterity");
		healerim.setLore(heallore);
		healer.setItemMeta(healerim);
		inv.setItem(5, healer);
		//ranged item
		ItemStack ranged = new ItemStack(152);
		ItemMeta rangedim = ranged.getItemMeta();
		rangedim.setDisplayName("Previous Menu");
		ArrayList<String> ranglore = new ArrayList<String>();
		ranglore.add("§FNot happy with these class selections?");
		ranglore.add("§FClick here to return to the previous");
		ranglore.add("§FMenu");
		rangedim.setLore(ranglore);
		ranged.setItemMeta(rangedim);
		inv.setItem(7, ranged);
		p.openInventory(inv);
	}
	public static void classConfirm(Player p, String cname){
		Inventory inv = Bukkit.createInventory(null, 9, cname + " Confirm:");
		//tank item
		ItemStack melee = new ItemStack(267);
		ItemMeta meleeim = melee.getItemMeta();
		meleeim.setDisplayName("§4Confirm Class");
		ArrayList<String> mellore = new ArrayList<String>();
		mellore.add("§FThis Decision is §4Final!!");
		mellore.add("§FPlease only click here if you are sure");
		mellore.add("§Fthat this is the class you want!");
		meleeim.setLore(mellore);
		melee.setItemMeta(meleeim);
		inv.setItem(3, melee);
		//caster item
		ItemStack ranged = new ItemStack(152);
		ItemMeta rangedim = ranged.getItemMeta();
		rangedim.setDisplayName("Previous Menu");
		ArrayList<String> ranglore = new ArrayList<String>();
		ranglore.add("§FNot happy with these class selections?");
		ranglore.add("§FClick here to return to the previous");
		ranglore.add("§FMenu");
		rangedim.setLore(ranglore);
		ranged.setItemMeta(rangedim);
		inv.setItem(7, ranged);
		p.openInventory(inv);
	}
}
