package godzhell.model.players.combat.specials;

import godzhell.model.entity.Entity;
import godzhell.model.npcs.NPC;
import godzhell.model.players.Player;
import godzhell.model.players.combat.AttackNPC;
import godzhell.model.players.combat.CombatType;
import godzhell.model.players.combat.Damage;
import godzhell.model.players.combat.Special;

public class CrystalHalberd extends Special {

	public CrystalHalberd() {
		super(3.0, 1.15, 1.00, new int[] { 13092 });
	}

	@Override
	public void activate(Player player, Entity target, Damage damage) {
		player.gfx100(1232);
		player.startAnimation(1203);
	}

	@Override
	public void hit(Player player, Entity target, Damage damage) {
		if (target instanceof NPC) {
			NPC other = (NPC) target;
			if (other != null && player.npcIndex > 0) {
				if (player.goodDistance(player.getX(), player.getY(), other.getX(), other.getY(), other.getSize() + 2) && other.getSize() > 1) {
					AttackNPC.calculateCombatDamage(player, other, CombatType.MELEE, null);
				}
			}
		}
	}

}
