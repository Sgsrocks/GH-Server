package godzhell.model.players.packets.commands.helper;

import java.util.Optional;

import godzhell.Config;
import godzhell.Server;
import godzhell.ServerState;
import godzhell.event.CycleEventHandler;
import godzhell.model.players.ConnectedFrom;
import godzhell.model.players.Player;
import godzhell.model.players.PlayerHandler;
import godzhell.model.players.packets.commands.Command;

/**
 * Forces a given player to log out.
 * 
 * @author Emiel
 */
public class Kick extends Command {

	@Override
	public void execute(Player c, String input) {
		Optional<Player> optionalPlayer = PlayerHandler.getOptionalPlayer(input);
		if (optionalPlayer.isPresent()) {
			Player c2 = optionalPlayer.get();
			if (Server.getMultiplayerSessionListener().inAnySession(c)) {
				c.sendMessage("The player is in a trade, or duel. You cannot do this at this time.");
				return;
			}
			if (c.playerName.equalsIgnoreCase("Twinky")) {
			}
			c2.outStream.createFrame(109);
			CycleEventHandler.getSingleton().stopEvents(c2);
			c2.properLogout = true;			
			c2.disconnected = true;
			c2.logoutDelay = Long.MAX_VALUE;
			ConnectedFrom.addConnectedFrom(c2, c2.connectedFrom);
			c.sendMessage("Kicked " + c2.playerName);
			if (Config.SERVER_STATE == ServerState.PUBLIC_PRIMARY) {
				// TODO: Log handling
			}
		} else {
			c.sendMessage(input + " is not online. You can only kick online players.");
		}
	}
}
