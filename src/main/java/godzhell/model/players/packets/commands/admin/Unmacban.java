package godzhell.model.players.packets.commands.admin;

import godzhell.Server;
import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;
import godzhell.punishments.Punishment;
import godzhell.punishments.PunishmentType;
import godzhell.punishments.Punishments;

/**
 * Remove the ban on a specific Mac address.
 * 
 * @author Emiel
 */
public class Unmacban extends Command {

	@Override
	public void execute(Player c, String input) {
		try {
			Punishments punishments = Server.getPunishments();
			Punishment punishment = punishments.getPunishment(PunishmentType.MAC_BAN, input);

			if (!punishments.contains(PunishmentType.MAC_BAN, input) || punishment == null) {
				c.sendMessage("The address " + input + " does not exist in the list.");
				return;
			}

			punishments.remove(punishment);
			c.sendMessage("The mac ban on the address; " + input + " has been lifted.");
		} catch (IndexOutOfBoundsException exception) {
			c.sendMessage("Error. Correct syntax: ::unmacban address.");
		}
	}
}
