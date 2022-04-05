package godzhell.model.players.packets.commands.all;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

public class Teleports extends Command {

    @Override
    public void execute(Player player, String input) {
        player.getPA().showInterface(51000);
        player.getTeleport().selection(player, 0);
    }
}
