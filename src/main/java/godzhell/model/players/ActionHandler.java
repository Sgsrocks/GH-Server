package godzhell.model.players;

import godzhell.model.players.packets.npcoptions.NpcOptionFour;
import godzhell.model.players.packets.npcoptions.NpcOptionOne;
import godzhell.model.players.packets.npcoptions.NpcOptionThree;
import godzhell.model.players.packets.npcoptions.NpcOptionTwo;
import godzhell.model.players.packets.objectoptions.ObjectOptionFive;
import godzhell.model.players.packets.objectoptions.ObjectOptionFour;
import godzhell.model.players.packets.objectoptions.ObjectOptionOne;
import godzhell.model.players.packets.objectoptions.ObjectOptionThree;
import godzhell.model.players.packets.objectoptions.ObjectOptionTwo;

public class ActionHandler {

	private Player c;

	public ActionHandler(Player Client) {
		this.c = Client;
	}

	public void firstClickObject(int objectType, int obX, int obY) {
		ObjectOptionOne.handleOption(c, objectType, obX, obY);
	}

	public void secondClickObject(int objectType, int obX, int obY) {
		ObjectOptionTwo.handleOption(c, objectType, obX, obY);
	}

	public void thirdClickObject(int objectType, int obX, int obY) {
		ObjectOptionThree.handleOption(c, objectType, obX, obY);
	}

	public void fourthClickObject(int objectType, int obX, int obY) {
		ObjectOptionFour.handleOption(c, objectType, obX, obY);
	}
	public void fifthClickObject(int objectType, int obX, int obY) {
		ObjectOptionFive.handleOption(c, objectType, obX, obY);
	}
	public void firstClickNpc(int npcType) {
		NpcOptionOne.handleOption(c, npcType);
	}

	public void secondClickNpc(int npcType) {
		NpcOptionTwo.handleOption(c, npcType);
	}

	public void thirdClickNpc(int npcType) {
		NpcOptionThree.handleOption(c, npcType);
	}

	public void fourthClickNpc(int npcType) {
		NpcOptionFour.handleOption(c, npcType);
	}

}