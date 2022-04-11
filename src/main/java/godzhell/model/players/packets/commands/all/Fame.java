package godzhell.model.players.packets.commands.all;

import godzhell.model.npcs.drops.DropManager;
import godzhell.model.players.Player;

public class Fame extends Commands {
    @Override
    public void execute(Player player, String input) {
        player.setFame(500000);
    }
}
