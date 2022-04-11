package godzhell.model.players.combat.effects;

import java.util.Objects;

import godzhell.model.items.EquipmentSet;
import godzhell.model.npcs.NPC;
import godzhell.model.players.Player;
import godzhell.model.players.combat.CombatType;
import godzhell.model.players.combat.Damage;
import godzhell.model.players.combat.DamageEffect;
import godzhell.model.players.combat.Hitmark;
import godzhell.util.Misc;

/**
 * The Amulet of the Damned has a special effect when wearing full kerils and combating another player. The effect has a 1/4 chance of executing which deals 1/2 of the damage dealt
 * to the player in the last damage step.
 * 
 * @author Jason MacKeigan
 * @date Nov 25, 2014, 2:52:54 AM
 */
public class AmuletOfTheDamnedKarilEffect implements DamageEffect {

	@Override
	public void execute(Player attacker, Player defender, Damage damage) {
		if (Objects.isNull(attacker) || Objects.isNull(defender) || Objects.isNull(damage)) {
			return;
		}
		if (damage.getAmount() < 2) {
			return;
		}
		int appendedDamage = damage.getAmount() / 2;
		attacker.getDamageQueue().add(new Damage(defender, appendedDamage, 1, attacker.playerEquipment, Hitmark.HIT, CombatType.RANGE));
	}

	@Override
	public boolean isExecutable(Player operator) {
		return EquipmentSet.KARIL.isWearingBarrows(operator) && Misc.random(100) < 25;
	}

	@Override
	public void execute(Player attacker, NPC defender, Damage damage) {

	}

}
