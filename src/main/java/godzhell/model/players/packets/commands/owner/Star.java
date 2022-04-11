package godzhell.model.players.packets.commands.owner;

import godzhell.model.content.ShootingStar;
import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

public class Star extends Command {
    @Override
    public void execute(Player player, String input) {

        ShootingStar.spawnStar();
    }
}
