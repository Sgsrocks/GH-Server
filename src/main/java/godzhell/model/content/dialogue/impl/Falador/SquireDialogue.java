package godzhell.model.content.dialogue.impl.Falador;

import godzhell.model.content.dialogue.Dialogue;
import godzhell.model.content.dialogue.DialogueConstants;
import godzhell.model.content.dialogue.DialogueManager;
import godzhell.model.content.dialogue.Emotion;
import godzhell.model.content.quests.QuestAssistant;
import godzhell.model.content.quests.QuestRewards;

public class SquireDialogue extends Dialogue {

	public SquireDialogue() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		switch (getNext()) {
		case 0:
			if (getPlayer().knightS == 0) {
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.DEFAULT, "Hello. I am the squire to Sir Vyvin.");
			setNext(1);
			} else if (getPlayer().knightS == 4) {
				DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.DEFAULT, "So how are you doing getting the sword?");
				setNext(14);
			} else if (getPlayer().knightS == 8) {
				DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY,"I have retrieved your sword for you.");
				setNext(18);
			}
			break;
		case 1:
			DialogueManager.sendOption(getPlayer(), "And how is life as a squire?", "Wouldn't you prefer to be a squire for me?");
			break;
		case 2:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.SAD, "Well, Sir Vyvin is a good guy to work for, however,", "I'm in a spot of trouble today. I've gone and lost Sir", "Vyvin's sword!");
			setNext(3);
			break;
		case 3:
			DialogueManager.sendOption(getPlayer(), "Do you know where you lost it?", "I can make a new sword if you like...", "Is he angry?");
			break;
		case 4:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.SAD, "No, I was hoping someone could help me find it though.");
			setNext(5);
			break;
		case 5:
			getPlayer().getPA().closeAllWindows();
			end();
			break;
		case 6:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.CALM, "Thanks for the offer. I'd be surprised if you could", "though.");
			setNext(7);
			break;
		case 7:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.CALM, "The thing is, this sword is a family heirloom. It has been", "passed down through Vyvin's family for five", "generations! It was originally made by the Imacando", "dwarves, who were");
			setNext(8);
			break;
		case 8:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.CALM, "a particularly skilled tribe of dwarven smiths.", "I doubt anyone could make it in the style they do.");
			setNext(9);
			break;
		case 9:
			DialogueManager.sendOption(getPlayer(), "So would these dwarves make another one?", "Well I hope you find it soon.");
			break;
		case 10:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.CALM, "I'm not a hundred percent sure the Imacando tribe", "exists anymore. I should think Reldo, the palace", "librarian will know; he has done a lot of", "research on the races of Ghreborn.");
			setNext(11);
			break;
		case 11:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.CALM, "I don't suppose you could try and track down the", "Imcando dwarves for me? I've got so much work to", "do...");
			setNext(12);
			break;
		case 12:
			DialogueManager.sendOption(getPlayer(), "Ok, I'll give it a go.", "No, I've got lots of mining work to do.");
			break;
		case 13:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.CALM, "Thank you very much! As I say, the best place to start", "should be with Reldo...");
			setNext(5);
			break;
		case 14:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "I've found an Imcando dwarf but he needs a picture of", "the sword before he can make it.");
			setNext(15);
			break;
		case 15:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.CALM, "A picture eh? Hmmm.... The only one I can think of is", "in a small portrait of Sir Vyvin's father... Sir Vyvin", "keeps it in a cupboard in his room I think.");
			setNext(16);
			break;
		case 16:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Ok, I'll try and get that then.");
			setNext(17);
			break;
		case 17:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.CALM, "Please don't let him catch you! He MUSTN'T know", "what happened!");
			getPlayer().knightS = 5;
			setNext(5);
			break;
		case 18:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.CALM, "Thank you, thank you, thank you! I was seriously", "worried I would have to own up to Sir Vyvin!");
			setNext(19);
			break;
		case 19:
			DialogueManager.sendStatement(player, "You give the sword to the squire.");
			player.getItems().deleteItem2(667, 1);
			player.knightS = 8;
			setNext(20);
			break;
		case 20:
			QuestRewards.knightsReward(player);
			end();
			break;
		}
	}
	@Override
	public boolean clickButton(int id) {
		switch(id) {
		case DialogueConstants.OPTIONS_2_1:
			if(getNext() == 1) {
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "And how is life as a squire?");
			setNext(2);
			} else if(getNext() == 9) {
				DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "So would these dwarves make another one?");
				setNext(10);
			} else if(getNext() == 12) {
				DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Ok, I'll give it a go.");
				getPlayer().knightS = 1;
			    QuestAssistant.sendStages(getPlayer());
				setNext(13);
			}
			break;
		case DialogueConstants.OPTIONS_2_2:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Sorry i don't want to talk to you actually.");
			setNext(3);
			break;
		case DialogueConstants.OPTIONS_3_1:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY,"Do you know where you lost it?");
			setNext(4);
			break;
		case DialogueConstants.OPTIONS_3_2:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY,"I can make a new sword if you like...");
			setNext(6);
			break;
		}
		return false;
	}

}
