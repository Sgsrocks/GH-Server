package godzhell.model.players.packets.commands.donator;

import godzhell.definitions.NPCCacheDefinition;
import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

/**
 * Transform a given player into an npc.
 * 
 * @author Emiel
 *
 */
public class Pnpc extends Command {

	@Override
	public void execute(Player c, String input) {
		int npc = Integer.parseInt(input);
		
		if (npc > 11463) {
			c.sendMessage("Max npc id is: 11463");
			return;
		}
		c.npcId2 = npc;
		c.playerStandIndex = NPCCacheDefinition.forID(npc).getStandIndex();
		c.playerWalkIndex = NPCCacheDefinition.forID(npc).getWalkIndex();
		c.playerRunIndex = NPCCacheDefinition.forID(npc).getWalkIndex();
		c.isNpc = true;
		c.updateRequired = true;
		c.appearanceUpdateRequired = true;
	}
}
