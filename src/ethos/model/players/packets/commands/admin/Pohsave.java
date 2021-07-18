package ethos.model.players.packets.commands.admin;

import ethos.model.players.Player;
import ethos.model.players.packets.commands.Command;

public class Pohsave extends Command {

	@Override
	public void execute(Player c, String input) {
		if (c.getHouse() != null)
			c.getHouse().save();

	}

}
