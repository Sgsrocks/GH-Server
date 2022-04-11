package godzhell.model.players.packets.commands.owner;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

public class Up extends Command {

    @Override
    public void execute(Player c, String input) {
        c.getPA().movePlayer(c.getX(), c.getY(), c.heightLevel+1);
    }
}
