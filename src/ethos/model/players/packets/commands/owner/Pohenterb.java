package ethos.model.players.packets.commands.owner;

import ethos.model.players.Player;
import ethos.model.players.packets.commands.Command;
import ethos.model.players.skills.construction.House;

public class Pohenterb extends Command {

	@Override
	public void execute(Player c, String input) {
		if (c.getHouse() == null) {
			c.sendMessage("You do not have a house loaded.");
			return;
		}

		House house = c.getHouse();
		house.setBuildMode(true);
		house.enter(c);

	}

}
