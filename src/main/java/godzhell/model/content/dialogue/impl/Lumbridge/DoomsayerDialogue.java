package godzhell.model.content.dialogue.impl.Lumbridge;

import godzhell.model.content.dialogue.Dialogue;
import godzhell.model.content.dialogue.DialogueConstants;
import godzhell.model.content.dialogue.DialogueManager;
import godzhell.model.content.dialogue.Emotion;

public class DoomsayerDialogue extends Dialogue {

	@Override
	public void execute() {
		switch(getNext()) {
		case 0:
			DialogueManager.sendNpcChat(getPlayer(), 6773, Emotion.DEFAULT, "Dooooom!");
			setNext(1);
			break;
		case 1:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "Where?");
			setNext(2);
			break;
		case 2:
			DialogueManager.sendNpcChat(getPlayer(), 6773, Emotion.DEFAULT, "All around us! I can feel it in the air, hear it on the", "wind, smell it... also in the air!");
			setNext(3);
			break;
		case 3:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "Is there anything we can do about this doom?");
			setNext(4);
			break;
		case 4:
			DialogueManager.sendNpcChat(getPlayer(), 6773, Emotion.DEFAULT, "There is nothing you need to do my friend! i am the", "Doomsayer, although my real title could be something", "like the danger Tutor.");
			setNext(5);
			break;
		case 5:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "Danger Tutor?");
			setNext(6);
			break;
		case 6:
			DialogueManager.sendNpcChat(getPlayer(), 6773, Emotion.DEFAULT, "Yes! I roam the world sensing danger.");
			setNext(7);
			break;
		case 7:
			DialogueManager.sendNpcChat(getPlayer(), 6773, Emotion.DEFAULT, "If i find a dangerous area, then I put up warning", "signs that will tell you what is so dangerous about that", "area.");
			setNext(8);
			break;
		case 8:
			DialogueManager.sendNpcChat(getPlayer(), 6773, Emotion.DEFAULT, "If you see the signs ofen enough, then you can turn", "them off; by that time you likely know what the area","has in store for you.");
			setNext(9);
			break;
		case 9:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "But what if I want to see the warnings again?");
			setNext(10);
			break;
		case 10:
			DialogueManager.sendNpcChat(getPlayer(), 6773, Emotion.DEFAULT, "That's why I'm waiting here!");
			setNext(11);
			break;
		case 11:
			DialogueManager.sendNpcChat(getPlayer(), 6773, Emotion.DEFAULT, "If you want to see the warning messages again, I can", "turn them back on for you.");
			setNext(12);
			break;
		case 12:
			DialogueManager.sendNpcChat(getPlayer(), 6773, Emotion.DEFAULT, "Do you need to turn on any warnings right now?");
			setNext(13);
			break;
		case 13:
			DialogueManager.sendOption(getPlayer(), "Yes, I do.", "Not right now.");
			break;
		case 14:
			getPlayer().getPA().showInterface(33924);
			end();
			break;
		case 15:
			DialogueManager.sendNpcChat(getPlayer(), 6773, Emotion.DEFAULT, "Ok, keep an eye out for the message though!");
			setNext(16);
			break;
		case 16:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "I will.");
			setNext(17);
			break;
		case 17:
			getPlayer().getPA().closeAllWindows();
			end();
			break;
		}

	}
	@Override
	public boolean clickButton(int id) {
		switch(id) {
		case DialogueConstants.OPTIONS_2_1:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "Yes, I do.");
			setNext(14);
			break;
		case DialogueConstants.OPTIONS_2_2:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "Not right now.");
			setNext(15);
			break;
		}
		return false;
		
	}

}
