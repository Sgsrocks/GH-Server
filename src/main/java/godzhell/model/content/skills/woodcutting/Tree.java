package godzhell.model.content.skills.woodcutting;

import godzhell.definitions.ObjectID;

public enum Tree {
	NORMAL(new int[] { ObjectID.TREE, ObjectID.TREE_1277, ObjectID.TREE_1278, ObjectID.TREE_1279, ObjectID.TREE_1280 }, 1342, 1511, 1, 5, 100, 25, 15, 12000),
	DEAD(new int[] { ObjectID.DEAD_TREE }, 1347, 1511, 1, 5, 100, 25, 15, 12000),
	DEAD2(new int[] { ObjectID.DEAD_TREE_1283 }, 1347, 1511, 1, 5, 100, 25, 15, 12000),
	DEAD3(new int[] { ObjectID.DEAD_TREE_1289 }, 1353, 1511, 1, 5, 100, 25, 15, 12000),
	EVERGREEN(new int[] { ObjectID.EVERGREEN_2091, ObjectID.EVERGREEN_2092 }, 1342, 1511, 1, 5, 100, 25, 15,  12000),
	OAK(new int[] { ObjectID.OAK_10820, ObjectID.OAK_9734, ObjectID.OAK_42831 }, 1356, 1521, 15, 8, 50, 38, 25, 11500),
	WILLOW(new int[] { ObjectID.WILLOW }, 9711, 1519, 30, 10, 60, 68, 35, 8000),
	WILLOW2(new int[] {  ObjectID.WILLOW_10829, ObjectID.WILLOW_10831, ObjectID.WILLOW_10833 }, 9471, 1519, 30, 10, 60, 68, 35, 8000),
	TEAK(new int[] { ObjectID.TEAK }, 1356, 6333, 35, 10, 65, 68, 35, 7000),
	MAPLE(new int[] { ObjectID.MAPLE_TREE_10832, ObjectID.MAPLE_TREE_36681, ObjectID.MAPLE_TREE_4674, ObjectID.MAPLE_TREE_40754 }, 1356, 1517, 45, 13, 75, 100, 45, 6000),
	ARCTIC_PINE(new int[] { ObjectID.ARCTIC_PINE }, 1356, 10810, 54, 14, 85, 100, 50, 5400),
	YEW(new int[] { ObjectID.YEW, ObjectID.YEW_42391, ObjectID.YEW_40756, ObjectID.YEW_42427, ObjectID.YEW_36683 }, 1356, 1515, 60, 15, 100, 175, 60, 5000),
	MAGIC(new int[] { ObjectID.MAGIC_TREE_10834 }, 9713, 1513, 75, 20, 125, 250, 75, 3600),
	REDWOOD(new int[] { ObjectID.REDWOOD  }, 29669, 19669, 90, 25, 1250, 275, 150, 3000),
	REDWOOD2(new int[] { ObjectID.REDWOOD_29670 }, 29671, 19669, 90, 25, 1250, 275, 150, 3000),
	SAPLING(new int[] { 29763 }, 29764, 20799, 65, 13, 75, 25, 15, 100000);

	private int[] treeIds;
	private int stumpId, wood, levelRequired, chopsRequired, deprecationChance, respawn, petChance;
	private double experience;

	private Tree(int[] treeIds, int stumpId, int wood, int levelRequired, int chopsRequired, int deprecationChance, double experience, int respawn, int petChance) {
		this.treeIds = treeIds;
		this.stumpId = stumpId;
		this.wood = wood;
		this.levelRequired = levelRequired;
		this.experience = experience;
		this.deprecationChance = deprecationChance;
		this.chopsRequired = chopsRequired;
		this.respawn = respawn;
		this.petChance = petChance;
	}

	public int[] getTreeIds() {
		return treeIds;
	}

	public int getStumpId() {
		return stumpId;
	}

	public int getWood() {
		return wood;
	}

	public int getLevelRequired() {
		return levelRequired;
	}

	public int getChopsRequired() {
		return chopsRequired;
	}

	public int getChopdownChance() {
		return deprecationChance;
	}

	public double getExperience() {
		return experience;
	}

	public int getRespawnTime() {
		return respawn;
	}
	
	public int getPetChance() {
		return petChance;
	}

	public static Tree forObject(int objectId) {
		for (Tree tree : values()) {
			for (int treeId : tree.treeIds) {
				if (treeId == objectId) {
					return tree;
				}
			}
		}
		return null;
	}

}
