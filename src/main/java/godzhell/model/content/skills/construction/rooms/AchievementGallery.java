package godzhell.model.content.skills.construction.rooms;

import java.util.ArrayList;
import java.util.List;

import godzhell.model.content.skills.construction.Room;
import godzhell.model.content.skills.construction.RoomObject;

public class AchievementGallery extends Room {

	public AchievementGallery() {
		super(1864, 5760);
		setName("Achievement Gallery");
		List<RoomObject> objects = new ArrayList<RoomObject>();
		objects.add(new RoomObject(15263, 2, 0, 0, 5, "Curtain"));
		objects.add(new RoomObject(15263, 5, 0, 0, 5, "Curtain"));
		objects.add(new RoomObject(15263, 2, 7, 0, 5, "Curtain"));
		objects.add(new RoomObject(15263, 5, 7, 0, 5, "Curtain"));
		objects.add(new RoomObject(15263, 7, 2, 0, 5, "Curtain"));
		objects.add(new RoomObject(15263, 7, 5, 0, 5, "Curtain"));
		objects.add(new RoomObject(15263, 0, 2, 0, 5, "Curtain"));
		objects.add(new RoomObject(15263, 0, 5, 0, 5, "Curtain"));
		objects.add(new RoomObject(15313, 0, 4, 0, 0, "Door hotspot"));
		objects.add(new RoomObject(15314, 0, 3, 0, 0, "Door hotspot"));
		objects.add(new RoomObject(15313, 7, 4, 2, 0, "Door hotspot"));
		objects.add(new RoomObject(15314, 7, 3, 2, 0, "Door hotspot"));
		objects.add(new RoomObject(15313, 4, 0, 3, 0, "Door hotspot"));
		objects.add(new RoomObject(15314, 3, 0, 3, 0, "Door hotspot"));
		objects.add(new RoomObject(15313, 4, 7, 1, 0, "Door hotspot"));
		objects.add(new RoomObject(15314, 3, 7, 1, 0, "Door hotspot"));
		setObjects(objects);
		// TODO Auto-generated constructor stub
	}

}
