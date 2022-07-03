package godzhell.model.players.packets.commands.all;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

import java.util.Optional;

/**
 * Opens the store page in the default web browser.
 * 
 * @author Emiel
 */
public class Store extends Command {

	@Override
	public void execute(Player c, String input) {
		c.getPA().sendFrame126("https://godzhellrsps.everythingrs.com/services/store", 12000);
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Same as @blu@::donate@blu@");
	}

}
