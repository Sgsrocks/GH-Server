package godzhell.model.players.packets.commands.all;

import java.util.Optional;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

/**
 * Open the forums in the default web browser.
 * 
 * @author Emiel
 */
public class Forums extends Command {

	@Override
	public void execute(Player c, String input) {
		c.sendMessage("@red@Opening forums... ");
        c.getPA().sendFrame126("http://playanguish.net", 12000);
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Opens a web page with our forums");
	}

}
