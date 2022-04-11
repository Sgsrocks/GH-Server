package godzhell.model.content.quests.impl;

import godzhell.model.players.Player;

public class RestlessGhost {

	public static void showInformation(Player client) {
		for (int i = 8144; i < 8195; i++) {
			client.getPA().sendFrame126("", i);
		}
		client.getPA().sendFrame126("@dre@Restless Ghost", 8144);
		client.getPA().sendFrame126("", 8145);
		if (client.restGhost == 0) {
			client.getPA().sendFrame126("Restless Ghost", 8144);
			client.getPA().sendFrame126("I can start this quest by speaking to Father Aereck in",	8147);
			client.getPA().sendFrame126("Lumbridge", 8148);
			client.getPA().sendFrame126("Minimum Requirments:", 8149);
			client.getPA().sendFrame126("None.", 8150);
		} else if (client.restGhost == 1) {
			client.getPA().sendFrame126("Restless Ghost", 8144);
			client.getPA().sendFrame126(
					"<str>I've talked to Father Aereck</str>", 8147);
			client.getPA().sendFrame126(
					"I should speak to Father Urhey", 8148);
		} else if (client.restGhost == 2) {
			client.getPA().sendFrame126("Restless Ghost", 8144);
			client.getPA().sendFrame126(
					"<str>I've talked Father Urhey</str>", 8147);
			client.getPA().sendFrame126("<str>He gave me an amulet</str>",
					8148);
			client.getPA().sendFrame126(
					"I should speak to the ghost", 8149);
		} else if (client.restGhost == 3) {
			client.getPA().sendFrame126("Restless Ghost", 8144);
			client.getPA().sendFrame126(
					"<str>I've talked to the Ghost", 8147);
			client.getPA().sendFrame126("I should travel to the wizards tower and kill the skeleton", 8148);
			client.getPA().sendFrame126(
					"I should find the ghosts skull", 8149);
		} else if (client.restGhost == 4) {
			client.getPA().sendFrame126("Restless Ghost", 8144);
			client.getPA().sendFrame126("<str>I've found the skull</str>",
					8147);
			client.getPA().sendFrame126(
					"<str>I killed the skeleton</str>", 8148);
			client.getPA().sendFrame126(
					"I should travel back to the ghost", 8149);
		} else if (client.restGhost == 5) {
			client.getPA().sendFrame126("Restless Ghost", 8144);
			client.getPA().sendFrame126(
					"<str>I've set the skull in the coffin</str>", 8147);
			client.getPA().sendFrame126(
					"<str>I've freed the ghost.</str>", 8148);
			client.getPA().sendFrame126("@red@     QUEST COMPLETE",
					8150);
			client.getPA().sendFrame126(
					"As a reward, I gained 125 Prayer Exp.", 8151);
			client.getPA().sendFrame126("And 1 Quest Point", 8152);
			client.getPA().sendFrame126("", 8152);
		}
		client.getPA().showInterface(8134);
	}
}
