package godzhell.model.players.packets.commands.donator;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

public class Fly extends Command {

	@Override
	public void execute(Player c, String input) {
		// TODO Auto-generated method stub
        c.startAnimation(1500);
        c.playerStandIndex = 1501;
        c.playerWalkIndex = 1851;
        c.playerRunIndex = 1851;
        //c.playerSEA = 1851;
       // c.playerEnergy = 99999999;
      // c. playerLevel[3] = 99999999;
       // sendFrame126(playerEnergy + "%", 149);
       c.sendMessage("fly mode on");
        c.updateRequired = true;
        c.appearanceUpdateRequired = true;
	}

}
