package advisor.command;

import advisor.Application;

class PlaylistsCommand extends Command {

    @Override
    public void execute(String[] commandArgs, String[] programArgs) {
        if (!Application.isActive()) {
            System.out.println("Please, provide access for application.");
            return;
        }
        System.out.printf("---%s PLAYLISTS---\n" +
                "Walk Like A Badass  \n" +
                "Rage Beats  \n" +
                "Arab Mood Booster  \n" +
                "Sunday Stroll\n", commandArgs[0].toUpperCase());
    }
}
