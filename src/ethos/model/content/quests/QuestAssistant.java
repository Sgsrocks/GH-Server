package ethos.model.content.quests;

import ethos.model.content.quests.impl.*;
import ethos.model.players.Player;

/**
 * Quest Assistant
 * @author Andrew (Mr Extremez)
 */

public class QuestAssistant {

	public static final int MAXIMUM_QUESTPOINTS = 23;

	public static void sendStages(Player player) {
		player.getPA().sendFrame126("Quest Points: " + player.QuestPoints + " ", 640);
		for (Quests quests : Quests.values()) {
			if (!quests.questStatus() && quests.getStringId() > 0) {
				player.getPA().sendFrame126("", quests.getStringId());
			}
		}
		if (player.pirateTreasure == 0) {
			player.getPA().sendFrame126("Pirate's Treasure", 7341);
		} else if (player.pirateTreasure == 6) {
			player.getPA().sendFrame126("@gre@Pirate's Treasure", 7341);
		} else {
			player.getPA().sendFrame126("@yel@Pirate's Treasure", 7341);
		}
		if (player.witchspot == 0) {
			player.getPA().sendFrame126("Witch's Potion", 7348);
		} else if (player.witchspot == 3) {
			player.getPA().sendFrame126("@gre@Witch's Potion", 7348);
		} else {
			player.getPA().sendFrame126("@yel@Witch's Potion", 7348);
		}
		if (player.romeojuliet == 0) {
			player.getPA().sendFrame126("Romeo and Juliet", 7343);
		} else if (player.romeojuliet < 9) {
			player.getPA().sendFrame126("@yel@Romeo and Juliet",
					7343);
		} else if (player.romeojuliet >= 9) {
			player.getPA().sendFrame126("@gre@Romeo and Juliet",
					7343);
		}
		if (player.vampSlayer == 0) {
			player.getPA().sendFrame126("Vampyre Slayer", 7347);
		} else if (player.vampSlayer == 5) {
			player.getPA().sendFrame126("@gre@Vampyre Slayer", 7347);
		} else {
			player.getPA().sendFrame126("@yel@Vampyre Slayer", 7347);
		}
		if (player.doricQuest == 0) {
			player.getPA().sendFrame126("Doric's Quest", 7336);
		} else if (player.doricQuest == 3) {
			player.getPA().sendFrame126("@gre@Doric's Quest", 7336);
		} else {
			player.getPA().sendFrame126("@yel@Doric's Quest", 7336);
		}
		if (player.restGhost == 0) {
			player.getPA().sendFrame126("Restless Ghost", 7337);
		} else if (player.restGhost == 5) {
			player.getPA().sendFrame126("@gre@Restless Ghost", 7337);
		} else {
			player.getPA().sendFrame126("@yel@Restless Ghost", 7337);
		}
		if (player.impsC == 0) {
			player.getPA().sendFrame126("Imp Catcher", 7340);
		} else if (player.impsC == 1) {
			player.getPA().sendFrame126("@yel@Imp Catcher", 7340);
		} else if (player.impsC == 2) {
			player.getPA().sendFrame126("@gre@Imp Catcher", 7340);
		}
		if (player.gertCat == 0) {
			player.getPA().sendFrame126("Gertrudes Cat", 7360);
		} else if (player.gertCat == 7) {
			player.getPA().sendFrame126("@gre@Gertrudes Cat", 7360);
		} else {
			player.getPA().sendFrame126("@yel@Gertrudes Cat", 7360);
		}
		if (player.sheepShear == 0) {
			player.getPA().sendFrame126("Sheep Shearer", 7344);
		} else if (player.sheepShear == 2) {
			player.getPA().sendFrame126("@gre@Sheep Shearer", 7344);
		} else {
			player.getPA().sendFrame126("@yel@Sheep Shearer", 7344);
		}
		if (player.runeMist == 0) {
			player.getPA().sendFrame126("Rune Mysteries", 7335);
		} else if (player.runeMist == 4) {
			player.getPA().sendFrame126("@gre@Rune Mysteries", 7335);
		} else {
			player.getPA().sendFrame126("@yel@Rune Mysteries", 7335);
		}
		if (player.knightS == 0) {
			player.getPA().sendFrame126("The Knight's Sword", 7346);
		} else if (player.knightS < 9) {
			player.getPA().sendFrame126("@yel@The Knight's Sword", 7346);
		} else if (player.knightS == 9) {
			player.getPA().sendFrame126("@gre@The Knight's Sword", 7346);
		}
		if (player.cookAss == 0) {
			player.getPA().sendFrame126("Cook's Assistant", 7333);
		} else if (player.cookAss == 3) {
			player.getPA().sendFrame126("@gre@Cook's Assistant", 7333);
		} else if (player.cookAss > 0 && player.cookAss < 3) {
			player.getPA().sendFrame126("@yel@Cook's Assistant", 7333);
		}
		if (player.blackKnight == 0) {
			player.getPA().sendFrame126("Black Knights' Fortress", 7332);
		} else if (player.blackKnight == 3) {
			player.getPA().sendFrame126("@gre@Black Knights' Fortress", 7332);
		} else {
			player.getPA().sendFrame126("@yel@Black Knights' Fortress", 7332);
		}
		if (player.shieldArrav == 0) {
			player.getPA().sendFrame126("Shield of Arrav", 7345);
		} else if (player.shieldArrav == 8) {
			player.getPA().sendFrame126("@gre@Shield of Arrav", 7345);
		} else {
			player.getPA().sendFrame126("@yel@Shield of Arrav", 7345);
		}
		if (player.dragonSlayer == 0) {
			player.getPA().sendFrame126("Dragon Slayer", 7383);
		} else if (player.dragonSlayer == 6) {
			player.getPA().sendFrame126("@gre@Dragon Slayer", 7383);
		} else {
			player.getPA().sendFrame126("@yel@Dragon Slayer", 7383);
		}
	}

	public enum Quests {
		BLACK_KNIGHT(28164, 7332, "Black Knights' Fortress", true), 
		COOKS_ASSISTANT(28165, 7333, "Cook's Assistant", true), 
		DEMON_SLAYER(28166, 7334, "Demon Slayer", true), 
		DORICS_QUEST(28168, 7336, "Doric's Quest", true), 
		DRAGON_SLAYER(28215, 7383, "Dragon Slayer", true),
		ERNEST(28171, 7339, "Ernest the Chicken", true), 
		GOBLIN(28170, 7338, "Goblin Diplomacy", true), 
		IMP_CATCHER(28172, 7340, "Imp Catcher", true), 
		KNIGHTS_SWORD(28178, 7346, "The Knight's Sword", true), 
		PIRATES_TREASURE(28173, 7341, "Pirates Treasure", true), 
		PRINCE_RESCUE(28174, 7342, "Prince Ali Rescue", true), 
		RESTLESS_GHOST(28169, 7337, "Restless Ghost", true), 
		ROMEO_JULIET(28175, 7343, "Romeo Juliet", true), 
		RUNE_MYSTERIES(28167, 7335, "Rune Mysteries", true), 
		SHEEP_SHEARER(28176, 7344, "Sheep Shearer", true), 
		SHIELD_OF_ARRAV(28177, 7345, "Shield of Arrav", true),
		VAMPYRE_SLAYER(28179, 7347, "Vampyre Slayer", true), 
		WITCHS_POTION(28180, 7348, "Witchs Potion", true), 
		BETWEEN_A_ROCK(49228, 12772, "Between A Rock", true), 
		CHOMPY(2161, 673, "Big Chompy Bird Hunting", true), 
		BIOHAZARD(28124, 7352, "Biohazard", true), 
		CABIN(68102, 17510, "Cabin Fever", true), 
		CLOCK(28185, 7353, "Clock Tower", true), 
		DEATH(32246, 8438, "Death Plateau", true), 
		CREATURE(47097, 12129, "Creature of Fenkenstrain", true), 
		DESERT_TREASURE(50052, 12852, "Desert Treasure", true), 
		DRUDIC_RITUAL(28187, 7355, "Drudic Ritual", true), 
		DWARF_CANNON(28188, 7356, "Dwarf Cannon", true), 
		EADGARS_RUSE(33231, 8679, "Eadgars Ruse", true), 
		DEVIOUS(61225, 15841, "Devious Minds", true), 
		DIGSITE(28186, 7354, "Digsite Quest", true), 
		ELEMENTAL(29035, 7459, "Elemental Workshop", true), 
		ENAKHRA(63021, 16149, "Enakhra's Lamet", true), 
		FAIRY1(27075, 6987, "A Fairy Tale Pt. 1", true), 
		FAMILYCREST(28189, 7357, "Family Crest", true), 
		FEUD(50036, 12836, "The Feud", true), 
		FIGHT_ARENA(28190, 7358, "Fight Arena", true), 
		FISHING_CONTEST(28191, 7359, "Fishing Contest", false),
		FORGETTABLE_TABLE(50089, 14169, "Forgettable Tale...", true), 
		FREMMY_TRIALS(39131, 10115, "The Fremennik Trials", true), 
		GARDEN(57012, 14604, "Garden of Tranquillity", true), 
		GERTRUDES_CAT(28192, 7360, "Gertrude's Cat", true),
		GHOSTS(47250, 12282, "Ghosts Ahoy", true), 
		GIANT_DWARF(53009, 13577, "The Giant Dwarf", true), 
		GOLEM(50039, 12839, "The Golem", true), 
		GRAND_TREE(28193, 7361, "The Grand Tree", true), 
		HAND_IN_THE_SAND(63000, 16128, "The Hand in the Sand", true), 
		HAUNTED_MINE(46081, 11857, "Haunted Mine", true), 
		HAZEEL(28194, 7362, "Hazeel Cult", true), 
		HEROES(28195, 7363, "Heroes Quest", true), 
		HOLY(28196, 7364, "Holy Grail", true), 
		HORROR(39151, 10135, "Horror from the Deep", true), 
		ITCHLARIN(17156, 4508, "Itchlarin's Little Helper", true), 
		AID_OF_MYREQUE(72085, 18517, "In Aid of the Myreque", true), 
		SEARCH_OF_MYREQUE(46131, 11907, "In Search of the Myreque", true), 
		JUNGLE_POTION(28197, 7365, "Jungle Potion", true), 
		LEGENDS_QUEST(28198, 7366, "Legends Quest", true), 
		LOST_CITY(28199, 7367, "Lost City", true), 
		LOST_TRIBE(52077, 13389, "The Lost Tribe", true), 
		MAKING_HISTORY(60127, 15487, "Making History", true), 
		MONKEY_MADNESS(43124, 11132, "Monkey Madness", true), 
		MERLINS_CRYSTAL(28200, 7368, "Merlins Crystal", true), 
		MONKS_FRIEND(28201, 7369, "Monks Friend", true), 
		MOUNTAIN_DAUGHTER(48101, 12389, "Mountain Daughter", true), 
		MOURNINGS_END_1(54150, 13974, "Mourning's Ends Part 1", true), 
		MOURNINGS_END_2(23139, 6027, "Mourning's Ends Part 2", true), 
		MURDER_MYSTERY(28202, 7370, "Murder Mystery", true), 
		NATURE_SPIRIT(31201, 8137, "Nature Spirit", true), 
		OBSERVATORY(28203, 7371, "Observatory Quest", true), 
		ONE_SMALL_FAVOUR(48057, 12345, "One Small Favour", true), 
		PLAGUE_CITY(28204, 7372, "Plague City", true), 
		PRIEST_IN_PERIL(31179, 8115, "Priest in Peril", true), 
		RAG_AND_BONE_MAN(72252, 18684, "Rag and Bone Man", true), 
		RAT_CATCHERS(60139, 15499, "Rat Catchers", true), 
		RECIPE(71130, 18306, "Recipe for Disaster", true), 
		RECRUITMENT_DRIVE(2156, 668, "Recruitment Drive", true), 
		REGICIDE(33128, 8576, "Regicide", false),
		ROVING_ELVES(47017, 12139, "Roving Elves", true), 
		RUM_DEAL(58064, 14912, "Rum Deal", true), 
		SCORPION_CATCHER(28205, 7373, "Scorpion Catcher", true), 
		SEA_SLUG(28206, 7374, "Sea Slug Quest", true), 
		SHADES_OF_MORTON(35009, 8969, "Shades of Mort'ton", true), 
		SHADOW_OF_THE_STORM(59248, 15352, "Shadow of the Storm", true), 
		SHEEP_HERDER(28207, 7375, "Sheep Herder", true), 
		SHILO_VILLAGE(28208, 7376, "Shilo Village", true), 
		SOULS_BANE(28250, 15098, "A Soul's Bane", false),
		SPIRITS_OF_THE_ELID(60232, 15592, "Spirits of The Elid", true), 
		SWAN_SONG(249, 249, "Swan Song", true), 
		TAI_BWO(6204, 1740, "Tai Bwo Wannai Trio", true), 
		TWO_CATS(59131, 15235, "A Tail of Two Cats", true), 
		TEARS_OF_GUTHIX(12206, 3278, "Tears of Guthix", true), 
		TEMPLE_OF_IKOV(28210, 7378, "Temple of Ikov", true), 
		THRONE_OF_MISCELLANIA(25118, 6518, "Throne of Miscellania", true), 
		TOURIST_TRAP(28211, 7379, "The Tourist Trap", true), 
		TREE_GNOME_VILLAGE(28212, 7380, "Tree Gnome Village", true), 
		TRIBAL_TOTEM(28213, 7381, "Tribal Totem", true), 
		TROLL_ROMANCE(46082, 11858, "Troll Romance", true), 
		TROLL_STRONGHOLD(191, 191, "Troll Stronghold", true), 
		UNDERGROUND_PASS(38199, 9927, "Underground Pass", true), 
		WANTED(23136, 6024, "Wanted", true), 
		WATCHTOWER(28181, 7349, "Watch Tower", true), 
		WATERFALL(28182, 7350, "Waterfall Quest", true),
		WITCH(28183, 7351, "Witch's House", true), 
		ZOGRE(52044, 13356, "Zogre Flesh Eaters", true);

		private final int button, string;
		private final String name;
		private final boolean questStatus;

		private Quests(final int button, final int string, final String name, final boolean questStatus) {
			this.button = button;
			this.name = name;
			this.string = string;
			this.questStatus = questStatus;
		}
		
		public int getStringId() {
			return string;
		}
		
		public boolean questStatus() {
			return questStatus;
		}

		public int getButton() {
			return button;
		}

		public String getName() {
			return name;
		}

		public static Quests forButton(int button) {
			for (Quests q : Quests.values()) {
				if (q.getButton() == button) {
					return q;
				}
			}
			return null;
		}
	}

	public static void questButtons(Player player, int buttonId) {
		switch (buttonId) {

		case 28165:
			CooksAssistant.showInformation(player);
			break;
			
		case 28168:
			DoricsQuest.showInformation(player);
			break;
			
		case 28169:
			RestlessGhost.showInformation(player);
			break;
		case 28172:
			ImpCatcher.showInformation(player);
			break;
		case 28178:
			KnightsSword.showInformation(player);
		break;
		case 28173:
			PiratesTreasure.showInformation(player);
			break;
		case 28167:
			RuneMysteries.showInformation(player);
			break;
			
		default:
			if (Quests.forButton(buttonId) != null) {
				player.sendMessage("The quest " + Quests.forButton(buttonId).getName() + " is currently disabled.");
			}
			break;
		}
	}
}