package ethos.model.content.dialogue.impl.wizard_tower;

import ethos.model.content.dialogue.Dialogue;
import ethos.model.content.dialogue.DialogueConstants;
import ethos.model.content.dialogue.DialogueManager;
import ethos.model.content.dialogue.Emotion;
import ethos.model.content.quests.QuestAssistant;
import ethos.model.content.quests.QuestRewards;

public class MizgagDialogue  extends Dialogue {
    @Override
    public void execute() {
    switch(getNext()){
        case 0:
    if(getPlayer().impsC == 0){
        DialogueManager.sendPlayerChat(getPlayer(), Emotion.DEFAULT, "Give me a quest!");
        setNext(1);
    } else if(getPlayer().impsC == 1 && !player.getItems().playerHasItem(1470, 1)
            && !player.getItems().playerHasItem(1472, 1)
            && !player.getItems().playerHasItem(1474, 1)
            && !player.getItems().playerHasItem(1476, 1)){
        DialogueManager.sendNpcChat(getPlayer(), 7746, Emotion.DEFAULT, "So how are you doing finding my beads?");
        setNext(10);
    } else if (player.impsC == 1 && player.getItems().playerHasItem(1470, 1)
            && player.getItems().playerHasItem(1472, 1)
            && player.getItems().playerHasItem(1474, 1)
            && player.getItems().playerHasItem(1476, 1)) {
        DialogueManager.sendNpcChat(getPlayer(), 7746, Emotion.DEFAULT, "So how are you doing finding my beads?");
        setNext(11);
    }
    break;
        case 1:
            DialogueManager.sendNpcChat(getPlayer(), 7746, Emotion.DEFAULT, "Give me a quest what?");
            setNext(2);
            break;
        case 2:
            DialogueManager.sendPlayerChat(getPlayer(), Emotion.DEFAULT, "Give me a quest please.");
            setNext(3);
            break;
        case 3:
            DialogueManager.sendNpcChat(getPlayer(), 7746, Emotion.DEFAULT, "Well seeing as you asked nicely... I could do with some",
                    "help.");
            setNext(4);
            break;
        case 4:
            DialogueManager.sendNpcChat(getPlayer(), 7746, Emotion.DEFAULT, "The wizard Grayzag next door decided he didn't like",
                    "me so he enlisted an army of hundreds of imps.");
            setNext(5);
            break;
        case 5:
            DialogueManager.sendNpcChat(getPlayer(), 7746, Emotion.DEFAULT, "These imps stole all sorts of my things. Most of these",
                    "things I don't really care about, just eggs and balls of",
                    "string and things.");
            setNext(6);
            break;
        case 6:
            DialogueManager.sendNpcChat(getPlayer(), 7746, Emotion.DEFAULT, "But they stole my four magical beads. There was a red",
                    "one, a yellow one, a black one, and a white one.");
            setNext(7);
            break;
        case 7:
            DialogueManager.sendNpcChat(getPlayer(), 7746, Emotion.DEFAULT,"These imps have now spread out all over the kingdom.",
                    "Could you get my beads back for me?");
            setNext(8);
            break;
        case 8:
            DialogueManager.sendOption(getPlayer(), "I'll try.",
                    "I've better things to do than chase imps.");
            break;
        case 9:
            DialogueManager.sendNpcChat(getPlayer(), 7746, Emotion.DEFAULT,"That's great, thank you.");
            setNext(200);
            break;
        case 10:
            DialogueManager.sendPlayerChat(getPlayer(), Emotion.DEFAULT, "I am still working on it.");
            setNext(200);
            break;
        case 11:
            DialogueManager.sendPlayerChat(getPlayer(), Emotion.DEFAULT, "I've got all four beads. It was hard work I can tell you.");
            setNext(12);
            break;
        case 12:
            DialogueManager.sendNpcChat(getPlayer(), 7746, Emotion.DEFAULT, "Give them here and I'll check that really are MY",
                    "beads, before I give you your reward. You'll take it, it's",
                    "an amulet of accuracy.");
            setNext(13);
            break;
        case 13:
            DialogueManager.sendStatement(getPlayer(), "You give four coloured beads to Wizard Mizgog.");
            if (player.getItems().playerHasItem(1470, 1)
                    && player.getItems().playerHasItem(1472, 1)
                    && player.getItems().playerHasItem(1474, 1)
                    && player.getItems().playerHasItem(1476, 1)) {
                player.getItems().deleteItem(1470, 1);
                player.getItems().deleteItem(1472, 1);
                player.getItems().deleteItem(1474, 1);
                player.getItems().deleteItem(1476, 1);
                player.impsC = 2;
                setNext(14);
            } else {
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.DEFAULT, "I am still working on it.");
                setNext(200);
            }
            break;
        case 14:
            QuestRewards.impFinish(player);
            end();
            break;
        case 200:
            getPlayer().getPA().closeAllWindows();
            end();
            break;
    }
    }
    @Override
    public boolean clickButton(int id) {
        switch(id) {
            case DialogueConstants.OPTIONS_2_1:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.DEFAULT, "I'll try.");
                getPlayer().impsC = 1;
                QuestAssistant.sendStages(getPlayer());
                setNext(9);
                break;
            case DialogueConstants.OPTIONS_2_2:
                getPlayer().getBankPin().bankPinSettings();
                break;
        }
        return false;
    }
}
