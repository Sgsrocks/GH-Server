package godzhell.model.players.packets.commands.all;

import java.util.Optional;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

/**
 * Opens the vote page in the default web browser.
 * 
 * @author Emiel
 */
public class Facebook extends Command {

	@Override
	public void execute(Player c, String input) {
		c.getPA().sendString("", 12000);
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Like our Facebook page!");
	}

}
