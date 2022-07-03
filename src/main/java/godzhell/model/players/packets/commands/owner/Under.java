package godzhell.model.players.packets.commands.owner;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

public class Under extends Command {
    @Override
    public void execute(Player c, String input) {
        if(c.getY() < 6400 && (c.heightLevel & 3) == 0) {
            c.getPA().movePlayer(c.getX(), c.getY() + 6400, 0);
        }
    }
}
