package godzhell.model.content.dialogue.impl.Varrock;

import godzhell.model.content.dialogue.Dialogue;
import godzhell.model.content.dialogue.DialogueConstants;
import godzhell.model.content.dialogue.DialogueManager;
import godzhell.model.content.dialogue.Emotion;

public class ReldoDIalogue extends Dialogue {

	public ReldoDIalogue() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		switch(getNext()) {
		case 0:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.DEFAULT, "Hello stranger.");
			setNext(1);
			break;
		case 1:
			if (player.knightS == 1) {
			DialogueManager.sendOption(getPlayer(), "Do you have anything to trade?", "What do you do?", "What do you know about the Imcando Dwarves?");
			} else {
			DialogueManager.sendOption(getPlayer(), "Do you have anything to trade?", "What do you do?");
			}
			break;
		case 2:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.DEFAULT, "I do not have anything to trade, sorry.");
			setNext(3);
			break;
		case 3:
			getPlayer().getPA().closeAllWindows();
			end();
			break;
		case 4:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.DEFAULT, "I work here as a librarian.");
			setNext(3);
			break;
		case 5:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.DEFAULT, "The imcando dwarves, you say?");
			setNext(6);
			break;
		case 6:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.DEFAULT, "Ah yes... for many hundreds of years they were the", "world's most skilled smiths. They used secret smithing", "knowledge passed down from generation to generation.");
			setNext(7);
			break;
		case 7:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.DEFAULT, "Unfortunately, about century ago, the once thriving", "race was wiped out during the barbarian invasions of", "that time.");
			setNext(8);
			break;
		case 8:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.DEFAULT, "So are there any Imcando left at all?");
			setNext(9);
			break;
		case 9:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.DEFAULT, "I believe a few of them survived, but with the bulk of", "their population destroyed their numbers have dwindled", "even further.");
			setNext(10);
			break;
		case 10:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.DEFAULT, "I believe I remember a couple living in Asgarnia near", "the cliffs on the Asgarnian southern peninsula, but they", "DO tend to keep to themselves.");
			setNext(11);
			break;
		case 11:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.DEFAULT, "They tend not to tell people they're the", "descendents of the Imcando, which is why people think", "that the tribe has died out totally, but you may well", "have more luck talking to them if you bring them some");
			setNext(12);
			break;
		case 12:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.DEFAULT, "redberry pie. They REALLY like redberry pie.");
			setNext(13);
			break;
		case 13:
			getPlayer().knightS = 2;
			getPlayer().getPA().closeAllWindows();
			end();
		break;
		}
	}
	@Override
	public boolean clickButton(int id) {
		switch(id) {
		case DialogueConstants.OPTIONS_2_1:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.DEFAULT, "Do you have anything to trade?");
			setNext(2);
			break;
		case DialogueConstants.OPTIONS_2_2:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.DEFAULT,  "What do you do?");
			setNext(4);
			break;
		case DialogueConstants.OPTIONS_3_1:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.DEFAULT, "Do you have anything to trade?");
			setNext(2);
			break;
		case DialogueConstants.OPTIONS_3_2:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.DEFAULT,  "What do you do?");
			setNext(4);
			break;
		case DialogueConstants.OPTIONS_3_3:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.DEFAULT,  "What do you know about the Imcando dwarves?");
			setNext(5);
			break;
		}
		return false;
	}

}
