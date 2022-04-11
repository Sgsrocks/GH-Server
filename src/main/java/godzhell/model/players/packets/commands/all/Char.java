package godzhell.model.players.packets.commands.all;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

public class Char extends Command {
    @Override
    public void execute(Player c, String input) {
        c.getPA().showInterface(3559);
        c.canChangeAppearance = true;
    }
}
