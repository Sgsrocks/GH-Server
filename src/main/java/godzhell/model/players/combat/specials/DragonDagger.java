package godzhell.model.players.combat.specials;

import godzhell.model.entity.Entity;
import godzhell.model.npcs.NPC;
import godzhell.model.players.Player;
import godzhell.model.players.combat.AttackNPC;
import godzhell.model.players.combat.AttackPlayer;
import godzhell.model.players.combat.CombatType;
import godzhell.model.players.combat.Damage;
import godzhell.model.players.combat.Special;

public class DragonDagger extends Special {

	public DragonDagger() {
		super(2.5, 1.50, 1.10, new int[] { 1215, 1231, 5680, 5698 });
	}

	@Override
	public void activate(Player player, Entity target, Damage damage) {
		player.gfx100(252);
		player.startAnimation(1062);
		if (target instanceof NPC) {
			AttackNPC.calculateCombatDamage(player, (NPC) target, CombatType.MELEE, null);
		} else if (target instanceof Player) {
			AttackPlayer.calculateCombatDamage(player, (Player) target, CombatType.MELEE, null);
		}
	}

	@Override
	public void hit(Player player, Entity target, Damage damage) {

	}

}
