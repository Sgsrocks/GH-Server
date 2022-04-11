package godzhell.model.players.packets.commands.admin;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

public class Pohsave extends Command {

	@Override
	public void execute(Player c, String input) {
		if (c.getHouse() != null)
			c.getHouse().save();

	}

}
