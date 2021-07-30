package ethos.model.content.dialogue.impl.teleports;

import ethos.model.content.dialogue.Dialogue;
import ethos.model.content.dialogue.DialogueConstants;
import ethos.model.content.dialogue.DialogueManager;
import ethos.model.items.impl.Teles;

public class RodDialogue extends Dialogue {
    @Override
    public void execute() {
        switch(getNext()){
            case 0:
                DialogueManager.sendOption(getPlayer(), "Al kharid Duel Arena.", "Castle Wars Arena.", "Ferox Enclave.", "Nowhere.");
                break;
        }
    }
    @Override
    public boolean clickButton(int id) {
        switch(id) {
            case DialogueConstants.OPTIONS_4_1:
                getPlayer().getPlayerAssistant().startTeleport(3313, 3234, 0, "glory", false);
                Teles.necklaces(getPlayer());
                end();
                break;
            case DialogueConstants.OPTIONS_4_2:
                getPlayer().getPlayerAssistant().startTeleport(2441, 3090, 0, "glory", false);
                Teles.necklaces(getPlayer());
                end();
                break;
            case DialogueConstants.OPTIONS_4_3:
                getPlayer().getPlayerAssistant().startTeleport(3150,3635, 0, "glory", false);
                Teles.necklaces(getPlayer());
                end();
                break;
            case DialogueConstants.OPTIONS_4_4:
                getPlayer().getPA().closeAllWindows();
                end();
                break;
        }
        return false;
    }
}
