package godzhell.model.content.dialogue.impl.Lumbridge;

import godzhell.Config;
import godzhell.definitions.NpcID;
import godzhell.model.content.dialogue.Dialogue;
import godzhell.model.content.dialogue.DialogueConstants;
import godzhell.model.content.dialogue.DialogueManager;
import godzhell.model.content.dialogue.Emotion;

public class BobDialogue extends Dialogue {

	@Override
	public void execute() {
		switch(getNext()) {
		case 0:
			DialogueManager.sendOption(getPlayer(), "Give me a quest!", "Have you anything to sell?",
					"Can you repair my items for me?");
			break;
		case 1:
			DialogueManager.sendNpcChat(getPlayer(), NpcID.BOB_10619, Emotion.DEFAULT, "Get yer own!");
			setNext(2);
			break;
		case 2:
			getPlayer().getPA().closeAllWindows();
			end();
			break;
		case 3:
			DialogueManager.sendNpcChat(getPlayer(), NpcID.BOB_10619, Emotion.DEFAULT, "Yes i buy and sell axes! Take your pick (or axe)!");
			setNext(4);
			break;
		case 4:
			getPlayer().getShops().openShop(Config.BOBS_BRILLIANT_AXES);
			break;
		case 5:
			DialogueManager.sendNpcChat(getPlayer(), NpcID.BOB_10619, Emotion.DEFAULT, "Of course I'll repair it, though the materials may cost", "you. Just hand me the item and I'll have a look.");
			setNext(2);
			break;
		}

	}
	@Override
	public boolean clickButton(int id) {
		switch(id) {
		case DialogueConstants.OPTIONS_3_1:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "Give me a quest!");
			setNext(1);
			break;
		case DialogueConstants.OPTIONS_3_2:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "Have you anything to sell?");
			setNext(3);
			break;
		case DialogueConstants.OPTIONS_3_3:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "Can you repair my items for me?");
			setNext(5);
			break;
		}
		return false;
		
	}
}
