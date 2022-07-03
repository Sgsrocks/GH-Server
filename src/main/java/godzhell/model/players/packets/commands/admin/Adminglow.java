package godzhell.model.players.packets.commands.admin;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

public class Adminglow extends Command {

    @Override
    public void execute(Player c, String input) {
        c.adglow = true;
    }
}
