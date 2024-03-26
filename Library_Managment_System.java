import java.util.*;

class Library {

    private static String books[];
    private static int noOfBooks;

    Library() {
        this.books = new String[100];
        this.noOfBooks = 0;
    }

    public void addBook(String book) {
        books[noOfBooks] = book;
        noOfBooks++;
    }

    public void showBooks() {
        int m = 1;
        for (int i = 0; i < noOfBooks; i++) {
            System.out.println(m + ". " + books[i]);
            m++;
        }
    }

    public void issueBook(String book) {
        for (int i = 0; i < noOfBooks; i++) {
            boolean flag = true;
            if (book.equals(books[i])) {
                flag = false;
                System.out.println("Book issued sucessfully.");
                noOfBooks--;
                for (int j = i; j < noOfBooks; j++) {
                    books[j] = books[j + 1];
                }
                break;
            }
            if (flag) {
                System.out.println(book + " is not available.");
            }
        }
    }

    public void returnBook(String book) {
        books[noOfBooks] = book;
        noOfBooks++;
    }
}

class Library_Managment_System {
    public static void main(String args[]) {
        Library l = new Library();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome TO My Library");
        System.out.println();
        System.out.println("1. Show Available Books");
        System.out.println("2. Add Book");
        System.out.println("3. Issue Book");
        System.out.println("4. Return Book");
        System.out.println();

        boolean flag = true;
        while (flag) {
            System.out.print("Enter Your Choice : ");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    l.showBooks();
                    break;

                case 2:
                    System.out.print("Enter Book Name : ");
                    String s = sc.next();
                    l.addBook(s);
                    System.out.println("Book Added Sucessfully.");
                    break;

                case 3:
                    System.out.print("Enter Book Name : ");
                    String s1 = sc.next();
                    l.issueBook(s1);
                    break;

                case 4:
                    System.out.print("Enter Book Name : ");
                    String s2 = sc.next();
                    l.returnBook(s2);
                    System.out.println("Book Returned Sucessfully.");
                    break;

                case 5:
                    flag = false;
                    break;

                default:
                    break;
            }
        }
    }
}