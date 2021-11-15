package ethos.model.players.packets.commands.admin;

import ethos.model.players.Player;
import ethos.model.players.packets.commands.Command;
import ethos.model.content.skills.construction.House;

public class Pohload extends Command {

	@Override
	public void execute(Player c, String input) {
		c.setHouse(House.load(c));

	}

}
