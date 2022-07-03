package godzhell.model.players.packets.commands.donator;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

import java.util.Optional;

/**
 * Teleports the player to the donator zone.
 * 
 * @author Emiel
 */
public class Donorzone extends Command {

	@Override
	public void execute(Player c, String input) {
		if (c.inTrade || c.inDuel || c.inWild()) {
			return;
		}
		c.getPA().startTeleport(1005, 9231, 0, "modern", false);
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Teleports you to the donator zone");
	}

}
