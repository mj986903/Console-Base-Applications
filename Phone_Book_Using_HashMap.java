import java.util.*;

public class Phone_Book_Using_HashMap {
    private static HashMap<String, String> phoneBook;

    public Phone_Book_Using_HashMap() {
        phoneBook = new HashMap<String, String>();
    }

    private static void addEntry(String name, String number) {
        phoneBook.put(name, number);
        System.out.println("Contact Number Added Successfully.");
    }

    private static String searchNumber(String name) {
        return phoneBook.getOrDefault(name, "Number Not Found.");
    }

    private static void printEntries() {
        if (phoneBook.isEmpty()) {
            System.out.println("PhoneBook is Empty.");
        }
        for (String s : phoneBook.keySet()) {
            System.out.println("Name : " + s);
            System.out.println("Number : " + phoneBook.get(s));
            System.out.println();
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
                    String name = sc.nextLine();
                    sc.nextLine();
                    System.out.print("Number : ");
                    String number = sc.nextLine();
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
