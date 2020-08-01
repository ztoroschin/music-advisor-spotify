package advisor.command;

class PlaylistsCommand extends Command {

    @Override
    public void execute(String[] args) {
        System.out.printf("---%s PLAYLISTS---\n" +
                "Walk Like A Badass  \n" +
                "Rage Beats  \n" +
                "Arab Mood Booster  \n" +
                "Sunday Stroll\n", args[0].toUpperCase());
    }
}
