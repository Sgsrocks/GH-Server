package ethos.model.players.packets;


import ethos.Server;
import ethos.model.objects.Doors;
import ethos.model.objects.DoubleDoors;
import ethos.model.players.PacketType;
import ethos.model.players.Player;
import ethos.world.GlobalDropsHandler;

/**
 * Change Regions
 */
public class ChangeRegions implements PacketType {

	@Override
	public void processPacket(Player c, int packetType, int packetSize) {
		Server.itemHandler.reloadItems(c);
		Server.objectHandler.updateObjects(c);//testing
		Doors.getSingleton().load();
		DoubleDoors.getSingleton().load();
		Server.getGlobalObjects().updateRegionObjects(c);
		GlobalDropsHandler.reset(c);
		c.getMusic().updateRegionMusic(c.getRegionId());
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
