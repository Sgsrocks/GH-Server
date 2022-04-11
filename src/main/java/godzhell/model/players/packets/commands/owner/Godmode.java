package godzhell.model.players.packets.commands.owner;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

public class Godmode extends Command {

    @Override
    public void execute(Player c, String input) {
        c.getHealth().setAmount(Short.MAX_VALUE);
        for(int i = 0; i < c.playerBonus.length; i++) {
            c.playerBonus[i] = 1000;
        }
    }
}
