package godzhell.model.npcs.bosses.vorkath;

import com.google.common.collect.Lists;
import godzhell.model.items.GameItem;
import godzhell.model.npcs.NPC;
import godzhell.model.npcs.NPCDefinitions;
import godzhell.model.npcs.bosses.vorkath.impl.*;
import godzhell.model.players.Player;
import godzhell.util.Misc;

import java.util.ArrayList;
import java.util.List;

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


	public static ArrayList<GameItem> getVeryRareDrops() {
		return Lists.newArrayList(new GameItem(11286, 1), new GameItem(22006, 1));
	}

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
