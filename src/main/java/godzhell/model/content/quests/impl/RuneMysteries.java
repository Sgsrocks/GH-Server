package godzhell.model.content.quests.impl;

import godzhell.model.players.Player;

public class RuneMysteries {
	
	public static void showInformation(Player client) {
		for (int i = 8144; i < 8195; i++) {
			client.getPA().sendFrame126("", i);
		}
		client.getPA().sendFrame126("@dre@Rune Mysteries", 8144);
		client.getPA().sendFrame126("", 8145);
		if (client.runeMist == 0) {
			client.getPA().sendFrame126("Rune Mysteries", 8144);
			client.getPA().sendFrame126(
					"I can start this quest by speaking to Duke Horiaco", 8147);
			client.getPA().sendFrame126(
					"who is located on the 2nd floor of the Lumbridge Castle.",
					8148);
			client.getPA().sendFrame126("", 8149);
			client.getPA().sendFrame126(
					"There are no minimum requirments.", 8150);
		} else if (client.runeMist == 1) {
			client.getPA().sendFrame126("Rune Mysteries", 8144);
			client.getPA().sendFrame126(
					"<str>I've talked to the duke</str>", 8147);
			client.getPA().sendFrame126(
					"I should take the talisman to the Head Wizard.", 8148);
		} else if (client.runeMist == 2) {
			client.getPA().sendFrame126("Rune Mysteries", 8144);
			client.getPA().sendFrame126(
					"<str>I've talked to Sedridor</str>", 8147);
			client.getPA().sendFrame126(
					"<str>I gave him the talisman</str>", 8148);
			client.getPA().sendFrame126(
					"I should bring the notes to Aubury.", 8149);
		} else if (client.runeMist == 3) {
			client.getPA().sendFrame126("Rune Mysteries", 8144);
			client.getPA().sendFrame126(
					"<str>I've talked to Aubury.</str>", 8147);
			client.getPA().sendFrame126("<str>I gave him the notes</str>",
					8148);
			client.getPA().sendFrame126(
					"I should go back to the wizard tower", 8149);
		} else if (client.runeMist == 4) {
			client.getPA().sendFrame126("Rune Mysteries", 8144);
			client.getPA().sendFrame126("<str>I talked to Sedridor</str>",
					8147);
			client.getPA().sendFrame126(
					"<str>I gave him his items.</str>", 8148);
			client.getPA().sendFrame126("@red@     QUEST COMPLETE",
					8150);
			client.getPA().sendFrame126(
					"As a reward, I gained 1 Quest point", 8151);
			client.getPA().sendFrame126("And an air talisman.", 8152);
		}
		client.getPA().showInterface(8134);
	}

}

