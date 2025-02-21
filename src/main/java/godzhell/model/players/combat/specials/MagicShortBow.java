package godzhell.model.players.combat.specials;

import godzhell.model.entity.Entity;
import godzhell.model.npcs.NPC;
import godzhell.model.players.Player;
import godzhell.model.players.combat.AttackNPC;
import godzhell.model.players.combat.AttackPlayer;
import godzhell.model.players.combat.CombatType;
import godzhell.model.players.combat.Damage;
import godzhell.model.players.combat.Special;
import godzhell.model.players.combat.range.RangeData;

public class MagicShortBow extends Special {

	public MagicShortBow() {
		super(5.0, 1.15, 1.05, new int[] { 859, 861 });
	}

	public MagicShortBow(double cost) {
		super(cost, 1.15, 1.05, new int[] { 12788 });
	}

	@Override
	public void activate(Player player, Entity target, Damage damage) {
		player.bowSpecShot = 1;
		player.getItems().deleteArrow();
		player.getItems().deleteArrow();
		player.startAnimation(1074);
		player.projectileStage = 1;
		if (player.fightMode == 2) {
			player.attackTimer--;
		}
		if (target instanceof NPC && player.npcIndex > 0) {
			RangeData.fireProjectileNpc(player, (NPC) target, 50, 70, 249, 43, 31, 37, 10);
			RangeData.fireProjectileNpc(player, (NPC) target, 50, 70, 249, 43, 31, 53, 10);
			AttackNPC.calculateCombatDamage(player, (NPC) target, CombatType.RANGE, null);
		} else if (target instanceof Player && player.playerIndex > 0) {
			RangeData.fireProjectilePlayer(player, (Player) target, 50, 70, 249, 43, 31, 37, 10);
			RangeData.fireProjectilePlayer(player, (Player) target, 50, 70, 249, 43, 31, 53, 10);
			AttackPlayer.calculateCombatDamage(player, (Player) target, CombatType.RANGE, null);
		}
	}

	@Override
	public void hit(Player player, Entity target, Damage damage) {

	}

}
