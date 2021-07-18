package ethos.model.content.dialogue.impl;

import ethos.model.content.barrows.RoomLocation;
import ethos.model.content.dialogue.Dialogue;
import ethos.model.content.dialogue.DialogueConstants;
import ethos.model.content.dialogue.DialogueManager;

public class BarrowsDialogue extends Dialogue {

	@Override
	public void execute() {
		switch (getNext()) {
		case 0:
			DialogueManager.sendStatement(getPlayer(), "You've found a hidden tunnel, do you want to enter?");
			setNext(1);
			break;
		case 1:
			DialogueManager.sendOption(getPlayer(), "Yeah I'm fearless!", "No way, that looks scary!");
			break;
			}
		// TODO Auto-generated method stub

	}
	@Override
	public boolean clickButton(int id) {
		
		switch(id) {
		case DialogueConstants.OPTIONS_2_1:
			getPlayer().getPA().movePlayer(RoomLocation.getRandomSpawn());
			getPlayer().getPA().removeAllWindows();
			end();
				break;
		case DialogueConstants.OPTIONS_2_2:
			end();
				break;
		}
		return false;
	}

}
