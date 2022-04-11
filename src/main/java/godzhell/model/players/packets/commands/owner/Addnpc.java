package godzhell.model.players.packets.commands.owner;

import godzhell.Server;
import godzhell.model.npcs.NPCDefinitions;
import godzhell.model.npcs.NPCStats;
import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

/**
 * Spawn a specific Npc.
 * 
 * @author Emiel
 *
 */
public class Addnpc extends Command {

	@Override
	public void execute(Player c, String input) {
		int newNPC = Integer.parseInt(input);
		if (newNPC > 0) {
			
			Server.npcHandler.addNPC(newNPC, c.absX, c.absY, c.heightLevel, 0, NPCDefinitions.get(newNPC).getNpcHealth(), NPCStats.npcStats[newNPC][0], NPCStats.npcStats[newNPC][1], NPCStats.npcStats[newNPC][2]);
			c.sendMessage("You added a Npc.");
		} else {
			c.sendMessage("No such NPC.");
		}
	}
}
