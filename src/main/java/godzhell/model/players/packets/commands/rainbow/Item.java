package godzhell.model.players.packets.commands.rainbow;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

public class Item extends Command {
    @Override
    public void execute(Player c, String input) {
        String[] args = input.split(" ");
        if (args.length >= 2) {
            int newItemID = Integer.parseInt(args[0]);
            int newItemAmount = Integer.parseInt(args[1]);
            if ((newItemID <= 40000) && (newItemID >= 0)) {
                c.getItems().addItem(newItemID, newItemAmount);
            } else {
                c.sendMessage("No such item.");
            }
        } else {
            c.sendMessage("Use as ::item id amount.");
        }
    }
}
