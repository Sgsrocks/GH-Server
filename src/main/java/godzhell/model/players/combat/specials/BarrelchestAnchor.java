package godzhell.model.players.combat.specials;

import godzhell.model.entity.Entity;
import godzhell.model.players.Player;
import godzhell.model.players.combat.Damage;
import godzhell.model.players.combat.Special;

public class BarrelchestAnchor extends Special {

	public BarrelchestAnchor() {
		super(5.0, 1.00, 1.10, new int[] { 10887 });
	}

	@Override
	public void activate(Player player, Entity target, Damage damage) {
		player.gfx0(1027);
		player.startAnimation(5870);
	}

	@Override
	public void hit(Player player, Entity target, Damage damage) {

	}
}