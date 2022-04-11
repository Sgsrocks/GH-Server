package godzhell.model.players.packets.commands.moderator;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

/**
 * Make a note for a given player.
 * 
 * @author Emiel
 */
public class Note extends Command {

	@Override
	public void execute(Player c, String input) {
		String command = input.replaceAll("'", "\\\\'");
		String[] args = command.split("-");
		if (args.length != 2) {
			throw new IllegalArgumentException();
		}
		c.sendMessage("Successfully added a note for " + args[1]);
	}
}
