package ethos.model.content.dialogue.impl.Falador;

import ethos.model.content.dialogue.Dialogue;
import ethos.model.content.dialogue.DialogueManager;
import ethos.model.content.dialogue.Emotion;

public class ThurgoDialogue extends Dialogue {

	public ThurgoDialogue() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		switch(getNext()) {
		case 0:
			if (player.knightS == 2) {
				if (player.getItems().playerHasItem(2325, 1)) {
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.DEFAULT, "Hello. Are you an Imcando dwarf?");
			setNext(1);
				} else if (!player.getItems().playerHasItem(2325, 1)) {
					DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.ANGRY_1, "I am not interested in talking to you right now.");
					setNext(3);
				}
			} else if (player.knightS == 3) {
				DialogueManager.sendPlayerChat(getPlayer(), Emotion.DEFAULT, "Can you make a special sword?");
				setNext(8);
			} else if (player.knightS == 6) {
				DialogueManager.sendPlayerChat(getPlayer(), Emotion.DEFAULT, "I have found a picture of the sword I would like you to", "make.");
				setNext(13);
			} else if (player.knightS == 7) {
				DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.HAPPY, "How are you doing finding those sword materials?");
				setNext(21);
			} else if (player.knightS == 8) {
				DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.HAPPY, "How are you doing finding those sword materials?");
				setNext(25);
			}
			break;
		case 1:
			DialogueManager.sendNpcChat(player, getPlayer().getNpcClickIndex(), Emotion.DEFAULT, "Maybe. Who wants to know?");
			setNext(2);
			break;
		case 2:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.DEFAULT, "Would you like some redberry pie?");
			setNext(4);
			break;
		case 3:
			getPlayer().getPA().closeAllWindows();
			end();
			break;
		case 4:
			DialogueManager.sendStatement(getPlayer(), "You see Thurgo's eyes light up.");
			setNext(5);
			break;
		case 5:
		DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.HAPPY, "I'd never say no to a redberry pie! They're GREAT", "stuff!");
		setNext(6);
			break;
		case 6:
			if (player.getItems().playerHasItem(2325, 1)) {
				DialogueManager.sendStatement(getPlayer(), "You hand over the pie. Thurgo eats the pie. Thurgo pats his", "stomach.");
				player.getItems().deleteItem2(2325, 1);
				setNext(7);
			} else {
				DialogueManager.sendPlayerChat(getPlayer(), Emotion.SAD, "I don't have pie anymore.");
				setNext(3);
			}
			break;
		case 7:
		DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.HAPPY,"By Guthix! THAT was a good pie! Anyone who makes", "pie like THAT has got to be alright!");
		player.knightS = 3;
		setNext(3);
			break;
		case 8:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.HAPPY, "Well, after bringing me my favorite food I guess I", "should give it a go. What sort of sword is it?");
			setNext(9);
			break;
		case 9:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.DEFAULT, "I need you to make a sword for one of Falador's", "knights. He had one which was passed down through five", "generations, but his squire lost it. So we need an", "identical one to replace it.");
			setNext(10);
			break;
		case 10:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.HAPPY, "A knight's sword eh? Well I'd need to know exactly", "how it looked before I could make a new one.");
			setNext(11);
			break;
		case 11:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.HAPPY, "All the Faladorian knights used to have sword with", "unique designs according to their position. Could you bring me", "a picture or something?");
			setNext(12);
			break;
		case 12:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.DEFAULT, "I'll go ask his squire and see if I can find one.");
			player.knightS = 4;
			setNext(3);
			break;
		case 13:
			DialogueManager.sendStatement(getPlayer(), "You give the portrait to Thurgo. Thurgo studies the portrait.");
			player.getItems().deleteItem2(666, 1);
			setNext(14);
			break;
		case 14:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.HAPPY, "Ok. You'll need to get me some stuff in order for me", "to make this.");
			setNext(15);
			break;
		case 15:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.HAPPY, "I'll need two iron bars to make the sword to start with.", "I'll also need an ore called blurite. It's useless for", "making actual weapons for fighting with except", "crossbows, but I'll need some as decoration for the hilt.");
			setNext(16);
			break;
		case 16:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.HAPPY, "It is a fairly rare sort of ore... The only place I know", "where to get it is under the cliff here...");
			setNext(17);
			break;
		case 17:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.HAPPY, "But it is guarded by a very powerful ice giant.");
			setNext(18);
			break;
		case 18:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.HAPPY, "Most of the rocks in that cliff are pretty useless, and", "don't contain much of anything, but there's", "DEFINITELY some blurite in there.");
			setNext(19);
			break;
		case 19:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.HAPPY, "You'll need a little bit of mining experience to be able to", "find it.");
			player.knightS = 7;
			setNext(20);
			break;
		case 20:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.DEFAULT, "Ok. I'll go and find them then.");
			setNext(3);
			break;
		case 21:
			if (player.getItems().playerHasItem(2351, 2) && player.getItems().playerHasItem(668, 1)) {
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.DEFAULT, "I have them right here.");
			setNext(22);
			} else {
				DialogueManager.sendPlayerChat(getPlayer(), Emotion.DEFAULT, "I'm still working on it.");
				setNext(3);
			}
			break;
		case 22:
			if (player.knightS == 7) {
				DialogueManager.sendStatement(player,"You give the blurite ore and two bars to Thurgo. Thurgo starts", "to make the sword. Thurgo hands you a sword.");
				player.getItems().deleteItem2(2351, 1);
				player.getItems().deleteItem2(2351, 1);
				player.getItems().deleteItem2(668, 1);
				player.knightS = 8;
				player.getItems().addItem(667, 1);
				setNext(23);
			} else if (player.knightS == 8) {
				DialogueManager.sendStatement(player,"You give the blurite ore and two bars to Thurgo. Thurgo starts", "to make the sword. Thurgo hands you a sword.");
				player.getItems().deleteItem2(2351, 1);
				player.getItems().deleteItem2(2351, 1);
				player.getItems().deleteItem2(668, 1);
				player.getItems().addItem(667, 1);
				setNext(23);
			} else {
				setNext(3);
			}
			break;
		case 23:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.DEFAULT, "Thank you very much!");
			setNext(24);
			break;
		case 24:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.HAPPY, "Just remember to call in with more pie some time!");
			setNext(3);
			break;
		case 25:
			if(player.getItems().playerHasItem(667, 1)) {
				DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.HAPPY, "You should bring the Squire that sword.");
				setNext(3);
		} else {
				DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.HAPPY, "Did the sword work?");
				setNext(26);
			}
			break;
		case 26:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.DEFAULT, "I've seemed to have lost my sword.", "Can you make me another?");
			setNext(27);
			break;
		case 27:
			if (player.getItems().playerHasItem(2351, 2) && player.getItems().playerHasItem(668, 1)){
				DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.HAPPY,"Sure, just let me see that blurite, and iron bars.");
				setNext(28);
			} else {
				DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.HAPPY,"Sure, but you need to get more", "blurite ore, and iron bars.");
				setNext(3);
			}
			break;
		case 28:
			DialogueManager.sendStatement(getPlayer(), "You give the bluerite ore and two bars to Thurgo");
			player.getItems().deleteItem(2351, 1);
			player.getItems().deleteItem(2351, 1);
			player.getItems().deleteItem(668, 1);
			setNext(29);
			break;
		case 29:
			DialogueManager.sendStatement(getPlayer(), "Thurgo starts to make the sword");
			setNext(30);
			break;
		case 30:
			DialogueManager.sendStatement(getPlayer(), "Thurgo hands you the sword");
			player.getItems().addItem(667, 1);
			setNext(31);
			break;
		case 31:
			DialogueManager.sendPlayerChat(getPlayer(), Emotion.DEFAULT, "Thank you very much!");
			setNext(32);
			break;
		case 32:
			DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.HAPPY, "Just remember to call in with more pie some time!");
			setNext(3);
			break;
		}

	}

}
