package godzhell.model.players.packets.commands.all;

import godzhell.model.npcs.drops.DropManager;
import godzhell.model.players.Player;
import godzhell.model.players.combat.monsterhunt.MonsterHunt;
import godzhell.model.players.packets.commands.Command;

public class Droprate extends Command {

    @Override
    public void execute(Player player, String input) {
        player.forcedChat("My drop rate bonus is : " +DropManager.getModifier1(player) + "%.");
    }

}


