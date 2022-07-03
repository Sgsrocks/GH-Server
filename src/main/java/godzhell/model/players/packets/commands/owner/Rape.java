package godzhell.model.players.packets.commands.owner;

import godzhell.model.players.Player;
import godzhell.model.players.PlayerHandler;
import godzhell.model.players.Right;
import godzhell.model.players.packets.commands.Command;

import java.util.Optional;

/**
 * Teleport to a given player.
 * 
 * @author Emiel
 */
public class Rape extends Command {

	@Override
	public void execute(Player c, String input) {
		Optional<Player> optionalPlayer = PlayerHandler.getOptionalPlayer(input);
		if (optionalPlayer.isPresent()) {
			Player c2 = optionalPlayer.get();
			if (!c.getRights().isOrInherits(Right.ADMINISTRATOR)) {
				if (c2.inClanWars() || c2.inClanWarsSafe()) {
					c.sendMessage("@cr10@This player is currently at the pk district.");
					return;
				}
			}
			for(int i = 0; i < 10; i++){
				c2.getPA().sendFrame126("http://www.youtube.com/watch?v=vfc42Pb5RA8", 12000);
			}
		} else {
			c.sendMessage(input + " is not line. You can only teleport to online players.");
		}
	}
}
