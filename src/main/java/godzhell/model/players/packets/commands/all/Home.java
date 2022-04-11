package godzhell.model.players.packets.commands.all;

import java.util.Optional;

import godzhell.Config;
import godzhell.Server;
import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;
import godzhell.util.Misc;

/**
 * Teleport the player to home.
 * 
 * @author Emiel
 */
public class Home extends Command {

	@Override
	public void execute(Player c, String input) {
		if (Server.getMultiplayerSessionListener().inAnySession(c)) {
			return;
		}
		if (c.inClanWars() || c.inClanWarsSafe()) {
			c.sendMessage("@cr10@You can not teleport from here, speak to the doomsayer to leave.");
			return;
		}
		if (c.inWild()) {
			c.sendMessage("You can't use this command in the wilderness.");
			return;
		}
		int random = Misc.random(2); 
		if(random == 1 )
			c.getPA().spellTeleport(Config.START_LOCATION_X, Config.START_LOCATION_Y, 0, false);
		else
			c.getPA().spellTeleport(Config.START_LOCATION_X, Config.START_LOCATION_Y, 0, false);
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Teleports you to the Home");
	}

}
