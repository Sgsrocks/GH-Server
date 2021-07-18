package ethos.model.players.packets.commands.admin;

import ethos.model.content.dialogue.impl.EmptyDialogue;
import ethos.model.players.Player;
import ethos.model.players.packets.commands.Command;

/**
 * Empty the inventory of the player.
 * 
 * @author Emiel
 */
public class Empty extends Command {

	@Override
	public void execute(Player c, String input) {
c.start(new EmptyDialogue());
	}
}
