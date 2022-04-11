package godzhell.model.players.packets.commands.owner;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

/**
 * Start the update timer and update the server.
 * 
 * @author Emiel
 *
 */
public class Resetstats extends Command {

	@Override
	public void execute(Player c, String input) {
		for (int i = 0; i < c.playerLevel.length; i++) {
			c.playerLevel[i] = c.getLevelForXP(c.playerXP[i]);
			c.getPA().refreshSkill(i);
		}
	}
}
