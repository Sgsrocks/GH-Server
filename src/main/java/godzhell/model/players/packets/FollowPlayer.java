package godzhell.model.players.packets;

import godzhell.model.players.PacketType;
import godzhell.model.players.Player;
import godzhell.model.players.PlayerHandler;

public class FollowPlayer implements PacketType {

	@Override
	public void processPacket(Player c, int packetType, int packetSize) {
		int followPlayer = c.getInStream().readUnsignedWordBigEndian();
		if (c.getInterfaceEvent().isActive()) {
			c.sendMessage("Please finish what you're doing.");
			return;
		}
		if (PlayerHandler.players[followPlayer] != null) {
			c.playerIndex = 0;
			c.npcIndex = 0;
			c.mageFollow = false;
			c.usingBow = false;
			c.usingRangeWeapon = false;
			c.followDistance = 1;
			c.followId = followPlayer;
		}
	}
}