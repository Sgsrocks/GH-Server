package ethos.model.players.packets.commands.all;

import ethos.model.players.Player;
import ethos.model.players.packets.commands.Command;

public class Skillz extends Command {
    @Override
    public void execute(Player c, String input) {
        c.getPA().spellTeleport(1335, 9176, 0, false);
        c.sendMessage("You teleport to Skillz.");
    }
}
