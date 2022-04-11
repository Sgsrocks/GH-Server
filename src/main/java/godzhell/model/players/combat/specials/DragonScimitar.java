package godzhell.model.players.combat.specials;

import godzhell.model.entity.Entity;
import godzhell.model.players.Player;
import godzhell.model.players.combat.Damage;
import godzhell.model.players.combat.Special;
import godzhell.model.players.combat.melee.CombatPrayer;

public class DragonScimitar extends Special {

	public DragonScimitar() {
		super(5.5, 1.00, 1.00, new int[] { 4587 });
	}

	@Override
	public void activate(Player player, Entity target, Damage damage) {
		player.gfx100(347);
		player.startAnimation(1872);
	}

	@Override
	public void hit(Player player, Entity target, Damage damage) {
		
		if (target instanceof Player) {
			if (damage.getAmount() > 0) {
				CombatPrayer.resetOverHeads((Player) target);
			}
		}

	}

}
