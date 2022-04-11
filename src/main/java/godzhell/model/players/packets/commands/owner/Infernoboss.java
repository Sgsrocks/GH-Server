package godzhell.model.players.packets.commands.owner;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

public class Infernoboss extends Command {

	@Override
	public void execute(Player c, String input) {
		c.createTzkalzukInstance();
		c.getInferno().initiateTzkalzuk();
	}

}

