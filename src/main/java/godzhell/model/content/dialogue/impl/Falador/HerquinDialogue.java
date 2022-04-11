package godzhell.model.content.dialogue.impl.Falador;

import godzhell.Config;
import godzhell.model.content.dialogue.Dialogue;
import godzhell.model.content.dialogue.DialogueConstants;
import godzhell.model.content.dialogue.DialogueManager;
import godzhell.model.content.dialogue.Emotion;

public class HerquinDialogue extends Dialogue {

	@Override
	public void execute() {
		switch (getNext()) {
		case 0:
			DialogueManager.sendOption(getPlayer(), "Do you wish to trade?", "Sorry i don't want to talk to you actually.");
			break;
		case 1:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.DEFAULT, "Why yes, this a jewel shop after all.");
			setNext(2);
			break;
		case 2:
			getPlayer().getShops().openShop(Config.HERQUINS_GEMS);
			end();
			break;
		case 3:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.DEFAULT, "Huh! Charming!");
			setNext(4);
			break;
		case 4:
			getPlayer().getPA().closeAllWindows();
			end();
			break;
		}
		
	}
	@Override
	public boolean clickButton(int id) {
		switch(id) {
		case DialogueConstants.OPTIONS_2_1:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Do you wish to trade?");
			setNext(1);
			break;
		case DialogueConstants.OPTIONS_2_2:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Sorry i don't want to talk to you actually.");
			setNext(3);
			break;
		}
		return false;
	}
}
