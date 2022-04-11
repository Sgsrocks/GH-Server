package godzhell.model.players.packets;

import godzhell.model.players.PacketType;
import godzhell.model.players.Player;

/**
 * Dialogue
 **/
public class Dialogue implements PacketType {

	@Override
	public void processPacket(Player c, int packetType, int packetSize) {
		handleDialogue(c);
	}
	public boolean handleDialogue(Player c) {
		if ((c.getDialogue() == null) || (c.getDialogue().getNext() == -1)) {
			c.getPA().removeAllWindows();
		} else if (c.getDialogue().getNext() > -1) {
			c.getDialogue().execute();
			return true;
		}
		return false;
	}

}
