package advisor.command;

import advisor.Application;

class FeaturedCommand extends Command {

    @Override
    public void execute(String[] commandArgs, String[] programArgs) {
        if (!Application.isActive()) {
            System.out.println("Please, provide access for application.");
            return;
        }
        System.out.println("---FEATURED---\n" +
                "Mellow Morning\n" +
                "Wake Up and Smell the Coffee\n" +
                "Monday Motivation\n" +
                "Songs to Sing in the Shower");
    }
}
