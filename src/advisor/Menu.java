package advisor;

import advisor.command.Commands;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {

    public static void show(String[] programArgs) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String[] command = scanner.nextLine().split(" ");

            if ("exit".equals(command[0])) {
                System.out.println("---GOODBYE!---");
                break;
            }

            Commands.get(command[0]).execute(Arrays.copyOfRange(command, 1, command.length), programArgs);
        }
    }
}
