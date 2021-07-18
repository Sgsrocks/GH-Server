package ethos.model.content.dialogue.impl;

import ethos.model.content.dialogue.Dialogue;
import ethos.model.content.dialogue.DialogueConstants;
import ethos.model.content.dialogue.DialogueManager;
import ethos.model.content.dialogue.Emotion;

public class KamfreenaDialogue extends Dialogue {

	@Override
	public void execute() {
		switch (getNext()) {
		case 0:
			DialogueManager.sendNpcChat(getPlayer(), 2461, Emotion.CALM,
					"You are not in the possesion of a defender.",
					"You must kill cyclops to obtain a defender.",
					"The fee for entering the area is 100 tokens.");
			setNext(1);
			break;
		case 1:
			DialogueManager.sendOption(getPlayer(), "Yes", "No");
			break;
		case 2:
			getPlayer().getPA().closeAllWindows();
			break;
		}
	}
	@Override
	public boolean clickButton(int id) {
		
		switch(id) {
		case DialogueConstants.OPTIONS_2_1:
			if (getPlayer().getItems().playerHasItem(8851, 100)) {
				getPlayer().getPA().movePlayer(2847, 3540, 2);
				getPlayer().getItems().deleteItem2(8851, 100);
				getPlayer().getPA().removeAllWindows();
				getPlayer().getWarriorsGuild().cycle();
			} else {
				DialogueManager.sendNpcChat(getPlayer(), 2461, Emotion.CALM,"You need atleast 100 warrior guild tokens.",
						"You can get some by operating the armour animator.");
				setNext(2);
			}
			  break;
		}
		return false;
	}

}
