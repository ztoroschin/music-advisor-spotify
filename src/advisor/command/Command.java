package advisor.command;

public abstract class Command {

    public abstract void execute(String[] commandArgs, String[] programArgs);
}
