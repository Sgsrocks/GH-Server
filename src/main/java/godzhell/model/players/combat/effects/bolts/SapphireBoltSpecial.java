package godzhell.model.players.combat.effects.bolts;

import godzhell.model.npcs.NPC;
import godzhell.model.players.Player;
import godzhell.model.players.combat.Damage;
import godzhell.model.players.combat.DamageEffect;
import godzhell.model.players.combat.range.RangeExtras;
import godzhell.util.Misc;

public class SapphireBoltSpecial implements DamageEffect {

	@Override
	public void execute(Player attacker, Player defender, Damage damage) {
		int change = Misc.random((int) (damage.getAmount()));
		damage.setAmount(change);
		RangeExtras.createCombatGraphic(attacker, defender, 751, false);

		if (attacker.playerIndex > 0) {
			defender.playerLevel[5] -= 2;
			defender.getPA().refreshSkill(5);
			defender.sendMessage("Your prayer has been lowered!");
			attacker.playerLevel[5] += 2;
			if (attacker.playerLevel[5] >= attacker.getPA().getLevelForXP(attacker.playerXP[5])) {
				attacker.playerLevel[5] = attacker.getPA().getLevelForXP(attacker.playerXP[5]);
			}
			attacker.getPA().refreshSkill(5);
		}
	}

	@Override
	public void execute(Player attacker, NPC defender, Damage damage) {
		if (defender.getDefinition().getNpcName() == null) {
			return;
		}
		int change = Misc.random((int) (damage.getAmount()));
		damage.setAmount(change);
		RangeExtras.createCombatGraphic(attacker, defender, 751, false);
	}

	@Override
	public boolean isExecutable(Player operator) {
		return RangeExtras.boltSpecialAvailable(operator, 9240);
	}

}