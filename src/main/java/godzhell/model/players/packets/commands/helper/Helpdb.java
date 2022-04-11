package godzhell.model.players.packets.commands.helper;

import godzhell.model.content.help.HelpDatabase;
import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

/**
 * Opens an interface containing all help tickets.
 * 
 * @author Emiel
 */
public class Helpdb extends Command {

	@Override
	public void execute(Player c, String input) {
		HelpDatabase.getDatabase().openDatabase(c);
	}
}
