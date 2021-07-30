package ethos.model.content.dialogue.impl.teleports;

import ethos.model.content.dialogue.Dialogue;
import ethos.model.content.dialogue.DialogueConstants;
import ethos.model.content.dialogue.DialogueManager;
import ethos.model.content.dialogue.Emotion;
import ethos.model.items.impl.Teles;

public class AogDialogue  extends Dialogue {
    @Override
    public void execute() {
        switch(getNext()){
            case 0:
                DialogueManager.sendOption(getPlayer(), "Edgeville", "Al-Kharid", "Karamja", "Draynor");
                break;
        }
    }
    @Override
    public boolean clickButton(int id) {
        switch(id) {
            case DialogueConstants.OPTIONS_4_1:
                getPlayer().getPlayerAssistant().startTeleport(3088, 3500, 0, "glory", false);
                Teles.necklaces(getPlayer());
                end();
                break;
            case DialogueConstants.OPTIONS_4_2:
                getPlayer().getPlayerAssistant().startTeleport(3293, 3174, 0, "glory", false);
                Teles.necklaces(getPlayer());
                end();
                break;
            case DialogueConstants.OPTIONS_4_3:
                getPlayer().getPlayerAssistant().startTeleport(2911, 3152, 0, "glory", false);
                Teles.necklaces(getPlayer());
                end();
                break;
            case DialogueConstants.OPTIONS_4_4:
                getPlayer().getPlayerAssistant().startTeleport(3103, 3249, 0, "glory", false);
                Teles.necklaces(getPlayer());
                end();
                break;
        }
        return false;
    }
}
