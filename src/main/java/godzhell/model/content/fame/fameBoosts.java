package godzhell.model.content.fame;

import godzhell.model.players.Player;

public class fameBoosts {

    private Player player;
    private double fame = player.getFame();

    public static double getBoost(Player player) {
        return player.getFame() / 10000;
    }
}
