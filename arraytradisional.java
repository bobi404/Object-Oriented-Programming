import java.util.Scanner;

public class arraytradisional {
    static String[] names = new String[100];
    static String[] pass = new String[100];
    static String[] phone = new String[100];
    static int count = 0;

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
        names[count] = sc.nextLine();
        System.out.print("Pass : ");
        pass[count] = sc.nextLine();
        System.out.print("Phone : ");
        phone[count] = sc.nextLine();
        count++;
        System.out.println("New data is added");
    }

    static void showData() {
        if (count == 0) {
            System.out.println("No data exists!");
            return;
        }
        System.out.printf("%-5s %-10s %-10s %-15s\n", "No", "Name", "Pass", "Phone");
        for (int i = 0; i < count; i++) {
            System.out.printf("%-5d %-10s %-10s %-15s\n", (i+1), names[i], pass[i], phone[i]);
        }
    }

    static void deleteData(Scanner sc) {
        if (count == 0) {
            System.out.println("No data to delete!");
            return;
        }
        showData();
        System.out.print("Input data number to be deleted: ");
        int del = sc.nextInt();
        sc.nextLine();
        if (del < 1 || del > count) {
            System.out.println("Invalid number!");
            return;
        }
        for (int i = del-1; i < count-1; i++) {
            names[i] = names[i+1];
            pass[i] = pass[i+1];
            phone[i] = phone[i+1];
        }
        count--;
        System.out.println("Data is removed");
    }
}
