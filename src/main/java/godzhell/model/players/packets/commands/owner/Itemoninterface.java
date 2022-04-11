package godzhell.model.players.packets.commands.owner;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

/**
 * Open a specific interface.
 * 
 * @author Emiel
 *
 */
public class Itemoninterface extends Command {

	@Override
	public void execute(Player c, String input) {
		try {
			int a = Integer.parseInt(input);
			for (int x = 0; x <= 18; x++) {
				c.getPA().itemOnInterface(a, 1, 39373, x);
			}

			c.getPA().showInterface(39271);
		} catch (Exception e) {
			c.sendMessage("::interface ####");
		}
	}
}
