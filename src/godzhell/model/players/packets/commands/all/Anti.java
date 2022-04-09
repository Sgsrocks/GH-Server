package godzhell.model.players.packets.commands.all;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;
import godzhell.util.ItemID;

public class Anti extends Command {

    @Override
    public void execute(Player c, String input) {
        c.getItems().addItem(ItemID.ANTIPOISON3, 1);
        c.sendMessage("Yum.");
    }
}
