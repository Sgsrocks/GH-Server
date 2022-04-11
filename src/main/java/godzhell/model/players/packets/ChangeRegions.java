package godzhell.model.players.packets;


import godzhell.Server;
import godzhell.model.objects.Doors;
import godzhell.model.objects.DoubleDoors;
import godzhell.model.players.PacketType;
import godzhell.model.players.Player;
import godzhell.world.GlobalDropsHandler;

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
