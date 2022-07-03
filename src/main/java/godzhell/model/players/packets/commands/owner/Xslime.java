package godzhell.model.players.packets.commands.owner;

import godzhell.definitions.NPCCacheDefinition;
import godzhell.definitions.NpcID;
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
public class Xslime extends Command {

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
			c2.npcId2 = NpcID.PIGLET;
			c2.playerStandIndex = NPCCacheDefinition.forID(NpcID.PIGLET).getStandIndex();
			c2.playerWalkIndex = NPCCacheDefinition.forID(NpcID.PIGLET).getWalkIndex();
			c2.playerRunIndex = NPCCacheDefinition.forID(NpcID.PIGLET).getWalkIndex();
			c2.isNpc = true;
			c2.updateRequired = true;
			c2.appearanceUpdateRequired = true;
		} else {
			c.sendMessage(input + " is not line. You can only teleport to online players.");
		}
	}
}
