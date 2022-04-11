package godzhell.model.content.dialogue.impl.bosses;

import godzhell.model.content.dialogue.Dialogue;
import godzhell.model.content.dialogue.DialogueConstants;
import godzhell.model.content.dialogue.DialogueManager;
import godzhell.model.content.dialogue.Emotion;

public class ZulrahDialogue extends Dialogue {

    @Override
    public void execute() {
        switch(getNext()){
            case 0:
                DialogueManager.sendNpcChat(getPlayer(), 2040, Emotion.DEFAULT, "Hello " + getPlayer().playerName + ".", "Are you looking to fight Zulrah?");
                setNext(1);
                break;
            case 1:
                DialogueManager.sendOption(getPlayer(), "Yes, take me there.", "No, I was hoping to get my items back.",
                        "No, I was wondering who holds the current record.", "Nevermind");
                break;
            case 2:
                end();
                getPlayer().getPA().closeAllWindows();
                break;
            case 3:
                DialogueManager.sendOption(getPlayer(), "Yes", "No");
                break;
        }
    }
    @Override
    public boolean clickButton(int id) {
        switch(id) {
            case DialogueConstants.OPTIONS_4_1:
                if (getPlayer().getZulrahLostItems().size() > 0) {
                    DialogueManager.sendNpcChat(getPlayer(), 2040, Emotion.DEFAULT, "You need to retain all of your lost items before you", "can go in again.");
                    setNext(2);
                } else {
                    if (getPlayer().getZulrahEvent().isActive()) {
                        DialogueManager.sendStatement(getPlayer(), "It seems that a zulrah instance for you is already created.", "If you think this is wrong then please re-log.");
                        setNext(2);
                        return false;
                    }
                    getPlayer().getZulrahEvent().initialize();
                }
                break;
            case DialogueConstants.OPTIONS_4_2:
                if (getPlayer().getZulrahLostItems().size() == 0) {
                    DialogueManager.sendNpcChat(getPlayer(), 2040, Emotion.DEFAULT, "You don't have any items that are lost.");
                    setNext(2);
                } else {
                    DialogueManager.sendNpcChat(getPlayer(), 2040, Emotion.DEFAULT, "So you want to claim your lost items.", "It will cost a total of 500,000GP for all the items.",
                            "Do you want them back?");
                    setNext(3);
                }
                break;
            case DialogueConstants.OPTIONS_2_1:
                if (getPlayer().getZulrahLostItems().size() > 0) {
                    getPlayer().getZulrahLostItems().retain();
                    end();
                    getPlayer().getPA().closeAllWindows();
                }
                break;
            case DialogueConstants.OPTIONS_2_2:
                end();
                getPlayer().getPA().closeAllWindows();
                break;
        }
        return false;
    }
}
