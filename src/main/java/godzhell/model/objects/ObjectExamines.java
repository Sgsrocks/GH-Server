package godzhell.model.objects;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ObjectExamines {

	public static final ObjectExamines[] DEFINITIONS = new ObjectExamines[50000];

	public static void add(int index, ObjectExamines def) {
		DEFINITIONS[index] = def;
	}


	private static Map<Integer, ObjectExamines> definitions = new HashMap<>();

	public static void load() throws IOException {
		System.out.println("Loading object examine info...");

		List<ObjectExamines> list = new Gson().fromJson(FileUtils.readFileToString(new File("./data/json/obj-examines.json")), new TypeToken<List<ObjectExamines>>() {
		}.getType());

		list.stream().filter(Objects::nonNull).forEach(object -> definitions.put((int) object.id, object));

		System.out.println("Loaded " + definitions.size() + " object examine infos.");
	}

	public static ObjectExamines forId(int id) {
		return definitions.get(id);
	}

	public static Map<Integer, ObjectExamines> getDefinitions() {
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
