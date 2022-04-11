package godzhell.model.content.dialogue.impl.Falador;

import godzhell.Config;
import godzhell.model.content.dialogue.Dialogue;
import godzhell.model.content.dialogue.DialogueConstants;
import godzhell.model.content.dialogue.DialogueManager;
import godzhell.model.content.dialogue.Emotion;

public class CassieDialogue extends Dialogue {

	@Override
	public void execute() {
		switch (getNext()) {
		case 0:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.DEFAULT, "I buy and sell shields, do you want to trade?");
			setNext(1);
			break;
		case 1:
			DialogueManager.sendOption(getPlayer(), "Yes please.", "No thanks.");
			break;
		case 2:
			getPlayer().getShops().openShop(Config.CASSIES_SHIELD_SHOP);
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
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Yes please.");
			setNext(2);
			break;
		case DialogueConstants.OPTIONS_2_2:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "No thank you.");
			setNext(3);
			break;
		}
		return false;
	}
}
