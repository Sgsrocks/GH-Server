package godzhell.model.npcs.bosses.vorkath.impl;


import godzhell.event.CycleEvent;
import godzhell.event.CycleEventContainer;
import godzhell.event.CycleEventHandler;
import godzhell.model.npcs.NPCHandler;
import godzhell.model.npcs.bosses.vorkath.VorkathAttack;
import godzhell.model.players.Player;
import godzhell.model.players.combat.CombatType;
import godzhell.model.players.combat.Hitmark;

public class FireballAttack implements VorkathAttack{
	@Override
	public void execute(Player player) {
		if(player.debugMessage) {
			player.sendMessage("Attacking with fireball attack");
		}
		NPCHandler.startAnimation(getAnimation(), NPCHandler.npcs[player.getVorkath().getIndex()]);

		int nX = player.getVorkath().absX + 2;
		int nY = player.getVorkath().absY + 2;
		int x1 = player.absX + 1;
		int y1 = player.absY + 2;
		int offY = (nX - x1) * -1;
		int offX = (nY - y1) * -1;

		int fireballX = player.absX;
		int fireballY = player.absY;
		
		CycleEventHandler.getSingleton().addEvent(this, new CycleEvent() {
			int count = 0;
			@Override
			public void execute(CycleEventContainer container) {
				if(count == 0)
				{
					player.getPA().createPlayersProjectile(nX, nY, offX, offY, 40, 100,
							getProjectileId(), 31, 0, -1, 5);
					count++;
				}
				else {
					player.getPA().createPlayersStillGfx(getEndProjectileId(), fireballX, fireballY, player.heightLevel, 5); // 305
					
					int xOff = fireballX-player.absX;
					int yOff = fireballY-player.absY;
					
					if(xOff == 0 && yOff == 0)
					{
						player.appendDamage(getMaxHit(), Hitmark.HIT);
					}
					else if(Math.abs(xOff) < 2 && Math.abs(yOff) < 2)
					{
						player.appendDamage(getMaxHit()/2, Hitmark.HIT);
					}
					
					container.stop();
				}
			}

		}, 3);

	}

	@Override
	public CombatType getCombatType() {
		return CombatType.DRAGON_FIRE;
	}

	@Override
	public int getProjectileId() {
		return 1481;
	}

	@Override
	public int getEndProjectileId() {
		return 157;
	}

	@Override
	public int getAnimation() {
		return 7960;
	}

	@Override
	public void executeAfterhit(Player player) {
		player.gfx(getEndProjectileId(), 65);
	}

	@Override
	public boolean appliesDamage(Player player) {
		return false;
	}

	@Override
	public int getMaxHit() {
		return 121;
	}

}
