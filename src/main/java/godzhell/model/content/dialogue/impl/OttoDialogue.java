package godzhell.model.content.dialogue.impl;

import godzhell.model.content.dialogue.Dialogue;
import godzhell.model.content.dialogue.DialogueConstants;
import godzhell.model.content.dialogue.DialogueManager;
import godzhell.model.content.dialogue.Emotion;

public class OttoDialogue extends Dialogue {

	@Override
	public void execute() {
		switch (getNext()) {
		
		case 0:
			DialogueManager.sendNpcChat(getPlayer(), 2914, Emotion.CALM, "Hello, do you want me to create your Zamorakian hasta?");
			setNext(1);
			break;
		case 1:
			DialogueManager.sendOption(getPlayer(), "Yes, please", "No thank you..");
			break;
		case 2:
			getPlayer().getPA().closeAllWindows();
			end();
			break;
		case 3:
			if (getPlayer().getItems().playerHasItem(11824)
					&& getPlayer().getItems().playerHasItem(995, 300_000)) {
				getPlayer().getItems().deleteItem(11824, 1);
				getPlayer().getItems().deleteItem(995, 300_000);
				getPlayer().getItems().addItem(11889, 1);
				getPlayer().refreshQuestTab(2);
				DialogueManager.sendItem1(getPlayer(), "Otto Godblessed successfully changes your Zamorakian spear to a Zamorakian hasta.", 11889);
			} else {
				DialogueManager.sendNpcChat(getPlayer(), 2914, Emotion.ANGRY_1, "Come back with a Zamorakian spear, 300k Gold!");
			}
			end();
			break;
		}

	}
	@Override
	public boolean clickButton(int id) {
		switch(id) {
		case DialogueConstants.OPTIONS_2_1:
			DialogueManager.sendNpcChat(getPlayer(), 2914, Emotion.DEFAULT, "Alright, that will be 300K coins thank you.",
					"You must have the Zamorakian spear", "of course.");
			setNext(3);
			break;
		case DialogueConstants.OPTIONS_2_2:
			setNext(2);
			break;
		}
		return false;
		}

}
