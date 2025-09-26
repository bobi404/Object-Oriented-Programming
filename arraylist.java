import java.util.ArrayList;
import java.util.Scanner;

class User {
    String name, pass, phone;
    User(String name, String pass, String phone) {
        this.name = name;
        this.pass = pass;
        this.phone = phone;
    }
}

public class arraylist {
    static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Input Data");
            System.out.println("2. Show Data");
            System.out.println("3. Delete Data");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: inputData(sc); break;
                case 2: showData(); break;
                case 3: deleteData(sc); break;
                case 4: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 4);
        sc.close();
    }

    static void inputData(Scanner sc) {
        System.out.print("Name : ");
        String name = sc.nextLine();
        System.out.print("Pass : ");
        String pass = sc.nextLine();
        System.out.print("Phone : ");
        String phone = sc.nextLine();
        users.add(new User(name, pass, phone));
        System.out.println("New data is added");
    }

    static void showData() {
        if (users.isEmpty()) {
            System.out.println("No data exists!");
            return;
        }
        System.out.printf("%-5s %-10s %-10s %-15s\n", "No", "Name", "Pass", "Phone");
        int i = 1;
        for (User u : users) {
            System.out.printf("%-5d %-10s %-10s %-15s\n", i, u.name, u.pass, u.phone);
            i++;
        }
    }

    static void deleteData(Scanner sc) {
        if (users.isEmpty()) {
            System.out.println("No data to delete!");
            return;
        }
        showData();
        System.out.print("Input data number to be deleted: ");
        int del = sc.nextInt();
        sc.nextLine();
        if (del < 1 || del > users.size()) {
            System.out.println("Invalid number!");
            return;
        }
        users.remove(del-1);
        System.out.println("Data is removed");
    }
}
