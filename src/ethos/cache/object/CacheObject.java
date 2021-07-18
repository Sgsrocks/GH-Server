package ethos.cache.object;

import ethos.clip.ObjectDef;
import ethos.model.objects.GameObjectDef;
import ethos.model.players.Position;

/**
 * Represents a single game object.
 * 
 * @author Graham Edgecombe
 * 
 */
public class CacheObject {

	/**
	 * The location.
	 */
	private Position location;

	/**
	 * The definition.
	 */
	private GameObjectDef def;

	/**
	 * The type.
	 */
	private int type = 0;

	/**
	 * The rotation.
	 */
	private int rotation = 0;

	/**
	 * Creates the game object.
	 * 
	 * @param gameObjectData
	 *            The definition.
	 * @param location
	 *            The location.
	 * @param type
	 *            The type.
	 * @param rotation
	 *            The rotation.
	 */
	public CacheObject(GameObjectData gameObjectData, Position location, int type, int rotation) {
		this.def = new GameObjectDef(gameObjectData.getId(), type, rotation, location);
		this.location = location;
		this.type = type;
		this.rotation = rotation;
	}

	/**
	 * Gets the location.
	 * 
	 * @return The location.
	 */
	public Position getLocation() {
		return location;
	}

	/**
	 * Gets the definition.
	 * 
	 * @return The definition.
	 */
	public GameObjectDef getDef() {
		return def;
	}

	/**
	 * Gets the type.
	 * 
	 * @return The type.
	 */
	public int getType() {
		return type;
	}

	/**
	 * Gets the rotation.
	 * 
	 * @return The rotation.
	 */
	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
	}

	public void setLocation(Position location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return GameObjectData.forId(def.getId()) + " " + location + " " + type + " " + rotation;
	}

}
