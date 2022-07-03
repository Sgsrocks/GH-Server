package godzhell.model.players.packets.commands.owner;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

public class Ags extends Command {
    @Override
    public void execute(Player c, String input) {
        c.startAnimation(7644);
        c.gfx0(1211);

    }
}
