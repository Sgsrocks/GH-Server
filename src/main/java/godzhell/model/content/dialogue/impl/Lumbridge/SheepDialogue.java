package godzhell.model.content.dialogue.impl.Lumbridge;

import godzhell.model.content.dialogue.Dialogue;
import godzhell.model.content.dialogue.DialogueManager;
import godzhell.model.content.dialogue.Emotion;

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
