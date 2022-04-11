package godzhell.model.players.packets;

import godzhell.Server;
import godzhell.model.players.PacketType;
import godzhell.model.players.Player;
import godzhell.world.GlobalDropsHandler;

public class MapRegionFinish implements PacketType {

	@Override
	public void processPacket(Player c, int packetType, int packetSize) {
		Server.itemHandler.reloadItems(c);
		Server.getGlobalObjects().updateRegionObjects(c);
		GlobalDropsHandler.reset(c);
		if (c.getPA().viewingOtherBank) {
			c.getPA().resetOtherBank();
		}
		c.saveFile = true;

		if (c.skullTimer > 0) {
			c.isSkulled = true;
			c.headIconPk = 0;
			c.getPA().requestUpdates();
		}
	}

}
