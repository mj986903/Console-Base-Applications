import java.util.*;
import java.text.SimpleDateFormat;

abstract class Account {

    public static Random rd = new Random();
    public static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    public static Date date = new Date();

    private long acNumber;
    private static String acName;
    private int acBalance;
    private int noOfTransaction = 0;
    private String transactionHistory[] = new String[100];

    abstract public void deposite(int amount);

    abstract public void withdraw(int amount);

    public void setAcNumber(long acNumber) {
        this.acNumber = acNumber;
    }

    public long getAcNumber() {
        return acNumber;
    }

    public void setAcBalance(int acBalance) {
        this.acBalance = acBalance;
    }

    public int getAcBalance() {
        return acBalance;
    }

    public void setAcName(String acName) {
        this.acName = acName;
    }

    public String getAcName() {
        return acName;
    }

    public void getInfo() {
        System.out.println("Account Holder Name = " + acName + ".");
        System.out.println("Balance = " + acBalance + ".");
    }

    public void setTransactionHistory(String transaction) {
        transactionHistory[noOfTransaction] = transaction;
        noOfTransaction++;
    }

    public void getTransactionHistory() {
        if (transactionHistory.length == 0) {
            System.out.println("No Transaction History Exits.");
        } else {
            System.out.println("Transaction History : ");
            for (int i = 0; i < noOfTransaction; i++) {
                System.out.println(transactionHistory[i]);
            }
        }
    }
}

class SavingAccount extends Account {
    SavingAccount(String name) {
        long num = Math.abs(rd.nextLong()) % 10000000000L;
        setAcNumber(num);
        setAcBalance(0);
        setAcName(name);
    }

    public void deposite(int amount) {
        if (amount > 100000) {
            System.out.println("Saving Account Maximum Limit To Deposite Is 100000$.");
        } else if (amount < 0) {
            System.out.println("Kindly Enter Valid Deposite Amount.");
        } else {
            setAcBalance(getAcBalance() + amount);
            System.out.println(
                    "Your " + amount + "$ Credited In Saving Account Number " + getAcNumber() + " Successfully.");
            String transaction = formatter.format(date) + "   " + amount + "$ Credited   Balance=" + getAcBalance()
                    + ".";
            setTransactionHistory(transaction);
        }

    }

    public void withdraw(int amount) {
        if (amount > 10000) {
            System.out.println("Saving Account Maximum Limit To Withdraw Is 10000$.");
        } else if (amount < 0) {
            System.out.println("Kindly Enter Valid Withdraw Amount.");
        } else if (amount > getAcBalance()) {
            System.out.println("Insufficient Balance.");
        } else {
            setAcBalance(getAcBalance() - amount);
            System.out.println(
                    "Your " + amount + "$ Debited From Saving Account Number " + getAcNumber() + " Successfully.");
            String transaction = formatter.format(date) + "   " + amount + "$ Debited   Balance=" + getAcBalance()
                    + ".";
            setTransactionHistory(transaction);
        }
    }
}

class CheckingAccount extends Account {
    CheckingAccount(String name) {
        long num = Math.abs(rd.nextLong()) % 10000000000L;
        setAcNumber(num);
        setAcBalance(0);
        setAcName(name);
    }

    public void deposite(int amount) {
        if (amount < 0) {
            System.out.println("Kindly Enter Deposite Amount Valid.");
        } else {
            setAcBalance(getAcBalance() + amount);
            System.out.println(
                    "Your " + amount + "$ Credited In Checking Account Number " + getAcNumber() + " Successfully.");
            String transaction = formatter.format(date) + "   " + amount + "$ Credited   Balance=" + getAcBalance()
                    + ".";
            setTransactionHistory(transaction);
        }
    }

    public void withdraw(int amount) {
        if (amount < 0) {
            System.out.println("Kindly Enter Valid Withdraw Amount.");
        } else if (amount > getAcBalance()) {
            System.out.println("Insufficient Balance.");
        } else {
            setAcBalance(getAcBalance() - amount);
            System.out.println(
                    "Your " + amount + "$ Debited From Checking Account Number " + getAcNumber() + " Successfully.");
            String transaction = formatter.format(date) + "   " + amount + "$ Debited   Balance=" + getAcBalance()
                    + ".";
            setTransactionHistory(transaction);
        }
    }
}

public class Banking_System {
    static Scanner sc = new Scanner(System.in);
    static List<CheckingAccount> checkingAcList = new ArrayList<>();
    static List<SavingAccount> savingAcList = new ArrayList<>();
    static Hashtable<Long, Integer> authentication = new Hashtable<>();

    public static void createAccount(String name, int age) {
        if (age < 18) {
            System.out.println("Sorry, You Can Not Create Account.");
        } else {
            System.out.print("Which Type Of Account ?(Saving/Checking) : ");
            String type = sc.next();
            System.out.print("Enter 4-Digit Pin For Authentication : ");
            int pin = sc.nextInt();
            if (pin <= 1000 || pin >= 9999) {
                System.out.println("Sorry, Your Pin Authentication Failed.");
                return;
            }

            if (type.equalsIgnoreCase("saving")) {
                SavingAccount sa = new SavingAccount(name);
                authentication.put(sa.getAcNumber(), pin);
                System.out.println(name + ", Your Saving Account Created Successfully.");
                System.out.println();
                System.out.println("Account Details : ");
                System.out.println("Account Number = " + sa.getAcNumber());
                System.out.println("Account Holder Name = " + sa.getAcName());
                System.out.println("Balance = " + sa.getAcBalance());
                savingAcList.add(sa);
            } else if (type.equalsIgnoreCase("checking")) {
                CheckingAccount ca = new CheckingAccount(name);
                authentication.put(ca.getAcNumber(), pin);
                System.out.println(name + ", Your Checking Account Created Successfully.");
                System.out.println();
                System.out.println("Account Details : ");
                System.out.println("Account Number = " + ca.getAcNumber());
                System.out.println("Account Holder Name = " + ca.getAcName());
                System.out.println("Balance = " + ca.getAcBalance());
                checkingAcList.add(ca);
            } else {
                System.out.println("Choose Valid Account Type.");
            }
        }
    }

    public static int findSavingAccount(long acNumber) {
        for (int i = 0; i < savingAcList.size(); i++) {
            SavingAccount currSA = savingAcList.get(i);
            if (currSA.getAcNumber() == acNumber) {
                return i;
            }
        }
        return -1;
    }

    public static int findCheckingAccount(long acNumber) {
        for (int i = 0; i < checkingAcList.size(); i++) {
            CheckingAccount currCA = checkingAcList.get(i);
            if (currCA.getAcNumber() == acNumber) {
                return i;
            }
        }
        return -1;
    }

    public static void depositeAccount(long acNumber, int amount) {
        int s = findSavingAccount(acNumber);
        int c = findCheckingAccount(acNumber);
        if (s == -1 && c == -1) {
            System.out.println("Invalid Account Number.");
            return;
        }
        if (s == -1) {
            CheckingAccount currCA = checkingAcList.get(c);
            currCA.deposite(amount);
            return;
        }
        if (c == -1) {
            SavingAccount currSA = savingAcList.get(s);
            currSA.deposite(amount);
            return;
        }
    }

    public static void withdrawAccount(long acNumber, int amount) {
        int s = findSavingAccount(acNumber);
        int c = findCheckingAccount(acNumber);
        if (s == -1 && c == -1) {
            System.out.println("Invalid Account Number.");
            return;
        }
        System.out.print("Enter Authentication Pin : ");
        int checkPin = sc.nextInt();
        if (s == -1) {
            if (checkPin == authentication.get(acNumber)) {
                CheckingAccount currCA = checkingAcList.get(c);
                currCA.withdraw(amount);
                return;
            } else {
                System.out.println("Wrong Authentication Pin.");
                return;
            }

        }
        if (c == -1) {
            if (checkPin == authentication.get(acNumber)) {
                SavingAccount currSA = savingAcList.get(s);
                currSA.withdraw(amount);
                return;
            } else {
                System.out.println("Wrong Authentication Pin.");
                return;
            }
        }
    }

    public static void checkBalance(long acNumber) {
        int s = findSavingAccount(acNumber);
        int c = findCheckingAccount(acNumber);
        if (s == -1 && c == -1) {
            System.out.println("Invalid Account Number.");
            return;
        }
        System.out.print("Enter Authentication Pin : ");
        int checkPin = sc.nextInt();
        if (s == -1) {
            if (checkPin == authentication.get(acNumber)) {
                CheckingAccount currCA = checkingAcList.get(c);
                System.out.println("Balance = " + currCA.getAcBalance() + "$");
                return;
            } else {
                System.out.println("Wrong Authentication Pin.");
                return;
            }

        }
        if (c == -1) {
            if (checkPin == authentication.get(acNumber)) {
                SavingAccount currSA = savingAcList.get(s);
                System.out.println("Balance = " + currSA.getAcBalance() + "$");
                return;
            } else {
                System.out.println("Wrong Authentication Pin.");
                return;
            }

        }
    }

    public static void deleteAccount(long acNumber) {
        int s = findSavingAccount(acNumber);
        int c = findCheckingAccount(acNumber);
        if (s == -1 && c == -1) {
            System.out.println("Invalid Account Number.");
            return;
        }
        System.out.print("Enter Authentication Pin : ");
        int checkPin = sc.nextInt();
        if (s == -1) {
            if (checkPin == authentication.get(acNumber)) {
                CheckingAccount currCA = checkingAcList.get(c);
                System.out.println("Your Checking Account Number " + acNumber + " Is Deleted Successfully.");
                checkingAcList.remove(c);
                authentication.remove(acNumber);
                return;
            } else {
                System.out.println("Wrong Authentication Pin.");
                return;
            }

        }
        if (c == -1) {
            if (checkPin == authentication.get(acNumber)) {
                SavingAccount currSA = savingAcList.get(s);
                System.out.println("Your Saving Account Number " + acNumber + " Is Deleted Successfully.");
                savingAcList.remove(s);
                authentication.remove(acNumber);
                return;
            } else {
                System.out.println("Wrong Authentication Pin.");
                return;
            }

        }
    }

    public static void getInfoAccount(long acNumber) {
        int s = findSavingAccount(acNumber);
        int c = findCheckingAccount(acNumber);
        if (s == -1 && c == -1) {
            System.out.println("Invalid Account Number.");
            return;
        }
        if (s == -1) {
            CheckingAccount currCA = checkingAcList.get(c);
            System.out.println("Account Type = Checking Account.");
            currCA.getInfo();
            return;
        }
        if (c == -1) {
            SavingAccount currSA = savingAcList.get(s);
            System.out.println("Account Type = Saving Account.");
            currSA.getInfo();
            return;
        }
    }

    public static void getTransaction(long acNumber) {
        int s = findSavingAccount(acNumber);
        int c = findCheckingAccount(acNumber);
        if (s == -1 && c == -1) {
            System.out.println("Invalid Account Number.");
            return;
        }
        if (s == -1) {
            CheckingAccount currCA = checkingAcList.get(c);
            currCA.getTransactionHistory();
            return;
        }
        if (c == -1) {
            SavingAccount currSA = savingAcList.get(s);
            currSA.getTransactionHistory();
            return;
        }
    }

    public static void main(String[] args) {
        System.out.println("********** Welcome To My Bank **********");
        System.out.println();
        System.out.println();
        System.out.println("1. Create Account");
        System.out.println("2. Deposite Cash");
        System.out.println("3. Withdraw Cash");
        System.out.println("4. Check Balance");
        System.out.println("5. Transaction History");
        System.out.println("6. Delete Your Account");
        System.out.println("7. Get Information Of Account");
        System.out.println("8. Exit");

        boolean flag = true;
        while (flag) {
            System.out.println();
            System.out.println();
            System.out.print("Enter Your Choice : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Your Name : ");
                    String name = sc.next();
                    System.out.print("Enter Your Age : ");
                    int age = sc.nextInt();
                    createAccount(name, age);
                    break;

                case 2:
                    if (savingAcList.isEmpty() && checkingAcList.isEmpty()) {
                        System.out.println("Accounts Not Exits In Bank.");
                        break;
                    }
                    System.out.print("Enter Your Account Number : ");
                    long acno = sc.nextLong();
                    System.out.print("Enter Deposite Amount : ");
                    int amount = sc.nextInt();
                    depositeAccount(acno, amount);
                    break;

                case 3:
                    if (savingAcList.isEmpty() && checkingAcList.isEmpty()) {
                        System.out.println("Accounts Not Exits In Bank.");
                        break;
                    }
                    System.out.print("Enter Your Account Number : ");
                    long acno1 = sc.nextLong();
                    System.out.print("Enter Withdraw Amount : ");
                    int amount1 = sc.nextInt();
                    withdrawAccount(acno1, amount1);
                    break;

                case 4:
                    if (savingAcList.isEmpty() && checkingAcList.isEmpty()) {
                        System.out.println("Accounts Not Exits In Bank.");
                        break;
                    }
                    System.out.print("Enter Your Account Number : ");
                    long acno2 = sc.nextLong();
                    checkBalance(acno2);
                    break;

                case 5:
                    if (savingAcList.isEmpty() && checkingAcList.isEmpty()) {
                        System.out.println("Accounts Not Exits In Bank.");
                        break;
                    }
                    System.out.print("Enter Your Account Number : ");
                    long acno3 = sc.nextLong();
                    getTransaction(acno3);
                    break;

                case 6:
                    if (savingAcList.isEmpty() && checkingAcList.isEmpty()) {
                        System.out.println("Accounts Not Exits In Bank.");
                        break;
                    }
                    System.out.print("Enter Your Account Number : ");
                    long acno4 = sc.nextLong();
                    deleteAccount(acno4);
                    break;

                case 7:
                    if (savingAcList.isEmpty() && checkingAcList.isEmpty()) {
                        System.out.println("Accounts Not Exits In Bank.");
                        break;
                    }
                    System.out.print("Enter Your Account Number : ");
                    long acno5 = sc.nextLong();
                    getInfoAccount(acno5);
                    break;

                case 8:
                    System.out.println("Thank You For Using Our Banking System.");
                    flag = false;
                    break;

                default:
                    System.out.println("Invalid Choice.");
                    break;
            }
        }
    }
}
