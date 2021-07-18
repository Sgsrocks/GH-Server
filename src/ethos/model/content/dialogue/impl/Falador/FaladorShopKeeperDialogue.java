package ethos.model.content.dialogue.impl.Falador;

import ethos.Config;
import ethos.model.content.dialogue.Dialogue;
import ethos.model.content.dialogue.DialogueConstants;
import ethos.model.content.dialogue.DialogueManager;
import ethos.model.content.dialogue.Emotion;

public class FaladorShopKeeperDialogue extends Dialogue {

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
			getPlayer().getShops().openShop(Config.FALADOR_GENERAL_STORE);
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
