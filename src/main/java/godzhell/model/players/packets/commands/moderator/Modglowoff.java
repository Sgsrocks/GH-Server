package godzhell.model.players.packets.commands.moderator;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

public class Modglowoff extends Command {

    @Override
    public void execute(Player c, String input) {
        c.pmodglow = false;
    }
}
