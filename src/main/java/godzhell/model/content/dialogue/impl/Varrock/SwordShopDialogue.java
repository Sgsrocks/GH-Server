package godzhell.model.content.dialogue.impl.Varrock;

import godzhell.Config;
import godzhell.model.content.dialogue.Dialogue;
import godzhell.model.content.dialogue.DialogueConstants;
import godzhell.model.content.dialogue.DialogueManager;
import godzhell.model.content.dialogue.Emotion;

public class SwordShopDialogue extends Dialogue {
    @Override
    public void execute() {
        switch(getNext()){
            case 0:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.CALM, "Hello, bold adventurer! Can I interest you in some ", "swords?");
                setNext(1);
                break;
            case 1:
                DialogueManager.sendOption(getPlayer(), "Yes, please!", "No, I'm okay for swords right now.");
                break;
            case 2:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.CALM, "Come back if you need any.");
                setNext(3);
                break;
            case 3:
                end();
                getPlayer().getPA().closeAllWindows();
                break;

        }
    }

    @Override
    public boolean clickButton(int id) {
        switch (id) {
            case DialogueConstants.OPTIONS_2_1:
                getPlayer().getShops().openShop(Config.VARROCK_SWORDSHOP);
                break;
            case DialogueConstants.OPTIONS_2_2:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "No, I'm okay for swords right now.");
                setNext(2);
                break;
        }
        return false;
    }
}
