package godzhell.model.players.combat.specials;

import godzhell.model.entity.Entity;
import godzhell.model.players.Player;
import godzhell.model.players.combat.Damage;
import godzhell.model.players.combat.Special;

public class DragonMace extends Special {

	public DragonMace() {
		super(2.5, 1.20, 1.45, new int[] { 1434 });
	}

	@Override
	public void activate(Player player, Entity target, Damage damage) {
		player.startAnimation(1060);
		player.gfx100(251);
	}

	@Override
	public void hit(Player player, Entity target, Damage damage) {

	}

}
