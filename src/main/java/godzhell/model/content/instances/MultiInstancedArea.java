package godzhell.model.content.instances;

import java.util.List;
import java.util.stream.Collectors;

import godzhell.model.players.Boundary;
import godzhell.model.players.Player;
import godzhell.model.players.PlayerHandler;

public class MultiInstancedArea extends InstancedArea {

	/**
	 * Creates a new single instanced area for multiple players
	 * 
	 * @param boundary the boundary of the instanced area
	 * @param height the height of the instanced area
	 */
	public MultiInstancedArea(Boundary boundary, int height) {
		super(boundary, height);
	}

	public List<Player> getPlayers() {
		return PlayerHandler.nonNullStream().filter(player -> Boundary.isIn(player, super.boundary) && player.getHeightLevel == height).collect(Collectors.toList());
	}

	@Override
	public void onDispose() {

	}
}
