import java.util.Scanner;

class MenuHandler {
    private Scanner scanner;
    private boolean showMenu;

    public MenuHandler(Scanner scanner) {
        this.scanner = scanner;
        this.showMenu = true;
    }

    public void displayMenu() {
        System.out.println("\nSelect the search method:");
        System.out.println("\t-1- Naive algorithm");
        System.out.println("\t-2- The algorithm of Rabin-Karpov");
        System.out.println("\t-3- Input new string");
        System.out.println("\t-4- Input new substring");
        System.out.println("\t-5- Exit");
    }

    public int getSelectedMenu() {
        int selectedMenu = 0;
        do {
            System.out.print("enter your choice: ");
            // while (!scanner.hasNextInt()) {
            //     System.out.print("--> ");
            //     scanner.next();
            // }
            selectedMenu = scanner.nextInt();
            scanner.nextLine();

        } while (selectedMenu < 1 || selectedMenu > 5);

        return selectedMenu;
    }

    public boolean shouldShowMenu() {
        return showMenu;
    }

    public void setShowMenu(boolean showMenu) {
        this.showMenu = showMenu;
    }
}