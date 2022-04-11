package godzhell.model.players.combat.specials;

import godzhell.model.entity.Entity;
import godzhell.model.players.Player;
import godzhell.model.players.combat.Damage;
import godzhell.model.players.combat.Special;

public class BandosGodsword extends Special {

	public BandosGodsword() {
		super(5.0, 1.35, 1.21, new int[] { 11804 });
	}

	@Override
	public void activate(Player player, Entity target, Damage damage) {
		player.startAnimation(7642);
		player.gfx0(1212);
	}

	@Override
	public void hit(Player player, Entity target, Damage damage) {
		if (target instanceof Player) {
			if (damage.getAmount() > 0) {
				if (((Player) target).playerLevel[1] > 0)
				((Player) target).playerLevel[1] -= ((Player) target).playerLevel[1] / 3;
				((Player) target).getPA().refreshSkill(1);
			}
		}
	}

}
