package godzhell.model.content.dialogue.impl;

import godzhell.model.content.dialogue.Dialogue;
import godzhell.model.content.dialogue.DialogueConstants;
import godzhell.model.content.dialogue.DialogueManager;

public class altarDialogue extends Dialogue {
    @Override
    public void execute() {
        switch (getNext()) {
            case 0:
                DialogueManager.sendOption(getPlayer(),"Standard spellbook", "Ancient Magicks", "Lunar spellbook", "Arceuus spellbook");
                break;
            case 1:
                getPlayer().getPA().closeAllWindows();
                end();
                break;
        }
    }
    @Override
    public boolean clickButton(int id) {
        switch(id) {
            case DialogueConstants.OPTIONS_4_1:
                getPlayer().setSidebarInterface(6, 1151);
                getPlayer().playerMagicBook = 0;
                getPlayer().autocasting = false;
                getPlayer().autocastId = -1;
                getPlayer().getPA().resetAutocast();
                getPlayer().getPA().closeAllWindows();
                end();
                break;
            case DialogueConstants.OPTIONS_4_2:
                getPlayer().setSidebarInterface(6, 12855);
                getPlayer().playerMagicBook = 1;
                getPlayer().autocasting = false;
                getPlayer().autocastId = -1;
                getPlayer().getPA().resetAutocast();
                getPlayer().getPA().closeAllWindows();
                end();
                break;
            case DialogueConstants.OPTIONS_4_3:
                getPlayer().setSidebarInterface(6, 29999);
                getPlayer().playerMagicBook = 2;
                getPlayer().autocasting = false;
                getPlayer().autocastId = -1;
                getPlayer().getPA().resetAutocast();
                getPlayer().getPA().closeAllWindows();
                end();
                break;
            case DialogueConstants.OPTIONS_4_4:
                DialogueManager.sendStatement(getPlayer(), "The Arceuus spellbook is not added yet.");
                setNext(1);
                break;
        }
        return false;
    }
}
