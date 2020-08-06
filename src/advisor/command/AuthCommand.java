package advisor.command;

import advisor.Application;

public class AuthCommand extends Command {

    @Override
    public void execute(String[] args) {
        System.out.println("https://accounts.spotify.com/authorize?client_id=266682ab64a84a5498544b7c7f8181f2&redirect_uri=http://localhost:8080&response_type=code");
        Application.setActive(true);
        System.out.println("---SUCCESS---");
    }
}
