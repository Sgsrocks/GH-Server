package godzhell.model.players.packets.commands.all;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

public class Hang extends Command {
    @Override
    public void execute(Player c, String input) {
        c.getPA().spellTeleport(1107, 9184, 0, false);
        c.sendMessage("You teleport to Hang.");
    }
}
