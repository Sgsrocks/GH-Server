package godzhell.model.players.packets.commands.admin;

import java.util.Optional;

import godzhell.model.players.Player;
import godzhell.model.players.PlayerHandler;
import godzhell.model.players.packets.commands.Command;

/**
 * Shows the bank of a given player.
 * 
 * @author Emiel
 */
public class Checkbank extends Command {

	@Override
	public void execute(Player c, String input) {
		if (PlayerHandler.updateRunning) {
			c.sendMessage("You cannot view a bank whilst the server is updating.");
			return;
		}
		Optional<Player> optionalPlayer = PlayerHandler.getOptionalPlayer(input);
		if (optionalPlayer.isPresent()) {
			c.getPA().openOtherBank(optionalPlayer.get());
		} else {
			c.sendMessage(input + " is not online. You can only view the bank of online players.");
		}
	}
}
