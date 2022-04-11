package godzhell.model.players.packets;

import godzhell.Config;
import godzhell.Server;
import godzhell.ServerState;
import godzhell.model.players.PacketType;
import godzhell.model.players.Player;
import godzhell.punishments.PunishmentType;
import godzhell.util.Misc;
import godzhell.util.log.PlayerLogging;
import godzhell.util.log.PlayerLogging.LogType;

/**
 * Chat
 **/
public class Chat implements PacketType {

	@Override
	public void processPacket(Player c, int packetType, int packetSize) {
		c.setChatTextEffects(c.getInStream().readUnsignedByteS());
		c.setChatTextColor(c.getInStream().readUnsignedByteS());
		c.setChatTextSize((byte) (c.packetSize - 2));
		c.inStream.readBytes_reverseA(c.getChatText(), c.getChatTextSize(), 0);

		if (Server.getPunishments().contains(PunishmentType.NET_MUTE, c.connectedFrom)) {
			c.sendMessage("Your entire network has been muted. Other players cannot see your message.");
			return;
		}

		if (Server.getPunishments().contains(PunishmentType.MUTE, c.playerName)) {
			c.sendMessage("You are currently muted. Other players cannot see your message.");
			return;
		}

		if (System.currentTimeMillis() < c.muteEnd) {
			c.sendMessage("You are currently muted. Other players cannot see your message.");
			return;
		}
		String message = Misc.decodeMessage(c.getChatText(), c.getChatTextSize());
		
		PlayerLogging.write(LogType.PUBLIC_CHAT, c, "Spoke = "+message);
		
		if (Config.SERVER_STATE == ServerState.PUBLIC_PRIMARY) {
			//TODO public chat logging
		}
		c.setChatTextUpdateRequired(true);
	}
}
