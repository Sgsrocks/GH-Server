package ethos.model.players.packets.commands.owner;

import ethos.model.players.Player;
import ethos.model.players.packets.commands.Command;

public class Phattest extends Command {

    public void execute(Player c, String input) {
        String[] args = input.split(" ");
        c.JDemonkills = Integer.parseInt(args[0]);
        c.Demonkills = Integer.parseInt(args[0]);
        c.Generalkills = Integer.parseInt(args[0]);
    }

}
