package ethos.model.content.dialogue.impl.Lumbridge;

import ethos.model.content.dialogue.Dialogue;
import ethos.model.content.dialogue.DialogueManager;
import ethos.model.content.dialogue.Emotion;

public class SheepDialogue extends Dialogue{

	@Override
	public void execute() {
		switch(getNext()) {
		case 0:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "That's a sheep...I think. I can't talk to sheep.");
			setNext(1);
			break;
		case 1:
			getPlayer().getPA().closeAllWindows();
			break;
		}
		
	}

}
