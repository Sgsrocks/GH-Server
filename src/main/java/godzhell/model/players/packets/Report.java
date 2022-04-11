package godzhell.model.players.packets;

import godzhell.model.players.PacketType;
import godzhell.model.players.Player;
import godzhell.util.Misc;

public class Report implements PacketType {

	@SuppressWarnings("unused")
	@Override
	public void processPacket(Player c, int packetType, int packetSize) {
		String player = Misc.longToReportPlayerName(c.inStream.readQWord2()).replaceAll("_", " ");
		byte rule = (byte) c.inStream.readUnsignedByte();
	}

}