package godzhell.model.players.packets.commands.admin;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;
import godzhell.model.content.skills.construction.House;

public class Poh extends Command {

	@Override
	public void execute(Player c, String input) {
		House house = new House(c);
		house.enter(c);
		
	}

}
