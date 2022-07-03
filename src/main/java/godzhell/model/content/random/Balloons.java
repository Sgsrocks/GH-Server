package godzhell.model.content.random;

import java.awt.Point;
import java.util.Random;

import godzhell.Server;
import godzhell.model.objects.Objects2;
import godzhell.model.players.Player;

public class Balloons extends Objects2 {

	static Random r = new Random();
	public static int item, amount;
	public static int x, y;

	@SuppressWarnings("static-access")
	public Balloons(int id, int x, int y, int height, int face, int type,
			int ticks, int item, int amount) {
		super(id, x, y, height, face, type, ticks);
		this.x = x;
		this.y = y;
		this.item = item;
		this.amount = amount;
	}

	public static void popBalloon(Player player, int x, int y) {
		PartyRoom.coords.remove(getCoords());
		Balloons empty = remove(x, y);
		Server.itemHandler.createGroundItem(player, item, x, y, amount, player.playerIndex);
		item = 0;
		amount = 0;
		Server.objectHandler.addObject(empty);
		Server.objectHandler.placeObject(empty);
		player.startAnimation(794);
	}

	public static Point getCoords() {
		return new Point(x, y);
	}

	public static Balloons getBalloon(int item, int amount) {
		return new Balloons(115 + r.nextInt(5), 3038 + r.nextInt(13),
				3372 + r.nextInt(13), 0, 0, 10, 0, item, amount);
	}

	public static Balloons getEmpty() {
		return new Balloons(115 + r.nextInt(5), 3038 + r.nextInt(13),
				3372 + r.nextInt(13), 0, 0, 10, 0, 0, 0);
	}
	public static Balloons remove(int x, int y) {
		return new Balloons(-1, x, y, 0, 0, 10, 0, 0, 0);
	}
}
