package godzhell.world;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import godzhell.event.CycleEvent;
import godzhell.event.CycleEventContainer;
import godzhell.event.CycleEventHandler;
import godzhell.model.players.Player;
import godzhell.model.players.PlayerHandler;
import godzhell.util.GlobalDropData;
import godzhell.util.Misc;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * Handles global drops which respawn after set amount of time when taken
 * 
 * @author Stuart <RogueX>
 */
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
	private static final List<GlobalDrop> globalDrops = new ArrayList<>();

	private static final Set<GlobalDrop> spawnedDrops = new HashSet<>();


	/**
	 * loads the items
	 */
	public static void initialize() {
		Gson gson = new Gson();
		try {
			Type collectionType = new TypeToken<GlobalDropData[]>() {
			}.getType();
			GlobalDropData[] globalDropData = gson.fromJson(new FileReader("./data/json/globaldrops.json"), collectionType);

			for (GlobalDropData data : globalDropData) {
				if (data.getHeight() > 0) {
					globalDrops.add(new GlobalDrop(data.getId(), data.getAmount(), data.getItemX(), data.getItemY(), data.getHeight()));
				} else {
					globalDrops.add(new GlobalDrop(data.getId(), data.getAmount(), data.getItemX(), data.getItemY()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//writeGlobalDropsDump();
		Misc.println("Loaded " + globalDrops.size() + " global drops.");

		for (Player player : PlayerHandler.players) {
			Player player2 = (Player) player;
			if (player2 != null) {
				CycleEventHandler.getSingleton().addEvent(player, new CycleEvent() {
					@Override
					public void execute(CycleEventContainer container) {
						for (GlobalDrop drop : globalDrops) {
							if (drop.isTaken() && drop.isSpawned()) {
								if (System.currentTimeMillis() - drop.getTakenAt() >= TIME_TO_RESPAWN * 1000) {
									drop.setTaken(false);
									if (player2.distanceToPoint(drop.getX(), drop.getY()) <= 60) {
										player2.getItems().createGroundItem(drop.getId(), drop.getX(), drop.getY(), drop.getAmount(), drop.getHeight());
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

	public static void writeGlobalDropsDump() {
		String         Data;
		BufferedReader Checker;
		JSONArray      array = new JSONArray();
		try {
			Checker = new BufferedReader(new FileReader("./data/cfg/globaldrops.txt"));
			while ((Data = Checker.readLine()) != null) {
				if (Data.startsWith("#")) {
					continue;
				}
				String[] args = Data.split(":");

				JSONObject object = new JSONObject();

				object.put("id", Integer.parseInt(args[0]));
				object.put("amount", args[1].replace("_", " "));
				object.put("itemX", Integer.parseInt(args[2]));
				object.put("itemY", Integer.parseInt(args[3]));

				if (args.length == 5) {
					object.put("height", Integer.parseInt(args[4]));
				}

				array.put(object);
			}
			Checker.close();

			FileWriter fileWriter = new FileWriter("globaldrops-dump.json");
			fileWriter.write(array.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * See if a drop exists at the given place
	 *
	 * @param a item id
	 * @param b x cord
	 * @param c y cord
	 *
	 * @return return the statement
	 */
	private static GlobalDrop itemExists(int a, int b, int c) {
		for (GlobalDrop drop : globalDrops) {
			if (drop.getId() == a && drop.getX() == b && drop.getY() == c) {
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
	 * @param player the Player
	 * @param a       item id
	 * @param b       cord x
	 * @param c       cord y
	 */
	public static void pickup(Player player, int a, int b, int c) {
		GlobalDrop drop = itemExists(a, b, c);
		if (drop == null) {
			return;
		}
		if (drop.isTaken()) {
			return;
		}
		if (player.getItems().freeSlots() < 1) {
			if (!(player.getItems().playerHasItem(player.itemId) && player.getItems().isStackable(player.itemId))) {
				player.sendMessage("Not enough space in your inventory.");
				return;
			}
		}
		player.getItems().addItem(drop.getId(), drop.getAmount());
		drop.setTakenAt(System.currentTimeMillis());
		drop.setTaken(true);
		for (Player playerLoop : PlayerHandler.players) {
			Player cl = (Player) playerLoop;
			if (cl != null) {
				cl.getItems().removeGroundItem(drop.getId(), drop.getX(), drop.getY(), drop.getAmount());
				spawnedDrops.remove(drop);
			}
		}
	}

	/**
	 * Loads all the items when a player changes region
	 *
	 * @param player the Player
	 */
	public static void load(Player player) {
		for (GlobalDrop drop : globalDrops) {
			if (!drop.isTaken() && !drop.isSpawned() && !itemExists(drop.getId(), drop.getX(), drop.getY(), true) && player.distanceToPoint(drop.getX(), drop.getY()) <= 60) {
				player.getItems().createGroundItem(drop.getId(), drop.getX(), drop.getY(), drop.getAmount(), drop.getHeight());
				spawnedDrops.add(drop);
				drop.setSpawned(true);
			}
		}
	}

	public static void reset(Player c) {
		for (GlobalDrop drop : globalDrops) {
			if (c.distanceToPoint(drop.getX(), drop.getY()) <= 60) {
				c.getItems().removeGroundItem(drop.getId(), drop.getX(), drop.getY(), drop.getAmount());
			}
		}
		spawnedDrops.clear();
		globalDrops.clear();
		initialize();
		for (GlobalDrop drop : globalDrops) {
			if (!drop.isTaken() && !drop.isSpawned() && !itemExists(drop.getId(), drop.getX(), drop.getY(), true) && c.distanceToPoint(drop.getX(), drop.getY()) <= 60) {
				c.getItems().createGroundItem(drop.getId(), drop.getX(), drop.getY(), drop.getAmount(), drop.getHeight());
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
		int itemX;
		/**
		 * cord y
		 */
		int itemY;

		private int height;
		/**
		 * item id
		 */
		int     id;
		/**
		 * item amount
		 */
		int     amount;
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
		 * @param id item id
		 * @param amount       item amount
		 * @param itemX  cord x
		 * @param itemY       cord y
		 */

		public GlobalDrop(int id, int amount, int itemX, int itemY) {
			this.id = id;
			this.amount = amount;
			this.itemX = itemX;
			this.itemY = itemY;
		}

		public GlobalDrop(int id, int amount, int itemX, int itemY, int height) {
			this.id = id;
			this.amount = amount;
			this.itemX = itemX;
			this.itemY = itemY;
			this.height = height;
		}

		/**
		 * get cord x
		 *
		 * @return return the statement
		 */
		public int getX() {
			return itemX;
		}

		/**
		 * get cord x
		 *
		 * @return return the statement
		 */
		public int getY() {
			return itemY;
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
		 * @param a true yes false no
		 */
		public void setTaken(boolean a) {
			taken = a;
		}

		/**
		 * set the time it was picked up
		 *
		 * @param a the a
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

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

	}

}