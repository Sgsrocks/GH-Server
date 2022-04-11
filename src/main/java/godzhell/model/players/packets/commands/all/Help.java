package godzhell.model.players.packets.commands.all;

import java.util.Optional;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

/**
 * Opens the help interface.
 * 
 * @author Emiel
 */
public class Help extends Command {

	@Override
	public void execute(Player c, String input) {
		c.getPA().closeAllWindows();
		c.getPA().showInterface(59525);
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Creates a help ticket");
	}

}
