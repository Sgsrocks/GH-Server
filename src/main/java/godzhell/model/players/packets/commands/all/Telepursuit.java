package godzhell.model.players.packets.commands.all;

import godzhell.model.players.Player;
import godzhell.model.players.combat.monsterhunt.MonsterHunt;
import godzhell.model.players.packets.commands.Command;

public class Telepursuit extends Command {

	@Override
	public void execute(Player player, String input) {
		if(MonsterHunt.getCurrentLocation() != null) {
			player.getPA().spellTeleport(MonsterHunt.getCurrentLocation().getX(), MonsterHunt.getCurrentLocation().getY(), 0, false);
		} else {
			player.sendMessage("@red@[Wildy Pursuit] @bla@No monster is currently in pursuit.");
		}
	}

}
