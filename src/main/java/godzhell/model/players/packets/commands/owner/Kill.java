package godzhell.model.players.packets.commands.owner;

import godzhell.model.players.Player;
import godzhell.model.players.PlayerHandler;
import godzhell.model.players.combat.Hitmark;
import godzhell.model.players.packets.commands.Command;

/**
 * Kill a player.
 * 
 * @author Emiel
 */
public class Kill extends Command {

	@Override
	public void execute(Player c, String input) {
		Player player = PlayerHandler.getPlayer(input);
		if (!c.playerName.equalsIgnoreCase("sgsrocks")) {
			return;
		}
		if (player == null) {
			c.sendMessage("Player is null.");
			return;
		}
		player.appendDamage(player.getHealth().getMaximum(), Hitmark.HIT);
		player.sendMessage("You have been merked");
	}
}
