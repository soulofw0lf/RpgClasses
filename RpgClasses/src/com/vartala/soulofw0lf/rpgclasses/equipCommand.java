package com.vartala.soulofw0lf.rpgclasses;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class equipCommand implements CommandExecutor{
	RpgClasses Rpgc;
	public equipCommand(RpgClasses rpgc){
		this.Rpgc = rpgc;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		Player player = (Player)sender;
		Inventory inv = Bukkit.createInventory(null, 45, "Equip");
		Integer i = 0;
		while (i < 45){
			if ((i != 0) && (i != 4) && (i != 8) && (i != 11) && (i != 12) && (i != 13) && (i != 14) && (i != 15) && (i != 19) && (i != 22) && (i != 25) && (i != 31) && (i != 38) && (i != 40) && (i != 42)){
			ItemStack itm = new ItemStack(30);
			ItemMeta im = itm.getItemMeta();
			im.setDisplayName(" ");
			itm.setItemMeta(im);
			inv.setItem(i, itm);
			} else {
				if (this.Rpgc.getConfig().getString(player.getName() + ".Equipment.Earring1") != null){
					String ear = this.Rpgc.getConfig().getString(player.getName() + ".Equipment.Earring1");
					ItemStack itm = new ItemStack(this.Rpgc.getConfig().getInt(player.getName() + ".Equipment.Earring1." + ear + ".Type"));
					ItemMeta im = itm.getItemMeta();
					im.setDisplayName(ear);
					List<String> lores = new ArrayList<String>();
					for (String conlore : this.Rpgc.getConfig().getConfigurationSection(player.getName() + ".Equipment.Earring1." + ear + ".Lores").getKeys(false)){
						lores.add(conlore);
					}
					im.setLore(lores);
					itm.setItemMeta(im);
					inv.setItem(0, itm);
				}
				if (this.Rpgc.getConfig().getString(player.getName() + ".Equipment.Helm") != null){
					String ear = this.Rpgc.getConfig().getString(player.getName() + ".Equipment.Helm");
					ItemStack itm = new ItemStack(this.Rpgc.getConfig().getInt(player.getName() + ".Equipment.Helm." + ear + ".Type"));
					ItemMeta im = itm.getItemMeta();
					im.setDisplayName(ear);
					List<String> lores = new ArrayList<String>();
					for (String conlore : this.Rpgc.getConfig().getConfigurationSection(player.getName() + ".Equipment.Helm." + ear + ".Lores").getKeys(false)){
						lores.add(conlore);
					}
					im.setLore(lores);
					itm.setItemMeta(im);
					inv.setItem(4, itm);
				}
				if (this.Rpgc.getConfig().getString(player.getName() + ".Equipment.Earring2") != null){
					String ear = this.Rpgc.getConfig().getString(player.getName() + ".Equipment.Earring2");
					ItemStack itm = new ItemStack(this.Rpgc.getConfig().getInt(player.getName() + ".Equipment.Earring2." + ear + ".Type"));
					ItemMeta im = itm.getItemMeta();
					im.setDisplayName(ear);
					List<String> lores = new ArrayList<String>();
					for (String conlore : this.Rpgc.getConfig().getConfigurationSection(player.getName() + ".Equipment.Earring2." + ear + ".Lores").getKeys(false)){
						lores.add(conlore);
					}
					im.setLore(lores);
					itm.setItemMeta(im);
					inv.setItem(8, itm);
				}
				if (this.Rpgc.getConfig().getString(player.getName() + ".Equipment.Glove1") != null){
					String ear = this.Rpgc.getConfig().getString(player.getName() + ".Equipment.Glove1");
					ItemStack itm = new ItemStack(this.Rpgc.getConfig().getInt(player.getName() + ".Equipment.Glove1." + ear + ".Type"));
					ItemMeta im = itm.getItemMeta();
					im.setDisplayName(ear);
					List<String> lores = new ArrayList<String>();
					for (String conlore : this.Rpgc.getConfig().getConfigurationSection(player.getName() + ".Equipment.Glove1." + ear + ".Lores").getKeys(false)){
						lores.add(conlore);
					}
					im.setLore(lores);
					itm.setItemMeta(im);
					inv.setItem(11, itm);
				}
				if (this.Rpgc.getConfig().getString(player.getName() + ".Equipment.Bracer1") != null){
					String ear = this.Rpgc.getConfig().getString(player.getName() + ".Equipment.Bracer1");
					ItemStack itm = new ItemStack(this.Rpgc.getConfig().getInt(player.getName() + ".Equipment.Bracer1." + ear + ".Type"));
					ItemMeta im = itm.getItemMeta();
					im.setDisplayName(ear);
					List<String> lores = new ArrayList<String>();
					for (String conlore : this.Rpgc.getConfig().getConfigurationSection(player.getName() + ".Equipment.Bracer1." + ear + ".Lores").getKeys(false)){
						lores.add(conlore);
					}
					im.setLore(lores);
					itm.setItemMeta(im);
					inv.setItem(12, itm);
				}
				if (this.Rpgc.getConfig().getString(player.getName() + ".Equipment.Chest") != null){
					String ear = this.Rpgc.getConfig().getString(player.getName() + ".Equipment.Chest");
					ItemStack itm = new ItemStack(this.Rpgc.getConfig().getInt(player.getName() + ".Equipment.Chest." + ear + ".Type"));
					ItemMeta im = itm.getItemMeta();
					im.setDisplayName(ear);
					List<String> lores = new ArrayList<String>();
					for (String conlore : this.Rpgc.getConfig().getConfigurationSection(player.getName() + ".Equipment.Chest." + ear + ".Lores").getKeys(false)){
						lores.add(conlore);
					}
					im.setLore(lores);
					itm.setItemMeta(im);
					inv.setItem(13, itm);
				}
				if (this.Rpgc.getConfig().getString(player.getName() + ".Equipment.Bracer2") != null){
					String ear = this.Rpgc.getConfig().getString(player.getName() + ".Equipment.Bracer2");
					ItemStack itm = new ItemStack(this.Rpgc.getConfig().getInt(player.getName() + ".Equipment.Bracer2." + ear + ".Type"));
					ItemMeta im = itm.getItemMeta();
					im.setDisplayName(ear);
					List<String> lores = new ArrayList<String>();
					for (String conlore : this.Rpgc.getConfig().getConfigurationSection(player.getName() + ".Equipment.Bracer2." + ear + ".Lores").getKeys(false)){
						lores.add(conlore);
					}
					im.setLore(lores);
					itm.setItemMeta(im);
					inv.setItem(14, itm);
				}
				if (this.Rpgc.getConfig().getString(player.getName() + ".Equipment.Glove2") != null){
					String ear = this.Rpgc.getConfig().getString(player.getName() + ".Equipment.Glove2");
					ItemStack itm = new ItemStack(this.Rpgc.getConfig().getInt(player.getName() + ".Equipment.Glove2." + ear + ".Type"));
					ItemMeta im = itm.getItemMeta();
					im.setDisplayName(ear);
					List<String> lores = new ArrayList<String>();
					for (String conlore : this.Rpgc.getConfig().getConfigurationSection(player.getName() + ".Equipment.Glove2." + ear + ".Lores").getKeys(false)){
						lores.add(conlore);
					}
					im.setLore(lores);
					itm.setItemMeta(im);
					inv.setItem(15, itm);
				}
				if (this.Rpgc.getConfig().getString(player.getName() + ".Equipment.MainHand") != null){
					String ear = this.Rpgc.getConfig().getString(player.getName() + ".Equipment.MainHand");
					ItemStack itm = new ItemStack(this.Rpgc.getConfig().getInt(player.getName() + ".Equipment.MainHand." + ear + ".Type"));
					ItemMeta im = itm.getItemMeta();
					im.setDisplayName(ear);
					List<String> lores = new ArrayList<String>();
					for (String conlore : this.Rpgc.getConfig().getConfigurationSection(player.getName() + ".Equipment.MainHand." + ear + ".Lores").getKeys(false)){
						lores.add(conlore);
					}
					im.setLore(lores);
					itm.setItemMeta(im);
					inv.setItem(19, itm);
				}
				if (this.Rpgc.getConfig().getString(player.getName() + ".Equipment.Belt") != null){
					String ear = this.Rpgc.getConfig().getString(player.getName() + ".Equipment.Belt");
					ItemStack itm = new ItemStack(this.Rpgc.getConfig().getInt(player.getName() + ".Equipment.Belt." + ear + ".Type"));
					ItemMeta im = itm.getItemMeta();
					im.setDisplayName(ear);
					List<String> lores = new ArrayList<String>();
					for (String conlore : this.Rpgc.getConfig().getConfigurationSection(player.getName() + ".Equipment.Belt." + ear + ".Lores").getKeys(false)){
						lores.add(conlore);
					}
					im.setLore(lores);
					itm.setItemMeta(im);
					inv.setItem(22, itm);
				}
				if (this.Rpgc.getConfig().getString(player.getName() + ".Equipment.OffHand") != null){
					String ear = this.Rpgc.getConfig().getString(player.getName() + ".Equipment.OffHand");
					ItemStack itm = new ItemStack(this.Rpgc.getConfig().getInt(player.getName() + ".Equipment.OffHand." + ear + ".Type"));
					ItemMeta im = itm.getItemMeta();
					im.setDisplayName(ear);
					List<String> lores = new ArrayList<String>();
					for (String conlore : this.Rpgc.getConfig().getConfigurationSection(player.getName() + ".Equipment.OffHand." + ear + ".Lores").getKeys(false)){
						lores.add(conlore);
					}
					im.setLore(lores);
					itm.setItemMeta(im);
					inv.setItem(25, itm);
				}
				if (this.Rpgc.getConfig().getString(player.getName() + ".Equipment.Legs") != null){
					String ear = this.Rpgc.getConfig().getString(player.getName() + ".Equipment.Legs");
					ItemStack itm = new ItemStack(this.Rpgc.getConfig().getInt(player.getName() + ".Equipment.Legs." + ear + ".Type"));
					ItemMeta im = itm.getItemMeta();
					im.setDisplayName(ear);
					List<String> lores = new ArrayList<String>();
					for (String conlore : this.Rpgc.getConfig().getConfigurationSection(player.getName() + ".Equipment.Legs." + ear + ".Lores").getKeys(false)){
						lores.add(conlore);
					}
					im.setLore(lores);
					itm.setItemMeta(im);
					inv.setItem(31, itm);
				}
				if (this.Rpgc.getConfig().getString(player.getName() + ".Equipment.Ring1") != null){
					String ear = this.Rpgc.getConfig().getString(player.getName() + ".Equipment.Ring1");
					ItemStack itm = new ItemStack(this.Rpgc.getConfig().getInt(player.getName() + ".Equipment.Ring1." + ear + ".Type"));
					ItemMeta im = itm.getItemMeta();
					im.setDisplayName(ear);
					List<String> lores = new ArrayList<String>();
					for (String conlore : this.Rpgc.getConfig().getConfigurationSection(player.getName() + ".Equipment.Ring1." + ear + ".Lores").getKeys(false)){
						lores.add(conlore);
					}
					im.setLore(lores);
					itm.setItemMeta(im);
					inv.setItem(38, itm);
				}
				if (this.Rpgc.getConfig().getString(player.getName() + ".Equipment.Boots") != null){
					String ear = this.Rpgc.getConfig().getString(player.getName() + ".Equipment.Boots");
					ItemStack itm = new ItemStack(this.Rpgc.getConfig().getInt(player.getName() + ".Equipment.Boots." + ear + ".Type"));
					ItemMeta im = itm.getItemMeta();
					im.setDisplayName(ear);
					List<String> lores = new ArrayList<String>();
					for (String conlore : this.Rpgc.getConfig().getConfigurationSection(player.getName() + ".Equipment.Boots." + ear + ".Lores").getKeys(false)){
						lores.add(conlore);
					}
					im.setLore(lores);
					itm.setItemMeta(im);
					inv.setItem(40, itm);
				}
				if (this.Rpgc.getConfig().getString(player.getName() + ".Equipment.Ring2") != null){
					String ear = this.Rpgc.getConfig().getString(player.getName() + ".Equipment.Ring2");
					ItemStack itm = new ItemStack(this.Rpgc.getConfig().getInt(player.getName() + ".Equipment.Ring2." + ear + ".Type"));
					ItemMeta im = itm.getItemMeta();
					im.setDisplayName(ear);
					List<String> lores = new ArrayList<String>();
					for (String conlore : this.Rpgc.getConfig().getConfigurationSection(player.getName() + ".Equipment.Ring2." + ear + ".Lores").getKeys(false)){
						lores.add(conlore);
					}
					im.setLore(lores);
					itm.setItemMeta(im);
					inv.setItem(42, itm);
				}
				
			}
			i++;
		}
		
		player.openInventory(inv);
		return false;
	}
}
