package advisor.command;

import advisor.Application;

class CategoriesCommand extends Command {

    @Override
    public void execute(String[] args) {
        if (!Application.isActive()) {
            System.out.println("Please, provide access for application.");
            return;
        }
        System.out.println("---CATEGORIES---\n" +
                "Top Lists\n" +
                "Pop\n" +
                "Mood\n" +
                "Latin");
    }
}
