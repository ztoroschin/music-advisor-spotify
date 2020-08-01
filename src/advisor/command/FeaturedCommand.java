package advisor.command;

class FeaturedCommand extends Command {

    @Override
    public void execute(String[] args) {
        System.out.println("---FEATURED---\n" +
                "Mellow Morning\n" +
                "Wake Up and Smell the Coffee\n" +
                "Monday Motivation\n" +
                "Songs to Sing in the Shower");
    }
}
