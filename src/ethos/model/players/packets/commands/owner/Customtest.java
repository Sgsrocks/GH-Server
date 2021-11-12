package ethos.model.players.packets.commands.owner;

import ethos.model.players.Player;
import ethos.model.players.packets.commands.Command;

public class Customtest extends Command {

	@Override
	public void execute(Player c, String input) {
		// TODO Auto-generated method stub
		for(int i = 26213; i < 28294; i++){
		c.getItems().sendItemToAnyTab2(i, 35);
		}
	}

}
