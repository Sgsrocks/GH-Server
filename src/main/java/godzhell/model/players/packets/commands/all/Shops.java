package godzhell.model.players.packets.commands.all;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

public class Shops extends Command {

	@Override
	public void execute(Player c, String input) {
		// TODO Auto-generated method stub
		for (int i = 35488; i < 35665; i++) {
			c.getPlayerAssistant().sendFrame126("", i);
			c.getPlayerAssistant().sendFrame126("", 35486);
		}
		c.getPlayerAssistant().sendFrame126("@dre@Where are shops?", 35486);
			c.getPlayerAssistant().sendFrame126("@whi@Shops are all over the world.", 35488);
			c.getPlayerAssistant().sendFrame126("@whi@Means you have to go them to shop for items.", 35489);
			c.getPlayerAssistant().sendFrame126("@whi@if you find a shop that does not work tell Sgsrocks.", 35490);
			c.getPlayerAssistant().sendFrame126("@whi@Most free to play shops are added.", 35491);
			c.getPlayerAssistant().showInterface(35483);
	}

}
