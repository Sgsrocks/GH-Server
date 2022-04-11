package godzhell.model.players.packets.commands.owner;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

public class Refreshskill extends Command {

	@Override
	public void execute(Player c, String input) {
		c.getPA().refreshSkill(Integer.parseInt(input));
	}

}
