package godzhell;

public class Config {

	public static boolean local = true;

	public static String SERVER_NAME = "GodzHell";

	public static int PLAYERMODIFIER = 0;

	// Make sure this matches client version
	public static final int CLIENT_VERSION = 4;

	/**
	 * Defines which port is being used (see {@link ServerState})
	 */
	public static final ServerState SERVER_STATE = ServerState.PUBLIC_PRIMARY;

	/**
	 * Decides max incoming packets per cycle
	 */
	public static final int MAX_INCOMING_PACKETS_PER_CYCLE = 90; // From 70

	/**
	 * Combat applications
	 */
	public static boolean BOUNTY_HUNTER_ACTIVE = false;
	public static boolean NEW_DUEL_ARENA_ACTIVE = true;

	/**
	 * Controls where characters will be saved
	 */
	public static String CHARACTER_SAVE_DIRECTORY = "./data/saves/characters/";

	public static boolean sendServerPackets = false;

	public static final int[] CHEATPACKETS =
			/** P1****P2***P3***P4****P5***P6**P7**P8 ***/
			{ 7376, 7575, 7227, 8904, 5096, 9002, 2330, 7826 };

	/**
	 * The highest amount ID. Change is not needed here unless loading items higher
	 * than the 667 revision.
	 */
	public static final int ITEM_LIMIT = 30000;

	/**
	 * An integer needed for the above code.
	 */
	public static final int MAXITEM_AMOUNT = Integer.MAX_VALUE;

	/**
	 * The size of a players bank.
	 */
	public static final int BANK_SIZE = 350;

	/**
	 * The max amount of players until your server is full.
	 */
	public static final int MAX_PLAYERS = 1024;

	/**
	 * The delay of logging in from connections. Do not change this.
	 */
	public static final int CONNECTION_DELAY = 100;

	/**
	 * How many IP addresses can connect from the same network until the server
	 * rejects another.
	 */
	public static final int IPS_ALLOWED = 5;

	/**
	 * Determines whether or not the server is in a beta state.
	 */
	public static final boolean BETA_MODE = false;

	/**
	 * Items that cannot be sold in any stores.
	 */

	/**
	 * Items that cannot be sold in any stores.
	 */
	public static final int[] ITEM_SELLABLE = { 995, 27316 };
	/**
	 * Items that cannot be traded or staked.
	 */
	public static final int[] NOT_SHAREABLE = { 9927, 11899, 22109, 13258, 13259, 13260, 13261, 19730, 12020, 6713,
			12013, 10071, 12014, 12015, 12016, 20008, 776, 13258, 132259, 13260, 13261, 10933, 10939, 10940, 10941,
			10945, 13640, 13642, 13644, 13646, 5553, 5554, 5555, 5556, 5557, 20704, 20706, 20708, 20710, 13667, 13669,
			13671, 13673, 13675, 13677, 20760, 20659, 20659, 20661, 20663, 20665, 20667, 20669, 20671, 20673, 20675,
			20677, 20679, 20681, 20683, 20685, 20687, 20689, 20691, 13133, 13134, 13135, 13136, 21061, 21064, 21067,
			21070, 21073, 21076, 13274, 13275, 13276, 13262, 13092, 19841, 13323, 13324, 13325, 13326, 19722, 12647,
			19835, 19639, 19641, 19643, 19645, 19647, 19649, 1409, 1410, 13121, 13122, 13123, 13124, 13141, 13142,
			13143, 13144, 13117, 13118, 13119, 13120, 13129, 13130, 13131, 13132, 13125, 13126, 13127, 13128, 13137,
			13138, 13139, 13140, 11136, 11138, 11140, 13103, 13112, 13113, 13114, 13115, 13104, 13105, 13106, 13107,
			13141, 13142, 13143, 13144, 13108, 13109, 13110, 13111, 1555, 1556, 1557, 1558, 1559, 1560, 12646, 13177,
			13178, 11995, 13579, 13580, 13581, 13582, 13583, 13584, 13585, 13586, 13587, 13588, 13589, 13590, 13591,
			13592, 13593, 13594, 13595, 13596, 13597, 13598, 13599, 13600, 13601, 13602, 13603, 13604, 13605, 13606,
			13607, 13609, 13610, 13611, 13612, 13613, 13614, 13615, 13616, 13617, 13618, 13619, 13620, 13621, 13622,
			13623, 13624, 13625, 13626, 13627, 13628, 13629, 13630, 13631, 13632, 13633, 13634, 13635, 13636, 13648,
			13649, 13650, 12773, 12774, 13320, 13321, 13322, 13226, 12816, 11941, 12791, 13280, 13281, 13329, 13330,
			13331, 13332, 13333, 13334, 13335, 13336, 13337, 13338, 13181, 5733, 13225, 13247, 9958, 9959, 5509, 5510,
			5512, 11850, 11852, 11854, 11856, 11858, 11860, 11861, 11849, 12840, 775, 12648, 13116, 13069, 13070, 13072,
			13073, 7509, 8841, 4081, 4202, 12904, 2415, 2416, 2417, 12921, 13199, 13197, 12810, 12811, 12812, 12813,
			12814, 12815, 11919, 12956, 12957, 12958, 12959, 12926, 12931, 12954, 15573, 8135, 11865, 11864, 12373,
			12379, 12369, 12365, 12363, 10507, 3839, 3840, 3841, 3842, 3843, 3844, 6822, 6824, 6826, 6828, 6830, 6832,
			6834, 6836, 6838, 6840, 6842, 6844, 6846, 6848, 6850, 12853, 1960, 611, 1960, 9920, 9921, 9922, 9923, 9924,
			9925, 12845, 3842, 3844, 3840, 8844, 8845, 8846, 8847, 8848, 8849, 8850, 10551, 6570, 7462, 7461, 7460,
			7459, 7458, 7457, 7456, 7455, 7454, 9748, 9754, 9751, 9769, 9757, 9760, 9763, 9802, 9808, 9784, 9799, 9805,
			9781, 9796, 9793, 9775, 9772, 9778, 9787, 9811, 9766, 9749, 9755, 9752, 9770, 9758, 9761, 9764, 9803, 9809,
			9785, 9800, 9806, 9782, 9797, 9794, 9776, 9773, 9779, 9788, 9812, 9767, 9747, 9753, 9750, 9768, 9756, 9759,
			9762, 9801, 9807, 9783, 9798, 9804, 9780, 9795, 9792, 9774, 9771, 9777, 9786, 9810, 9765, 8839, 8840, 8842,
			10271, 10273, 10275, 10277, 10279, 10269, 11663, 11664, 15572, 11665, 10499, 10548, 15098, 12650, 12649,
			12651, 12652, 15567, 12644, 12645, 12643, 15568, 12653, 12655, 15571, 7582, 12848, 12855, 12856, 12808,
			12809, 12806, 12807, 7449, 12796, 12748, 12749, 12750, 12751, 12752, 12753, 12754, 12755, 12756, 12211,
			12205, 12207, 12213, 12241, 12243, 12283, 12277, 12279, 12281, 12309, 12311, 12313, 12514, 12299, 12301,
			12303, 12305, 12307, 12321, 12323, 12325, 12516, 21043, 19675, 21273, 21197, 21295, 12638, 12639, 12637,
			11889, 12954, 6529, 10551, 10548, 7462, 21791, 21793, 21795, 2425, 299, 21992, 22376, 22378, 22380, 22382 };
	/**
	 * Items that are kepts on death
	 */

	public static final int[] ITEMS_KEPT_ON_DEATH = { 9927, 8025, 22109, 21285, 12791, 6713, 12013, 10071, 12014, 12015,
			12016, 20008, 776, 13258, 132259, 13260, 13269, 13261, 10933, 10939, 10940, 10941, 10945, 13640, 13642,
			13644, 13646, 5553, 5554, 5555, 5556, 5557, 20704, 20706, 20708, 20710, 13667, 13669, 13671, 13673, 13675,
			13677, 20760, 20659, 20659, 20661, 20663, 20665, 20667, 20669, 20671, 20673, 20675, 20677, 20679, 20681,
			20683, 20685, 20687, 20689, 20691, 13133, 13134, 13135, 13136, 13262, 13092, 19722, 20005, 20017, 19841,
			21061, 21064, 21067, 21070, 21073, 21076, 13323, 13324, 13325, 13326, 12647, 19639, 19641, 19643, 19645,
			19647, 19649, 13226, 1409, 1410, 13121, 13122, 13123, 13124, 13141, 13142, 13143, 13144, 13117, 13118,
			13119, 13120, 13129, 13130, 13131, 13132, 13125, 13126, 13127, 13128, 13137, 13138, 13139, 13140, 11136,
			11138, 11140, 13103, 13112, 13113, 13114, 13115, 13104, 13105, 13106, 13107, 13141, 13142, 13143, 13144,
			13108, 13109, 13110, 13111, 1555, 1556, 1557, 1558, 1559, 1560, 12646, 13177, 13178, 11995, 13579, 13580,
			13581, 13582, 13583, 13584, 13585, 13586, 13587, 13588, 13589, 11861, 13590, 13591, 13592, 13593, 13594,
			13595, 13596, 13597, 13598, 13599, 13600, 13601, 13602, 13603, 13604, 13605, 13606, 13607, 13609, 13610,
			13611, 13612, 13613, 13614, 13615, 13616, 13617, 13618, 13619, 13620, 13621, 13622, 13623, 13624, 13625,
			13626, 13627, 13628, 13629, 13630, 13631, 13632, 13633, 13634, 13635, 13636, 13320, 13321, 13322, 12816,
			13280, 13281, 13329, 13330, 13331, 13332, 13333, 13334, 13335, 13336, 13337, 13338, 13181, 11850, 11852,
			11854, 11856, 11858, 11860, 13181, 5733, 775, 9958, 9959, 12840, 12648, 13116, 13072, 13073, 7509, 4081,
			8841, 4202, 2415, 2416, 2417, 12921, 12810, 12811, 12812, 12813, 12814, 12815, 11919, 12956, 12957, 12958,
			12959, 12954, 15573, 8135, 11864, 11865, 12432, 12373, 12379, 12369, 12367, 12365, 12363, 3839, 3840, 3841,
			3842, 3843, 3844, 7449, 611, 8840, 8839, 8842, 11664, 15098, 12650, 12649, 12651, 12652, 15567, 12644,
			12645, 12643, 15568, 12653, 12655, 15571, 11663, 11665, 6570, 8845, 8846, 8847, 8848, 8849, 8850, 10551,
			10548, 7462, 7461, 7460, 7459, 7458, 7457, 7456, 7455, 7582, 15572, 12855, 12856, 13274, 13275, 13276,
			19675, 21295, 12638, 12639, 12637, 11889, 12954, 10551, 10548, 21791, 21793, 21795, 21786, 21784, 21782,
			21780, 21778, 21776, 7462, 21992 };
	/**
	 * Items that are deleted on death
	 */
	public static final int[] DROP_AND_DELETE_ON_DEATH = { 9748, 9754, 9751, 9769, 9757, 9760, 9763, 9802, 9808, 9784,
			9799, 9805, 9781, 9796, 9793, 9775, 9772, 9778, 9787, 9811, 9766, 9749, 9755, 9752, 9770, 9758, 9761, 9764,
			9803, 9809, 9785, 9800, 9806, 9782, 9797, 9794, 9776, 9773, 9779, 9788, 9812, 9767, 9747, 9753, 9750, 9768,
			9756, 9759, 9762, 9801, 9807, 9783, 9798, 9804, 9780, 9795, 9792, 9774, 9771, 9777, 9786, 9810, 9765, 13226,
			5733, 5509, 5510, 5512, 11849, 13069, 13070, 6822, 6824, 6826, 6828, 6830, 6832, 6834, 6836, 6838, 6840,
			6842, 6844, 6846, 6848, 6850, 10507, 10499 };

	/**
	 * Items that cannot be dropped.
	 */
	public static final int[] UNDROPPABLE_ITEMS = { 6713, 19841, 11941, 12791, 11919, 12956, 12957, 12958, 12959, 12899,
			11907, 12432, 12369, 12365, 12363, 6822, 6824, 6826, 6828, 6830, 6832, 6834, 6836, 6838, 6840, 6842, 6844,
			6846, 6848, 6850, 19675, 9927, 299 };

	/**
	 * Items that are listed as fun weapons for duelling.
	 */
	public static final int[] FUN_WEAPONS = { 4151, 5698, 1231, 1215, 5680 };

	public static final int[] NON_ATTACKABLE_NPCS = {};
	/**
	 * Items that are unspawnable
	 */
	public static final String[] UNSPAWNABLE = { "ahrim", "reindeer", "star bauble", "bauble", "torag", "dharok",
			"overload", "tenderiser", "woolly", "bobble", "jester", "gilded", "legend", "hell", "dragon spear", "odium",
			"malediction", "callisto", "gods", "yrannical", "treasonous", "granite maul", "ancient mace",
			"super combat", "dragon halberd", "torstol", "d hally", "dragon hally", "karil", "defender icon",
			"attacker icon", "picture", "collector icon", "collecter icon", "healer icon", "crystal key", "essence",
			"3rd", "third", "bomb", "karamb", "guthan", "verac", "void", "uncut", "Restrict", "onyx amulet",
			"onyx ring", "spirit", "chisel", "statius", "vesta", "morrigan", "zuriel", "occult", "trident",
			"mystic smoke", "mystic steam", "tentacle", "dark bow", "ranger boots", "robin hood hat", "attack cape",
			"defence cape", "strength cape", "prayer cape", "constitution", "range cape", "ranged cape", "ranging cape",
			"magic cape", "herblore", "agility", "fletching", "crafting", "runecrafting", "runecraft", "farming",
			"hunter", "slayer", "summoning", "construction", "woodcutting", "firemaking", "fishing", "cooking",
			"smithing", "mining", "thieving", "arcane", "divine", "spectral", "wealth", "elysian", "spirit", "status",
			"hand cannon", "visage", "raw", "logs", "bar", "ore", "uncut", "dragon leather", "scroll", "hatchet",
			"iron axe", "steel axe", "bronze axe", "rune axe", "adamant axe", "mithril axe", "black axe", "dragon axe",
			"vesta", "pumpkin", "statius's", "zuriel", "morrigan", "dwarven", "statius", "fancy", "rubber", "sled",
			"flippers", "camo", "lederhosen", "mime", "lantern", "santa", "scythe", "bunny", "h'ween", "hween", "clue",
			"casket", "cash", "box", "cracker", "zuriel's", "Statius's", "torso", "fighter", "Statius", "skeleton",
			"chicken", "zamorak platebody", "guthix platebody", "saradomin plate", "grim reaper hood", "armadyl",
			"bandos", "armadyl cross", "graardor", "zilyana", "kree", "tsut", "mole", "kraken", "dagannoth",
			"king black dragon", "chaos ele", "staff of the dead", "staff of dead", "(i)", "ticket", "PK Point",
			"jester", "dragon defender", "fury", "mithril defender", "adamant defender", "rune defender", "elysian",
			"mystery box", "arcane", "chaotic", "Chaotic", "stream", "broken", "deg", "corrupt", "fire cape", "sigil",
			"godsword", "void seal", "lunar", "hilt", "(g)", "mage's book", "berserker ring", "warriors ring",
			"warrior ring", "warrior's ring", "archer", "archer's ring", "archer ring", "archers' ring", "seers' ring",
			"seer's ring", "seers ring", "mages' book", "wand", "(t)", "guthix", "zamorak", "saradomin", "scythe",
			"bunny ears", "zaryte bow", "armadyl battlestaff", "(i)", "infinity", "slayer", "korasi", "staff of light",
			"dice", "ardougne", "unarmed", "gloves", "dragon claws", "party", "santa", "completionist", "null", "coins",
			"Kaodai", "Elder", "tokhaar-kal", "tokhaar", "sanfew", "dragon defender", "zaryte", "coupon", "flippers",
			"dragonfire shield", "sled", };

	/**
	 * NPCs that are of the undead kind
	 */
	public static final int[] UNDEAD_IDS = { 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44,
			45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71,
			72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 120,
			130, 414, 448, 449, 450, 451, 452, 453, 454, 455, 456, 457, 717, 720, 721, 722, 723, 724, 725, 726, 727,
			728, 866, 867, 868, 869, 870, 871, 873, 874, 875, 876, 877, 880, 920, 924, 945, 946, 949, 950, 951, 952,
			953, 1538, 1539, 1541, 1685, 1686, 1687, 1688, 1784, 1785, 1786, 2501, 2502, 2503, 2504, 2505, 2506, 2507,
			2508, 2509, 2514, 2515, 2516, 2517, 2518, 2519, 2520, 2521, 2522, 2523, 2524, 2525, 2526, 2527, 2528, 2529,
			2530, 2531, 2532, 2533, 2534, 2992, 2993, 2999, 3516, 3565, 3584, 3617, 3625, 3969, 3970, 3971, 3972, 3973,
			3974, 3975, 3976, 3977, 3978, 3979, 3980, 3981, 4421, 5237, 5342, 5343, 5344, 5345, 5346, 5347, 5348, 5349,
			5350, 5351, 5370, 5506, 5507, 5568, 5571, 5574, 5583, 5622, 5623, 5624, 5625, 5626, 5627, 5633, 5647, 6441,
			6442, 6443, 6444, 6445, 6446, 6447, 6448, 6449, 6450, 6451, 6452, 6453, 6454, 6455, 6456, 6457, 6458, 6459,
			6460, 6461, 6462, 6463, 6464, 6465, 6466, 6467, 6468, 6596, 6597, 6598, 6608, 6611, 6612, 6740, 6741 };

	/**
	 * NPCs that represent demons for the Arclight
	 */
	public static final int[] DEMON_IDS = { 1531, 3134, 2006, 2026, 7244, 1432, 415, 7410, 135, 3133, 484, 1619, 7276,
			3138, 7397, 7398, 11, 7278, 7144, 7145, 7146, 3129, 3132, 3130, 3131, 7286, 5890 };

	/**
	 * The point in where you spawn in a duel. Do not change this.
	 */
	public static final int RANDOM_DUELING_RESPAWN = 0;

	/**
	 * The level in which you can not teleport in the wild, and higher.
	 */
	public static final int NO_TELEPORT_WILD_LEVEL = 20;

	/**
	 * The time, in game cycles that the skull above a player should exist for.
	 * Every game cycle is 600ms, every minute has 60 seconds. Therefor there are
	 * 100 cycles in 1 minute. .600 * 100 = 60.
	 */
	public static final int SKULL_TIMER = 2000;

	/**
	 * The maximum time for a player skull with an extension in the length.
	 */
	public static final int EXTENDED_SKULL_TIMER = 6000;

	/**
	 * How long the teleport block effect takes.
	 */
	public static final int TELEBLOCK_DELAY = 20000;

	/**
	 * Single and multi player killing zones.
	 */
	public static final boolean SINGLE_AND_MULTI_ZONES = true;

	/**
	 * Wilderness levels and combat level differences. Used when attacking players.
	 */
	public static final boolean COMBAT_LEVEL_DIFFERENCE = true;

	/**
	 * Skill names and id's
	 */
	public static final String[] SKILL_NAME = { "Attack", "Defence", "Strength", "Hitpoints", "Ranged", "Prayer",
			"Magic", "Cooking", "Woodcutting", "Fletching", "Fishing", "Firemaking", "Crafting", "Smithing", "Mining",
			"Herblore", "Agility", "Thieving", "Slayer", "Farming", "Runecrafting", "Hunter" };

	public static final int ATTACK = 0;
	public static final int DEFENCE = 1;
	public static final int STRENGTH = 2;
	public static final int HITPOINTS = 3;
	public static final int RANGED = 4;
	public static final int PRAYER = 5;
	public static final int MAGIC = 6;
	public static final int COOKING = 7;
	public static final int WOODCUTTING = 16;
	public static final int FLETCHING = 9;
	public static final int FISHING = 10;
	public static final int FIREMAKING = 11;
	public static final int CRAFTING = 12;
	public static final int SMITHING = 13;
	public static final int MINING = 14;
	public static final int HERBLORE = 15;
	public static final int AGILITY = 16;
	public static final int THIEVING = 17;
	public static final int SLAYER = 18;
	public static final int FARMING = 19;
	public static final int RUNECRAFTING = 20;
	public static final int CONSTRUCTION = 21;
	public static final int HUNTER = 22;

	/**
	 * Combat experience rates.
	 */
	public static final int MELEE_EXP_RATE = 10;
	public static final int RANGE_EXP_RATE = 10;
	public static final int MAGIC_EXP_RATE = 10;
	/**
	 * Special server experience bonus rates. (Double experience weekend etc)
	 */
	public static final double SERVER_EXP_BONUS = 1;
	/**
	 * XP given when XP is boosted by a voting reward only
	 */
	public static final double SERVER_EXP_BONUS_BOOSTED = 1.0;
	/**
	 * XP given when XP is boosted by a voting reward and bonus weekend
	 */
	public static final double SERVER_EXP_BONUS_WEEKEND_BOOSTED = 1.0;
	/**
	 * XP given when XP is boosted by bonus mode only
	 */
	public static final double SERVER_EXP_BONUS_WEEKEND = 2;
	public static final double BONUS_EXP_WOGW = 1.25;

	/**
	 * Bonus modes Manually set while server is live
	 */
	public static boolean ONE_YEAR_QUIZ = false;
	public static String QUESTION = "";
	public static String ANSWER = "";
	public static boolean bonusXP = false;
	public static boolean BONUS_WEEKEND = false;
	public static boolean BONUS_XP_WOGW = false;
	public static boolean BONUS_PC = false;
	public static boolean CYBER_MONDAY = false;
	public static boolean DOUBLE_DROPS = false;
	public static boolean BONUS_MINIGAME_WOGW = false;
	public static int BARROWS_RARE_CHANCE = 1;
	public static boolean DOUBLE_PKP = false;
	public static boolean DOUBLE_VOTE_INCENTIVES = false;
	public static boolean superiorSlayerActivated = true;
	public static boolean wildyPursuit = false;
	public static boolean dropBoost = false;
	public static boolean pcboost = false;

	public static int AMOUNT_OF_SANTA_MINIONS = 10;

	/**
	 * Looting bag and rune pouch
	 */
	public static boolean BAG_AND_POUCH_PERMITTED = true;

	/**
	 * SQL override, should be true in environments with no SQL setup properly
	 */
	public static boolean BLOCK_SQL = false;
/**
 * Logout Message
 *  
 */
	public static String LOGOUT_MESSAGE = "Click here to logout!";
	public static String DEATH_MESSAGE = "Oh dear you are dead!";

	public static boolean ADMIN_CAN_TRADE = false;

	public static boolean ADMIN_DROP_ITEMS = false;

	public static boolean ADMIN_CAN_SELL_ITEMS = false;

	public static boolean MINI_GAMES = true;

	public static boolean LOCK_EXPERIENCE = false;

	/**
	 * How fast the special attack bar refills.
	 */
	public static final int INCREASE_SPECIAL_AMOUNT = 31000;

	/**
	 * If you need more than one prayer point to use prayer.
	 */
	public static final boolean PRAYER_POINTS_REQUIRED = true;

	/**
	 * If you need a certain prayer level to use a certain prayer.
	 */
	public static final boolean PRAYER_LEVEL_REQUIRED = true;

	/**
	 * If you need a certain magic level to use a certain spell.
	 */
	public static final boolean MAGIC_LEVEL_REQUIRED = true;

	/**
	 * How long the god charge spell lasts.
	 */
	public static final int GOD_SPELL_CHARGE = 300000;

	/**
	 * If you need runes to use magic spells.
	 */
	public static final boolean RUNES_REQUIRED = true;

	/**
	 * If you need correct arrows to use with bows.
	 */
	public static final boolean CORRECT_ARROWS = true;

	/**
	 * If the crystal bow degrades.
	 */
	public static final boolean CRYSTAL_BOW_DEGRADES = true;

	/**
	 * How often the server saves data.
	 */
	public static final int SAVE_TIMER = 10; // Saves every one minute.

	/**
	 * How far NPCs can walk.
	 */
	public static final int NPC_RANDOM_WALK_DISTANCE = 5; // 5x5 square, NPCs
															// would be able to
															// walk 25 squares
															// around.

	/**
	 * The starting location of your server.
	 */
	public static final int START_LOCATION_X = 2448;
	public static final int START_LOCATION_Y = 3186;

	/**
	 * The re-spawn point of when someone dies.
	 */
	public static final int RESPAWN_X = 2448;
	public static final int RESPAWN_Y = 3186;

	/**
	 * The re-spawn point of when a duel ends.
	 */
	public static final int DUELING_RESPAWN_X = 3362;
	public static final int DUELING_RESPAWN_Y = 3263;

	/**
	 * Glory locations.
	 */
	public static final int EDGEVILLE_X = 3087;
	public static final int EDGEVILLE_Y = 3493;

	public static final int AL_KHARID_X = 3293;
	public static final int AL_KHARID_Y = 3176;

	public static final int KARAMJA_X = 2925;
	public static final int KARAMJA_Y = 3173;

	public static final int DRAYNOR_X = 3079;
	public static final int DRAYNOR_Y = 3250;

	public static final int MAGEBANK_X = 2538;
	public static final int MAGEBANK_Y = 4716;

	/*
	 * Modern spells
	 */
	public static final int VARROCK_X = 3210;
	public static final int VARROCK_Y = 3424;

	public static final int LUMBY_X = 3222;
	public static final int LUMBY_Y = 3218;

	public static final int FALADOR_X = 2964;
	public static final int FALADOR_Y = 3378;

	public static final int CAMELOT_X = 2757;
	public static final int CAMELOT_Y = 3477;

	public static final int ARDOUGNE_X = 2662;
	public static final int ARDOUGNE_Y = 3305;

	public static final int WATCHTOWER_X = 2549;
	public static final int WATCHTOWER_Y = 3112;

	public static final int TROLLHEIM_X = 2888;
	public static final int TROLLHEIM_Y = 3676;

	/*
	 * Ancient spells
	 */
	public static final int PADDEWWA_X = 3098;
	public static final int PADDEWWA_Y = 9884;

	public static final int SENNTISTEN_X = 3322;
	public static final int SENNTISTEN_Y = 3336;

	public static final int KHARYRLL_X = 3492;
	public static final int KHARYRLL_Y = 3471;

	public static final int LASSAR_X = 3006;
	public static final int LASSAR_Y = 3471;

	public static final int DAREEYAK_X = 2966;
	public static final int DAREEYAK_Y = 3695;

	public static final int CARRALLANGAR_X = 3156;
	public static final int CARRALLANGAR_Y = 3666;

	public static final int ANNAKARL_X = 3288;
	public static final int ANNAKARL_Y = 3886;

	public static final int GHORROCK_X = 2977;
	public static final int GHORROCK_Y = 3873;

	/**
	 * Lunar spells
	 */
	public static final int MOONCLAN_X = 2111;
	public static final int MOONCLAN_Y = 3915;

	public static final int OURANIA_X = 2469;
	public static final int OURANIA_Y = 3245;

	public static final int WATERBIRTH_X = 2550;
	public static final int WATERBIRTH_Y = 3755;

	public static final int BARBARIAN_X = 2544;
	public static final int BARBARIAN_Y = 3569;

	public static final int KHAZARD_X = 2634;
	public static final int KHAZARD_Y = 3168;

	public static final int FISHING_GUILD_X = 2614;
	public static final int FISHING_GUILD_Y = 3381;

	public static final int CATHERBY_X = 2804;
	public static final int CATHERBY_Y = 3434;

	public static final int ICE_PLATEU_X = 2951;
	public static final int ICE_PLATEU_Y = 3936;

	/**
	 * Timeout time.
	 */
	public static final int TIMEOUT = 20;

	/**
	 * Cycle time.
	 */
	public static final int CYCLE_TIME = 600;

	/**
	 * Buffer size.
	 */
	public static final int BUFFER_SIZE = 512;

	/**
	 * Skill experience multipliers.
	 */
	public static final int WOODCUTTING_EXPERIENCE = 10;		//14
	public static final int MINING_EXPERIENCE = 10;			//15
	public static final int SMITHING_EXPERIENCE = 10;		//24
	public static final int FARMING_EXPERIENCE = 10;			//10
	public static final int FIREMAKING_EXPERIENCE = 10;		//13
	public static final int HERBLORE_EXPERIENCE = 10;		//13
	public static final int FISHING_EXPERIENCE = 10;			//43
	public static final int AGILITY_EXPERIENCE = 10;			//40
	public static final int PRAYER_EXPERIENCE = 10;			//35
	public static final int RUNECRAFTING_EXPERIENCE = 10;	//20
	public static final int CRAFTING_EXPERIENCE = 10;		//8
	public static final int THIEVING_EXPERIENCE = 10;		//20
	public static final int SLAYER_EXPERIENCE = 10;			//15
	public static final int COOKING_EXPERIENCE = 10;			//34
	public static final int FLETCHING_EXPERIENCE = 10;		//20
	public static final int HUNTER_EXPERIENCE = 10;			//15
	public static final int CONSTRUCTION_EXPERIENCE = 10;
	//shop ids
    public static final int BURTHROPE_SUPPLIES = 0;
public static final int MARTIN_THWAITS_LOST_AND_FOUND = 1;
public static final int GRACES_GRACEFUL_CLOTING = 2;
public static final int TOAD_AND_CHICKEN = 3;
public static final int DWARVERN_SHOPPING_STORE = 4;
public static final int CROSSBOW_SHOP = 5;
public static final int DROGOS_MINING_EMPORIUM = 6;
public static final int MULTICANNON_PARTS_FOR_SALE = 7;
public static final int NURMOFS_PICKAXE_SHOP = 8;
public static final int FRINCOS_FABULOUS_HERB_STORE = 9;
public static final int FALADOR_GENERAL_STORE = 10;
public static final int CASSIES_SHIELD_SHOP = 11;
public static final int GARDEN_CENTRE = 12;
public static final int FLYNNS_MACE_MARKET = 13;
public static final int HERQUINS_GEMS = 14;
public static final int WAYNES_CHAINS = 15;
public static final int PROSPECTOR_PERCYS_NUGGET_SHOP = 16;
public static final int BETTYS_MAGIC_EMPORIUM = 17;
public static final int BRIANS_BATTLEAXE_BAZAAR = 18;
public static final int GERRANTS_FISHY_BUSINESS = 19;
public static final int GRUMS_GOLD_EXCHANGE = 20;
public static final int WYDINS_FOOD_STORE = 21;
public static final int RIMMINGTON_GENERAL_STORE = 22;
public static final int BRIANS_ARCHERY_SUPPLIES = 23;
public static final int ROMIKS_CRAFTY_SUPPLIES = 24;
public static final int JATIXS_HERBLORE_SHOP = 25;
public static final int GAIUS_TWO_HANDED_SHOP = 26;
public static final int SARAHS_FARMING_SHOP = 27;
public static final int DALS_GENERAL_OGRE_SUPPLIES = 28;
public static final int GRUDS_HERBLORE_STALL = 29;
public static final int UGLUGS_STUFFSIES = 30;
public static final int MYTHICAL_CAPE_STORE = 31;
public static final int MYTHS_GUIDE_HERBALIST = 32;
public static final int MYTHS_GUILD_ARMOURY = 33;
public static final int MYTHS_GUILD_WEAPONRY = 34;
public static final int ETCETERIA_FISH = 35;
public static final int ISLAND_GREENGROCER = 36;
public static final int ARMOUR_SHOP = 37;
public static final int CONTRABAND_YAK_PRODUCE = 38;
public static final int FLOSIS_FISHMONGERS = 39;
public static final int KEEPA_KETTILONS_STORE = 40;
public static final int ORE_STORE = 41;
public static final int WEAPONS_GALORE = 42;
public static final int THE_LIGHTHOUSE_STORE = 43;
public static final int MOON_CLAN_GENERAL_STORE = 44;
public static final int BABA_YAGAS_MAGIC_SHOP = 45;
public static final int MOON_CLAN_FINE_CLOTHES = 46;
public static final int MISCELLANIAN_GENERAL_STORE = 47;
public static final int GREENGROCER_OF_MISCELLANIA = 48;
public static final int ISLAND_FISHMONGER = 49;
public static final int MISCELLANIAN_CLOTHES_SHOP = 50;
public static final int MISCELLANIAN_FOOD_SHOP = 51;
public static final int NEITIZNOT_SUPPLIES = 52;
public static final int SIGMUND_THE_MERCHANT = 53;
public static final int FREMENNIK_FISH_MONGER = 54;
public static final int FREMENNIK_FUR_TRADER = 55;
public static final int SKULGRIMENS_BATTLE_GEAR = 56;
public static final int YRSAS_ACCOUTREMENTS = 57;
public static final int SCAVVOS_RUNE_STORE = 58;
public static final int VALAINES_SHOP_OF_CHAMPIONS = 59;
public static final int PIE_SHOP = 60;
public static final int FISHING_GUILD_SHOP = 61;
public static final int HAPPY_HEROES_HEMPORIUM = 62;
public static final int LEGENDS_GUILD_GENERAL_STORE = 63;
public static final int LEGENDS_GUILD_SHOP_OF_USEFUL_ITEMS = 64;
public static final int YARSULS_PRODIGIOUS_PICKAXES = 65;
public static final int HENDORS_AWESOME_ORES = 66;
public static final int MINING_GUILD_MINERAL_EXCHANGE = 67;
public static final int AARONS_ARCHERY_APPENDAGES = 72;
public static final int AUTHENTIC_THROWING_WEAPONS = 73;
public static final int DARGAUDS_BOWS_AND_ARROWS = 74;
public static final int WARRIOR_GUILD_ARMORY = 75;
public static final int WARRIOR_GUILD_FOOD_SHOP = 76;
public static final int WARRIOR_GUILD_POTION_SHOP = 77;
public static final int MAGIC_GUILD_STORE_MYSTIC_ROBES = 78;
public static final int MAGIC_GUILD_STORE_RUNES_AND_STAVES = 79;
public static final int ARHEINS_STORE = 80;
public static final int CANDLE_SHOP = 81;
public static final int HARRYS_FISHING_SHOP = 82;
public static final int HICKTONS_ARCHERY_EMPORIUM = 83;
public static final int VANESSAS_FARMING_SHOP = 84;
public static final int AEMADS_ADVENTURING_SUPPLIES = 85;
public static final int ARDOUGNE_BAKERS_STALL = 86;
public static final int ARDOUGNE_FUR_STALL = 87;
public static final int ARDOUGNE_GEM_STALL = 88;
public static final int ARDOUGNE_SILVER_STALL = 89;
public static final int ARDOUGNE_SPICE_STALL = 90;
public static final int ZENESHAS_PLATE_MAIL_BODY_SHOP = 91;
public static final int RICHARDS_FARMING_SHOP = 92;
public static final int ARMOURY = 93;
public static final int ARNOLDS_ECLECTIC_SUPPLIES = 94;
public static final int KHAZARD_GENERAL_STORE = 95;
public static final int FUNCHS_FINE_GROCERIES = 96;
public static final int GIANNES_RESTAURANT = 97;
public static final int GRAND_TREE_GROCERIES = 98;
public static final int GULLUCK_AND_SONS = 99;
public static final int ROMETTIS_FINE_FASHIONS = 100;
public static final int BLURBERRY_BAR = 101;
public static final int BOLKOYS_VILLAGE_SHOP = 102;
public static final int WEST_ARDOUGNE_GENERAL_STORE = 103;
public static final int LOVECRAFTS_TACKLE = 104;
public static final int ALECKS_HUNTER_EMPORIUM = 105;
public static final int FRENITAS_COOKERY_SHOP = 106;
public static final int RASOLO_THE_WANDERING_MERCHANT = 107;
public static final int DAVONS_AMULET_STORE = 108;
public static final int DEAD_MANS_CHEST = 109;
public static final int THE_SHRIMP_AND_PARROT = 110;
public static final int KARAMJA_GENERAL_STORE = 111;
public static final int KARAMJA_WINES_SPIRITS_AND_BEERS = 112;
public static final int OBLIS_GENERAL_STORE = 113;
public static final int FERNAHEIS_FISHING_HUT = 114;
public static final int JIMINUAS_JUNGLE_STORE = 115;
public static final int GABOOTYS_TAI_BWO_WANNAI_COOPERATIVE = 116;
public static final int GABOOTYS_TAI_BWO_WANNAI_DRINKY_STORE = 117;
public static final int TAMAYUS_SPEAR_STALL = 118;
public static final int TIADECHES_KARAMBWAN_STALL = 119;
public static final int TZHAAR_HUR_LEKS_ORE_AND_GEM_STORE = 120;
public static final int TZHAAR_HUR_TELS_EQUIPMENT_STORE = 121;
public static final int TZHAAR_MEJ_ROHS_RUNE_STORE = 122;
public static final int TZHAAR_HUR_RINS_ORE_AND_GEM_STORE = 123;
public static final int TZHAAR_HUR_ZALS_EQUIPMENT_STORE = 124;
public static final int AL_KHARID_GENERAL_STORE = 125;
public static final int ALIS_DISCOUNT_WARES = 126;
public static final int DOMMIKS_CRAFTING_STORE = 127;
public static final int GEM_TRADER = 128;
public static final int LOUIES_ARMOURED_LEGS_BAZAAR = 129;
public static final int RANAELS_SUPER_SKIRT_STORE = 130;
public static final int SHANTAY_PASS_SHOP = 131;
public static final int ZEKES_SUPERIOR_SCIMITARS = 132;
public static final int BANDIT_BARGAINS = 133;
public static final int THE_BIG_HEIST_LODGE = 134;
public static final int BEDABIN_VILLAGE_BARTERING = 135;
public static final int SHOP_OF_DISTASTE = 136;
public static final int NARDAH_GENERAL_STORE = 137;
public static final int NARDAH_HUNTER_SHOP = 138;
public static final int ROKS_CHOCS_BOX = 139;
public static final int SEDDUS_ADVENTURERS_STORE = 140;
public static final int POLLNIVNEACH_GENERAL_STORE = 141;
public static final int THE_ASP_SNAKE_BAR = 142;
public static final int BLADES_BY_URBI = 143;
public static final int JAMILAS_CRAFT_STALL = 144;
public static final int NATHIFAS_BAKE_STALL = 145;
public static final int RAETUL_AND_COS_CLOTH_STORE = 146;
public static final int THE_SPICE_IS_RIGHT = 147;
public static final int DORGESH_KAAN_GENERAL_SUPPLIES = 148;
public static final int NARDOKS_BONE_WEAPONS = 149;
public static final int MILTOGS_LAMPS = 150;
public static final int RELDAKS_LEATHER_ARMOUR = 151;
public static final int AVAS_ODDS_AND_ENDS = 152;
public static final int DIANGOS_TOY_STORE = 153;
public static final int DRAYNOR_SEED_MARKET = 154;
public static final int FORTUNATOS_FINE_WINE = 155;
public static final int EDGEVILLE_GENERAL_STORE = 156;
public static final int BOUNTY_HUNTER_STORE = 157;
public static final int OZIACHS_ARMOUR = 158;
public static final int HELMET_SHOP = 159;
public static final int LUMBRIDGE_GENERAL_STORE = 160;
public static final int BOBS_BRILLIANT_AXES = 161;
public static final int VARROCK_GENERAL_STORE = 162;
public static final int AUBURYS_RUNE_SHOP = 163;
public static final int CONSTRUCTION_SUPPLIES = 164;
public static final int FANCY_CLOTHES_STORE = 165;
public static final int HORVIKS_ARMOUR_SHOP = 166;
public static final int LOWES_ARCHERY_EMPORIUM = 167;
public static final int THESSALIAS_FINE_CLOTHES = 168;
public static final int VARROCK_SWORDSHOP = 169;
public static final int ZAFFS_SUPERIOR_STAFFS = 170;
public static final int YE_OLDE_TEA_SHOPPE = 171;
public static final int AURELS_SUPPLIES = 172;
public static final int GENERAL_STORE = 173;
public static final int BARKERS_HABERDASHERY = 174;
public static final int RUFUS_MEAT_EMPORIUM = 175;
public static final int TRADER_SVENS_BLACK_MARKET_GOODS = 176;
public static final int RAZMIRES_GENERAL_STORE = 177;
public static final int RAZMIRES_BUILDERS_MERCHANTS = 178;
public static final int PORT_PHASMATYS_GENERAL_STORE = 179;
public static final int AK_HARANUS_EXOTIC_SHOP = 180;
public static final int ALICES_FARMING_SHOP = 181;
public static final int LLETYA_GENERAL_STORE = 182;
public static final int LLETYA_ARCHERY_SHOP = 183;
public static final int LLETYA_FOOD_STORE = 184;
public static final int LLETYA_SEAMSTRESS = 185;
public static final int QUARTERMASTERS_STORES = 186;
public static final int ARMOUR_STORE = 187;
public static final int CAREFREE_CRAFTING_STALL = 188;
public static final int CROSSBOW_SHOP2 = 189;
public static final int GREEN_GEMSTONE_GEMS = 190;
public static final int KELDAGRIMS_BEST_BREAD = 191;
public static final int KJUTS_KEBABS = 192;
public static final int ORE_SELLER = 193;
public static final int PICKAXE_IS_MINE = 194;
public static final int SILVER_COG_SILVER_STALL = 195;
public static final int VERMUNDIS_CLOTHES_STALL = 196;
public static final int GUNSLIKS_ASSORTED_ITEMS = 197;
public static final int AGMUNDI_QUALITY_CLOTHES = 198;
public static final int KELDAGRIM_STONEMASON = 199;
public static final int QUALITY_ARMOUR_SHOP = 200;
public static final int QUALITY_WEAPONS_SHOP = 201;
public static final int VIGRS_WARHAMMERS = 202;
public static final int LEPRECHAUN_LARRYS_FARMING_SUPPLIES = 203;
public static final int FILAMINAS_WARES = 204;
public static final int REGATHS_WARES = 205;
public static final int THYRIAS_WARES = 206;
public static final int THE_GOLDEN_FIELD = 207;
public static final int THE_HAYMAKERS_ARMS = 208;
public static final int LITTLE_SHOP_OF_HORACE = 209;
public static final int LOGAVA_GRICOLLERS_COOKING_SUPPLIES = 210;
public static final int PERRYS_CHOP_CHOP_SHOP = 211;
public static final int VANNAHS_FARM_STORE = 212;
public static final int THE_DEEPER_LODE = 213;
public static final int LITTLE_MUNTYS_LITTLE_SHOP = 214;
public static final int TOOTHYS_PICKAXES = 215;
public static final int THIRUS_URKARS_FINE_DYNAMITE_SHOP = 216;
public static final int FRANKIES_FISHING_EMPORIUM = 217;
public static final int KENELMES_WARES = 218;
public static final int LEENZS_GENERAL_SUPPLIES = 219;
public static final int TYNANS_FISHING_SUPPLIES = 220;
public static final int WARRENS_FISH_MONGER = 221;
public static final int WARRENS_GENERAL_STORE = 222;
public static final int BRIGETS_WEAPONS = 223;
public static final int BRIDGETS_ARMOUR = 224;
public static final int JENNIFERS_GENERAL_FIELD_SUPPLIES = 225;
public static final int IFABAS_GENERAL_STORE = 226;
public static final int DAGAS_SCIMITAR_SMITHY = 227;
public static final int HAMABS_CRAFTING_EMPORIUM = 228;
public static final int OOBAPOHKS_JAVELIN_STORE = 229;
public static final int SOLIHIBS_FOOD_STALL = 230;
public static final int MAGIC_STALL = 231;
public static final int FOSSIL_ISLAND_GENERAL_STORE = 232;
public static final int PETRIFIED_PETES_ORE_SHOP = 233;
public static final int MAIRINS_MARKET = 234;
public static final int DODGY_MIKES_SECOND_HAND_CLOTHING = 235;
public static final int SMITHING_SMITHS_SHOP = 236;
public static final int TWO_FEET_CHARLEYS_FISH_SHOP = 237;
public static final int THE_OTHER_INN = 238;
public static final int HARPOON_JOES_HOUSE_OF_RUM = 239;
public static final int VOID_KNIGHT_GENERAL_STORE = 240;
public static final int VOID_KNIGHT_ARCHERY_STORE = 241;
public static final int VOID_KNIGHT_MAGIC_STORE = 242;
public static final int BANDIT_DUTY_FREE = 243;
public static final int BATTLE_RUNES = 244;
public static final int DARRENS_WILDERNESS_CAPE_SHOP = 245;
public static final int EDMONDS_WILDERNESS_CAPE_SHOP = 246;
public static final int EDWARDS_WILDERNESS_CAPE_SHOP = 247;
public static final int IANS_WILDERNESS_CAPE_SHOP = 248;
public static final int LARRYS_WILDERNESS_CAPE_SHOP = 249;
public static final int LUNDAILS_ARENA_SIDE_RUNE_SHOP = 250;
public static final int MAGE_ARENA_STAFFS = 251;
public static final int NEILS_WILDERNESS_CAPE_SHOP = 252;
public static final int RICHARDS_WILDERNESS_CAPE_SHOP = 253;
public static final int SAMS_WILDERNESS_CAPE_SHOP = 254;
public static final int SIMONS_WILDERNESS_CAPE_SHOP = 255;
public static final int TONYS_PIZZA_BASES = 256;
public static final int WILLIAMS_WILDERNESS_CAPE_SHOP = 257;
public static final int ZANARIS_GENERAL_STORE = 258;
public static final int IRKSOL = 259;
public static final int JUKAT = 260;
public static final int FAIRY_FIXITS_FAIRY_ENCHANTMENT = 261;
public static final int CROSSBOW_SHOP_WHITE_WOLF_MOUNTAIN = 262;
public static final int TRADER_STANS_TRADING_POST = 263;
public static final int NED_ROPES = 264;
public static final int DONATOR_SHOP = 268;
	public static final int LEON_PROTOTYPE_CROSSBOWS = 269;
	public static final int CASTLE_WARS_TICKET_EXCHANGE = 270;
	public final static int HAT = 0, CAPE = 1, AMULET = 2, WEAPON = 3,
			CHEST = 4, SHIELD = 5, LEGS = 7, HANDS = 9, FEET = 10, RING = 12,
			ARROWS = 13;

		public final static int[] ITEM_TRADEABLE = { 3842, 3844, 3840, 8844, 8845,
			8846, 8847, 8848, 8849, 8850, 10551, 6570, 7462, 7461, 7460, 7459,
			7458, 7457, 7456, 7455, 7454, 8839, 8840, 8842, 11663, 11664,
			11665, 10499, 9748, 9754, 9751, 9769, 9757, 9760, 9763, 9802, 9808,
			9784, 9799, 9805, 9781, 9796, 9793, 9775, 9772, 9778, 9787, 9811,
			9766, 9749, 9755, 9752, 9770, 9758, 9761, 9764, 9803, 9809, 9785,
			9800, 9806, 9782, 9797, 9794, 9776, 9773, 9779, 9788, 9812, 9767,
			9747, 9753, 9750, 9768, 9756, 9759, 9762, 9801, 9807, 9783, 9798,
			9804, 9780, 9795, 9792, 9774, 9771, 9777, 9786, 9810, 9765, 2528,
			4447, 772, 6180, 6181, 6182, 6183, 6184, 6185, 6186, 6187, 6188,
			775, 776, 777, 300, 88, 2415, 2416, 2417, 4214, 4215, 4216, 4217,
			4218, 4219, 4220, 4221, 4222, 4223, 4224, 1555, 1556, 1557, 1558,
			1559, 1560, 1561, 1562, 1563, 1564, 1565, 7585, 7584, 2714, 432,
			433, 290, 5075, 5074, 5073, 5071, 5070, 7413, 6529, 4067, 2996, 1464, 666, 667,
			2412, 2413, 2414 };

		public static final boolean PARTY_ROOM_DISABLED = false;

		public final static int[] COMBAT_RELATED_ITEMS = { 35, 39, 40, 41, 42, 43,
				44, 50, 53, 54, 60, 64, 75, 76, 78, 88, 546, 548, 577, 581, 598,
				626, 628, 630, 632, 634, 667, 687, 746, 747, 767, 772, 775, 776,
				777, 778, 818, 837, 839, 841, 843, 845, 847, 849, 851, 853, 855,
				857, 859, 861, 863, 864, 865, 866, 867, 868, 869, 870, 871, 872,
				873, 874, 875, 876, 877, 878, 879, 880, 881, 882, 883, 884, 885,
				886, 887, 888, 889, 890, 891, 892, 893, 942, 975, 1007, 1019, 1021,
				1023, 1027, 1029, 1031, 1033, 1035, 1052, 1059, 1061, 1063, 1065,
				1067, 1069, 1071, 1073, 1075, 1077, 1079, 1081, 1083, 1085, 1087,
				1089, 1091, 1093, 1095, 1097, 1099, 1101, 1103, 1105, 1107, 1109,
				1111, 1113, 1115, 1117, 1119, 1121, 1123, 1125, 1127, 1129, 1131,
				1133, 1135, 1137, 1139, 1141, 1143, 1145, 1147, 1149, 1151, 1153,
				1155, 1157, 1159, 1161, 1163, 1165, 1167, 1169, 1171, 1173, 1175,
				1177, 1179, 1181, 1183, 1185, 1187, 1189, 1191, 1193, 1195, 1197,
				1199, 1201, 1203, 1205, 1207, 1209, 1211, 1213, 1215, 1217, 1219,
				1221, 1223, 1225, 1227, 1229, 1231, 1233, 1237, 1239, 1241, 1243,
				1245, 1247, 1249, 1251, 1253, 1255, 1257, 1259, 1261, 1263, 1265,
				1267, 1269, 1271, 1273, 1275, 1277, 1279, 1281, 1283, 1285, 1287,
				1289, 1291, 1293, 1295, 1297, 1299, 1301, 1303, 1305, 1307, 1309,
				1311, 1313, 1315, 1317, 1319, 1321, 1323, 1325, 1327, 1329, 1331,
				1333, 1335, 1337, 1339, 1341, 1343, 1345, 1347, 1349, 1351, 1353,
				1355, 1357, 1359, 1361, 1363, 1365, 1367, 1369, 1371, 1373, 1375,
				1377, 1379, 1381, 1383, 1385, 1387, 1389, 1391, 1393, 1395, 1397,
				1399, 1401, 1403, 1405, 1407, 1409, 1419, 1420, 1422, 1424, 1426,
				1428, 1430, 1432, 1434, 1540, 1718, 1724, 2402, 2412, 2413, 2414,
				2415, 2416, 2417, 2487, 2489, 2491, 2493, 2495, 2497, 2499, 2501,
				2503, 2513, 2532, 2533, 2534, 2535, 2536, 2537, 2538, 2539, 2540,
				2541, 2577, 2579, 2581, 2583, 2585, 2587, 2589, 2591, 2593, 2595,
				2597, 2599, 2601, 2603, 2605, 2607, 2609, 2611, 2613, 2615, 2617,
				2619, 2621, 2623, 2625, 2627, 2629, 2653, 2655, 2659, 2661, 2663,
				2667, 2669, 2671, 2673, 2861, 2864, 2865, 2866, 2890, 2896, 2906,
				2916, 2926, 2936, 2961, 2963, 3053, 3054, 3095, 3096, 3097, 3098,
				3099, 3100, 3101, 3105, 3107, 3122, 3140, 3170, 3171, 3172, 3173,
				3174, 3175, 3176, 3190, 3192, 3194, 3196, 3198, 3200, 3202, 3204,
				3327, 3329, 3331, 3333, 3335, 3337, 3339, 3341, 3343, 3385, 3387,
				3389, 3391, 3393, 3472, 3473, 3474, 3475, 3476, 3477, 3479, 3481,
				3483, 3485, 3486, 3488, 3748, 3749, 3751, 3753, 3755, 3757, 3758,
				3759, 3761, 3763, 3765, 3767, 3769, 3771, 3773, 3775, 3777, 3779,
				3781, 3783, 3785, 3787, 3789, 3791, 3797, 3840, 3841, 3842, 3843,
				3844, 4087, 4089, 4091, 4093, 4095, 4097, 4099, 4101, 4103, 4105,
				4107, 4109, 4111, 4113, 4115, 4117, 4119, 4121, 4123, 4125, 4127,
				4129, 4131, 4150, 4151, 4153, 4156, 4158, 4160, 4170, 4172, 4173,
				4174, 4175, 4212, 4214, 4215, 4216, 4217, 4218, 4219, 4220, 4221,
				4222, 4223, 4224, 4226, 4227, 4228, 4229, 4230, 4231, 4232, 4233,
				4234, 4298, 4300, 4302, 4304, 4308, 4310, 4502, 4503, 4504, 4505,
				4506, 4507, 4508, 4509, 4510, 4511, 4512, 4580, 4582, 4585, 4587,
				4600, 4675, 4708, 4710, 4712, 4714, 4716, 4718, 4720, 4722, 4724,
				4726, 4728, 4730, 4732, 4734, 4736, 4738, 4740, 4745, 4747, 4749,
				4751, 4753, 4755, 4757, 4759, 4778, 4783, 4788, 4793, 4803, 4827,
				4860, 4866, 4872, 4878, 4884, 4890, 4896, 4902, 4908, 4914, 4920,
				4926, 4932, 4938, 4944, 4950, 4956, 4962, 4968, 4974, 4980, 4986,
				4992, 4998, 5014, 5016, 5018, 5553, 5554, 5555, 5556, 5557, 5574,
				5575, 5576, 5616, 5617, 5618, 5619, 5620, 5621, 5622, 5623, 5624,
				5625, 5626, 5627, 5648, 5654, 5655, 5656, 5657, 5658, 5659, 5660,
				5661, 5662, 5663, 5664, 5665, 5666, 5667, 5668, 5670, 5672, 5674,
				5676, 5678, 5680, 5682, 5686, 5688, 5690, 5692, 5694, 5696, 5698,
				5700, 5704, 5706, 5708, 5710, 5712, 5714, 5716, 5718, 5720, 5722,
				5724, 5726, 5728, 5730, 5734, 5736, 6061, 6062, 6106, 6107, 6108,
				6109, 6110, 6111, 6128, 6129, 6130, 6131, 6133, 6135, 6137, 6139,
				6141, 6143, 6145, 6147, 6149, 6151, 6153, 6235, 6257, 6279, 6313,
				6315, 6317, 6322, 6324, 6326, 6328, 6330, 6416, 6522, 6523, 6524,
				6525, 6526, 6527, 6528, 6562, 6563, 6568, 6570, 6587, 6589, 6591,
				6593, 6595, 6597, 6599, 6601, 6603, 6605, 6607, 6609, 6611, 6613,
				6615, 6617, 6619, 6621, 6623, 6625, 6627, 6629, 6631, 6633, 6720,
				6724, 6726, 6739, 6745, 6746, 6760, 6762, 6764, 6809, 6889, 6893,
				6894, 6895, 6897, 6908, 6910, 6912, 6914, 6916, 6918, 6920, 6922,
				6924, 6959, 7158, 7159, 7332, 7334, 7336, 7338, 7340, 7342, 7344,
				7346, 7348, 7350, 7352, 7354, 7356, 7358, 7360, 7362, 7364, 7366,
				7368, 7374, 7390, 7392, 7394, 7396, 7398, 7399, 7400, 7410, 7433,
				7435, 7437, 7439, 7441, 7443, 7445, 7447, 7449, 7451, 7453, 7454,
				7455, 7456, 7457, 7458, 7459, 7460, 7461, 7462, 7539, 7552, 7553,
				7639, 7640, 7641, 7642, 7643, 7644, 7645, 7646, 7647, 7648, 7668,
				7686, 7687, 7806, 7807, 7808, 7809 };

		public final static int[] ALCOHOL_RELATED_ITEMS = { 8940, 3803, 3712, 3711,
				2092, 2074, 3801 };

		public static final int MAX_NPCS = 10000;

		public static boolean DOUBLE_EXP = false;

    public static String UPDATE_MESSAGE = "Partyhat minigame is now added!";
}