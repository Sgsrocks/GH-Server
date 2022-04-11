package godzhell.model.content.skills.construction;

import godzhell.model.players.Player;
import godzhell.model.content.skills.construction.rooms.Default;

public class Construction {

	public static Room getCurrentRoom(Player client) {
		return client.getHouse().getRoom((int) ((client.absX / 8) - 2) + 4, (int) ((client.absY / 8) - 2) + 4);
	}
	public static void handleConstructionClick(final Player client, int id, final int x, final int y) {	
		switch (id) {
		case 15305:
		case 15306:
		case 15317:
		case 15316:
		case 15308:
		case 15307:
		case 15314:
		case 15313:
			/*if (!canBuild(player)) {
				return;
			}*/
			final House house = client.getHouse();
			
			Room buildRoom;

			int locX = x % 8, locY = y % 8;
			int roomX = 0, roomY = 0;
			
			if (locX == 3 && locY == 7 || locX == 4 && locY == 7) { // north
				roomX = (x / 8) + 2;
				roomY = ((y + 1) / 8) + 2;
//				house.addRoom(client, id, x, y, Rooms.Build(client), x / 8, (y + 1) / 8);
			}
			if (locX == 3 && locY == 0 || locX == 4 && locY == 0) { // south
				roomX = (x / 8) + 2;
				roomY = ((y - 1) / 8) + 2;
//				house.addRoom(client, id, x, y, Rooms.Build(client), x / 8, (y - 1) / 8);
			}
			if (locX == 7 && locY == 3 || locX == 7 && locY == 4) { // east
				roomX = ((x + 1) / 8) + 2;
				roomY = (y / 8) + 2;
//				house.addRoom(client, id, x, y, Rooms.Build(client), (x + 1) / 8, y / 8);
			}
			if (locX == 0 && locY == 3 || locX == 0 && locY == 4) { // west
				roomX = ((x - 1) / 8) + 2;
				roomY = (y / 8) + 2;
//				house.addRoom(client, id, x, y, Rooms.Build(client), (client.absX - 1) / 8, client.absY / 8);
			}
			
			if (roomX == 6 && roomY == 6) {
				client.sendMessage("You cannot replace this garden.");
				return;
			}
			
			buildRoom = house.getRoom(roomX, roomY, 0);
			
			if (buildRoom == null) {
				client.sendMessage("You can't build there!");
				return;
			}
			
			client.toReplace = buildRoom;
			
			if (!(buildRoom instanceof Default)) {
				client.getDH().sendStatement("You already have a " + buildRoom.getName() + " in that spot.");
				client.start(new RoomDialogue2());
				return;
			}
			
			client.getPA().showInterface(30946); 
			break;
		}
	}
/*
 * public static void handleConstructionClick(final Player client, int id, final
 * int x, final int y) { switch (id) { case 15314: case 15313:
 * client.getPA().showInterface(30946); break; } } public static void
 * HandleConstructionButton(final Player client, int id, final int x, final int
 * y) { Room buildRoom;
 * 
 * int locX = x % 8, locY = y % 8; int roomX = 0, roomY = 0; switch (id) { case
 * 121131: client.RoomClicked = 1; client.replaceWith = new Parlour();
 * //client.getHouse().buildRoom(client); client.start(new RoomDialogue());
 * break; }
 * 
 * } public static void HandleConstruction(final Player client, int id, final
 * int x, final int y) { final House house = client.getHouse();
 * 
 * Room buildRoom;
 * 
 * int locX = x % 8, locY = y % 8; int roomX = 0, roomY = 0; client.RoomClicked
 * = id; if (!canBuild(player)) { return; } if (locX == 3 && locY == 7 || locX
 * == 4 && locY == 7) { // north roomX = (x / 8) + 2; roomY = ((y + 1) / 8) + 2;
 * house.addRoom(client, client.RoomClicked, x, y, Rooms.Build(client), x / 8,
 * (y + 1) / 8); } if (locX == 3 && locY == 0 || locX == 4 && locY == 0) { //
 * south roomX = (x / 8) + 2; roomY = ((y - 1) / 8) + 2; house.addRoom(client,
 * client.RoomClicked, x, y, Rooms.Build(client), x / 8, (y - 1) / 8); } if
 * (locX == 7 && locY == 3 || locX == 7 && locY == 4) { // east roomX = ((x + 1)
 * / 8) + 2; roomY = (y / 8) + 2; house.addRoom(client, client.RoomClicked, x,
 * y, Rooms.Build(client), (x + 1) / 8, y / 8); } if (locX == 0 && locY == 3 ||
 * locX == 0 && locY == 4) { // west roomX = ((x - 1) / 8) + 2; roomY = (y / 8)
 * + 2; house.addRoom(client, client.RoomClicked, x, y, Rooms.Build(client),
 * (client.absX - 1) / 8, client.absY / 8); }
 * 
 * if (roomX == 6 && roomY == 6) {
 * client.sendMessage("You cannot replace this garden."); return; }
 * 
 * buildRoom = house.getRoom(roomX, roomY, 0);
 * 
 * if (buildRoom == null) { client.sendMessage("You can't build there!");
 * return; }
 * 
 * client.toReplace = buildRoom;
 * 
 * if (!(buildRoom instanceof Default)) {
 * client.getDH().sendStatement("You already have a " + buildRoom.getName() +
 * " in that spot."); client.nextChat = 903; return; }
 * 
 * //client.start(new RoomDialogue());
 * 
 * } }
 */
}
