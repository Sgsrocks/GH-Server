package godzhell.model.players.combat.effects;

import godzhell.model.items.EquipmentSet;
import godzhell.model.npcs.NPC;
import godzhell.model.players.Player;
import godzhell.model.players.combat.CombatType;
import godzhell.model.players.combat.Damage;
import godzhell.model.players.combat.DamageEffect;
import godzhell.model.players.combat.Hitmark;
import godzhell.util.Misc;

/**
 * The Amulet of the damned has an effect when worn with the entire Dharok set. There is a 1/4 chance that during the damage step the attacker will receive 15% of the damage they
 * dealt as a recoil.
 * 
 * @author Jason MacKeigan
 * @date Nov 25, 2014, 2:53:48 AM
 */
public class AmuletOfTheDamnedDharokEffect implements DamageEffect {

	@Override
	public void execute(Player attacker, Player defender, Damage damage) {
		int damageDealt = (int) Math.floor(damage.getAmount() * .15);
		if (damageDealt < 1) {
			return;
		}
		defender.getDamageQueue().add(new Damage(attacker, damageDealt, 1, attacker.playerEquipment, Hitmark.HIT, CombatType.MELEE));
	}

	@Override
	public boolean isExecutable(Player operator) {
		return EquipmentSet.DHAROK.isWearingBarrows(operator) && operator.getItems().isWearingItem(12853) && Misc.random(100) < 25;
	}

	@Override
	public void execute(Player attacker, NPC defender, Damage damage) {

	}

}
