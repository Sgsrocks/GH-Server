package godzhell.model.content.dialogue.impl;

import godzhell.model.content.dialogue.Dialogue;
import godzhell.model.content.dialogue.DialogueConstants;
import godzhell.model.content.dialogue.DialogueManager;
import godzhell.model.content.dialogue.Emotion;

public class TownCrierDialogue extends Dialogue {
    @Override
    public void execute() {
        switch (getNext()) {
            case 0:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.CALM, "Hello citizen!");
                setNext(1);
                break;
            case 1:
                DialogueManager.sendOption(getPlayer(), "What do you do around here?", "See you later.");
                break;
            case 2:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.CALM, "I'm a Town Crier. It's my job to let people know of", "any recent news. After all, there's all sorts of things", "happening around here.");
                setNext(3);
                break;
            case 3:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "I see. See you later.");
                setNext(4);
                break;
            case 4:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.CALM, "Until next time.");
                setNext(5);
                break;
            case 5:
                end();
                getPlayer().getPA().closeAllWindows();
                break;
        }
    }

    @Override
    public boolean clickButton(int id) {
        switch (id) {
            case DialogueConstants.OPTIONS_2_1:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "What do you do around here?");
                setNext(2);
                break;
            case DialogueConstants.OPTIONS_2_2:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "See you later.");
                setNext(4);
                break;
        }
        return false;
    }
}
