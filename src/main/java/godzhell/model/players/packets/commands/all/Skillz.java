package godzhell.model.players.packets.commands.all;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

import java.util.Optional;

public class Skillz extends Command {
    @Override
    public void execute(Player c, String input) {
        c.getPA().spellTeleport(1335, 9176, 0, false);
        c.sendMessage("You teleport to Skillz.");
    }
    @Override
    public Optional<String> getDescription() {
        return Optional.of("Teleports to the Skillz.");
    }
}
