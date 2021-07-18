package ethos.model.content.dialogue.impl.Lumbridge;

import ethos.model.content.dialogue.Dialogue;
import ethos.model.content.dialogue.DialogueConstants;
import ethos.model.content.dialogue.DialogueManager;
import ethos.model.content.dialogue.Emotion;

public class ShearedRamDialogue extends Dialogue {

	@Override
	public void execute() {
		switch(getNext()) {
		case 0:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.DEFAULT, "Welcome to the Sheared Ram. What can I do for you?");
			setNext(1);
			break;
		case 1:
			DialogueManager.sendOption(getPlayer(), "I'll have a beer please.", "Heard any rumors recently?", "Nothing, I'm fine.");
			break;
		case 2:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.DEFAULT, "That'll be two coins please.");
			setNext(3);
			break;
		case 3:
			if(getPlayer().getItems().playerHasItem(995, 2)) {
				getPlayer().getItems().deleteItem2(995, 2);
				getPlayer().getItems().addItem(1917, 1);
				getPlayer().getPA().closeAllWindows();
				end();
			} else {
				DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "Oh dear, I don't seem to have enough money.");
				setNext(6);
			}
			break;
		case 4:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.DEFAULT, "No, it hasn't been very busy lately.");
			setNext(5);
			break;
		case 5:
			getPlayer().getPA().closeAllWindows();
			end();
			break;
		case 6:
			getPlayer().getPA().closeAllWindows();
			end();
			break;
		}
	}
	@Override
	public boolean clickButton(int id) {
		switch(id) {
		case DialogueConstants.OPTIONS_3_1:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "I'll have a beer please");
			setNext(2);
			break;
		case DialogueConstants.OPTIONS_3_2:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "Heard any rumors recently?");
			setNext(4);
			break;
		case DialogueConstants.OPTIONS_3_3:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "Nothing, I'm fine.");
			setNext(6);
			break;
		}
		return false;
		
	}



}