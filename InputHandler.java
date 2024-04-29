import java.util.Scanner;

class InputHandler {
    public static String getStringInput(Scanner in) {
        String input = in.nextLine().trim().toLowerCase();
        while (input.isEmpty()) {
            System.out.println("Please enter a valid non-empty string: ");
            input = in.nextLine().trim().toLowerCase();
        }
        return input;
    }
}