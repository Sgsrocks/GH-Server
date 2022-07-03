package godzhell.model.players.packets.commands.admin;

import godzhell.definitions.ItemCacheDefinition;
import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

public class Gitem extends Command {
    @Override
    public void execute(Player c, String input) {
        String[] args = input.split(" ");
        if (args.length >= 2) {
            int newItemID = Integer.parseInt(args[0]);
            int newItemAmount = Integer.parseInt(args[1]);
            if ((newItemID <= 40000) && (newItemID >= 0)) {
                c.getPA().addItems(newItemID, c.getX(), c.getY(), newItemAmount);
                c.sendMessage("@blu@The item "+ ItemCacheDefinition.forID(newItemID).getName()+" saved to ItemSpawns.txt");
            } else {
                c.sendMessage("No such item.");
            }
        } else {
            c.sendMessage("Use as ::item id amount.");
        }
    }
}
