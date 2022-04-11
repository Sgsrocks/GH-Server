package godzhell.model.content.dialogue.impl;

import godzhell.model.content.dialogue.Dialogue;
import godzhell.model.content.dialogue.DialogueConstants;
import godzhell.model.content.dialogue.DialogueManager;

public class LadderAndStairDialogue extends Dialogue {

	@Override
	public void execute() {
		switch (getNext()) {
		case 0:
			DialogueManager.sendOption(getPlayer(), "Climb up", "Climb down", "Nothing");
			break;
		
	}
	}
	@Override
	public boolean clickButton(int id) {
		
		switch(id) {
		case DialogueConstants.OPTIONS_3_1://fishing guild
			if(getPlayer().getHeight() == 0) {
				getPlayer().getPA().movePlayer(getPlayer().getX(), getPlayer().getY(), 1);
			} else if(getPlayer().getHeight() == 1) {
				getPlayer().getPA().movePlayer(getPlayer().getX(), getPlayer().getY(), 2);
			} else if(getPlayer().getHeight() == 2) {
				getPlayer().getPA().movePlayer(getPlayer().getX(), getPlayer().getY(), 3);
			} 
				break;
		case DialogueConstants.OPTIONS_3_2://mining guild
			if(getPlayer().getHeight() == 1) {
				getPlayer().getPA().movePlayer(getPlayer().getX(), getPlayer().getY(), 0);
			} else if(getPlayer().getHeight() == 2) {
				getPlayer().getPA().movePlayer(getPlayer().getX(), getPlayer().getY(), 1);
			} else if(getPlayer().getHeight() == 3) {
				getPlayer().getPA().movePlayer(getPlayer().getX(), getPlayer().getY(), 2);
			}
			break;
		case DialogueConstants.OPTIONS_3_3://crafting guild
			getPlayer().getPA().closeAllWindows();
			end();
			break;
		}
		return false;
	}
}
