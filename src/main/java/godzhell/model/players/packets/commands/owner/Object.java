package godzhell.model.players.packets.commands.owner;

import java.util.Arrays;

import godzhell.model.players.Player;
import godzhell.model.players.PlayerHandler;
import godzhell.model.players.packets.commands.Command;

/**
 * Spawn a specific Object.
 * 
 * @author Emiel
 *
 */
public class Object extends Command {

	@Override
	public void execute(Player c, String input) {
		String[] args = input.split(" ");
			Arrays.stream(PlayerHandler.players).forEach(p -> {
				if (p != null) {
					p.getPA().object(Integer.parseInt(args[0]), c.absX, c.absY, Integer.parseInt(args[1]), Integer.parseInt(args[2]));
				}
			});
			c.sendMessage("Object: " + Integer.parseInt(args[0]) + ", Type: " + Integer.parseInt(args[2]) + ".");
	}
}
