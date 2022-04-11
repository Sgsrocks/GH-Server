package godzhell.model.players.packets.commands.owner;

import godzhell.model.players.Boundary;
import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

/**
 * Checking if inwild
 *
 */
public class Checkarea extends Command {

	@Override
	public void execute(Player player, String input) {
		if (Boundary.isIn(player, Boundary.RAID_MAIN)) { //YO 
			player.sendMessage("player is in raid");
		} else {
			player.sendMessage("not in raid area please recode");
		}
		
	}
}
