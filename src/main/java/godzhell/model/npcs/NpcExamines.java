package godzhell.model.npcs;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class NpcExamines {

	public static final NpcExamines[] DEFINITIONS = new NpcExamines[15000];

	public static void add(int index, NpcExamines def) {
		DEFINITIONS[index] = def;
	}


	private static Map<Integer, NpcExamines> definitions = new HashMap<>();

	public static void load() throws IOException {
		System.out.println("Loading npc examine info...");

		List<NpcExamines> list = new Gson().fromJson(FileUtils.readFileToString(new File("./data/json/npc-examines.json")), new TypeToken<List<NpcExamines>>() {
		}.getType());

		list.stream().filter(Objects::nonNull).forEach(item -> definitions.put((int) item.id, item));

		System.out.println("Loaded " + definitions.size() + " npc examine infos.");
	}

	public static NpcExamines forId(int id) {
		return definitions.get(id);
	}

	public static Map<Integer, NpcExamines> getDefinitions() {
		return definitions;
	}

	private short id;

	private String examine;


	public short getId() {
		return id;
	}

	public String getName() {
		return examine;
	}
}
