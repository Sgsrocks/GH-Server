package ethos.model.content.dialogue.impl;

import ethos.model.content.dialogue.Dialogue;
import ethos.model.content.dialogue.DialogueConstants;
import ethos.model.content.dialogue.DialogueManager;
import ethos.model.content.dialogue.Emotion;

public class OziachDialogue extends Dialogue {

	@Override
	public void execute() {
		switch (getNext()) {
		
		case 0:
			DialogueManager.sendNpcChat(getPlayer(), 822, Emotion.CALM, "Hello, do you want me to create your dragonfire shield?");
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
			if (getPlayer().getItems().playerHasItem(11286) && getPlayer().getItems().playerHasItem(1540)
					&& getPlayer().getItems().playerHasItem(995, 5_000_000)) {
				getPlayer().getItems().deleteItem(11286, 1);
				getPlayer().getItems().deleteItem(1540, 1);
				getPlayer().getItems().deleteItem(995, 500_000);
				getPlayer().getItems().addItem(11283, 1);
				getPlayer().votePoints -= 5;
				getPlayer().refreshQuestTab(2);
				DialogueManager.sendItem1(getPlayer(), "Oziach successfully bound your dragonfire shield.", 11283);
			} else {
				DialogueManager.sendNpcChat(getPlayer(), 822, Emotion.ANGRY_1, "Come back with a shield, visage and 5M Gold!");
			}
			end();
			break;
		}

	}
	@Override
	public boolean clickButton(int id) {
		switch(id) {
		case DialogueConstants.OPTIONS_2_1:
			DialogueManager.sendNpcChat(getPlayer(), 822, Emotion.DEFAULT, "Alright, that will be 500K coins and 5 vote points thank you.",
					"You must have the visage and a antifire shield as well", "of course.");
			setNext(3);
			break;
		case DialogueConstants.OPTIONS_2_2:
			setNext(2);
			break;
		}
		return false;
		}

}
