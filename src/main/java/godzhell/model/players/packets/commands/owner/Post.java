package godzhell.model.players.packets.commands.owner;

import godzhell.model.content.tradingpost.Listing;
import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

public class Post extends Command {

	@Override
	public void execute(Player c, String input) {
		Listing.openPost(c, false, true);
	}
}
