package godzhell.model.players.packets.commands.all;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

import java.util.Optional;

/**
 * Open the forums in the default web browser.
 * 
 * @author Emiel
 */
public class Forums extends Command {

	@Override
	public void execute(Player c, String input) {
		c.sendMessage("@red@Opening forums... ");
        c.getPA().sendFrame126("https://www.youtube.com/watch?v=dQw4w9WgXcQ", 12000);
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Opens a web page with our forums");
	}

}
