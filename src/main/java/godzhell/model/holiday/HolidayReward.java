package godzhell.model.holiday;

import godzhell.model.players.Player;

public interface HolidayReward {
	/**
	 * Gives the player a reward that is determined based on implementation
	 * 
	 * @param player the player receiving the reward
	 */
	public abstract void receive(Player player);

}
