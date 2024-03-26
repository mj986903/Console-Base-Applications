import java.util.*;

public class Phone_Book_Using_Array {
    private static final int MAX_ENTRIES = 1000;
    private static String[] names;
    private static String[] numbers;
    private static int size;

    public Phone_Book_Using_Array() {
        names = new String[MAX_ENTRIES];
        numbers = new String[MAX_ENTRIES];
        size = 0;
    }

    private static void addEntry(String name, String number) {
        if (size >= MAX_ENTRIES) {
            System.out.println("PhoneBook Is Full.");
            return;
        }
        names[size] = name;
        numbers[size] = number;
        size++;
        System.out.println("Contact Number Added Successfully.");
    }

    private static String searchNumber(String name) {
        for (int i = 0; i < size; i++) {
            if (names[i] == name) {
                return numbers[i];
            }
        }
        return "Number Not Found";
    }

    private static void printEntries() {
        if (size == 0) {
            System.out.println("PhoneBook is Empty.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(names[i] + " : " + numbers[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println("********** Welcome To PhoneBook **********");
        System.out.println();
        System.out.println();
        System.out.println("1. Add Contact");
        System.out.println("2. Search Contact");
        System.out.println("3. Print All Contact");
        System.out.println("4. Exit");
        System.out.println();
        System.out.println();

        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.println();
            System.out.print("What You Want To Do : ");
            int choice = sc.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.print("Name : ");
                    String name = sc.next();
                    System.out.print("Number : ");
                    String number = sc.next();
                    addEntry(name, number);
                    break;

                case 2:
                    System.out.print("Name : ");
                    String name1 = sc.next();
                    String result = searchNumber(name1);
                    System.out.println(result);
                    break;

                case 3:
                    printEntries();
                    break;

                case 4:
                    flag = false;
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}
