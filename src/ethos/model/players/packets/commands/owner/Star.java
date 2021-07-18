package ethos.model.players.packets.commands.owner;

import ethos.model.content.ShootingStar;
import ethos.model.players.Player;
import ethos.model.players.packets.commands.Command;

public class Star extends Command {
    @Override
    public void execute(Player player, String input) {
        ShootingStar.spawnStar();
    }
}
