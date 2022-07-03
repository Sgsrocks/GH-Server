package godzhell.model.players.packets.commands.all;

import godzhell.Server;
import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

import java.util.Map.Entry;
import java.util.Optional;

/**
 * Shows a list of commands.
 * 
 * @author Emiel
 *
 */
public class Commands extends Command {

	@Override
	public void execute(Player c, String input) {
		if (Server.getMultiplayerSessionListener().inAnySession(c)) {
			return;
		}
		for (int i = 35488; i < 35665; i++) {
			c.getPA().sendFrame126("", i);
			c.getPlayerAssistant().sendFrame126("", 35486);
		}
		int counter = 35486;
		c.getPA().sendFrame126("@dre@GodzHell Commands", counter++);
		c.getPA().sendFrame126("", counter++);
		counter++; // 8146 is already being used
		counter = sendCommands(c, "all", counter);
		c.getPA().sendFrame126("", counter++);
		c.getPA().sendFrame126("@dre@Donators Only", counter++);
		//noinspection UnusedAssignment
		counter = sendCommands(c, "donator", counter);
		c.getPA().showInterface(35483);
	}

	public int sendCommands(Player player, String rank, int counter) {
		for (Entry<String, Command> entry : godzhell.model.players.packets.Commands.COMMAND_MAP.entrySet()) {
			if (entry.getKey().contains("." + rank.toLowerCase() + ".")) {
				if (entry.getValue().isHidden()) {
					continue;
				}
				String command = entry.getValue().getClass().getSimpleName().toLowerCase();
				if (entry.getValue().getParameter().isPresent()) {
					command += " @dre@" + entry.getValue().getParameter().get() + "@bla@";
				}
				String description = entry.getValue().getDescription().orElse("No description");
				player.getPA().sendFrame126("@blu@::" + command + "@bla@ - " + description, counter);
				counter++;
			}
		}
		return counter;
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Shows a list of all commands");
	}

}
