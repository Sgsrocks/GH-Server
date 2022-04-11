package godzhell.model.content.quests.impl;

import godzhell.model.players.Player;

public class ImpCatcher {

	public static void showInformation(Player client) {
		for (int i = 35488; i < 35665; i++) {
			client.getPlayerAssistant().sendFrame126("", i);
			client.getPlayerAssistant().sendFrame126("", 35486);
		}
		client.getPlayerAssistant().sendFrame126("@dre@Imp Catcher", 35486);
		if (client.impsC == 0) {
			client.getPlayerAssistant()
					.sendFrame126(
							"I can start this quest by speaking to Wizard Mizgog who is",
							35488);
			client.getPlayerAssistant().sendFrame126("in the Wizard's Tower.",
					35489);
		} else if (client.impsC == 1) {
			client.getPlayerAssistant()
					.sendFrame126(
							"<str>I can start this quest by speaking to Wizard Mizgog who is",
							35488);
			client.getPlayerAssistant().sendFrame126(
					"<str>in the Wizard's Tower.", 35489);
			client.getPlayerAssistant().sendFrame126("", 35490);
			client.getPlayerAssistant().sendFrame126(
					"Wizard Mizgog have asked you to get the following items:",
					35491);
			client.getPlayerAssistant().sendFrame126("Red bead", 35492);
			client.getPlayerAssistant().sendFrame126("Yellow bead", 35493);
			client.getPlayerAssistant().sendFrame126("Black bead", 35494);
			client.getPlayerAssistant().sendFrame126("White bead", 35495);
		} else if (client.impsC == 2) {
			client.getPlayerAssistant()
					.sendFrame126(
							"<str>I can start this quest by speaking to Wizard Mizgog who is",
							35488);
			client.getPlayerAssistant().sendFrame126(
					"<str>in the Wizard's Tower.", 35489);
			client.getPlayerAssistant().sendFrame126("", 35490);
			client.getPlayerAssistant()
					.sendFrame126(
							"<str>Wizard Mizgog have asked you to get the following items:",
							35491);
			client.getPlayerAssistant().sendFrame126("<str>Red bead", 35492);
			client.getPlayerAssistant().sendFrame126("<str>Yellow bead", 35493);
			client.getPlayerAssistant().sendFrame126("<str>Black bead", 35494);
			client.getPlayerAssistant().sendFrame126("<str>White bead", 35495);
			client.getPlayerAssistant().sendFrame126("", 35496);
			client.getPlayerAssistant().sendFrame126(
					"You have completed this quest!", 35497);
		}
		client.getPlayerAssistant().showInterface(35483);
	}

}
