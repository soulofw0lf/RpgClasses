package com.vartala.soulofw0lf.rpgclasses;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class NewClass {
	public static Boolean breaktut = false;

	public static void select(Player player){
		final Player p = player;
		p.sendMessage("§2A inventory style menu is about to open. This will be used to pick your stats and your class.");
		p.sendMessage("§5If at any time you accidently close it just type §4/class select.");
		new BukkitRunnable(){
			Integer i = 1;
			@Override
			public void run(){
				if (i == 37 || p.hasPermission("class.select")){
					if (!(p.hasPermission("class.select"))){
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " class.select");
					ClassViewer.classSelector(p);
					}
					p.sendMessage("you can now use </class select> to pick your class!");
					cancel();
					}
				if (i == 1){
				p.sendMessage("§2Welcome to the §4Paths of Iluthi §2MMO RPG Server.");
				}
				if (i == 2){
				p.sendMessage("§2Please feel free to look around our spawn while we go over this tutorial for you.");
				}
				if (i == 3){
				p.sendMessage("§2first off let's go ahead and get the server rules out of the way.");
				}
				if (i == 4){
				p.sendMessage("§4No hacked clients, no unapproved mods, no griefing, no trolling and no spamming.");
				}
				if (i == 5){
				p.sendMessage("§5Only rei's minimap, optifine, mcpatcher, and the spout client are allowed for client side mods. §2And now back to our regularly scheduled tutorial!");
				}
				if (i == 6){
				p.sendMessage("§2If at any time you would like to §5skip the tutorial §and go straight into the class selection process please type §4/tutskip");
				}
				if (i == 7){
				p.sendMessage("§4Paths of Iluthi §2is an §3Adventure Path Rpg. §2This means that as you level your charactor throughout the game you will have many §3Path choices §2to make to determine the story line you are following.");
				}
				if (i == 8){
				p.sendMessage("§2This game is split up between §892 Worlds. §2Each of which have their own storylines, unique §4Dungeons, §1Gear Rewards, §4Raids, §2and Insight into the main plot.");
				}
				if (i == 9){
				p.sendMessage("§2While traversing the §4Paths of Iluthi §2there are some usefull §6game features §2and §6commands §2you might like to know about.");
				}
				if (i == 10){
				p.sendMessage("§2We'll start out with our social features! These consist of our §5Friends, §3Guild, §6Party, §2and §7Raid §2Features.");
				}
				if (i == 11){
				p.sendMessage("§2First we have our friends list. this server is a busy server so we have Player loggin in messges disabled. Addin peole you like playing with to your friends list is a way to alert you when they come online.");
				}
				if (i == 12){
				p.sendMessage("§2This is done by typing §5/friend add playername §2while they are online. This will send them a friend invite that they can choose to decline or accept.");
				}
				if (i == 13){
				p.sendMessage("§2Friend invites are accepted by typing §5/friend accept §2 and declined by typing §4/friend deny");
				}
				if (i == 14){
				p.sendMessage("§2To see which of your friends are online when you first log on you can type §5/friend list §2to bring up a inventory display of all your friends. Online friends will be displayed with a §3player head §2and offline players will be displayed with a §8Skeleton Head");
				}
				if (i == 15){
				p.sendMessage("§2Mousing over the heads will give you additional information about your friends, such as what world they are on and the ability to use extra commands by §3Left §4Right §2or §6Middle §2clicking on them.");
				}
				if (i == 16){
				p.sendMessage("§2you can also type §4/friend Ignore §2to ignore someone, and block all chat messages that they would later send!");
				}
				if (i == 17){
				p.sendMessage("§2don't forget you can type §4/tutskip §2at any point in time to exit the tutorial and start making your very first charactor!");
				}
				if (i == 18){
				p.sendMessage("§2The next feature is the §5Party System. §2The main party commands are §5/party invite playername §3/party accept §4/party deny §6/party kick playername §7/party promote playername §2and §5/party leave.");
				}
				if (i == 19){
				p.sendMessage("§2Only the party leader can invite, kick, or promote.");
				}
				if (i == 20){
				p.sendMessage("§2While in a party good quality loot items that drop for your party are rolled on, and the item goes to the player with the highest roll. When items first drop it will open a window that has the item in it. you can §3Left click §2to roll on the item or §4Right click §2to pass on the item.");
				}
				if (i == 21){
				p.sendMessage("	§2If you close the roling window you can manually type §3/party roll §4/party pass §2or §5/party info. §2 the info command brings up the rolling window so you can more closely look at the item. Remember some items are better suited for some classes than other! It's best not to get too greedy!");
				}
				if (i == 22){
				p.sendMessage("§2Our guild and raid features are very similiar to our friend and party features so i'm not going to go them indepth here, they are just on a larger scale with more management options.");
				}
				if (i == 23){
				p.sendMessage("§2Typing in commands constantly can be both boring and annoying so we've provided you with a nice little short cut. If you are near a player and want to invite them to party, or guild, or inspect their gear, or invite them to a trade, all you have to do is shift click on the player to bring up an inventory menu with multiple commands to use with a click of a mouse!");
				}
				if (i == 24){
				p.sendMessage("§2speaking of our trade system. When invited to a trade you can type §3/trade accept §2or just shift click on the person that invited you and use our click menu to accept through there.");
				}
				if (i == 25){
				p.sendMessage("§2While in a trade the person who §3started §2the trade controls the §3left §2side of the inventory and the person who was §4invited §2has the §4right §2side. When both party's are in agreement about the trade all they have to do is click on the green accept wool to confirm it!");
				}
				if (i == 26){
				p.sendMessage("§4Don't worry! §2If you've already hit accept but the second player switches an item out the accept is automatically cancelled on your end and you have to hit it again! No trade scamming this way!");
				}
				if (i == 27){
				p.sendMessage("§2don't forget you can type §4/tutskip §2at any point in time to exit the tutorial and start making your very first charactor!");
				}
				if (i == 28){
				p.sendMessage("§2One of the most important features of our server that probably just seems kind of §9quant §2is our §3Achievements / titles §2system.");
				}
				if (i == 29){
				p.sendMessage("§2While this may just seem like something kind of fun, there are achievements in game which give you specially abilities while you have the titles equipped!");
				}
				if (i == 30){
				p.sendMessage("§2These abilities can grant you access into dungeons you are otherwise prohibited form entering, allow you to speak with people that your reputations would normally prohibit, and even give you access to special spells / followers / and mounts!");
				}
				if (i == 31){
				p.sendMessage("§2Once you've earned an achievement you can set the title associated with it by typing §3/titles set title_name. §2you can have both a prefix title and a suffix title active at the same time!");
				}
				if (i == 32){
				p.sendMessage("§2to remove your titles just type §4/titles none. §you can view all available achievements by typing §3/titles list §2or the achievements a specific player, including yourself, has earned by typing §3/titles list playername.");
				}
				if (i == 33){
				p.sendMessage("§2To view more detailed information about any soecific title and the achievement associated with it just type §3/titles info title_name.");
				}
				if (i == 34){
				p.sendMessage("§2there are alot more features in the game that you will learn about as you quest and progress through the storylines, and a lot of class specific features you will learn about while playing your selected class.");
				}
				if (i == 35){
				p.sendMessage("§2The only other important note to remember is that eatting food is not like it is in regular minecraft! you must stand still to eat and it heals you as you are eatting. you're \"hunger bar\" is instead a cast bar for how long you have left to eat!");
				}
				if (i == 36){
				p.sendMessage("§2If you eat for the full duration of your hunger bar, alot of the food in game will give you buffs that last from 1 min to 1 hour depending on the food you eat!");
				}
				
				i++;
			}
			
		}.runTaskTimer(RpgClasses.plugin, 60, 180);
		
	}

}
