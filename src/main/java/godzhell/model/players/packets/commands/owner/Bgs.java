package godzhell.model.players.packets.commands.owner;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

public class Bgs extends Command {
    @Override
    public void execute(Player c, String input) {
        c.startAnimation(7642);
        c.gfx0(1212);

    }
}
