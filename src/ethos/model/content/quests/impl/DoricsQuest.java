package ethos.model.content.quests.impl;

import ethos.model.players.Player;

/**
 * Doric's Quest
 * @author Andrew (Mr Extremez)
 */

public class DoricsQuest {

	public static void showInformation(Player client) {
		for (int i = 8144; i < 8195; i++) {
			client.getPA().sendFrame126("", i);
		}
		client.getPA().sendFrame126("@dre@Dorics Quest", 8144);
		client.getPA().sendFrame126("", 8145);
		if (client.doricQuest == 0) {
			client.getPA().sendFrame126("Dorics Quest", 8144);
			client.getPA().sendFrame126(
					"I can start this quest by speaking to doric", 8147);
			client.getPA().sendFrame126("Northwest of falador.",
					8148);
			client.getPA().sendFrame126("", 8149);
			client.getPA().sendFrame126(
					"Recommended Levels: 15 Mining", 8150);
		} else if (client.doricQuest == 1) {
			client.getPA().sendFrame126("Dorics Quest", 8144);
			client.getPA().sendFrame126(
					"<str>I've talked to the doric.</str>", 8147);
			client.getPA().sendFrame126(
					"He wants me to gather the following materials:", 8148);
			if (client.getItems().playerHasItem(434, 6)) {
				client.getPA().sendFrame126("<str>6 Clay</str>", 8149);
			} else {
				client.getPA().sendFrame126("@red@6 Clay", 8149);
			}
			if (client.getItems().playerHasItem(436, 4)) {
				client.getPA().sendFrame126("<str>4 Copper</str>", 8150);
			} else {
				client.getPA().sendFrame126("@red@4 Copper", 8150);
			}
			if (client.getItems().playerHasItem(440, 2)) {
				client.getPA().sendFrame126("<str>2 Iron ore</str>", 8151);
			} else {
				client.getPA().sendFrame126("@red@2 Iron ore", 8151);
			}
		} else if (client.doricQuest == 2) {
			client.getPA().sendFrame126("Dorics Quest", 8144);
			client.getPA().sendFrame126(
					"<str>I talked to the doric.</str>", 8147);
			client.getPA().sendFrame126(
					"<str>I gave the doric his items.</str>", 8148);
			client.getPA().sendFrame126(
					"I should go speak to the doric.", 8149);
		} else if (client.doricQuest == 3) {
			client.getPA().sendFrame126("Dorics Quest", 8144);
			client.getPA().sendFrame126(
					"<str>I talked to the doric.</str>", 8147);
			client.getPA().sendFrame126(
					"<str>I gave him his items.</str>", 8148);
			client.getPA().sendFrame126("@red@     QUEST COMPLETE",
					8150);
			client.getPA().sendFrame126(
					"As a reward, I gained 1300 Mining Exp", 8151);
			client.getPA().sendFrame126("180 Coins", 8152);
			client.getPA().sendFrame126("And 1 Quest Point.", 8153);
		}
		client.getPA().showInterface(8134);
	}

}
