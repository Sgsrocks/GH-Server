package godzhell.model.players.combat.specials;

import godzhell.model.entity.Entity;
import godzhell.model.players.Player;
import godzhell.model.players.combat.Damage;
import godzhell.model.players.combat.Special;

public class DragonWarhammer extends Special {

	public DragonWarhammer() {
		super(5.0, 2.10, 1.30, new int[] { 13576 });
	}

	@Override
	public void activate(Player player, Entity target, Damage damage) {
		player.startAnimation(1378);
		player.gfx0(1292);
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
