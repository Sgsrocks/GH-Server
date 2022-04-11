package godzhell.model.players.packets.commands.all;

import java.util.Optional;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

/**
 * Toggles whether a warning will be shown when attempting to drop an item on the ground.
 * 
 * @author Emiel
 *
 */
public class Toggledrop extends Command {

	@Override
	public void execute(Player c, String input) {
		c.setDropWarning(!c.showDropWarning());
		if (c.showDropWarning()) {
			c.sendMessage("You will now be warned when attempting to drop an item.");
		} else {
			c.sendMessage("You will @red@no longer@bla@ be warned when attempting to drop an item.");
		}
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Toggles the item drop warning on or off");
	}

}
