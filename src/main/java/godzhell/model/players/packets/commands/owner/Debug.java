package godzhell.model.players.packets.commands.owner;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

/**
 * Show the current position.
 * 
 * @author Emiel
 *
 */
public class Debug extends Command {

	@Override
	public void execute(Player player, String input) {
		if (player.debugMessage) {
			player.debugMessage = false;
			player.sendMessage("Debug Messages Disabled.");
		} else {
			player.debugMessage = true;
			player.sendMessage("Debug Messages Enabled.");
		}
		
	}
}
