package advisor.command;

class CategoriesCommand extends Command {

    @Override
    public void execute(String[] args) {
        System.out.println("---CATEGORIES---\n" +
                "Top Lists\n" +
                "Pop\n" +
                "Mood\n" +
                "Latin");
    }
}
