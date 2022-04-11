package godzhell.model.players.combat.specials;

import godzhell.model.entity.Entity;
import godzhell.model.players.Player;
import godzhell.model.players.combat.Damage;
import godzhell.model.players.combat.Special;

public class ArmadylGodsword extends Special {

	public ArmadylGodsword() {
		super(5.0, 1.75, 1.375, new int[] { 11802 });
	}

	@Override
	public void activate(Player player, Entity target, Damage damage) {
		player.startAnimation(7644);
		player.gfx0(1211);
	}

	@Override
	public void hit(Player player, Entity target, Damage damage) {

	}

}
