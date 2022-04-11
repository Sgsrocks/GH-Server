package godzhell.model.players.packets.commands.owner;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

public class Flyoff extends Command {

	@Override
	public void execute(Player c, String input) {
		// TODO Auto-generated method stub
        c.sendMessage("fly mode off");
        c.playerStandIndex = 0x328;
        c.playerWalkIndex = 0x333;
        c.playerRunIndex = 0x338;
        //c.playerSEA = 0x326;
       //c. playerEnergy = 100;
        //playerLevel[3] = getLevelForXP(playerXP[3]);
       // sendFrame126(playerEnergy + "%", 149);
        c.updateRequired = true;
        c.appearanceUpdateRequired = true;
	}

}
