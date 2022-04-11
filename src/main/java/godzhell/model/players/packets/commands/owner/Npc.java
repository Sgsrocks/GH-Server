package godzhell.model.players.packets.commands.owner;

import godzhell.Server;
import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

/**
 * Spawn a specific Npc.
 * 
 * @author Emiel
 *
 */
public class Npc extends Command {

	@Override
	public void execute(Player c, String input) {
		int newNPC = Integer.parseInt(input);
		if (newNPC > 0) {
			Server.npcHandler.spawnNpc(c, newNPC, c.absX, c.absY, c.heightLevel, 0, 120, 7, 70, 70, false, false);
			c.sendMessage("You spawn a Npc.");
		} else {
			c.sendMessage("No such NPC.");
		}
	}
}
