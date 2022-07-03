package godzhell.model.players.packets.commands.rainbow;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

public class Bank extends Command {
    @Override
    public void execute(Player player, String input) {
        player.getPA().openUpBank();
    }
}
