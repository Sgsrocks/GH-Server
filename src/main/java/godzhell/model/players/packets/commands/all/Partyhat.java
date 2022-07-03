package godzhell.model.players.packets.commands.all;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

import java.util.Optional;

public class Partyhat extends Command {

    @Override
    public void execute(Player c, String input) {
        c.getPA().startTeleport(1315, 9095, 0,  "modern", false);
        c.sendMessage("You teleport to the Party Hat Mini Game!");
        c.sendMessage("Good Luck!");
    }
    @Override
    public Optional<String> getDescription() {
        return Optional.of("Teleports to the PartyHat mini.");
    }
}
