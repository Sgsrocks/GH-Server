package godzhell.model.player;

import godzhell.cache.region.RegionManager;

public class World {

	/**
	 * World instance.
	 */
	private static final World world = new World();

	/**
	 * Gets the world instance.
	 * 
	 * @return The world instance.
	 */
	public static World getWorld() {
		return world;
	}

	/**
	 * The region manager.
	 */
	private RegionManager regionManager = new RegionManager();

	/**
	 * Gets the region manager.
	 * 
	 * @return The region manager.
	 */
	public RegionManager getRegionManager() {
		return regionManager;
	}
}
