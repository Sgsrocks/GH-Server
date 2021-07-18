package ethos.model.players.packets.commands.owner;

import ethos.model.players.Player;
import ethos.model.players.packets.commands.Command;
import ethos.model.players.skills.construction.House;

public class Pohload extends Command {

	@Override
	public void execute(Player c, String input) {
		c.setHouse(House.load(c));

	}

}
