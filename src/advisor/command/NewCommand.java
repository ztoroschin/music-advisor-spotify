package advisor.command;

import advisor.Application;

class NewCommand extends Command {

    @Override
    public void execute(String[] args) {
        if (!Application.isActive()) {
            System.out.println("Please, provide access for application.");
            return;
        }
        System.out.println("---NEW RELEASES---\n" +
                "Mountains [Sia, Diplo, Labrinth]\n" +
                "Runaway [Lil Peep]\n" +
                "The Greatest Show [Panic! At The Disco]\n" +
                "All Out Life [Slipknot]");
    }
}
