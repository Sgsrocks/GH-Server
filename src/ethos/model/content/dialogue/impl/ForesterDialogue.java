package ethos.model.content.dialogue.impl;

import ethos.model.content.dialogue.Dialogue;
import ethos.model.content.dialogue.DialogueManager;
import ethos.model.content.dialogue.Emotion;
import ethos.util.Misc;

public class ForesterDialogue extends Dialogue {

	
	@Override
	public void execute() {
		switch (getNext()) {
		case 0:
			int random = Misc.random(3);
			if (random == 0) {
			DialogueManager.sendNpcChat(getPlayer(), 7238, Emotion.CALM,
					"Nice weather we're having today.");
			setNext(1);
			}
			else if (random == 1) {
			DialogueManager.sendNpcChat(getPlayer(), 7238, Emotion.CALM,
					"There's plenty of trees around, couldn't you go to", "another spot?");
			setNext(1);
			}
			else if (random == 2) {
			DialogueManager.sendNpcChat(getPlayer(), 7238, Emotion.CALM,
					"It's so peaceful here, don't you agree?");
			setNext(1);
			}
			break;
		case 1:
			getPlayer().getPA().closeAllWindows();
			break;
		}
		// TODO Auto-generated method stub
		
	}
	

}
