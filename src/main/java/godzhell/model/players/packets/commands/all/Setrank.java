package godzhell.model.players.packets.commands.all;

import java.util.Optional;

import godzhell.model.players.Player;
import godzhell.model.players.Right;
import godzhell.model.players.packets.commands.Command;

public class Setrank extends Command {

	@Override
	public void execute(Player player, String input) {
		if (player.getRights().isOrInherits(Right.IRONMAN)) {
			player.sendMessage("This command is not available for you.");
			return;
		}
		try {
			Right right = Right.valueOf(input.toUpperCase().replaceAll(" ", "_"));
			if (player.getRights().isOrInherits(right)) {
				player.getRights().setPrimary(right);
			} else {
				player.sendMessage("You do not have this rank.");
			}
		} catch (IllegalArgumentException e) {
			player.sendMessage("No such rank exists.");
		}
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Changes which of your rank will be displayed.");
	}

	@Override
	public Optional<String> getParameter() {
		return Optional.of("rank");
	}

}
