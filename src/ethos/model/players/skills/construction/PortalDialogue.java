package ethos.model.players.skills.construction;

import ethos.model.content.dialogue.Dialogue;
import ethos.model.content.dialogue.DialogueConstants;
import ethos.model.content.dialogue.DialogueManager;
import ethos.model.content.dialogue.Emotion;

public class PortalDialogue extends Dialogue {

	@Override
	public void execute() {
		switch(getNext()) {
		case 0:
			DialogueManager.sendOption(getPlayer(), "Enter your house", "Enter your house (building mode)", "Enter a friend's house", "Nevermind");
			break;
		}
		// TODO Auto-generated method stub

	}
	@Override
	public boolean clickButton(int id) {
		switch(id) {
		case DialogueConstants.OPTIONS_4_1:
			if (House.hasHouse(getPlayer())) {
				House house;
				
				if (getPlayer().getHouse() == null) {
					house = House.load(getPlayer());
				} else {
					house = getPlayer().getHouse().getOwner().equals(getPlayer()) ? getPlayer().getHouse() : House.load(getPlayer()) ;
				}
				house.setBuildMode(false);
				getPlayer().setHouse(house);
				house.enter(getPlayer());
				getPlayer().getPA().closeAllWindows();
			} else {
				getPlayer().sendMessage("You must purchase a house first!");
				getPlayer().getPA().closeAllWindows();
			}
			break;
		case DialogueConstants.OPTIONS_4_2:
			if (House.hasHouse(getPlayer())) {
				House house;
				
				if (getPlayer().getHouse() == null) {
					house = House.load(getPlayer());
				} else {
					house = getPlayer().getHouse().getOwner().equals(getPlayer()) ? getPlayer().getHouse() : House.load(getPlayer()) ;
				}
				house.setBuildMode(true);
				getPlayer().setHouse(house);
				house.enter(getPlayer());
				getPlayer().getPA().closeAllWindows();
			} else {
				getPlayer().sendMessage("You must purchase a house first!");
				getPlayer().getPA().closeAllWindows();
			}
			break;
		case DialogueConstants.OPTIONS_4_3:
			getPlayer().getPA().closeAllWindows();
			getPlayer().getOutStream().createFrame(187);
			getPlayer().flushOutStream();
			getPlayer().inputData[0] = 1;
			end();
			break;
		case DialogueConstants.OPTIONS_4_4:
			getPlayer().getPA().closeAllWindows();
			end();
			break;
		}
		return false;
	}
}
