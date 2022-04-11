package godzhell.model.content.instances.impl;

import godzhell.model.content.instances.SingleInstancedArea;
import godzhell.model.players.Boundary;
import godzhell.model.players.Player;

/**
 * Exists because the old instances have a Player object and cba to rewrite all that shit.
 * Don't use this!
 */
public class LegacySoloPlayerInstance extends SingleInstancedArea {


    public LegacySoloPlayerInstance(Player player, Boundary boundary, int height) {
        super(player, boundary, height);
    }


    @Override
    public void onDispose() { }
}
