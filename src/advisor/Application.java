package advisor;

public class Application {

    private static boolean active = false;

    public static boolean isActive() {
        return active;
    }

    public static void setActive(boolean active) {
        Application.active = active;
    }
}
