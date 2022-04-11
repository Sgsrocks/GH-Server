package godzhell.model.minigames;

import godzhell.model.items.Item2;
import godzhell.model.players.Player;

public class Partyhat {

    public boolean execute(final Player c, final int objectId) {
        switch(objectId){
            case 4113: //mini game
                if(c.absX == 1287 && c.absY == 9110) {
                    if (c.JDemonkills >= 1) {
                    }
                    if (c.Demonkills >= 1) {
                    }
                    if (c.Generalkills >= 1) {
                        c.Demonkills -= 1;
                        c.JDemonkills -= 1;
                        c.Generalkills -= 1;
                        c.sendMessage("Congradulations!!! You have beaten the Party Hat Mini game!!!");
                        //PlayerHandler.messageToAll = playerName+ " has just finished the Party Hat Mini game!";
                        c.getItems().addItem(Item2.randomPhat(), 1);
                    } else {
                        c.sendMessage("You attempt to open the chest but it seems to be sealed tightly shut.");
                    }
                }
                break;
            case 16105: // Portal
                if(c.absX == 1316 && c.absY == 9090 || c.absX == 1316 && c.absY == 9089) {
                    if (c.Druidkills >= 1) {
                    }
                    if (c.Ghostkills >= 1) {
                    }
                    if (c.Giantkills >= 1) {
                        c.getPA().movePlayer(1318, 9089, 0);
                        c.Giantkills -= 1;
                        c.Druidkills -= 1;
                        c.Ghostkills -= 1;
                        c.sendMessage("You pass through the Ghostly Portal.");
                    } else {
                        c.sendMessage("You attempt to step through the portal but you are stopped.");
                        c.sendMessage("A voice tells you to kill the three unclean monsters.");
                    }
                }
                break;
        }
        return false;
    }
}
