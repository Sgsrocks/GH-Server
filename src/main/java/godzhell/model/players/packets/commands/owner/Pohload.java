package godzhell.model.players.packets.commands.owner;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;
import godzhell.model.content.skills.construction.House;

public class Pohload extends Command {

	@Override
	public void execute(Player c, String input) {
		c.setHouse(House.load(c));

	}

}
