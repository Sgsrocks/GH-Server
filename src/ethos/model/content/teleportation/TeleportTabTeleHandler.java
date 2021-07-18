package ethos.model.content.teleportation;

import ethos.Config;
import ethos.event.impl.WheatPortalEvent;
import ethos.model.players.Player;

/*
 * Teleport handler for the teleport tab
 * 
 * @author James
 */

public class TeleportTabTeleHandler {
	
	private Player c;
	
	public TeleportTabTeleHandler(Player player) {
		this.c = player;
	}

	String[] monsterNames = { "Ancient Cavern", "Asgarnian Ice Caves", "Brimhaven Dungeon", "Chasm of Fire",
			"Corsair Cave", "Crash Site Cavern", "Fremennik Dungeon", "Kourend Catacombs", "Karuulm Dungeon", "Lithkren Vault", "Slayer Tower", "Smoke Dungeon",
			"Stronghold Dungeon", "Taverley Dungeon", "Wyvern Cave", "", "", "", "", "", ""};
	
	String[] minigameNames = { "Barrows", "Chambers of Xeric", "Duel Arena", "Fight Caves", "Inferno", "Mage Arena",
			"Pest Control", "Shayzien Assault", "Warriors Guild", "", "", "", "", "", "", "",
			"", "", "", ""};
	
	String[] skillingNames = { "Cooking Guild", "Crafting Guild", "Farming Guild", "Falador Farming",
			"Feldip Hills", "Fishing Guild", "Piscatoris Fishing", "Pure Essence Mine", "Tree Gnome Stronghold", "Woodcutting Guild", "ZMI Altar", "",
			"", "", "", "", "", "", "", ""}; 
	/*
	 * "Mining", "Smithing", "Fishing", "Woodcutting (low level)", "Woodcutting Guild", "Farming", "Gnome Agility", "Barbarian Agitity", "Wilderness Agility", "Rooftop Agility", "Thieving", "Slayer", "Hunter", "RCing", 
			"", "", "", "", "", ""		
	 */
	
	String[] bossesNames = {"Abyssal Sire", "Corporeal Beast", "Cerberus",
			"Dagonnoth Kings", "Giant Mole", "God Wars Dungeon",
			"Kraken", "Lizardman Shaman", "Thermonuclear Smoke Devil", "Vorkath", "Zulrah",
			"", "", "", "", "", "", "", "", "" };
			
	String[] wildernessNames = { "Eastern Dragons", "Forinthry Dungeon",
			"Mage Bank", "Western Dragons", "Wilderness Agility Course",
			"Vet'ion", "Callisto", "Scorpia", "Venenatis",
			"Chaos Elemental", "Crazy Archaeologist", "Chaos Fanatic", "", "", "", "", "",
			"", "", ""};
	
	String[] citiesNames = { "Al Kharid", "Ardougne", "Brimhaven", "Burthorpe", "Camelot", "Canifis",
			"Catherby", "Draynor Village", "Falador", "Kourend", "Lumbridge", "Lletya", "Mos Le Harmless", "Pollnivneach",
			"Rellekka", "Shilo Village", "Sophanem", "Taverley", "Varrock", "Yanille"};
	
	
	/*
	 * for(int iD = 47628; iD <= 47648; iD++) {
	 * 20 teleports
	 */
	public void loadMonsterTab() {
		int[] ids = { 47628, 47629, 47630, 47631, 47632, 47633, 47634, 47635, 47636, 47637, 47638, 47639, 47640, 47641, 47642, 47643, 47644, 47645, 47646, 47647 };
		for (int j = 0; j <= 19; j++) {
			
			c.getPA().sendFrame126(monsterNames[j], ids[j]);
		}
	}
	
	public void loadMinigamesTab() {
		int[] ids = { 47628, 47629, 47630, 47631, 47632, 47633, 47634, 47635, 47636, 47637, 47638, 47639, 47640, 47641, 47642, 47643, 47644, 47645, 47646, 47647 };
		for (int j = 0; j <= 19; j++) {
			
			c.getPA().sendFrame126(minigameNames[j], ids[j]);
		}
	}
	
	public void loadSkillingTab() {
		int[] ids = { 47628, 47629, 47630, 47631, 47632, 47633, 47634, 47635, 47636, 47637, 47638, 47639, 47640, 47641, 47642, 47643, 47644, 47645, 47646, 47647 };
		for (int j = 0; j <= 19; j++) {
			
			c.getPA().sendFrame126(skillingNames[j], ids[j]);
		}
	}
	
	public void loadBossesTab() {
		int[] ids = { 47628, 47629, 47630, 47631, 47632, 47633, 47634, 47635, 47636, 47637, 47638, 47639, 47640, 47641, 47642, 47643, 47644, 47645, 47646, 47647 };
		for (int j = 0; j <= 19; j++) {
			
			c.getPA().sendFrame126(bossesNames[j], ids[j]);
		}
	}
	
	public void loadWildernessTab() {
		int[] ids = { 47628, 47629, 47630, 47631, 47632, 47633, 47634, 47635, 47636, 47637, 47638, 47639, 47640, 47641, 47642, 47643, 47644, 47645, 47646, 47647 };
		for (int j = 0; j <= 19; j++) {
			
			c.getPA().sendFrame126(wildernessNames[j], ids[j]);
		}
	}
	
	public void loadCitiesTab() {
		int[] ids = { 47628, 47629, 47630, 47631, 47632, 47633, 47634, 47635, 47636, 47637, 47638, 47639, 47640, 47641, 47642, 47643, 47644, 47645, 47646, 47647 };
		for (int j = 0; j <= 19; j++) {
			
			c.getPA().sendFrame126(citiesNames[j], ids[j]);
		}
	}
	
	public void loadTab(Player player, int tab) {
		if (player.teleTabSelected == 0) {
			loadMonsterTab();
		} else if (player.teleTabSelected == 1) {
			loadMinigamesTab();
		} else if (player.teleTabSelected == 2) {
			loadSkillingTab();
		} else if (player.teleTabSelected == 3) {
			loadBossesTab();
		} else if (player.teleTabSelected == 4) {
			loadWildernessTab();
		} else if (player.teleTabSelected == 5) {
			loadCitiesTab();
		}
	}
	
	public void selection(Player player, int i) {
		player.teleTabSelected = i;
		loadTab(player, i);
	}
	
	public boolean teleportCheck(Player player) {
		return true;
	}
	
	public void handleTeleport(Player player, int Id) {
		if (player.inWild() && player.wildLevel > Config.NO_TELEPORT_WILD_LEVEL) {
			player.sendMessage("You can not teleport while above level " + Config.NO_TELEPORT_WILD_LEVEL + " wilderness.");
			return;
		}
		
		switch(Id) {
			//selection btns
			case 185145:
				selection(player, 0);
				break;
			case 185146:
				selection(player, 1);
				break;
			case 185147:
				selection(player, 2);
				break;
			case 185148:
				selection(player, 3);
				break;
			case 185149:
				selection(player, 4);
				break;
			case 185150:
				selection(player, 5);
				break;
			
			//now its the teleports buttons:
				//185247 - 185255
				//186000 - 186009
			case 185247://1
				//player.sendMessage("teletabsel "  + player.teleTabSelected);
				if (!teleportCheck(player))
					return;
				//player.sendMessage("Selection:" + player.teleTabSelected);
				if (player.teleTabSelected == 0) { // Monsters
					player.getPA().startTeleport(1773, 5336, 0, "modern", false);
				} else if (player.teleTabSelected == 1) { // Minigames
					player.getPA().startTeleport(3565, 3316, 0, "modern", false); // change
				} else if (player.teleTabSelected == 2) { // Skilling
					player.getPA().startTeleport(3143, 3442, 0, "modern", false);
				} else if (player.teleTabSelected == 3) { // Bosses
					player.getPA().startTeleport(3039, 4768, 0, "modern", false);
				} else if (player.teleTabSelected == 4) { // Wilderness
					player.getPA().startTeleport(2976, 3591, 0, "modern", false);
				} else if (player.teleTabSelected == 5) { // Cities
					player.getPA().startTeleport(3294, 3194, 0, "modern", false);
				}
				break;
			case 185248://2
				//player.sendMessage("teletabsel "  + player.teleTabSelected);
				if (!teleportCheck(player))
					return;
				if (player.teleTabSelected == 0) { // Monsters
					player.getPA().startTeleport(3011, 3151, 0, "modern", false);
				} else if (player.teleTabSelected == 1) { // Minigames
					player.getPA().startTeleport(3365, 3266, 0, "modern", false);
				} else if (player.teleTabSelected == 2) { // Skilling
					player.getPA().startTeleport(2933, 3290, 0, "modern", false);
				} else if (player.teleTabSelected == 3) { // Bosses
					player.getPA().startTeleport(2968, 4383, 2, "modern", false);
				} else if (player.teleTabSelected == 4) { // Wilderness
					player.getPA().startTeleport(2539, 4716, 0, "modern", false);
				} else if (player.teleTabSelected == 5) { // Cities
					player.getPA().startTeleport(2662, 3306, 0, "modern", false);
				}
				break;
			case 185249://3
				//player.sendMessage("teletabsel "  + player.teleTabSelected);
				if (!teleportCheck(player))
					return;
				if (player.teleTabSelected == 0) { // Monsters
					player.getPA().startTeleport(2744, 3148, 0, "modern", false);
				} else if (player.teleTabSelected == 1) { // Minigames
					player.getPA().startTeleport(2444, 5179, 0, "modern", false);
				} else if (player.teleTabSelected == 2) { // Skilling
					player.getPA().startTeleport(1249, 3720, 0, "modern", false);
				} else if (player.teleTabSelected == 3) { // Bosses
					player.getPA().startTeleport(1310, 1242, 0, "modern", false);
				} else if (player.teleTabSelected == 4) { // Wilderness
					player.getPA().startTeleport(3020, 3632, 0, "modern", false);
				} else if (player.teleTabSelected == 5) { // Cities
					player.getPA().startTeleport(2783, 3183, 0, "modern", false);
				}
				break;
			case 185250://4
				//player.sendMessage("teletabsel "  + player.teleTabSelected);
				if (!teleportCheck(player))
					return;
				if (player.teleTabSelected == 0) { // Monsters
					player.getPA().startTeleport(1440, 10092, 2, "modern", false);
				} else if (player.teleTabSelected == 1) { // Minigames
					player.getPA().startTeleport(2444, 5179, 0, "modern", false);
				} else if (player.teleTabSelected == 2) { // Skilling
					player.getPA().startTeleport(2993, 3370, 0, "modern", false);
				} else if (player.teleTabSelected == 3) { // Bosses
					player.getPA().startTeleport(1913, 4367, 0, "modern", false);
				} else if (player.teleTabSelected == 4) { // Wilderness
					player.getPA().startTeleport(3304, 3657, 0, "modern", false);
				} else if (player.teleTabSelected == 5) { // Cities
					player.getPA().startTeleport(2918, 3545, 0, "modern", false);
				}
				break;
			case 185251://5
				//player.sendMessage("teletabsel "  + player.teleTabSelected);
				if (!teleportCheck(player))
					return;
				if (player.teleTabSelected == 0) { // Monsters
					player.getPA().startTeleport(2012, 9003, 1, "modern", false);
				} else if (player.teleTabSelected == 1) { // Minigames
					player.getPA().startTeleport(3565, 3316, 0, "modern", false);
				} else if (player.teleTabSelected == 2) { // Skilling
					player.getPA().startTeleport(2560, 2972, 0, "modern", false);
				} else if (player.teleTabSelected == 3) { // Bosses
					player.getPA().startTeleport(2998, 3376, 0, "modern", false);
				} else if (player.teleTabSelected == 4) { // Wilderness
					player.getPA().startTeleport(2998, 3913, 0, "modern", false);
				} else if (player.teleTabSelected == 5) { // Cities
					player.getPA().startTeleport(2756, 3478, 0, "modern", false);
				}
				break;
			case 185252://6
				//player.sendMessage("teletabsel "  + player.teleTabSelected);
				if (!teleportCheck(player))
					return;
				if (player.teleTabSelected == 0) { // Monsters
					player.getPA().startTeleport(2131, 5646, 0, "modern", false);
				} else if (player.teleTabSelected == 1) { // Minigames
					player.getPA().startTeleport(2541, 4716, 0, "modern", false);
				} else if (player.teleTabSelected == 2) { // Skilling
					player.getPA().startTeleport(2611, 3392, 0, "modern", false);
				} else if (player.teleTabSelected == 3) { // Bosses
					player.getPA().startTeleport(2881, 5310, 2, "modern", false);
				} else if (player.teleTabSelected == 4) { // Wilderness
					player.getPA().startTeleport(3200, 3794, 0, "modern", false);
					
				} else if (player.teleTabSelected == 5) { // Cities
					player.getPA().startTeleport(3497, 3492, 0, "modern", false);
				}
				break;
			case 185253://7
				//player.sendMessage("teletabsel "  + player.teleTabSelected);
				if (!teleportCheck(player))
					return;
				if (player.teleTabSelected == 0) { // Monsters
					player.getPA().startTeleport(2807, 10002, 0, "modern", false);
				} else if (player.teleTabSelected == 1) { // Minigames
					player.getPA().startTeleport(2660, 2648, 0, "modern", false);
				} else if (player.teleTabSelected == 2) { // Skilling
					player.getPA().startTeleport(2336, 3690, 0, "modern", false);
				} else if (player.teleTabSelected == 3) { // Bosses
					player.getPA().startTeleport(2278, 10016, 0, "modern", false);
				} else if (player.teleTabSelected == 4) { // Wilderness
					player.getPA().startTeleport(3325, 3845, 0, "modern", false);
				} else if (player.teleTabSelected == 5) { // Cities
					player.getPA().startTeleport(2830, 3438, 0, "modern", false);
				}
				break;
			case 185254://8
				//player.sendMessage("teletabsel "  + player.teleTabSelected);
				if (!teleportCheck(player))
					return;
				if (player.teleTabSelected == 0) { // Monsters
					player.getPA().startTeleport(1636, 3670, 0, "modern", false);
				} else if (player.teleTabSelected == 1) { // Minigames
					player.getPA().startTeleport(1461, 3689, 0, "modern", false);
				} else if (player.teleTabSelected == 2) { // Skilling
					player.getPA().startTeleport(2911, 4832, 0, "modern", false);
				} else if (player.teleTabSelected == 3) { // Bosses
					player.getPA().startTeleport(1550, 3696, 0, "modern", false);
				} else if (player.teleTabSelected == 4) { // Wilderness
					player.getPA().startTeleport(3233, 3945, 0, "modern", false);
				} else if (player.teleTabSelected == 5) { // Cities
					player.getPA().startTeleport(3103, 3257, 0, "modern", false);
				}
				break;
			case 185255://9
				//player.sendMessage("teletabsel "  + player.teleTabSelected);
				if (!teleportCheck(player))
					return;
				if (player.teleTabSelected == 0) { // Monsters
					player.getPA().startTeleport(1312, 10225, 0, "modern", false);
				} else if (player.teleTabSelected == 1) { // Minigames
					player.getPA().startTeleport(2874, 3546, 0, "modern", false);
				} else if (player.teleTabSelected == 2) { // Skilling
					player.getPA().startTeleport(2465, 3446, 0, "modern", false);
				} else if (player.teleTabSelected == 3) { // Bosses
					player.getPA().startTeleport(2381, 9452, 0, "modern", false);
				} else if (player.teleTabSelected == 4) { // Wilderness
					player.getPA().startTeleport(3345, 3754, 0, "modern", false);
				} else if (player.teleTabSelected == 5) { // Cities
					player.getPA().startTeleport(2965, 3384, 0, "modern", false);
				}
				break;
			case 186000://10
				//player.sendMessage("teletabsel "  + player.teleTabSelected);
				if (!teleportCheck(player))
					return;
				if (player.teleTabSelected == 0) { // Monsters
					player.getPA().startTeleport(1568, 5065, 0, "modern", false);
				} else if (player.teleTabSelected == 2) { // Skilling
					player.getPA().startTeleport(1659, 3504, 0, "modern", false);
	
				} else if (player.teleTabSelected == 3) { // Bosses
					player.getPA().startTeleport(2272, 4050, 0, "modern", false);
					
				} else if (player.teleTabSelected == 4) { // Wilderness
					player.getPA().startTeleport(3300, 3921, 0, "modern", false);
				} else if (player.teleTabSelected == 5) { // Cities
					player.getPA().startTeleport(1629, 3646, 0, "modern", false);
				}
				break;
			case 186001://11
				//player.sendMessage("teletabsel "  + player.teleTabSelected);
				if (!teleportCheck(player))
					return;
				if (player.teleTabSelected == 0) { // Monsters
					player.getPA().startTeleport(3428, 3538, 0, "modern", false);
					
				} else if (player.teleTabSelected == 2) { // Skilling
					player.getPA().startTeleport(3032, 5573, 0, "modern", false);// change
				} else if (player.teleTabSelected == 3) { // Bosses
					player.getPA().startTeleport(2202, 3056, 0, "modern", false);
					//player.getPA().startTeleport(2404, 9415, 0, "modern", false);
				} else if (player.teleTabSelected == 4) { // Wilderness
					player.getPA().startTeleport(2978, 3833, 0, "modern", false);
				} else if (player.teleTabSelected == 5) { // Cities
					player.getPA().startTeleport(3235, 3218, 0, "modern", false);
				}
				break;
			case 186002://12
				//player.sendMessage("teletabsel "  + player.teleTabSelected);
				if (!teleportCheck(player))
					return;
				if (player.teleTabSelected == 0) { // Monsters
					player.getPA().startTeleport(3294, 9373, 0, "modern", false);
					
				} else if (player.teleTabSelected == 3) { // Bosses
					player.getPA().startTeleport(2404, 9415, 0, "modern", false);
					//player.getPA().startTeleport(2124, 5660, 0, "modern", false);
				} else if (player.teleTabSelected == 4) { // Wilderness
					player.getPA().startTeleport(2971, 3695, 0, "modern", false);
				} else if (player.teleTabSelected == 5) { // Cities
					player.getPA().startTeleport(2342, 3172, 0, "modern", false);
				}
				break;
			case 186003://13
				//player.sendMessage("teletabsel "  + player.teleTabSelected);
				if (!teleportCheck(player))
					return;
				if (player.teleTabSelected == 0) { // Monsters
					player.getPA().startTeleport(2453, 9834, 0, "modern", false);

				}else if (player.teleTabSelected == 3) { // Bosses
					player.getPA().startTeleport(3037, 4765, 0, "modern", false);
				} else if (player.teleTabSelected == 4) { // Wilderness
					player.getPA().startTeleport(3129, 3831, 0, "modern", false);
					
					//player.getPA().startTeleport(1558, 3696, 0, "modern", false);
				}else if (player.teleTabSelected == 5) { // Cities
					player.getPA().startTeleport(3717, 2970, 0, "modern", false);
				}
				break;
			case 186004://14
				//player.sendMessage("teletabsel "  + player.teleTabSelected);
				if (!teleportCheck(player))
					return;
				if (player.teleTabSelected == 0) { // Monsters
					player.getPA().startTeleport(2884, 9799, 0, "modern", false);
				}else if (player.teleTabSelected == 2) { // Skilling
					//player.getPA().startTeleport(x, y, 0, "modern", false);// change
				} else if (player.teleTabSelected == 3) { // Bosses
					player.sendMessage("@red@Coming Soon.");
				}else if (player.teleTabSelected == 5) { // Cities
					player.getPA().startTeleport(3362, 2987, 0, "modern", false);
					
					//player.getPA().startTeleport(2272, 4050, 0, "modern", false);
				}
				break;
			case 186005://15
				//player.sendMessage("teletabsel "  + player.teleTabSelected);
				if (!teleportCheck(player))
					return;
				if (player.teleTabSelected == 0) { // Monsters
					player.getPA().startTeleport(3603, 10224, 0, "modern", false);
				} else if (player.teleTabSelected == 2) { // Skilling
					//player.getPA().startTeleport(x, y, 0, "modern", false);// change
				} else if (player.teleTabSelected == 3) { // Bosses
					player.getPA().startTeleport(1558, 3696, 0, "modern", false);
				} else if (player.teleTabSelected == 5) { // Cities
					player.getPA().startTeleport(2643, 3677, 0, "modern", false);
					
					//player.getPA().startTeleport(3037, 4765, 0, "modern", false);
				}
				break;
			case 186006://16
				//player.sendMessage("teletabsel "  + player.teleTabSelected);
				if (!teleportCheck(player))
					return;
				if (player.teleTabSelected == 3) { // Bosses
					player.getPA().startTeleport(2272, 4050, 0, "modern", false);
				} else if (player.teleTabSelected == 5) { // Cities
					player.getPA().startTeleport(2864, 2968, 0, "modern", false);
				}
				break;
			case 186007://17
				if (!teleportCheck(player))
					return;
				if (player.teleTabSelected == 2) { // Skilling
					//player.getPA().startTeleport(x, y, 0, "modern", false);// change
				} else if (player.teleTabSelected == 3) { // Bosses
					//player.getPA().startTeleport(2202, 3056, 0, "modern", false);
					player.getPA().startTeleport(2495, 5108, 0, "modern", false);
				} else if (player.teleTabSelected == 5) { // Cities
					player.getPA().startTeleport(3296, 2784, 0, "modern", false);
				}
				break;
			case 186008://18
				if (!teleportCheck(player))
					return;
				if (player.teleTabSelected == 2) { // Skilling
					player.getPA().startTeleport(2873, 9847, 0, "modern", false);
				} else if (player.teleTabSelected == 3) { // Bosses
					player.getPA().startTeleport(2873, 9847, 0, "modern", false);
				} else if (player.teleTabSelected == 5) { // Cities
					player.getPA().startTeleport(2896, 3440, 0, "modern", false);
					
				}
				break;
			case 186009://19
				if (!teleportCheck(player))
					return;
				if (player.teleTabSelected == 2) { // Skilling
					//player.getPA().startTeleport(x, y, 0, "modern", false);// change
				} else if (player.teleTabSelected == 3) { // Bosses
					if (player.playerLevel[18] < 93) {
						player.sendMessage("You need a Slayer level of 93 to kill these.");
						return;
					}
					player.getPA().startTeleport(2376, 9452, 0, "modern", false);
					//player.getPA().startTeleport(3039, 4788, 0, "modern", false);
				} else if (player.teleTabSelected == 5) { // Cities
					player.getPA().startTeleport(3212, 3429, 0, "modern", false);
				
				}
				break;
			case 186010://20 - not used ever
				break;
				
		
		}
	}
}
