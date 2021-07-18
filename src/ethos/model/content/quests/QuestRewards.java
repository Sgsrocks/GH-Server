package ethos.model.content.quests;

import ethos.model.players.Player;

public class QuestRewards {

	public static String QUEST_NAME;

	public static void questReward(Player player, String questName, String Line1, String Line2, String Line3, String Line4, String Line5, String Line6, int itemID) {
		player.getPA().sendFrame126("You have completed " + questName + "!", 12144);
		player.getPA().sendFrame126("" + player.QuestPoints, 12147);
		player.getPA().sendFrame126(Line1, 12150);
		player.getPA().sendFrame126(Line2, 12151);
		player.getPA().sendFrame126(Line3, 12152);
		player.getPA().sendFrame126(Line4, 12153);
		player.getPA().sendFrame126(Line5, 12154);
		player.getPA().sendFrame126(Line6, 12155);
		if (itemID > 0) {
			player.getPA().sendFrame246(12145, 250, itemID);
		}
		player.getPA().showInterface(12140);
		player.sendMessage("You completed " + questName + "!");
		QuestAssistant.sendStages(player);
		//player.getPA().sendQuickSong(93, 0);
	}
	
	public static void knightsReward(Player player) {
		questReward(player, "Knight's Sword Quest", "1 Quest Point", "12,725 Smithing XP", "", "", "", "", 0);
		QUEST_NAME = "The Knight's Sword";
		player.getPA().sendFrame126("@gre@" + QUEST_NAME + "", 7346);
		player.getPlayerAssistant().addSkillXP(12725, player.playerSmithing, true);
		player.QuestPoints ++;
		player.knightS = 9;
	}

	public static void gertFinish(Player player) {
		questReward(player, "Gertrude's Cat", "1 Quest Point", "1,525 Cooking XP", "A kitten!", "Ability to raise cats", "A chocolate cake", "A bowl of stew", 1897);
		QUEST_NAME = "Gertrude's Cat";
		player.getPA().sendFrame126("@gre@" + QUEST_NAME + "", 7360);
		player.getItems().addItem(1897, 1);
		player.getItems().addItem(2003, 1);
		player.getItems().addItem(1560, 1);
		player.getPlayerAssistant().addSkillXP(1525, player.playerCooking, true);
		player.QuestPoints++;
		player.gertCat = 7;
	}

	public static void pirateFinish(Player c) {
		questReward(c, "Pirate's Treasure", "2 Quest Points", "One-Eyed Hector's Treasure", "", "", "", "", 2714);
		QUEST_NAME = "Pirate's Treasure";
		c.getPA().sendFrame126("@gre@" + QUEST_NAME + "", 7341);
		c.getItems().addItem(2714, 1);
		c.QuestPoints += 2;
		c.pirateTreasure = 6;
	}

	public static void witchFinish(Player client) {
		questReward(client, "Witch's Potion", "1 Quest Point", "325 Magic XP", "", "", "", "", 325);
		QUEST_NAME = "Witch's Potion";
		client.getPA().sendFrame126("@gre@" + QUEST_NAME + "", 7348);
		client.getPlayerAssistant().addSkillXP(325, client.playerMagic, true);
		client.QuestPoints++;
		client.witchspot = 3;
	}

	public static void julietFinish(Player player) {
		questReward(player, "Romeo and Juliet", "5 Quest Points", "", "", "", "", "", 0);
		QUEST_NAME = "Romeo and Juliet";
		player.getPA().sendFrame126("@gre@" + QUEST_NAME + "", 7343);
		player.QuestPoints += 5;
		player.romeojuliet = 9;
	}

	public static void restFinish(Player client) {
		questReward(client, "Restless Ghost", "1 Quest Point", "125 Prayer XP", "", "", "", "", 0);
		QUEST_NAME = "Restless Ghost";
		client.getPA().sendFrame126("@gre@" + QUEST_NAME + "", 7337);
		client.getPlayerAssistant().addSkillXP(125, client.playerPrayer, true);
		client.QuestPoints++;
		client.restGhost = 5;
	}

	public static void vampFinish(Player player) {
		questReward(player, "Vampyre Slayer", "3 Quest Points", "4,825 Attack XP", "", "", "", "", 0);
		QUEST_NAME = "Vampyre Slayer";
		player.getPA().sendFrame126("@gre@" + QUEST_NAME + "", 7347);
		player.getPlayerAssistant().addSkillXP(4825, player.playerAttack);
		player.QuestPoints += 3;
		player.vampSlayer = 5;
	}

	public static void runeFinish(Player player) {
		questReward(player, "Rune Mysteries", "1 Quest Point", "Air Talisman", "", "", "", "", 1438);
		QUEST_NAME = "Rune Mysteries";
		player.getPA().sendFrame126("@gre@" + QUEST_NAME + "", 7335);
		player.getItems().addItem(1438, 1);
		player.QuestPoints++;
		player.runeMist = 4;
	}

	public static void sheepFinish(Player player) {
		questReward(player, "Sheep Shearer", "1 Quest Point", "150 Crafting Exp", "60 Coins", "", "", "", 995);
		QUEST_NAME = "Sheep Shearer";
		player.getPA().sendFrame126("@gre@" + QUEST_NAME + "", 7344);
		player.getItems().addItem(995, 60);
		player.getPlayerAssistant().addSkillXP(150, player.playerCrafting, true);
		player.QuestPoints++;
		player.sheepShear = 2;
	}

	public static void doricFinish(Player player) {
		questReward(player, "Doric's Quest", "1 Quest Point", "1,300 Mining XP", "180 Coins", "", "", "", 995);
		QUEST_NAME = "Doric's Quest";
		player.getPA().sendFrame126("@gre@" + QUEST_NAME + "", 7336);
		player.getItems().addItem(995, 180);
		player.getPlayerAssistant().addSkillXP(1300, player.playerMining, true);
		player.QuestPoints++;
		player.doricQuest = 3;
	}

	public static void impFinish(Player player) {
		questReward(player, "Imp Catcher", "1 Quest Point", "875 Magic XP", "Amulet of Accuracy", "", "", "", 1478);
		QUEST_NAME = "Imp Catcher";
		player.getPA().sendFrame126("@gre@" + QUEST_NAME + "", 7340);
		player.getItems().addItem(1478, 1);
		player.getPlayerAssistant().addSkillXP(875, player.playerMagic, true);
		player.QuestPoints++;
		player.impsC = 2;
	}

	public static void cookReward(Player player) {
		questReward(player, "Cook's Assistant", "1 Quest Point", "500 Coins", "300 Cooking XP", "", "", "", 326);
		QUEST_NAME = "Cook's Assistant";
		player.getPA().sendFrame126("@gre@" + QUEST_NAME + "", 7333);
		player.getItems().addItem(995, 500);
		player.getPlayerAssistant().addSkillXP(300, player.playerCooking, true);
		player.QuestPoints++;
		player.cookAss = 3;
	}

	public static void blackKnightReward(Player player) {
		questReward(player, "Black Knights' Fortress", "3 Quest Points", "2,500 Coins", "", "", "", "", 0);
		QUEST_NAME = "Black Knights' Fortress";
		player.getPA().sendFrame126("@gre@" + QUEST_NAME + "", 7332);
		player.getItems().addItem(995, 2500);
		player.QuestPoints += 3;
		player.blackKnight = 3;
	}

	public static void shieldArravReward(Player player) {
		questReward(player, "Shield of Arrav", "1 Quest Point", "1,200 Coins", "", "", "", "", 767);
		QUEST_NAME = "Shield of Arrav";
		player.getPA().sendFrame126("@gre@" + QUEST_NAME + "", 7345);
		player.getItems().addItem(995, 1200);
		player.QuestPoints++;
		player.shieldArrav = 8;
	}
}
