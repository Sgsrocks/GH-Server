package ethos.model.players.packets.commands.owner;

import ethos.model.players.Player;
import ethos.model.players.packets.commands.Command;

public class Music extends Command {


	@Override
	public void execute(Player player, String input) {
		int id = Integer.parseInt(input);
		player.getPA().playMusic(id);
		

	}

}
