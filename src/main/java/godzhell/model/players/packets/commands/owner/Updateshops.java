package godzhell.model.players.packets.commands.owner;


import godzhell.Server;
import godzhell.model.players.Player;
import godzhell.model.players.PlayerHandler;
import godzhell.model.players.packets.commands.Command;
import godzhell.world.ShopHandler;

/**
 * Update the shops.
 * 
 * @author Emiel
 *
 */
public class Updateshops extends Command {

	@Override
	public void execute(Player player, String input) {
		Server.shopHandler = new ShopHandler();
		PlayerHandler.executeGlobalMessage("<shad=255>[Live Update] " + player.playerName + " has made a live update to the shops!");
	}
}
