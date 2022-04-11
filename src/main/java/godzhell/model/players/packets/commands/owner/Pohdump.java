package godzhell.model.players.packets.commands.owner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import godzhell.model.players.Player;
import godzhell.model.players.packets.commands.Command;

public class Pohdump extends Command {

	@Override
	public void execute(Player c, String input) {
		GsonBuilder builder = new GsonBuilder();
		builder.excludeFieldsWithoutExposeAnnotation();
		Gson gson = builder.create();

		System.out.println(gson.toJson(c.getHouse()));

	}

}
