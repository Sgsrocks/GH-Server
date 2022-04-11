package godzhell.model.content.quests.impl;

import godzhell.model.players.Player;

/**
 * @author Andrew (Mr Extremez)
 * Cooks Assistant
 */

public class CooksAssistant {

	private static final int EGG = 1944;
	private static final int MILK = 1927;
	private static final int FLOUR = 1933;

	public static void showInformation(Player client) {
		for (int i = 35488; i < 35665; i++) {
			client.getPA().sendFrame126("", i);
			client.getPlayerAssistant().sendFrame126("", 35486);
		}
		client.getPA().sendFrame126("@dre@Cook's Assistant", 35486);
		if (client.cookAss == 0) {
			client.getPA().sendFrame126("@dre@Cook's Assistant", 35486);
			client.getPA().sendFrame126("I can start this quest by speaking to the Cook in the", 35488);
			client.getPA().sendFrame126("Lumbridge Castle kitchen.", 35489);
			client.getPA().sendFrame126("", 35490);
			client.getPA().sendFrame126("There are no minimum requirements.", 35491);
		} else if (client.cookAss == 1) {
			client.getPA().sendFrame126("Cook's Assistant", 35486);
			client.getPA().sendFrame126("<str>I've talked to the cook.</str>", 35488);
			client.getPA().sendFrame126("He wants me to gather the following materials:", 35489);
			if (client.getItems().playerHasItem(EGG, 1)) {
				client.getPA().sendFrame126("<str>1 egg</str>", 35490);
			} else {
				client.getPA().sendFrame126("@red@1 egg", 35490);
			}
			if (client.getItems().playerHasItem(MILK, 1)) {
				client.getPA().sendFrame126("<str>1 bucket of milk</str>", 35491);
			} else {
				client.getPA().sendFrame126("@red@1 bucket of milk", 35491);
			}
			if (client.getItems().playerHasItem(FLOUR, 1)) {
				client.getPA().sendFrame126("<str>1 heap of flour</str>", 35492);
			} else {
				client.getPA().sendFrame126("@red@1 pot of flour", 35492);
			}
		} else if (client.cookAss == 2) {
			client.getPA().sendFrame126("@dre@Cook's Assistant", 35486);
			client.getPA().sendFrame126("<str>I talked to the cook.</str>", 8147);
			client.getPA().sendFrame126("<str>I gave the cook his items.</str>", 8148);
			client.getPA().sendFrame126("I should go speak to the cook.", 8149);
		} else if (client.cookAss == 3) {
			client.getPA().sendFrame126("@dre@Cook's Assistant", 35486);
			client.getPA().sendFrame126("<str>I talked to the cook.</str>", 35488);
			client.getPA().sendFrame126("<str>I gave him his items.</str>", 35489);
			client.getPA().sendFrame126("@red@     QUEST COMPLETE", 35490);
			client.getPA().sendFrame126("As a reward, I gained 150 Cooking Experience.", 35491);
		}
		client.getPA().showInterface(35483);
	}

}
