package godzhell.model.players.combat.effects.bolts;

import godzhell.model.npcs.NPC;
import godzhell.model.players.Player;
import godzhell.model.players.combat.Damage;
import godzhell.model.players.combat.DamageEffect;
import godzhell.model.players.combat.range.RangeExtras;
import godzhell.util.Misc;

public class PearlBoltSpecial implements DamageEffect {

	@Override
	public void execute(Player attacker, Player defender, Damage damage) {
		int change = Misc.random((int) (damage.getAmount()));
		damage.setAmount(change);
		RangeExtras.createCombatGraphic(attacker, defender, 750, false);
	}

	@Override
	public void execute(Player attacker, NPC defender, Damage damage) {
		if (defender.getDefinition().getNpcName() == null) {
			return;
		}
		int change = Misc.random((int) (damage.getAmount()));
		damage.setAmount(change);
		RangeExtras.createCombatGraphic(attacker, defender, 750, false);
	}

	@Override
	public boolean isExecutable(Player operator) {
		return RangeExtras.boltSpecialAvailable(operator, 9238);
	}

}
