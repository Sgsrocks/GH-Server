package godzhell.model.players.packets.commands.helper;
import java.util.Optional;

import godzhell.Server;
import godzhell.model.players.Player;
import godzhell.model.players.PlayerHandler;
import godzhell.model.players.packets.commands.Command;
import godzhell.punishments.Punishment;
import godzhell.punishments.PunishmentType;

/**
 * Unmute a given player.
 * 
 * @author Emiel
 */
public class Unmute extends Command {

	@Override
	public void execute(Player c, String input) {
		Optional<Player> optionalPlayer = PlayerHandler.getOptionalPlayer(input);
		if (optionalPlayer.isPresent()) {
			Player c2 = optionalPlayer.get();

			Punishment punishment = Server.getPunishments().getPunishment(PunishmentType.MUTE, c2.playerName);

			if (punishment == null) {
				c.sendMessage("This player is not muted.");
				return;
			}

			Server.getPunishments().remove(punishment);
			c2.muteEnd = 0;
			c.sendMessage(c2.playerName + " has been unmuted.");
			c2.sendMessage("@red@You have been unmuted by " + c.playerName + ".");
			// TODO: Log handling
		}
	}
}
