package godzhell.model.players.packets.commands.owner;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

public class Getframeid extends Command {
    @Override
    public void execute(Player c, String input) {
        for(int i = 0; i < 40000; i++)
        {
            c.getPA().sendFrame126(""+i, i);
        }
    }
}
