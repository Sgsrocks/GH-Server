package godzhell.model.npcs.bosses.vorkath;

import java.util.ArrayList;
import java.util.List;

import godzhell.model.npcs.NPC;
import godzhell.model.npcs.NPCDefinitions;
import godzhell.model.npcs.bosses.vorkath.impl.DragonfireAttack;
import godzhell.model.npcs.bosses.vorkath.impl.FireballAttack;
import godzhell.model.npcs.bosses.vorkath.impl.MagicAttack;
import godzhell.model.npcs.bosses.vorkath.impl.PoolAttack;
import godzhell.model.npcs.bosses.vorkath.impl.PrayerAttack;
import godzhell.model.npcs.bosses.vorkath.impl.RangedAttack;
import godzhell.model.npcs.bosses.vorkath.impl.SpawnAttack;
import godzhell.model.npcs.bosses.vorkath.impl.VenomAttack;
import godzhell.model.players.Player;
import godzhell.util.Misc;

public class Vorkath extends NPC{

	final Player player;
	
	private static final List<VorkathAttack> attacks = new ArrayList<VorkathAttack>();
	
	private static final List<VorkathAttack> specialAttacks = new ArrayList<VorkathAttack>();
	
	public VorkathAttack currentAttack;
	
	static {
		attacks.add(new RangedAttack());
		attacks.add(new VenomAttack());
		attacks.add(new PrayerAttack());
		attacks.add(new DragonfireAttack());
		attacks.add(new DragonfireAttack());
		attacks.add(new DragonfireAttack());
		attacks.add(new DragonfireAttack());
		attacks.add(new MagicAttack());
		attacks.add(new MagicAttack());
		attacks.add(new FireballAttack());
		
		specialAttacks.add(new SpawnAttack());
		specialAttacks.add(new PoolAttack());
	}
	
	public Vorkath(Player player, int _npcId, int _npcType, NPCDefinitions definition) {
		super(_npcId, _npcType, definition);
		this.player = player;
		this.freezeTimer = 9999999;
	}
	
	public int numberOfAttacks = 0;

	public void attack(Player c) {
		if(this.npcType != 8061 || !VorkathInstance.inVorkath(player)) //8028 - 8061
		{
			return;
		}
		
		if(currentAttack != null && currentAttack instanceof SpawnAttack && !((SpawnAttack)currentAttack).finished)
		{
			return;
		}
		
		if(currentAttack != null && currentAttack instanceof PoolAttack && !((PoolAttack)currentAttack).finished)
		{
			return;
		}
		
		this.hitDelayTimer = VorkathAttack.hitDelay;
		this.attackTimer = 5;
		
		if(numberOfAttacks >= 10 && Misc.random(5) == 3)
		{
			currentAttack = Misc.randomTypeOfList(specialAttacks);
			
			currentAttack.execute(player);
			return;
		}
		
		numberOfAttacks++;
		
		currentAttack = Misc.randomTypeOfList(attacks);
		currentAttack.execute(player);
		
		this.attackType = currentAttack.getCombatType();
	}
}
