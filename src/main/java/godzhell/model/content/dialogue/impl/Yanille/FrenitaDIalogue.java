package godzhell.model.content.dialogue.impl.Yanille;

import godzhell.Config;
import godzhell.model.content.dialogue.Dialogue;
import godzhell.model.content.dialogue.DialogueConstants;
import godzhell.model.content.dialogue.DialogueManager;
import godzhell.model.content.dialogue.Emotion;

public class FrenitaDIalogue extends Dialogue {

    @Override
    public void execute() {
        switch(getNext()){
            case 0:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().getNpcClickIndex(), Emotion.DEFAULT, "Would you like to buy some cooking equipment?");
                setNext(1);
                break;
            case 1:
                DialogueManager.sendOption(getPlayer(), "Yes please.", "No thank you.");
                break;
            case 2:
                end();
                player.getPA().closeAllWindows();
                break;
        }
    }
    @Override
    public boolean clickButton(int id) {
        switch (id) {
            case DialogueConstants.OPTIONS_2_1:
                getPlayer().getShops().openShop(Config.FRENITAS_COOKERY_SHOP);
                break;
            case DialogueConstants.OPTIONS_2_2:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.DEFAULT, "No thank you.");
                setNext(2);
                break;
        }
        return false;
    }
}
