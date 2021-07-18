package ethos.model.content.dialogue.impl.Lumbridge;

import ethos.model.content.dialogue.Dialogue;
import ethos.model.content.dialogue.DialogueConstants;
import ethos.model.content.dialogue.DialogueManager;
import ethos.model.content.dialogue.Emotion;

public class Lumbridge_guide_Dialogue extends Dialogue {

	@Override
	public void execute() {
		switch(getNext()) {
		case 0:
			DialogueManager.sendNpcChat(getPlayer(), 306, Emotion.DEFAULT, "Greetings, adventurer. I am Phileas the Lumbridge", "Guide. I am here to give information and directions to", "new players. s there anything I can help you with?");
			setNext(1);
			break;
		case 1:
			DialogueManager.sendOption(getPlayer(), "Where can I find a quest to go on?", "What monsters should I fight?", "Where can I make money?", "Where can I find more information?", "More options...");
			break;
		}
		
	}
	@Override
	public boolean clickButton(int id) {
		switch(id) {
		case DialogueConstants.OPTIONS_5_1:
		break;
		case DialogueConstants.OPTIONS_5_2:
		break;
		case DialogueConstants.OPTIONS_5_3:
		break;
		case DialogueConstants.OPTIONS_5_4:
		break;
		case DialogueConstants.OPTIONS_5_5:
			DialogueManager.sendOption(getPlayer(), "I'd like to know more about security.", "WHere can I find a bank?", "I don't need any help.", "Previous options...");
		break;
		case DialogueConstants.OPTIONS_4_4:
			setNext(1);
		break;
		}
		return false;
		
	}

}
