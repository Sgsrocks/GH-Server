package godzhell.model.players.packets.commands.owner;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

public class Raidgear extends Command {
    @Override
    public void execute(Player c, String input) {
        if(c.getItems().hasFreeSlots(11)) {
            c.getItems().addItem(24271, 1);//1
            c.getItems().addItem(19553, 1);//2
            c.getItems().addItem(21295, 1);//3
            c.getItems().addItem(11832, 1);//4
            c.getItems().addItem(11834, 1);//5
            c.getItems().addItem(22325, 1);//6
            c.getItems().addItem(22322, 1);//7
            c.getItems().addItem(22981, 1);//8
            c.getItems().addItem(13239, 1);//9
            c.getItems().addItem(11773, 1);//10
            c.getItems().addItem(13576, 1);//11
        } else {
            c.sendMessage("You need 11 free slots.");
        }
    }
}
