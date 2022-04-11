package godzhell.model.players.packets;

import godzhell.model.players.PacketType;
import godzhell.model.players.Player;

public class MouseMovement implements PacketType {

	@Override
	public void processPacket(Player c, int packetType, int packetSize) {
		if (c.isIdle)
			c.isIdle = false;
		//c.sendMessage("Tits1");
	}
}