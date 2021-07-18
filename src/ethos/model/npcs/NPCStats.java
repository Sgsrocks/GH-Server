package ethos.model.npcs;
/**
 * 
 * @author Sgsrocks,
 * get the stats for npcs by combat level.
 */
public class NPCStats {
	public static int[][] npcStats = new int[15000][3];
	
	public static void setDefailtStats(NPCHandler npcHandler) {
		
		for(int i = 0; i < npcStats.length; i++) {
			try {
				int npcLevel = npcHandler.getNpclistCombat(i);
				if(npcLevel > 0) {
					int maxHit = getMaxHit(npcLevel);
					int attack = getAttack(npcLevel);
					int defence = getDefence(npcLevel);
					newNPCStats(npcStats, i, maxHit, attack, defence);

				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static int getDefence(int level) {
		// TODO Auto-generated method stub
		final double levelPadding = level / 100;
	return (int) Math.round(level * (1.0 + (0.5 * levelPadding)));
	}

	private static int getAttack(int level) {
		// TODO Auto-generated method stub
		final double levelPadding = level / 100;
	return (int) Math.round(level * (2.15 + (0.85 * levelPadding)));
	}

	private static int getMaxHit(int level) {
		// TODO Auto-generated method stub
		final double levelPadding = level / 100;
	return 10 + (int) Math.round(level * (1.45 + (1.0 * levelPadding)));
	}

	private static void newNPCStats(int[][] npcStats, int i, int maxHit, int attack, int defence) {
		npcStats[i] = new int[] {maxHit, attack, defence};
	}
	
}
