package godzhell.model.content.dialogue.impl.Falador;

import godzhell.model.content.dialogue.Dialogue;
import godzhell.model.content.dialogue.DialogueConstants;
import godzhell.model.content.dialogue.DialogueManager;
import godzhell.model.content.dialogue.Emotion;
import godzhell.model.content.quests.QuestAssistant;
import godzhell.model.content.quests.QuestRewards;

public class DoricDialogue extends Dialogue {

	@Override
	public void execute() {
		switch(getNext()) {
		case 0:
			if (getPlayer().doricQuest == 0) {
				DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.CALM, "Hello traveler, what brings you to my humble smithy?");
				setNext(1);
			} else if (getPlayer().doricQuest == 1) {
				if (getPlayer().getItems().playerHasItem(434, 6)
						&& getPlayer().getItems().playerHasItem(436, 4)
						&& getPlayer().getItems().playerHasItem(440, 2)) {
				DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "Here's all the items!");
				setNext(7);
				} else {
					DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "I don't have all the items yet.");
					setNext(11);
				}
			} else if (getPlayer().doricQuest == 2) {
				DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "So do I get to go to the Duke's Party?");
				setNext(12);
			} else if (getPlayer().doricQuest == 3) {
				DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.DEFAULT, "Thanks for the help!");
				setNext(8);
			}
			break;
		case 1:
			DialogueManager.sendOption(getPlayer(),"Mind your own buisness, Shortstuff!",
					"I wanted to use your anivils.");
			break;
		case 2:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "Yes, I would like to use your anivil.");
			setNext(3);
			break;
		case 3:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.CALM, "My anvils get enough work with my own use.",
					"I make pickaxes, and it takes a lot of hard work.",
					"If you could get me some more materials,",
					"then i could let use them.");
			setNext(4);
			break;
		case 4:
			DialogueManager.sendOption(getPlayer(),"Yes i will get you the materials.",
					"No, hitting rocks is boring.");
			break;
		case 5:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.CALM, "Clay is what i use more than anything, to make casts.",
					"Could you get me 6 clay, 4 copper, and 2 iron, please?",
					"I could give a nice little reward",
					"Take my pickaxe with you just incase you need it.");
			getPlayer().getItems().addOrDropItem(1265, 1);
			setNext(6);
			break;
		case 6:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "Certainly, I'll be right back!");
			getPlayer().doricQuest = 1;
			QuestAssistant.sendStages(getPlayer());
			setNext(8);
			break;
		case 7:
			getPlayer().getItems().deleteItem2(434, 6);
			getPlayer().getItems().deleteItem2(436, 4);
			getPlayer().getItems().deleteItem2(440, 2);
			getPlayer().doricQuest = 2;
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.CALM, "You brought me everything I need.",
					"Thank You!");
			setNext(9);
			break;
		case 8:
			getPlayer().getPA().closeAllWindows();
			end();
			break;
		case 9:
			QuestRewards.doricFinish(getPlayer());
			end();
			break;
		}

	}
	@Override
	public boolean clickButton(int id) {
		
		switch(id) {
		case DialogueConstants.OPTIONS_2_1://fishing guild
			if(getNext() == 1) {
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.CALM, "Mind your own buisness, Shortstuff!");
			setNext(8);
			} else if(getNext() == 4) {
				DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "Yes i will get you the materials.");
				setNext(5);
			}
				break;
		case DialogueConstants.OPTIONS_2_2://fishing guild
			if(getNext() == 1) {
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.CALM, "So you want to use my anivils?");
			setNext(2);
			} else if(getNext() == 4) {
				DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "No, hitting rocks is boring.");
				setNext(8);
			}
				break;
		}
		return false;
	}

}
