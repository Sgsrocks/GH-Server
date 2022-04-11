package godzhell.model.players.packets.commands.owner;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

public class Region extends Command {

	@Override
	public void execute(Player c, String input) {
		// TODO Auto-generated method stub
		int regionId = Integer.parseInt(input);
		int x = (regionId >> 8) << 6;
		int y = (regionId & 0xFF) << 6;
		c.getPA().movePlayer(x, y, c.heightLevel);
	}

}
