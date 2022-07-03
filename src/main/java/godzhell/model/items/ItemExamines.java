package godzhell.model.items;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ItemExamines {

	public static final ItemExamines[] DEFINITIONS = new ItemExamines[35000];

	public static void add(int index, ItemExamines def) {
		DEFINITIONS[index] = def;
	}


	private static Map<Integer, ItemExamines> definitions = new HashMap<>();

	public static void load() throws IOException {
		System.out.println("Loading item examine info...");

		List<ItemExamines> list = new Gson().fromJson(FileUtils.readFileToString(new File("./data/json/item-examines.json")), new TypeToken<List<ItemExamines>>() {
		}.getType());

		list.stream().filter(Objects::nonNull).forEach(item -> definitions.put((int) item.id, item));

		System.out.println("Loaded " + definitions.size() + " item examine infos.");
	}

	public static ItemExamines forId(int id) {
		return definitions.get(id);
	}

	public static Map<Integer, ItemExamines> getDefinitions() {
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
