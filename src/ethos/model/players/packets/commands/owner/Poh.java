package ethos.model.players.packets.commands.owner;

import ethos.model.players.Player;
import ethos.model.players.packets.commands.Command;
import ethos.model.content.skills.construction.House;

public class Poh extends Command {

	@Override
	public void execute(Player c, String input) {
		House house = new House(c);
		house.enter(c);
		
	}

}
