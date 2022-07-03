package godzhell.model.players.packets.commands.owner;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

public class Sgs extends Command {
    @Override
    public void execute(Player c, String input) {
        c.startAnimation(7640);
        c.gfx0(1209);

    }
}
