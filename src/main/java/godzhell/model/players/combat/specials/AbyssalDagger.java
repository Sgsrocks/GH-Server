package godzhell.model.players.combat.specials;

import godzhell.model.entity.Entity;
import godzhell.model.npcs.NPC;
import godzhell.model.players.Player;
import godzhell.model.players.combat.AttackNPC;
import godzhell.model.players.combat.AttackPlayer;
import godzhell.model.players.combat.CombatType;
import godzhell.model.players.combat.Damage;
import godzhell.model.players.combat.Special;

public class AbyssalDagger extends Special {

	public AbyssalDagger() {
		super(5.0, 1.2, 1.0, new int[] { 13265, 13267, 13269, 13271 });
	}

	@Override
	public void activate(Player player, Entity target, Damage damage) {
		player.startAnimation(3300);
		player.gfx0(1283);
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
