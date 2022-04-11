package godzhell.model.content.dialogue.impl;

import godzhell.model.content.dialogue.Dialogue;
import godzhell.model.content.dialogue.DialogueConstants;
import godzhell.model.content.dialogue.DialogueManager;

public class RockDialogue extends Dialogue {

    @Override
    public void execute() {
        switch(getNext()){
            case 0:
                DialogueManager.sendStatement(getPlayer(), "Warning: The heat of the ground beyond this point can burn you as", "you walk upon it. It is recommended you wear appropriate boots for", "this.");
                setNext(1);
                break;
            case 1:
                DialogueManager.sendOption(getPlayer(), "Yes", "No");
                break;
        }
    }
    @Override
    public boolean clickButton(int id) {
        switch (id) {
            case DialogueConstants.OPTIONS_2_1:
                if(getPlayer().getX() == 1303 && getPlayer().getY() == 10205 && getPlayer().getHeight() == 0){
                    getPlayer().getPA().movePlayer(1301, 10205, 0);
                } else if(getPlayer().getX() == 1303 && getPlayer().getY() == 10206 && getPlayer().getHeight() == 0){
                    getPlayer().getPA().movePlayer(1301, 10206, 0);
                } else if(getPlayer().getX() == 1311 && getPlayer().getY() == 10214 && getPlayer().getHeight() == 0){
                    getPlayer().getPA().movePlayer(1311, 10216, 0);
                } else if(getPlayer().getX() == 1312 && getPlayer().getY() == 10214 && getPlayer().getHeight() == 0){
                    getPlayer().getPA().movePlayer(1312, 10216, 0);
                } else if(getPlayer().getX() == 1320 && getPlayer().getY() == 10206 && getPlayer().getHeight() == 0){
                    getPlayer().getPA().movePlayer(1322, 10206, 0);
                } else if(getPlayer().getX() == 1320 && getPlayer().getY() == 10205 && getPlayer().getHeight() == 0){
                    getPlayer().getPA().movePlayer(1322, 10205, 0);
                }
                getPlayer().getPA().closeAllWindows();
                end();
                break;
            case DialogueConstants.OPTIONS_2_2:
                getPlayer().getPA().closeAllWindows();
                end();
                break;
        }
        return false;
    }
}
