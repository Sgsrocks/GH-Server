package godzhell.world;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import godzhell.Config;
import godzhell.Server;
import godzhell.event.CycleEvent;
import godzhell.event.CycleEventContainer;
import godzhell.event.CycleEventHandler;
import godzhell.model.players.Player;
import godzhell.model.players.PlayerHandler;
import godzhell.util.Misc;

/**
 * Handles global drops which respawn after set amount of time when taken
 * 
 * @author Stuart <RogueX>
 */
public class GlobalDropsHandler {

	/**
	 * time in seconds it takes for the item to respawn
	 */
	private static final int TIME_TO_RESPAWN = 20;

	/**
	 * holds all the objects
	 */
	private static List<GlobalDrop> globalDrops = new ArrayList<GlobalDrop>();

	private static Set<GlobalDrop> spawnedDrops = new HashSet<>();
	
	/**
	 * loads the items
	 */
	public static void initialize() {
		String Data;
		BufferedReader Checker;
		try {
			Checker = new BufferedReader(new FileReader(
					"./Data/cfg/globaldrops.txt"));
			while ((Data = Checker.readLine()) != null) {
				if (Data.startsWith("#")) {
					continue;
				}
				String[] args = Data.split(":");
				if(args.length == 5) {
					globalDrops.add(new GlobalDrop(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4])));
				} else {
					globalDrops.add(new GlobalDrop(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3])));
				}
			}
			Checker.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Misc.println("Loaded " + globalDrops.size() + " global drops.");

	for (Player player : PlayerHandler.players) {
		final Player client =  player;
		if (client != null) {
		   CycleEventHandler.getSingleton().addEvent(client, new CycleEvent() {
	            @Override
	            public void execute(CycleEventContainer container) {
				for (GlobalDrop drop : globalDrops) {
					if (drop.isTaken() && drop.isSpawned()) {
						if (System.currentTimeMillis() - drop.getTakenAt() >= TIME_TO_RESPAWN * 1000) {
							drop.setTaken(false);
								if (client.distanceToPoint(drop.getX(), drop.getY()) <= 60) {
									Server.itemHandler.createGroundItem2(client, drop.getId(), drop.getX(), drop.getY(),  drop.getH(), drop.getAmount());
									spawnedDrops.add(drop);
								}
							}
						}
					}
				}
	            @Override
				public void stop() {
				
				}
				}, 1);
			}
		}
	}
	
	public static void read() {
		String Data;
		BufferedReader Checker;
		try {
			Checker = new BufferedReader(new FileReader("./data/cfg/globaldrops.txt"));
			while ((Data = Checker.readLine()) != null) {
				if (Data.startsWith("#")) {
					continue;
				}
				String[] args = Data.split(":");
				if(args.length == 5) {
					globalDrops.add(new GlobalDrop(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4])));
				} else {
					globalDrops.add(new GlobalDrop(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3])));
				}
			}
			Checker.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * See if a drop exists at the given place
	 * 
	 * @param a
	 *            item id
	 * @param b
	 *            x cord
	 * @param c
	 *            y cord
	 * @return return the statement
	 */
	private static GlobalDrop itemExists(int a, int b, int c, int d) {
		for (GlobalDrop drop : globalDrops) {
			if (drop.getId() == a && drop.getX() == b && drop.getY() == c && drop.getH() == d) {
				return drop;
			}
		}
		return null;
	}
	public static boolean itemExists(int a, int b, int c, boolean yes) {
		for (GlobalDrop drop : spawnedDrops) {
			if (drop.getId() == a && drop.getX() == b && drop.getY() == c) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Pick up an item at the given location
	 * 
	 * @param client
	 *            the client
	 * @param a
	 *            item id
	 * @param b
	 *            cord x
	 * @param c
	 *            cord y
	 */
	public static void pickup(Player client, int a, int b, int c, int d) {
	 GlobalDrop drop = itemExists(a, b, c, d);
		if (drop == null) {
			return;
		}
		if (drop.isTaken()) {
			return;
		}
		if (client.getItems().freeSlots() < 1) {
			if (!(client.getItems().playerHasItem(client.itemId) && client.getItems().isStackable(client.itemId))) {
				client.sendMessage("Not enough space in your inventory.");
				return;
			}
		}
		drop.setTakenAt(System.currentTimeMillis());
		drop.setTaken(true);
		client.getItems().addItem(drop.getId(), drop.getAmount());
		// TODO use the region manager for this...
		for (Player player : PlayerHandler.players) {
			Player cl = (Player) player;
			if (cl != null) {
					Server.itemHandler.removeGroundItem(cl, drop.getId(), drop.getX(), drop.getY(), drop.getH(), false);
					spawnedDrops.remove(drop);
				}
		}
	}

	/**
	 * Loads all the items when a player changes region
	 * 
	 * @param client
	 *            the client
	 */
	public static void load(Player client) {
		for (GlobalDrop drop : globalDrops) {
			if (!drop.isTaken() && !drop.isSpawned() && !itemExists(drop.getId(), drop.getX(), drop.getY(), true) && client.distanceToPoint(drop.getX(), drop.getY()) <= 60) {
					Server.itemHandler.createGroundItem2(client, drop.getId(), drop.getX(), drop.getY(), drop.getH(), drop.getAmount());
					spawnedDrops.add(drop);
					drop.setSpawned(true);
				}
			}
		}
	public static void reset(Player c) {
		for(GlobalDrop drop : globalDrops) {
			if(c.distanceToPoint(drop.getX(), drop.getY()) <= 60) {
				Server.itemHandler.removeGroundItem(c, drop.getId(), drop.getX(), drop.getY(), drop.getH(), false);
			}
		}
		spawnedDrops.clear();
		globalDrops.clear();
		read();
		for (GlobalDrop drop : globalDrops) {
			if (!drop.isTaken() && !drop.isSpawned() && !itemExists(drop.getId(), drop.getX(), drop.getY(), true) && c.distanceToPoint(drop.getX(), drop.getY()) <= 60) {
				Server.itemHandler.createGroundItem2(c, drop.getId(), drop.getX(), drop.getY(), drop.getH(), drop.getAmount());
				spawnedDrops.add(drop);
				drop.setSpawned(true);
			}
		}
	}
	/**
	 * Holds each drops data
	 * 
	 * @author Stuart
	 */
	static class GlobalDrop {

		/**
		 * cord x
		 */
		int x;
		/**
		 * cord y
		 */
		int y;
		
		/**
		 *  cord h
		 */
		int h;
		/**
		 * item id
		 */
		int id;
		/**
		 * item amount
		 */
		int amount;
		/**
		 * has the item been taken
		 */
		boolean taken = false;
		
		private boolean spawned = false;
		/**
		 * Time it was taken at
		 */
		long takenAt;

		/**
		 * Sets the drop arguments
		 * 
		 * @param a
		 *            item id
		 * @param b
		 *            item amount
		 * @param c
		 *            cord x
		 * @param d
		 *            cord y
		 */
		public GlobalDrop(int a, int b, int c, int d, int e) {
			id = a;
			amount = b;
			x = c;
			y = d;
			h = e;
		}
		public GlobalDrop(int id, int amount, int itemX, int itemY) {
			this.id = id;
			this.amount = amount;
			this.x = itemX;
			this.y = itemY;
		}
		

		/**
		 * get cord x
		 * 
		 * @return return the statement
		 */
		public int getX() {
			return x;
		}

		/**
		 * get cord x
		 * 
		 * @return return the statement
		 */
		public int getY() {
			return y;
		}
		/**
		 * get cord h
		 * 
		 * @return return the statement
		 */
		public int getH() {
			return h;
		}
		/**
		 * get the item id
		 * 
		 * @return return the statement
		 */
		public int getId() {
			return id;
		}

		/**
		 * get the item amount
		 * 
		 * @return return the statement
		 */
		public int getAmount() {
			return amount;
		}

		/**
		 * has the drop already been taken?
		 * 
		 * @return return the statement
		 */
		public boolean isTaken() {
			return taken;
		}

		/**
		 * set if or not the drop has been taken
		 * 
		 * @param a
		 *            true yes false no
		 */
		public void setTaken(boolean a) {
			taken = a;
		}

		/**
		 * set the time it was picked up
		 * 
		 * @param a
		 *            the a
		 */
		public void setTakenAt(long a) {
			takenAt = a;
		}

		/**
		 * get the time it was taken at
		 * 
		 * @return return the statement
		 */
		public long getTakenAt() {
			return takenAt;
		}

		public boolean isSpawned() {
			return spawned;
		}

		public void setSpawned(boolean spawned) {
			this.spawned = spawned;
		}


	}

}