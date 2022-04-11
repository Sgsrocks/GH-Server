package godzhell.model.players.packets.commands.admin;

import godzhell.model.players.Player;
import godzhell.model.players.PlayerHandler;
import godzhell.model.players.packets.commands.Command;
import godzhell.model.content.skills.construction.House;
import godzhell.util.Misc;

public class Pohjoin extends Command {

	@Override
	public void execute(Player c, String input) {
		Player toJoin = null;


		String[] args = input.split(" ");
		if (args.length != 1) {
			c.sendMessage("The correct format is '::pohjoin name'.");
			return;
		}
		Player player1 = PlayerHandler.getPlayer(args[0]);
		if (player1 == null) {
			c.sendMessage("The player '" + args[0] + "' could not be found, try again.");
			return;
		}

	toJoin = player1;
		if (toJoin == null)
			return;

		if (toJoin.getHouse() == null) {
			c.sendMessage(Misc.formatPlayerName(toJoin.playerName) + " does not appear to be home.");
			return;
		}

		House house = toJoin.getHouse();
		c.setHouse(house);
		house.enter(c);

	}

}
