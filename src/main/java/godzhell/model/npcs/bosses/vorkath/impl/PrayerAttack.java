package godzhell.model.npcs.bosses.vorkath.impl;


import godzhell.model.npcs.NPCHandler;
import godzhell.model.npcs.bosses.vorkath.VorkathAttack;
import godzhell.model.players.Player;
import godzhell.model.players.combat.CombatType;
import godzhell.model.players.combat.melee.CombatPrayer;

public class PrayerAttack implements VorkathAttack{
	@Override
	public void execute(Player player) {
		if(player.debugMessage) {
			player.sendMessage("Attacking with prayerattack");
		}
		NPCHandler.startAnimation(getAnimation(), NPCHandler.npcs[player.getVorkath().getIndex()]);
		
		int nX = NPCHandler.npcs[player.getVorkath().getIndex()].getX() + NPCHandler.offset(player.getVorkath().getIndex());
		int nY = NPCHandler.npcs[player.getVorkath().getIndex()].getY() + NPCHandler.offset(player.getVorkath().getIndex());
		int pX = player.getX();
		int pY = player.getY();
		int offX = (nX - pX) * -1;
		int offY = (nY - pY) * -1;
		int centerX = nX + NPCHandler.npcs[player.getVorkath().getIndex()].getSize() / 2;
		int centerY = nY + NPCHandler.npcs[player.getVorkath().getIndex()].getSize() / 2;
		player.getPA().createPlayersProjectile(centerX, centerY, offX, offY, 50, 85,
				getProjectileId(), 60,
				15, -player.getIndex() - 1, 65,
				0);
	}

	@Override
	public CombatType getCombatType() {
		return CombatType.MAGE;
	}

	@Override
	public int getProjectileId() {
		return 1471;
	}

	@Override
	public int getEndProjectileId() {
		return 1473;
	}

	@Override
	public int getAnimation() {
		return 7952;
	}

	@Override
	public void executeAfterhit(Player player) {
		player.gfx(getEndProjectileId(), 65);
		
		CombatPrayer.resetPrayers(player);
		
		player.sendMessage("@red@Your prayers have been disabled!");
	}

	@Override
	public boolean appliesDamage(Player player) {
		return true;
	}

	@Override
	public int getMaxHit() {
		return 0;
	}

}
