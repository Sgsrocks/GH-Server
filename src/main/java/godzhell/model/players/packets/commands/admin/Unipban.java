package godzhell.model.players.packets.commands.admin;

import godzhell.Server;
import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;
import godzhell.punishments.Punishment;
import godzhell.punishments.PunishmentType;
import godzhell.punishments.Punishments;

public class Unipban extends Command {

	@Override
	public void execute(Player c, String input) {
		if (input.isEmpty()) {
			c.sendMessage("You must enter a valid IP address.");
			return;
		}
		String[] args = input.split("-");
		String ipToUnban = args[0];
		
		Punishments punishments = Server.getPunishments();
		Punishment punishment = punishments.getPunishment(PunishmentType.NET_BAN, ipToUnban);

		if (!punishments.contains(PunishmentType.NET_BAN, ipToUnban) || punishment == null) {
			c.sendMessage("This IP address is not banned.");
			return;
		}

		punishments.remove(punishment);
		c.sendMessage("The IP '" + input + "' has been removed from the IP ban list.");
	}

}
