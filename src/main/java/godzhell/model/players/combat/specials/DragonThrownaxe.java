package godzhell.model.players.combat.specials;

import godzhell.model.entity.Entity;
import godzhell.model.players.Player;
import godzhell.model.players.combat.Damage;
import godzhell.model.players.combat.Special;

public class DragonThrownaxe extends Special {

	public DragonThrownaxe() {
		super(2.5, 2.50, 2.50, new int[] { 20849 });
	}

	@Override
	public void activate(Player player, Entity target, Damage damage) {
		player.startAnimation(806);
		player.gfx100(1317);
	}

	@Override
	public void hit(Player player, Entity target, Damage damage) {
		if (target instanceof Player) {
		
		}

	}
}
