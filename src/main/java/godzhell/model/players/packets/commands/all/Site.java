package godzhell.model.players.packets.commands.all;

import java.util.Optional;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

public class Site extends Command {

	@Override
	public void execute(Player c, String input) {
		String[] args = input.split(" ");
		
		switch (args[0]) {
		
		case "":
			c.sendMessage("Usage: ::site forums");
			break;
		case "home":
			c.getPA().sendFrame126("https://auroraps.org/", 12000);
			break;
		case "forums":
			c.getPA().sendFrame126("https://https://auroraps.org/forums/", 12000);
			break;
		case "discord":
			c.getPA().sendString("https://discord.gg/q3rjD2c", 12000);
			break;	
		case "donate":
			c.getPA().sendFrame126("https://auroraps.everythingrs.com/services/store", 12000);
			break;

		}
	}
	@Override
	public Optional<String> getDescription() {
		return Optional.of("You can visit all our different sites using this command");
	}
}
