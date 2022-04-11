package godzhell.model.content.dialogue.impl.teleports;

import godzhell.model.content.dialogue.Dialogue;
import godzhell.model.content.dialogue.DialogueConstants;
import godzhell.model.content.dialogue.DialogueManager;
import godzhell.model.content.dialogue.Emotion;
import godzhell.model.items.impl.Teles;

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
