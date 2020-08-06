package advisor.command;

import java.util.HashMap;
import java.util.Map;

public class Commands {

    private static Map<String, Command> commands = new HashMap<>();

    static {
        commands.put("new", new NewCommand());
        commands.put("featured", new FeaturedCommand());
        commands.put("categories", new CategoriesCommand());
        commands.put("playlists", new PlaylistsCommand());
        commands.put("auth", new AuthCommand());
    }

    public static Command get(String command) {
        if (!commands.containsKey(command)) {
            throw new UnsupportedOperationException("Unknown command");
        }
        return commands.get(command);
    }
}
