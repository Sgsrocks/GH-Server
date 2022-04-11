package godzhell.model.players.packets.commands.all;

import java.util.Optional;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

/**
 * Opens the game rule page in the default web browser.
 * 
 * @author Emiel
 */
public class Rules extends Command {

	@Override
	public void execute(Player c, String input) {
		c.getPA().sendFrame126("http://playanguish.net/index.php?/topic/8-forum-rules/", 12000);
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Opens a web page with in-game rules");
	}

}
