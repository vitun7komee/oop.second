import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter string: ");
        String string = InputHandler.getStringInput(in);

        System.out.println("\nEnter substring: ");
        String substring = InputHandler.getStringInput(in);

        // Создание объекта Solution с использованием шаблонного паттерна "Стратегия"
        Solution<String> solution = new Solution<>(new NaiveStringSearchStrategy<>());

        MenuHandler menuHandler = new MenuHandler(in);

        while (menuHandler.shouldShowMenu()) {
            menuHandler.displayMenu();
            int selectedMenu = menuHandler.getSelectedMenu();

            switch (selectedMenu) {
                case 1:
                    solution.setStrategy(new NaiveStringSearchStrategy<>()); // Установка стратегии наивного поиска
                    break;
                case 2:
                    solution.setStrategy(new RabinKarpStringSearchStrategy<>()); // Установка стратегии Рабина-Карпа
                    break;
                case 3:
                    System.out.println("New string: ");
                    string = InputHandler.getStringInput(in);
                    break;
                case 4:
                    System.out.println("New substring: ");
                    substring = InputHandler.getStringInput(in);
                    break;
                case 5:
                    menuHandler.setShowMenu(false);
                    break;
                default:
                    System.out.println("Something went wrong");
                    break;
            }

            if (menuHandler.shouldShowMenu()) {
                // Использование метода containsSubstring с текущей стратегией
                System.out.println("ANSWER: " + solution.containsSubstring(string, substring));
            }
        }

        in.close();
    }
}
