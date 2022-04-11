package godzhell.model.players.packets.commands.owner;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

public class Customtest extends Command {

	@Override
	public void execute(Player c, String input) {
		// TODO Auto-generated method stub
		for(int i = 28213; i < 29600; i++){
		c.getItems().sendItemToAnyTab2(i, 35);
		}
	}

}
