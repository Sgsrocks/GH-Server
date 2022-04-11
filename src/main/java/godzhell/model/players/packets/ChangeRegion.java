package godzhell.model.players.packets;

import godzhell.model.players.PacketType;
import godzhell.model.players.Player;

public class ChangeRegion implements PacketType {

	@Override
	public void processPacket(Player c, int packetType, int packetSize) {
		c.getPA().removeObjects();
		// Server.objectManager.loadObjects(c);
	}

}
