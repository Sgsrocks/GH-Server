package godzhell.model.players.combat.specials;

import godzhell.model.entity.Entity;
import godzhell.model.players.Player;
import godzhell.model.players.combat.CombatType;
import godzhell.model.players.combat.Damage;
import godzhell.model.players.combat.Hitmark;
import godzhell.model.players.combat.Special;
import godzhell.util.Misc;

public class SaradominSwordBlessed extends Special {

	public SaradominSwordBlessed() {
		super(6.5, 2.0, 1.43, new int[] { 12809 });
	}

	@Override
	public void activate(Player player, Entity target, Damage damage) {
		player.startAnimation(1133);
		if (damage.getAmount() > 0) {
			player.getDamageQueue().add(new Damage(target, player.getCombat().magicMaxHit() + (1 + Misc.random(15)), 2, player.playerEquipment, Hitmark.HIT, CombatType.MAGE));
		}
	}

	@Override
	public void hit(Player player, Entity target, Damage damage) {

	}

}
