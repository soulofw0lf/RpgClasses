package com.vartala.soulofw0lf.rpgclasses;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.vartala.soulofw0lf.rpgapi.fireworkapi.FireworkSettings;

public class RpgClasses extends JavaPlugin implements Listener {
	public static YamlConfiguration playerConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgClasses/Players.yml"));
	public static YamlConfiguration classConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgClasses/Classes.yml"));
	public static YamlConfiguration statsConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgClasses/Stats.yml"));
	static RpgClasses plugin;
	public static List<String> plist = new ArrayList<String>();
	public static List<String> dlist = new ArrayList<String>();
	

	@Override
	public void onEnable(){
		plugin = this;
		getCommand("firework").setExecutor(new fwHandler());
		getCommand("addxp").setExecutor(new expHandler(this));
		getCommand("tutskip").setExecutor(new tutSkip());
		getCommand("class").setExecutor(new classNew());
		getCommand("equip").setExecutor(new equipCommand(this));
		Bukkit.getPluginManager().registerEvents(this, this);
		saveDefaultConfig();
		playerConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgClasses/Players.yml"));
		classConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgClasses/Classes.yml"));
		statsConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgClasses/Stats.yml"));
		playerConfig.set("Player Files", "This file is for storing player data!");
		classConfig.set("Class File", "This file is for saving class info!");
		statsConfig.set("Stats File", "specific set non changeable stats go here!");
		try {
			playerConfig.save(new File("plugins/RpgClasses/Players.yml"));
			classConfig.save(new File("plugins/RpgClasses/Classes.yml"));
			statsConfig.save(new File("plugins/RpgClasses/Stats.yml"));
		} catch (IOException e) {}
		CoreClasses.getClasses();
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	@Override
	public void onDisable(){

	}

	@EventHandler
	public void onMove(PlayerMoveEvent event){
		Player player = event.getPlayer();
		if (player.getName() == null){
			return;
		}
		if (!(playerConfig.getString(player.getName() + ".Class").equalsIgnoreCase("New"))){
			return;
		}
		if (player.hasPermission("class.select")){
			return;
		}
		Double X = getConfig().getDouble("Location.X");
		Double Y = getConfig().getDouble("Location.Y");
		Double Z = getConfig().getDouble("Location.Z");
		String world = getConfig().getString("Location.World");
		World newworld = Bukkit.getWorld(world);
		if (player.getWorld() != newworld){
			return;
		}
		Location loc = new Location(newworld, X, Y, Z);
		Double close = loc.distance(player.getLocation());
		if (plist.contains(player.getName())){
			return;
		}
		if (close <= 3){
			NewClass.select(player);
			plist.add(player.getName());

		}
	}
	@EventHandler
	public void onPlayerLogin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		if (!(playerConfig.contains(player.getName()))){
			player.setLevel(1);
			playerConfig.createSection(player.getName());
			playerConfig.set(player.getName() + ".Class", "New");
			playerConfig.set(player.getName() + ".Experience", 0);
			playerConfig.set(player.getName() + ".Stats.SpHit", 0);
			playerConfig.set(player.getName() + ".Stats.Equipped.SpHit", 0);
			playerConfig.set(player.getName() + ".Stats.Armor", 0);
			playerConfig.set(player.getName() + ".Stats.Equipped.Armor", 0);
			playerConfig.set(player.getName() + ".Stats.Fort", 0);
			playerConfig.set(player.getName() + ".Stats.Equipped.Fort", 0);
			playerConfig.set(player.getName() + ".Stats.Health", 10);
			playerConfig.set(player.getName() + ".Stats.Equipped.Health", 10);
			playerConfig.set(player.getName() + ".Stats.RHit", 0);
			playerConfig.set(player.getName() + ".Stats.Equipped.RHit", 0);
			playerConfig.set(player.getName() + ".Stats.Reflex", 0);
			playerConfig.set(player.getName() + ".Stats.Equipped.Reflex", 0);
			playerConfig.set(player.getName() + ".Stats.Speed", 0);
			playerConfig.set(player.getName() + ".Stats.Equipped.Speed", 0);
			playerConfig.set(player.getName() + ".Stats.Hit", 0);
			playerConfig.set(player.getName() + ".Stats.Equipped.Hit", 0);
			playerConfig.set(player.getName() + ".Stats.Will", 0);
			playerConfig.set(player.getName() + ".Stats.Equipped.Will", 0);
			playerConfig.set(player.getName() + ".Stats.Strength", 10);
			playerConfig.set(player.getName() + ".Stats.Dexterity", 10);
			playerConfig.set(player.getName() + ".Stats.Constitution", 10);
			playerConfig.set(player.getName() + ".Stats.Intelligence", 10);
			playerConfig.set(player.getName() + ".Stats.Wisdom", 10);
			playerConfig.set(player.getName() + ".Stats.Charisma", 10);
			playerConfig.set(player.getName() + ".Stats.Crit", 20);
			playerConfig.set(player.getName() + ".Stats.CritMult", 2);
			playerConfig.set(player.getName() + ".Stats.DR", 0);
			playerConfig.set(player.getName() + ".Stats.Equipped.Strength", 0);
			playerConfig.set(player.getName() + ".Stats.Equipped.Dexterity", 0);
			playerConfig.set(player.getName() + ".Stats.Equipped.Constitution", 0);
			playerConfig.set(player.getName() + ".Stats.Equipped.Intelligence", 0);
			playerConfig.set(player.getName() + ".Stats.Equipped.Wisdom", 0);
			playerConfig.set(player.getName() + ".Stats.Equipped.Charisma", 0);
			playerConfig.set(player.getName() + ".Stats.ElemDmgType.Fire", false);
			playerConfig.set(player.getName() + ".Stats.ElemDmgType.Frost", false);
			playerConfig.set(player.getName() + ".Stats.ElemDmgType.Holy", false);
			playerConfig.set(player.getName() + ".Stats.ElemDmgType.Unholy", false);
			playerConfig.set(player.getName() + ".Stats.ElemDmgType.Nature", false);
			playerConfig.set(player.getName() + ".Stats.ElemDmgType.Acid", false);
			playerConfig.set(player.getName() + ".Stats.ElemResType.Fire", false);
			playerConfig.set(player.getName() + ".Stats.ElemResType.Frost", false);
			playerConfig.set(player.getName() + ".Stats.ElemResType.Holy", false);
			playerConfig.set(player.getName() + ".Stats.ElemResType.Unholy", false);
			playerConfig.set(player.getName() + ".Stats.ElemResType.Nature", false);
			playerConfig.set(player.getName() + ".Stats.ElemResType.Acid", false);
			playerConfig.set(player.getName() + ".Stats.MinDmg", 1);
			playerConfig.set(player.getName() + ".Stats.MaxDmg", 3);
			playerConfig.set(player.getName() + ".Stats.MinElemDmg", 0);
			playerConfig.set(player.getName() + ".Stats.MaxElemDmg", 0);
			playerConfig.set(player.getName() + ".Stats.ElemRes", 0);
			playerConfig.set(player.getName() + ".Stats.DrType.Piercing", false);
			playerConfig.set(player.getName() + ".Stats.DrType.Slashing", false);
			playerConfig.set(player.getName() + ".Stats.DrType.Blunt", false);
			playerConfig.set(player.getName() + ".Stats.DrType.Magical", false);
			playerConfig.set(player.getName() + ".Stats.DrType.Epic", false);
			playerConfig.set(player.getName() + ".Stats.DmgType.Piercing", false);
			playerConfig.set(player.getName() + ".Stats.DmgType.Slashing", false);
			playerConfig.set(player.getName() + ".Stats.DmgType.Blunt", true);
			playerConfig.set(player.getName() + ".Stats.DmgType.Magical", false);
			playerConfig.set(player.getName() + ".Stats.DmgType.Epic", false);
			playerConfig.set(player.getName() + ".Stats.WeaponSpeed", 20);
			playerConfig.set(player.getName() + ".WeaponType", "Unarmed");
			playerConfig.set(player.getName() + ".Stats.Equipped.MinDmg", 0);
			playerConfig.set(player.getName() + ".Stats.Equipped.MaxDmg", 0);
			try {
				playerConfig.save(new File("plugins/RpgClasses/Players.yml"));
			} catch (IOException e) {}
		}
		statsSet.logStats(player);
	}

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent event){
		if(event.getEntity() instanceof Player){
			Player p2 = (Player)event.getEntity();
			Entity dealer = event.getDamager();
			if (dealer.getClass() != Player.class){
				return;
			}
			if (dealer instanceof Player){
				Player p1 = (Player)dealer;
				if (dlist.contains(p1.getName())){
					event.setCancelled(true);
				}
				Integer dmg = DamageClass.pvpdamage(p1, p2);
				event.setDamage(dmg);
				dlist.add(p1.getName());
				final Integer speed = playerConfig.getInt(p1.getName() + ".Stats.WeaponSpeed");
				final Player player = p1;
				new BukkitRunnable(){
					public void run(){
						dlist.remove(player.getName());
						cancel();
					}
				}.runTaskLater(plugin, speed);
			}
		}
	}
	@EventHandler
	public void statEquip(InventoryClickEvent event){
		if (event.getInventory().getHolder() instanceof Player){
			if ((event.getSlotType() == InventoryType.SlotType.QUICKBAR) || (event.getSlotType() == InventoryType.SlotType.ARMOR)){
				if (event.isLeftClick() || event.isRightClick() || event.isShiftClick()){
					event.setCancelled(true);
					event.setResult(Result.DENY);
				}
			}
		}
		if (event.getInventory().getTitle().equalsIgnoreCase("Equip")){
			Integer i = event.getSlot();
			if ((i != 0) && (i != 4) && (i != 8) && (i != 11) && (i != 12) && (i != 13) && (i != 14) && (i != 15) && (i != 19) && (i != 22) && (i != 25) && (i != 31) && (i != 38) && (i != 40) && (i != 42)){
				event.setCancelled(true);
				event.setResult(Result.DENY);
			} else {
				
			}
			if ((event.getSlotType() == InventoryType.SlotType.QUICKBAR) || (event.getSlotType() == InventoryType.SlotType.ARMOR)){
				if (event.isLeftClick() || event.isRightClick() || event.isShiftClick()){
					event.setCancelled(true);
					event.setResult(Result.DENY);
				}
			}
		}
	}
	@EventHandler
	public void onstatclick(InventoryClickEvent event){
		Player p = (Player)event.getWhoClicked();
		if (!(event.getInventory().getTitle().equalsIgnoreCase(p.getName() + " Stats:"))){
			return;
		}
		if ((event.getSlotType() == InventoryType.SlotType.QUICKBAR) || (event.getSlotType() == InventoryType.SlotType.ARMOR)){
			if (event.isLeftClick() || event.isRightClick() || event.isShiftClick()){
				event.setCancelled(true);
				event.setResult(Result.DENY);
			}
		}
		ItemStack item = event.getCurrentItem();
		if (item == null){
			return;
		}
		if (event.isLeftClick()){
			Integer amt = item.getAmount();
			ItemMeta im = item.getItemMeta();
			if (im != null){
				if ((!(im.getDisplayName().equalsIgnoreCase("§4Strength"))) && (!(im.getDisplayName().equalsIgnoreCase("§4Dexterity"))) && (!(im.getDisplayName().equalsIgnoreCase("§4Constitution"))) && (!(im.getDisplayName().equalsIgnoreCase("§4Intelligence"))) && (!(im.getDisplayName().equalsIgnoreCase("§4Wisdom"))) && (!(im.getDisplayName().equalsIgnoreCase("§4Charisma"))) && !(im.getDisplayName().equalsIgnoreCase("§4Points Remaining"))){
					event.setResult(Result.DENY);
					event.setCancelled(true);
					return;
				}
				if (!(im.getDisplayName().equalsIgnoreCase("§4Points Remaining"))){
					if (amt >= 18){
						event.setResult(Result.DENY);
						event.setCancelled(true);
						return;
					}
					Integer newamt = amt + 1;
					item.setAmount(newamt);
					ItemStack pr = event.getInventory().getItem(8);
					Integer totstats = pr.getAmount();
					Integer newstats = totstats -1;
					if (newstats <= 0){
						event.setResult(Result.DENY);
						event.setCancelled(true);
						ItemStack classget = event.getInventory().getItem(0);
						ItemMeta mclass = classget.getItemMeta();
						String classname = null;
						List<String> lclass = mclass.getLore();
						if (lclass.contains("Fighter")){
							classname = "Fighter";
						}
						if (lclass.contains("Warrior")){
							classname = "Warrior";
						}
						if (lclass.contains("Rogue")){
							classname = "Rogue";
						}
						if (lclass.contains("Priest")){
							classname = "Priest";
						}
						if (lclass.contains("Cleric")){
							classname = "Cleric";
						}
						if (lclass.contains("Oracle")){
							classname = "Oracle";
						}
						if (lclass.contains("Wizard")){
							classname = "Wizard";
						}
						if (lclass.contains("Sorcerer")){
							classname = "Sorcerer";
						}
						if (lclass.contains("Summoner")){
							classname = "Summoner";
						}
						if (lclass.contains("Ranger")){
							classname = "Ranger";
						}
						if (lclass.contains("Hunter")){
							classname = "Hunter";
						}
						if (lclass.contains("Sniper")){
							classname = "Sniper";
						}
						p.closeInventory();
						final Player player = p;
						final String curclass = classname;
						final Integer s1 = event.getInventory().getItem(0).getAmount();
						final Integer s2 = event.getInventory().getItem(1).getAmount();
						final Integer s3 = event.getInventory().getItem(2).getAmount();
						final Integer s4 = event.getInventory().getItem(3).getAmount();
						final Integer s5 = event.getInventory().getItem(4).getAmount();
						final Integer s6 = event.getInventory().getItem(5).getAmount();
						new BukkitRunnable(){

							@Override
							public void run(){
								statChooser.statConfirm(player, curclass, s1, s2, s3, s4, s5, s6);
							}

						}.runTaskLater(plugin, 6);
					}
					pr.setAmount(newstats);
					event.setResult(Result.DENY);
					event.setCancelled(true);
				}
				if (im.getDisplayName().equalsIgnoreCase("§4Points Remaining")){
					ItemStack i1 = event.getInventory().getItem(0);
					ItemStack i2 = event.getInventory().getItem(1);
					ItemStack i3 = event.getInventory().getItem(2);
					ItemStack i4 = event.getInventory().getItem(3);
					ItemStack i5 = event.getInventory().getItem(4);
					ItemStack i6 = event.getInventory().getItem(5);
					ItemStack i7 = event.getInventory().getItem(8);
					i1.setAmount(10);
					i2.setAmount(10);
					i3.setAmount(10);
					i4.setAmount(10);
					i5.setAmount(10);
					i6.setAmount(10);
					i7.setAmount(25);
					event.setResult(Result.DENY);
					event.setCancelled(true);
				}
			}
		}
		if (event.isRightClick()){
			Integer amt = item.getAmount();
			ItemMeta im = item.getItemMeta();
			if (im != null){
				if ((!(im.getDisplayName().equalsIgnoreCase("§4Strength"))) && (!(im.getDisplayName().equalsIgnoreCase("§4Dexterity"))) && (!(im.getDisplayName().equalsIgnoreCase("§4Constitution"))) && (!(im.getDisplayName().equalsIgnoreCase("§4Intelligence"))) && (!(im.getDisplayName().equalsIgnoreCase("§4Wisdom"))) && (!(im.getDisplayName().equalsIgnoreCase("§4Charisma"))) && !(im.getDisplayName().equalsIgnoreCase("§4Points Remaining"))){
					event.setResult(Result.DENY);
					event.setCancelled(true);
					return;
				}

				if (!(im.getDisplayName().equalsIgnoreCase("§4Points Remaining"))){
					if (amt <= 7){
						event.setResult(Result.DENY);
						event.setCancelled(true);
						return;
					}
					Integer newamt = amt - 1;
					item.setAmount(newamt);
					ItemStack pr = event.getInventory().getItem(8);
					Integer totstats = pr.getAmount();
					Integer newstats = totstats +1;
					if (newstats <= 0){
						//do code here for completion
					}
					pr.setAmount(newstats);
					event.setResult(Result.DENY);
					event.setCancelled(true);

				}
			}
			if (im.getDisplayName().equalsIgnoreCase("§4Points Remaining")){
				ItemStack i1 = event.getInventory().getItem(0);
				ItemStack i2 = event.getInventory().getItem(1);
				ItemStack i3 = event.getInventory().getItem(2);
				ItemStack i4 = event.getInventory().getItem(3);
				ItemStack i5 = event.getInventory().getItem(4);
				ItemStack i6 = event.getInventory().getItem(5);
				ItemStack i7 = event.getInventory().getItem(8);
				i1.setAmount(10);
				i2.setAmount(10);
				i3.setAmount(10);
				i4.setAmount(10);
				i5.setAmount(10);
				i6.setAmount(10);
				i7.setAmount(25);
				event.setResult(Result.DENY);
				event.setCancelled(true);
			}
		}
	}
	@EventHandler
	public void onPlayerClick(InventoryClickEvent event){
		if (!(event.getInventory().getTitle().equalsIgnoreCase("Class Selector:"))){
			return;
		}
		if ((event.getSlotType() == InventoryType.SlotType.QUICKBAR) || (event.getSlotType() == InventoryType.SlotType.ARMOR)){
			if (event.isLeftClick() || event.isRightClick() || event.isShiftClick()){
				event.setCancelled(true);
				event.setResult(Result.DENY);
			}
		}
		ItemStack item = event.getCurrentItem();
		if (item == null){
			return;
		}
		event.setResult(Result.DENY);
		event.setCancelled(true);
		Player player = (Player)event.getWhoClicked();
		final Player p = player;
		ItemMeta current = item.getItemMeta();
		if (current == null){
			return;
		}
		if (current.getDisplayName().equalsIgnoreCase("§4Melee Classes")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					ClassViewer.meleeSelector(p);
				}

			}.runTaskLater(plugin, 6);
		}
		if (current.getDisplayName().equalsIgnoreCase("§3Caster Classes")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					ClassViewer.casterSelector(p);
				}

			}.runTaskLater(plugin, 6);
		}
		if (current.getDisplayName().equalsIgnoreCase("§CHealer Classes")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					ClassViewer.healerSelector(p);
				}

			}.runTaskLater(plugin, 6);
		}
		if (current.getDisplayName().equalsIgnoreCase("§3Ranged Dps Classes")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					ClassViewer.rangedSelector(p);
				}

			}.runTaskLater(plugin, 6);
		}
	}
	@EventHandler
	public void onMeleeClick(InventoryClickEvent event){
		if (!(event.getInventory().getTitle().equalsIgnoreCase("Melee Classes:"))){
			return;
		}
		if ((event.getSlotType() == InventoryType.SlotType.QUICKBAR) || (event.getSlotType() == InventoryType.SlotType.ARMOR)){
			if (event.isLeftClick() || event.isRightClick() || event.isShiftClick()){
				event.setCancelled(true);
				event.setResult(Result.DENY);
			}
		}
		ItemStack item = event.getCurrentItem();
		if (item == null){
			return;
		}
		event.setResult(Result.DENY);
		event.setCancelled(true);
		Player player = (Player)event.getWhoClicked();
		final Player p = player;
		ItemMeta current = item.getItemMeta();
		if (current == null){
			return;
		}
		if (current.getDisplayName().equalsIgnoreCase("§2Fighter")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					ClassViewer.classConfirm(p, "Fighter");
				}

			}.runTaskLater(plugin, 6);
		}
		if (current.getDisplayName().equalsIgnoreCase("§6Warrior")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					ClassViewer.classConfirm(p, "Warrior");
				}

			}.runTaskLater(plugin, 6);
		}
		if (current.getDisplayName().equalsIgnoreCase("§CRogue")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					ClassViewer.classConfirm(p, "Rogue");
				}

			}.runTaskLater(plugin, 6);
		}
		if (current.getDisplayName().equalsIgnoreCase("Previous Menu")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					ClassViewer.classSelector(p);
				}

			}.runTaskLater(plugin, 6);
		}
	}
	@EventHandler
	public void onCasterClick(InventoryClickEvent event){
		if (!(event.getInventory().getTitle().equalsIgnoreCase("Caster Classes:"))){
			return;
		}
		if ((event.getSlotType() == InventoryType.SlotType.QUICKBAR) || (event.getSlotType() == InventoryType.SlotType.ARMOR)){
			if (event.isLeftClick() || event.isRightClick() || event.isShiftClick()){
				event.setCancelled(true);
				event.setResult(Result.DENY);
			}
		}
		ItemStack item = event.getCurrentItem();
		if (item == null){
			return;
		}
		event.setResult(Result.DENY);
		event.setCancelled(true);
		Player player = (Player)event.getWhoClicked();
		final Player p = player;
		ItemMeta current = item.getItemMeta();
		if (current == null){
			return;
		}
		if (current.getDisplayName().equalsIgnoreCase("§5Sorcerer")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					ClassViewer.classConfirm(p, "Sorcerer");
				}

			}.runTaskLater(plugin, 6);
		}
		if (current.getDisplayName().equalsIgnoreCase("§DWizard")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					ClassViewer.classConfirm(p, "Wizard");
				}

			}.runTaskLater(plugin, 6);
		}
		if (current.getDisplayName().equalsIgnoreCase("§3Summoner")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					ClassViewer.classConfirm(p, "Summoner");
				}

			}.runTaskLater(plugin, 6);
		}
		if (current.getDisplayName().equalsIgnoreCase("Previous Menu")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					ClassViewer.classSelector(p);
				}

			}.runTaskLater(plugin, 6);
		}
	}
	@EventHandler
	public void onRangedClick(InventoryClickEvent event){
		if (!(event.getInventory().getTitle().equalsIgnoreCase("Healer Classes:"))){
			return;
		}
		if ((event.getSlotType() == InventoryType.SlotType.QUICKBAR) || (event.getSlotType() == InventoryType.SlotType.ARMOR)){
			if (event.isLeftClick() || event.isRightClick() || event.isShiftClick()){
				event.setCancelled(true);
				event.setResult(Result.DENY);
			}
		}
		ItemStack item = event.getCurrentItem();
		if (item == null){
			return;
		}
		event.setResult(Result.DENY);
		event.setCancelled(true);
		Player player = (Player)event.getWhoClicked();
		final Player p = player;
		ItemMeta current = item.getItemMeta();
		if (current == null){
			return;
		}
		if (current.getDisplayName().equalsIgnoreCase("§BPriest")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					ClassViewer.classConfirm(p, "Priest");
				}

			}.runTaskLater(plugin, 6);
		}
		if (current.getDisplayName().equalsIgnoreCase("§ACleric")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					ClassViewer.classConfirm(p, "Cleric");
				}

			}.runTaskLater(plugin, 6);
		}
		if (current.getDisplayName().equalsIgnoreCase("§EOracle")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					ClassViewer.classConfirm(p, "Oracle");
				}

			}.runTaskLater(plugin, 6);
		}
		if (current.getDisplayName().equalsIgnoreCase("Previous Menu")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					ClassViewer.classSelector(p);
				}

			}.runTaskLater(plugin, 6);
		}
	}
	@EventHandler
	public void onHealerClick(InventoryClickEvent event){
		if (!(event.getInventory().getTitle().equalsIgnoreCase("Ranged Classes:"))){
			return;
		}
		if ((event.getSlotType() == InventoryType.SlotType.QUICKBAR) || (event.getSlotType() == InventoryType.SlotType.ARMOR)){
			if (event.isLeftClick() || event.isRightClick() || event.isShiftClick()){
				event.setCancelled(true);
				event.setResult(Result.DENY);
			}
		}
		ItemStack item = event.getCurrentItem();
		if (item == null){
			return;
		}
		event.setResult(Result.DENY);
		event.setCancelled(true);
		Player player = (Player)event.getWhoClicked();
		final Player p = player;
		ItemMeta current = item.getItemMeta();
		if (current == null){
			return;
		}
		if (current.getDisplayName().equalsIgnoreCase("§2Ranger")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					ClassViewer.classConfirm(p, "Ranger");
				}

			}.runTaskLater(plugin, 6);
		}
		if (current.getDisplayName().equalsIgnoreCase("§4Sniper")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					ClassViewer.classConfirm(p, "Sniper");
				}

			}.runTaskLater(plugin, 6);
		}
		if (current.getDisplayName().equalsIgnoreCase("§3Hunter")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					ClassViewer.classConfirm(p, "Hunter");
				}

			}.runTaskLater(plugin, 6);;
		}
		if (current.getDisplayName().equalsIgnoreCase("Previous Menu")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					ClassViewer.classSelector(p);
				}

			}.runTaskLater(plugin, 6);
		}
	}
	@EventHandler
	public void onFighterconfirm(InventoryClickEvent event){
		if (!(event.getInventory().getTitle().equalsIgnoreCase("Fighter Confirm:"))){
			return;
		}
		if ((event.getSlotType() == InventoryType.SlotType.QUICKBAR) || (event.getSlotType() == InventoryType.SlotType.ARMOR)){
			if (event.isLeftClick() || event.isRightClick() || event.isShiftClick()){
				event.setCancelled(true);
				event.setResult(Result.DENY);
			}
		}
		ItemStack item = event.getCurrentItem();
		if (item == null){
			return;
		}
		event.setResult(Result.DENY);
		event.setCancelled(true);
		Player player = (Player)event.getWhoClicked();
		final Player p = player;
		ItemMeta current = item.getItemMeta();
		if (current == null){
			return;
		}
		if (current.getDisplayName().equalsIgnoreCase("§4Confirm Class")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					statChooser.baseStats(p, "Fighter");
				}

			}.runTaskLater(plugin, 6);
		}
		if (current.getDisplayName().equalsIgnoreCase("Previous Menu")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					ClassViewer.meleeSelector(p);
				}

			}.runTaskLater(plugin, 6);
		}

	}
	@EventHandler
	public void onWarriorconfirm(InventoryClickEvent event){
		if (!(event.getInventory().getTitle().equalsIgnoreCase("Warrior Confirm:"))){
			return;
		}
		if ((event.getSlotType() == InventoryType.SlotType.QUICKBAR) || (event.getSlotType() == InventoryType.SlotType.ARMOR)){
			if (event.isLeftClick() || event.isRightClick() || event.isShiftClick()){
				event.setCancelled(true);
				event.setResult(Result.DENY);
			}
		}
		ItemStack item = event.getCurrentItem();
		if (item == null){
			return;
		}
		event.setResult(Result.DENY);
		event.setCancelled(true);
		Player player = (Player)event.getWhoClicked();
		final Player p = player;
		ItemMeta current = item.getItemMeta();

		if (current == null){
			return;
		}
		if (current.getDisplayName().equalsIgnoreCase("§4Confirm Class")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					statChooser.baseStats(p, "Warrior");
				}

			}.runTaskLater(plugin, 6);
		}
		if (current.getDisplayName().equalsIgnoreCase("Previous Menu")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					ClassViewer.meleeSelector(p);
				}

			}.runTaskLater(plugin, 6);
		}

	}
	@EventHandler
	public void onRogueconfirm(InventoryClickEvent event){
		if (!(event.getInventory().getTitle().equalsIgnoreCase("Rogue Confirm:"))){
			return;
		}
		if ((event.getSlotType() == InventoryType.SlotType.QUICKBAR) || (event.getSlotType() == InventoryType.SlotType.ARMOR)){
			if (event.isLeftClick() || event.isRightClick() || event.isShiftClick()){
				event.setCancelled(true);
				event.setResult(Result.DENY);
			}
		}
		ItemStack item = event.getCurrentItem();
		if (item == null){
			return;
		}
		event.setResult(Result.DENY);
		event.setCancelled(true);
		Player player = (Player)event.getWhoClicked();
		final Player p = player;
		ItemMeta current = item.getItemMeta();
		if (current == null){
			return;
		}
		if (current.getDisplayName().equalsIgnoreCase("§4Confirm Class")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					statChooser.baseStats(p, "Rogue");
				}

			}.runTaskLater(plugin, 6);
		}
		if (current.getDisplayName().equalsIgnoreCase("Previous Menu")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					ClassViewer.meleeSelector(p);
				}

			}.runTaskLater(plugin, 6);
		}

	}
	@EventHandler
	public void onPriestconfirm(InventoryClickEvent event){
		if (!(event.getInventory().getTitle().equalsIgnoreCase("Priest Confirm:"))){
			return;
		}
		if ((event.getSlotType() == InventoryType.SlotType.QUICKBAR) || (event.getSlotType() == InventoryType.SlotType.ARMOR)){
			if (event.isLeftClick() || event.isRightClick() || event.isShiftClick()){
				event.setCancelled(true);
				event.setResult(Result.DENY);
			}
		}
		ItemStack item = event.getCurrentItem();
		if (item == null){
			return;
		}
		event.setResult(Result.DENY);
		event.setCancelled(true);
		Player player = (Player)event.getWhoClicked();
		final Player p = player;
		ItemMeta current = item.getItemMeta();
		if (current == null){
			return;
		}
		if (current.getDisplayName().equalsIgnoreCase("§4Confirm Class")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					statChooser.baseStats(p, "Priest");
				}

			}.runTaskLater(plugin, 6);
		}
		if (current.getDisplayName().equalsIgnoreCase("Previous Menu")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					ClassViewer.healerSelector(p);
				}

			}.runTaskLater(plugin, 6);
		}

	}
	@EventHandler
	public void onClericconfirm(InventoryClickEvent event){
		if (!(event.getInventory().getTitle().equalsIgnoreCase("Cleric Confirm:"))){
			return;
		}
		if ((event.getSlotType() == InventoryType.SlotType.QUICKBAR) || (event.getSlotType() == InventoryType.SlotType.ARMOR)){
			if (event.isLeftClick() || event.isRightClick() || event.isShiftClick()){
				event.setCancelled(true);
				event.setResult(Result.DENY);
			}
		}
		ItemStack item = event.getCurrentItem();
		if (item == null){
			return;
		}
		event.setResult(Result.DENY);
		event.setCancelled(true);
		Player player = (Player)event.getWhoClicked();
		final Player p = player;
		ItemMeta current = item.getItemMeta();
		if (current == null){
			return;
		}
		if (current.getDisplayName().equalsIgnoreCase("§4Confirm Class")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					statChooser.baseStats(p, "Cleric");
				}

			}.runTaskLater(plugin, 6);
		}
		if (current.getDisplayName().equalsIgnoreCase("Previous Menu")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					ClassViewer.healerSelector(p);
				}

			}.runTaskLater(plugin, 6);
		}

	}
	@EventHandler
	public void onOracleconfirm(InventoryClickEvent event){
		if (!(event.getInventory().getTitle().equalsIgnoreCase("Oracle Confirm:"))){
			return;
		}
		if ((event.getSlotType() == InventoryType.SlotType.QUICKBAR) || (event.getSlotType() == InventoryType.SlotType.ARMOR)){
			if (event.isLeftClick() || event.isRightClick() || event.isShiftClick()){
				event.setCancelled(true);
				event.setResult(Result.DENY);
			}
		}
		ItemStack item = event.getCurrentItem();
		if (item == null){
			return;
		}
		event.setResult(Result.DENY);
		event.setCancelled(true);
		Player player = (Player)event.getWhoClicked();
		final Player p = player;
		ItemMeta current = item.getItemMeta();
		if (current == null){
			return;
		}
		if (current.getDisplayName().equalsIgnoreCase("§4Confirm Class")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					statChooser.baseStats(p, "Oracle");
				}

			}.runTaskLater(plugin, 6);
		}
		if (current.getDisplayName().equalsIgnoreCase("Previous Menu")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					ClassViewer.healerSelector(p);
				}

			}.runTaskLater(plugin, 6);
		}

	}
	@EventHandler
	public void onWizardconfirm(InventoryClickEvent event){
		if (!(event.getInventory().getTitle().equalsIgnoreCase("Wizard Confirm:"))){
			return;
		}
		if ((event.getSlotType() == InventoryType.SlotType.QUICKBAR) || (event.getSlotType() == InventoryType.SlotType.ARMOR)){
			if (event.isLeftClick() || event.isRightClick() || event.isShiftClick()){
				event.setCancelled(true);
				event.setResult(Result.DENY);
			}
		}
		ItemStack item = event.getCurrentItem();
		if (item == null){
			return;
		}
		event.setResult(Result.DENY);
		event.setCancelled(true);
		Player player = (Player)event.getWhoClicked();
		final Player p = player;
		ItemMeta current = item.getItemMeta();
		if (current == null){
			return;
		}
		if (current.getDisplayName().equalsIgnoreCase("§4Confirm Class")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					statChooser.baseStats(p, "Wizard");
				}

			}.runTaskLater(plugin, 6);
		}
		if (current.getDisplayName().equalsIgnoreCase("Previous Menu")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					ClassViewer.casterSelector(p);
				}

			}.runTaskLater(plugin, 6);
		}

	}
	@EventHandler
	public void onSorcererconfirm(InventoryClickEvent event){
		if (!(event.getInventory().getTitle().equalsIgnoreCase("Sorcerer Confirm:"))){
			return;
		}
		if ((event.getSlotType() == InventoryType.SlotType.QUICKBAR) || (event.getSlotType() == InventoryType.SlotType.ARMOR)){
			if (event.isLeftClick() || event.isRightClick() || event.isShiftClick()){
				event.setCancelled(true);
				event.setResult(Result.DENY);
			}
		}
		ItemStack item = event.getCurrentItem();
		if (item == null){
			return;
		}
		event.setResult(Result.DENY);
		event.setCancelled(true);
		Player player = (Player)event.getWhoClicked();
		final Player p = player;
		ItemMeta current = item.getItemMeta();
		if (current == null){
			return;
		}
		if (current.getDisplayName().equalsIgnoreCase("§4Confirm Class")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					statChooser.baseStats(p, "Sorcerer");
				}

			}.runTaskLater(plugin, 6);
		}
		if (current.getDisplayName().equalsIgnoreCase("Previous Menu")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					ClassViewer.casterSelector(p);
				}

			}.runTaskLater(plugin, 6);
		}

	}
	@EventHandler
	public void onsummonerconfirm(InventoryClickEvent event){
		if (!(event.getInventory().getTitle().equalsIgnoreCase("Summoner Confirm:"))){
			return;
		}
		if ((event.getSlotType() == InventoryType.SlotType.QUICKBAR) || (event.getSlotType() == InventoryType.SlotType.ARMOR)){
			if (event.isLeftClick() || event.isRightClick() || event.isShiftClick()){
				event.setCancelled(true);
				event.setResult(Result.DENY);
			}
		}
		ItemStack item = event.getCurrentItem();
		if (item == null){
			return;
		}
		event.setResult(Result.DENY);
		event.setCancelled(true);
		Player player = (Player)event.getWhoClicked();
		final Player p = player;
		ItemMeta current = item.getItemMeta();
		if (current == null){
			return;
		}
		if (current.getDisplayName().equalsIgnoreCase("§4Confirm Class")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					statChooser.baseStats(p, "Summoner");
				}

			}.runTaskLater(plugin, 6);
		}
		if (current.getDisplayName().equalsIgnoreCase("Previous Menu")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					ClassViewer.casterSelector(p);
				}

			}.runTaskLater(plugin, 6);
		}

	}
	@EventHandler
	public void onHunterconfirm(InventoryClickEvent event){
		if (!(event.getInventory().getTitle().equalsIgnoreCase("Hunter Confirm:"))){
			return;
		}
		if ((event.getSlotType() == InventoryType.SlotType.QUICKBAR) || (event.getSlotType() == InventoryType.SlotType.ARMOR)){
			if (event.isLeftClick() || event.isRightClick() || event.isShiftClick()){
				event.setCancelled(true);
				event.setResult(Result.DENY);
			}
		}
		ItemStack item = event.getCurrentItem();
		if (item == null){
			return;
		}
		event.setResult(Result.DENY);
		event.setCancelled(true);
		Player player = (Player)event.getWhoClicked();
		final Player p = player;

		ItemMeta current = item.getItemMeta();
		if (current == null){
			return;
		}
		if (current.getDisplayName().equalsIgnoreCase("§4Confirm Class")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					statChooser.baseStats(p, "Hunter");
				}

			}.runTaskLater(plugin, 6);
		}
		if (current.getDisplayName().equalsIgnoreCase("Previous Menu")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					ClassViewer.rangedSelector(p);
				}

			}.runTaskLater(plugin, 6);
		}

	}
	@EventHandler
	public void onSniperconfirm(InventoryClickEvent event){
		if (!(event.getInventory().getTitle().equalsIgnoreCase("Sniper Confirm:"))){
			return;
		}
		if ((event.getSlotType() == InventoryType.SlotType.QUICKBAR) || (event.getSlotType() == InventoryType.SlotType.ARMOR)){
			if (event.isLeftClick() || event.isRightClick() || event.isShiftClick()){
				event.setCancelled(true);
				event.setResult(Result.DENY);
			}
		}
		ItemStack item = event.getCurrentItem();
		if (item == null){
			return;
		}
		event.setResult(Result.DENY);
		event.setCancelled(true);
		Player player = (Player)event.getWhoClicked();
		final Player p = player;

		ItemMeta current = item.getItemMeta();
		if (current == null){
			return;
		}
		if (current.getDisplayName().equalsIgnoreCase("§4Confirm Class")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					statChooser.baseStats(p, "Sniper");
				}

			}.runTaskLater(plugin, 6);
		}
		if (current.getDisplayName().equalsIgnoreCase("Previous Menu")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					ClassViewer.rangedSelector(p);
				}

			}.runTaskLater(plugin, 6);
		}

	}
	@EventHandler
	public void onRangerconfirm(InventoryClickEvent event){
		if (!(event.getInventory().getTitle().equalsIgnoreCase("Ranger Confirm:"))){
			return;
		}
		if ((event.getSlotType() == InventoryType.SlotType.QUICKBAR) || (event.getSlotType() == InventoryType.SlotType.ARMOR)){
			if (event.isLeftClick() || event.isRightClick() || event.isShiftClick()){
				event.setCancelled(true);
				event.setResult(Result.DENY);
			}
		}
		ItemStack item = event.getCurrentItem();
		if (item == null){
			return;
		}
		event.setResult(Result.DENY);
		event.setCancelled(true);
		Player player = (Player)event.getWhoClicked();
		final Player p = player;
		ItemMeta current = item.getItemMeta();
		if (current == null){
			return;
		}
		if (current.getDisplayName().equalsIgnoreCase("§4Confirm Class")){
			p.closeInventory();
			new BukkitRunnable(){

				@Override
				public void run(){
					statChooser.baseStats(p, "Ranger");
				}

			}.runTaskLater(plugin, 6);
		} else {
			if (current.getDisplayName().equalsIgnoreCase("Previous Menu")){
				p.closeInventory();
				new BukkitRunnable(){

					@Override
					public void run(){
						ClassViewer.rangedSelector(p);
					}

				}.runTaskLater(plugin, 6);
			}else {
				event.setResult(Result.DENY);
				event.setCancelled(true);
			} 
		}

	}
	@EventHandler
	public void onStatsconfirm(InventoryClickEvent event){
		if (!(event.getInventory().getTitle().equalsIgnoreCase("Final Confirm:"))){
			return;
		}
		if ((event.getSlotType() == InventoryType.SlotType.QUICKBAR) || (event.getSlotType() == InventoryType.SlotType.ARMOR)){
			if (event.isLeftClick() || event.isRightClick() || event.isShiftClick()){
				event.setCancelled(true);
				event.setResult(Result.DENY);
			}
		}
		ItemStack item = event.getCurrentItem();
		if (item == null){
			return;
		}
		event.setResult(Result.DENY);
		event.setCancelled(true);
		Player player = (Player)event.getWhoClicked();
		final Player p = player;
		ItemMeta current = item.getItemMeta();
		if (current == null){
			return;
		}
		if (current.getDisplayName().equalsIgnoreCase("§4Confirm Stats")){
			event.setResult(Result.DENY);
			event.setCancelled(true);
			ItemStack classget = event.getInventory().getItem(12);
			ItemMeta mclass = classget.getItemMeta();
			String classname = null;
			List<String> lclass = mclass.getLore();
			if (lclass.contains("Fighter")){
				classname = "Fighter";
			}
			if (lclass.contains("Warrior")){
				classname = "Warrior";
			}
			if (lclass.contains("Rogue")){
				classname = "Rogue";
			}
			if (lclass.contains("Priest")){
				classname = "Priest";
			}
			if (lclass.contains("Cleric")){
				classname = "Cleric";
			}
			if (lclass.contains("Oracle")){
				classname = "Oracle";
			}
			if (lclass.contains("Wizard")){
				classname = "Wizard";
			}
			if (lclass.contains("Sorcerer")){
				classname = "Sorcerer";
			}
			if (lclass.contains("Summoner")){
				classname = "Summoner";
			}
			if (lclass.contains("Ranger")){
				classname = "Ranger";
			}
			if (lclass.contains("Hunter")){
				classname = "Hunter";
			}
			if (lclass.contains("Sniper")){
				classname = "Sniper";
			}
			p.closeInventory();
			final String curclass = classname;
			final Integer s1 = event.getInventory().getItem(10).getAmount();
			final Integer s2 = event.getInventory().getItem(11).getAmount();
			final Integer s3 = event.getInventory().getItem(12).getAmount();
			final Integer s4 = event.getInventory().getItem(14).getAmount();
			final Integer s5 = event.getInventory().getItem(15).getAmount();
			final Integer s6 = event.getInventory().getItem(16).getAmount();
			new BukkitRunnable(){

				@Override
				public void run(){
					statsSet.statSaver(p, curclass, s1, s2, s3, s4, s5, s6);
				}

			}.runTaskLater(plugin, 6);
		} else {
			if (current.getDisplayName().equalsIgnoreCase("Previous Menu")){
				p.closeInventory();
				ItemStack classget = event.getInventory().getItem(11);
				ItemMeta mclass = classget.getItemMeta();
				String classname = null;
				List<String> lclass = mclass.getLore();
				if (lclass.contains("Fighter")){
					classname = "Fighter";
				}
				if (lclass.contains("Warrior")){
					classname = "Warrior";
				}
				if (lclass.contains("Rogue")){
					classname = "Rogue";
				}
				if (lclass.contains("Priest")){
					classname = "Priest";
				}
				if (lclass.contains("Cleric")){
					classname = "Cleric";
				}
				if (lclass.contains("Oracle")){
					classname = "Oracle";
				}
				if (lclass.contains("Wizard")){
					classname = "Wizard";
				}
				if (lclass.contains("Sorcerer")){
					classname = "Sorcerer";
				}
				if (lclass.contains("Summoner")){
					classname = "Summoner";
				}
				if (lclass.contains("Ranger")){
					classname = "Ranger";
				}
				if (lclass.contains("Hunter")){
					classname = "Hunter";
				}
				if (lclass.contains("Sniper")){
					classname = "Sniper";
				}
				final String curclass = classname;
				new BukkitRunnable(){

					@Override
					public void run(){
						statChooser.baseStats(p, curclass);
					}

				}.runTaskLater(plugin, 6);
			}else {
				event.setResult(Result.DENY);
				event.setCancelled(true);
			} 
		}

	}









	public static List<Location> circle (Player player, Location loc, Integer r, Integer h, Boolean hollow, Boolean sphere, int plus_y) {
		List<Location> circleblocks = new ArrayList<Location>();
		int cx = loc.getBlockX();
		int cy = loc.getBlockY();
		int cz = loc.getBlockZ();
		for (int x = cx - r; x <= cx +r; x++)
			for (int z = cz - r; z <= cz +r; z++)
				for (int y = (sphere ? cy - r : cy); y < (sphere ? cy + r : cy + h); y++) {
					double dist = (cx - x) * (cx - x) + (cz - z) * (cz - z) + (sphere ? (cy - y) * (cy - y) : 0);
					if (dist < r*r && !(hollow && dist < (r-1)*(r-1))) {
						Location l = new Location(loc.getWorld(), x, y + plus_y, z);
						circleblocks.add(l);
					}
				}

		return circleblocks;
	}
	public static void firePlayer(Player p){
		final Player player = p;
		final Integer level = p.getLevel();
		final List<Location> newl = circle(player, p.getLocation(), 4, 1, true, false, 6);
		final FireworkEffect fm = FireworkEffect.builder().with(Type.BALL_LARGE).withColor(Color.YELLOW).withFade(Color.BLACK).trail(true).flicker(true).build();
		final Location fwb = p.getLocation();
		fwb.setY(fwb.getY() + 10);
		FireworkSettings.playFw(fwb, fm);

		new BukkitRunnable() {
			Integer count = level *5;
			Integer display = 19;

			@Override
			public void run() {
				Location ploc = newl.get(display);
				if (count == 0){
					cancel();

				}
				FireworkEffect fwe = FireworkEffect.builder().with(Type.BALL).withColor(Color.YELLOW).withFade(Color.WHITE).trail(true).flicker(false).build();
				FireworkSettings.playFw(ploc, fwe);
				count--;
				display--;
				if (display == 0){
					FireworkSettings.playFw(fwb, fm);
					display = 19;
				}
			}
		}.runTaskTimer(plugin, 5, 1);
	}
	@EventHandler
	public void playerDeath(PlayerDeathEvent event){
		 Location loc = event.getEntity().getLocation();
		 loc.setY(loc.getY() - 1);
		 FireworkEffect fwe = FireworkEffect.builder().with(Type.BURST).withColor(Color.RED).withFade(Color.BLACK).trail(false).flicker(true).build();
		 FireworkSettings.playFw(loc, fwe);
	}
}
