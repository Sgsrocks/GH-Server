package godzhell.model.npcs;

import godzhell.model.players.Player;
import godzhell.util.Misc;

import java.util.HashMap;
import java.util.Map;

public class NPCDeathTracker {

	/**
	 * The player this is relative to
	 */
	private Player player;

	/**
	 * A mapping of npcs names with their corresponding kill count
	 */
	private Map<String, Integer> tracker = new HashMap<>();

	/**
	 * Creates a new {@link NPCDeathTracker} object for a singular player
	 * 
	 * @param player
	 *            the player
	 */
	public NPCDeathTracker(Player player) {
		this.player = player;
	}

	/**
	 * Attempts to add a kill to the total amount of kill for a single npc
	 * 
	 * @param name
	 *            the name of the npc
	 */
	public void add(String name) {
		if (name == null) {
			return;
		} else {
			int kills = (tracker.get(name) == null ? 0 : tracker.get(name)) + 1;
			tracker.put(name, kills);
			if (name.equalsIgnoreCase("none")) {
				return;
			}
			player.sendMessage("Your " + Misc.capitalizeJustFirst(name.replaceAll("_", " "))
					+ " kill count is: <col=FF0000>" + kills + "</col>.");
		}
	}

	/**
	 * Determines the total amount of kills
	 * 
	 * @return the total kill count
	 */
	public long getTotal() {
		return tracker.values().stream().mapToLong(Integer::intValue).sum();
	}

	/**
	 * A mapping of npcs with their corresponding kill count
	 * 
	 * @return the map
	 */
	public Map<String, Integer> getTracker() {
		return tracker;
	}

	public int getKc(String name) {
		name = name.toLowerCase();

		//if (name.equalsIgnoreCase(TobConstants.THEATRE_OF_BLOOD)) {
		//	return player.tobCompletions;
		//}

		if (name.equalsIgnoreCase("Chambers of Xeric") || name.equalsIgnoreCase("cox")) {
			return player.raidCount;
		}

		return tracker.getOrDefault(name, 0);
	}

}
