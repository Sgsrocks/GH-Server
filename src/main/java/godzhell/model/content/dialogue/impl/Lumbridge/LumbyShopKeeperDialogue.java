package godzhell.model.content.dialogue.impl.Lumbridge;

import godzhell.Config;
import godzhell.model.content.dialogue.Dialogue;
import godzhell.model.content.dialogue.DialogueConstants;
import godzhell.model.content.dialogue.DialogueManager;
import godzhell.model.content.dialogue.Emotion;

public class LumbyShopKeeperDialogue extends Dialogue {

	@Override
	public void execute() {
		switch (getNext()) {
		case 0:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.DEFAULT, "Can i help you at all?");
			setNext(1);
			break;
		case 1:
			DialogueManager.sendOption(getPlayer(), "Yes please, What are you selling?", "No thanks.");
			break;
		case 2:
			getPlayer().getShops().openShop(Config.LUMBRIDGE_GENERAL_STORE);
			end();
			break;
		case 3:
			getPlayer().getPA().closeAllWindows();
			end();
			break;
		}
		
	}
	@Override
	public boolean clickButton(int id) {
		switch(id) {
		case DialogueConstants.OPTIONS_2_1:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Yes please, What are you selling?");
			setNext(2);
			break;
		case DialogueConstants.OPTIONS_2_2:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "No thanks.");
			setNext(3);
			break;
		}
		return false;
	}
}
