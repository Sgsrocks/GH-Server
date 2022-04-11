package godzhell.model.players.packets.commands.owner;
import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

/*
 * @author - James
 *  Just sends packets for debug purposes
 */
public class Packet extends Command {
	public void execute(Player player, String input) {
		
		if(player.sendServerPackets) {
			player.sendServerPackets = false;
			player.sendMessage("Packets disabled");
		} else if (!player.sendServerPackets) {
			player.sendServerPackets = true;
			player.sendMessage("Packets enabled");
		}
		
		
	}

}