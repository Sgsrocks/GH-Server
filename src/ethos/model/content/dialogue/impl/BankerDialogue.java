package ethos.model.content.dialogue.impl;

import ethos.model.content.BankPin;
import ethos.model.content.dialogue.Dialogue;
import ethos.model.content.dialogue.DialogueConstants;
import ethos.model.content.dialogue.DialogueManager;
import ethos.model.content.dialogue.Emotion;

public class BankerDialogue extends Dialogue {


	@Override
	public void execute() {
		switch (getNext()) {
		case 0:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.DEFAULT, "Good day, how may I help you?");
			setNext(1);
			break;
		case 1:
			DialogueManager.sendOption(getPlayer(), "I'd like to access my bank account, please.", "I'd like to check my PIN settings.", "I'd like to collect items.", "What is this place?");
			break;
			case 2:
				DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.DEFAULT, "This is a branch of the Bank of Ghreborn.", "We have branches in many towns.");
				setNext(3);
				break;
			case 3:
				DialogueManager.sendPlayerChat(getPlayer(), Emotion.DEFAULT, "And what do you do?");
				setNext(4);
				break;
			case 4:
				DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.DEFAULT, "We will look after your items and money for you. ", "Leave your valuables with us if you want to keep them safe.");
				setNext(5);
				break;
			case 5:
				end();
				break;
		}

	}
	@Override
	public boolean clickButton(int id) {
		switch(id) {
		case DialogueConstants.OPTIONS_4_1:
			getPlayer().getPA().openUpBank();
			break;
		case DialogueConstants.OPTIONS_4_2:
			getPlayer().getBankPin().bankPinSettings();
			break;
			case DialogueConstants.OPTIONS_4_3:
				DialogueManager.sendStatement(getPlayer(), "The G.E is not added yet.");
				setNext(5);
				break;
			case DialogueConstants.OPTIONS_4_4:
				DialogueManager.sendPlayerChat(getPlayer(), Emotion.DEFAULT, "What is this place?");
				setNext(2);
				break;
		}
		return false;
	}
}
