package godzhell.model.players.combat.effects.bolts;

import godzhell.model.npcs.NPC;
import godzhell.model.players.Player;
import godzhell.model.players.combat.Damage;
import godzhell.model.players.combat.DamageEffect;
import godzhell.model.players.combat.range.RangeExtras;
import godzhell.util.Misc;

public class DragonBoltSpecial implements DamageEffect {

	@Override
	public void execute(Player attacker, Player defender, Damage damage) {
		if (defender.antifireDelay > 0 || defender.getItems().isWearingAnyItem(11283, 11284, 1540)) {
			return;
		}
		int change = Misc.random((int) (damage.getAmount() * 1.45));
		damage.setAmount(change);
		RangeExtras.createCombatGraphic(attacker, defender, 756, false);
	}

	@Override
	public void execute(Player attacker, NPC defender, Damage damage) {
		if (defender.getDefinition().getNpcName() != null && defender.getDefinition().getNpcName().toLowerCase().contains("dragon")) {
			return;
		}
		int change = Misc.random((int) (damage.getAmount() * 1.45));
		damage.setAmount(change);
		RangeExtras.createCombatGraphic(attacker, defender, 756, false);
	}

	@Override
	public boolean isExecutable(Player operator) {
		return RangeExtras.boltSpecialAvailable(operator, 9244);
	}

}
