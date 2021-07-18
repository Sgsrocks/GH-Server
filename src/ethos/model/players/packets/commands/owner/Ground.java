package ethos.model.players.packets.commands.owner;

import ethos.model.players.Player;
import ethos.model.players.packets.commands.Command;

public class Ground extends Command {

    @Override
    public void execute(Player c, String input) {
        c.getPA().movePlayer(c.getX(), c.getY(), 0);
    }
}
