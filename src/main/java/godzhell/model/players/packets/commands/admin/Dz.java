package godzhell.model.players.packets.commands.admin;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

import java.util.Optional;

/**
 * Teleports the player to the donator zone.
 * 
 * @author Emiel
 */
public class Dz extends Command {

	@Override
	public void execute(Player c, String input) {
		if (c.inTrade || c.inDuel || c.inWild()) {
			return;
		}
		if (c.inClanWars() || c.inClanWarsSafe()) {
			c.sendMessage("@cr10@This player is currently at the pk district.");
			return;
		}
		c.getPA().startTeleport(1005, 9231, 0, "modern", false);
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Same as @blu@::donatorzone@blu@");
	}

}
