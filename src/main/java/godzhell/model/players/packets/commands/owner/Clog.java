package godzhell.model.players.packets.commands.owner;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

public class Clog extends Command {
    @Override
    public void execute(Player c, String input) {
        c.getCollectionLog().loadForPlayer(c);
        c.getCollectionLog().openInterface(c);
    }
}
