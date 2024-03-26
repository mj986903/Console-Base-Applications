import java.util.*;

public class Online_Shopping_Cart {
    static Scanner sc = new Scanner(System.in);
    static Hashtable<String, Integer> itemSelected = new Hashtable<>();
    static int itemNumber = 0, quantity = 0;
    static Double totalCost = 0.0;

    public static void selectItem(int itemNumber, int quantity) {
        switch (itemNumber) {
            case 1:
                System.out.println("T-Shirt (" + quantity + " Units) Added To Your Cart.");
                itemSelected.put("T-Shirt", quantity);
                break;

            case 2:
                System.out.println("Jeans (" + quantity + " Units) Added To Your Cart.");
                itemSelected.put("Jeans", quantity);
                break;

            case 3:
                System.out.println("Sneakers (" + quantity + " Units) Added To Your Cart.");
                itemSelected.put("Sneakers", quantity);
                break;

            case 4:
                System.out.println("Backpack (" + quantity + " Units) Added To Your Cart.");
                itemSelected.put("Backpack", quantity);
                break;

            case 5:
                System.out.println("Hat (" + quantity + " Units) Added To Your Cart.");
                itemSelected.put("Hat", quantity);
                break;

            default:
                System.out.println("Product Not Available.");
        }
        System.out.println();
    }

    public static void removeItem(int removeNumber) {
        Enumeration<String> enu = itemSelected.keys();
        boolean find = false;
        switch (removeNumber) {
            case 1:
                while (enu.hasMoreElements()) {
                    String key = enu.nextElement();
                    if (key.equals("T-Shirt")) {
                        find = true;
                        System.out.println("T-Shirt (" + itemSelected.get(key) + " Units) Removed From Your Cart.");
                        itemSelected.remove("T-Shirt");
                    }
                }
                if (!find) {
                    System.out.println("T-Shirt Not In The Cart.");
                }
                break;

            case 2:
                while (enu.hasMoreElements()) {
                    String key = enu.nextElement();
                    if (key.equals("Jeans")) {
                        find = true;
                        System.out.println("Jeans (" + itemSelected.get(key) + " Units) Removed From Your Cart.");
                        itemSelected.remove("Jeans");
                    }
                }
                if (!find) {
                    System.out.println("Jeans Not In The Cart.");
                }
                break;

            case 3:
                while (enu.hasMoreElements()) {
                    String key = enu.nextElement();
                    if (key.equals("Sneakers")) {
                        find = true;
                        System.out.println("Sneakers (" + itemSelected.get(key) + " Units) Removed From Your Cart.");
                        itemSelected.remove("Sneakers");
                    }
                }
                if (!find) {
                    System.out.println("Sneakers Not In The Cart.");
                }
                break;

            case 4:
                while (enu.hasMoreElements()) {
                    String key = enu.nextElement();
                    if (key.equals("Backpack")) {
                        find = true;
                        System.out.println("Backpack (" + itemSelected.get(key) + " Units) Removed From Your Cart.");
                        itemSelected.remove("Backpack");
                    }
                }
                if (!find) {
                    System.out.println("Backpack Not In The Cart.");
                }
                break;

            case 5:
                while (enu.hasMoreElements()) {
                    String key = enu.nextElement();
                    if (key.equals("Hat")) {
                        find = true;
                        System.out.println("Hat (" + itemSelected.get(key) + " Units) Removed From Your Cart.");
                        itemSelected.remove("Hat");
                    }
                }
                if (!find) {
                    System.out.println("Hat Not In The Cart.");
                }
                break;

            default:
                System.out.println("Product Not Available.");
        }
        System.out.println();
    }

    public static void myShoppingCart() {
        Enumeration<String> enu = itemSelected.keys();
        int i = 1;
        totalCost = 0.0;
        System.out.println();
        System.out.println("Your Shopping Cart : ");
        while (enu.hasMoreElements()) {
            String key = enu.nextElement();
            System.out.print(i++ + ". " + key + "(" + itemSelected.get(key) + " units) - Price: ");

            switch (key) {
                case "T-Shirt":
                    System.out.println("$15.99");
                    totalCost = totalCost + itemSelected.get(key) * 15.99;
                    break;

                case "Jeans":
                    System.out.println("$29.99");
                    totalCost = totalCost + itemSelected.get(key) * 29.99;
                    break;

                case "Sneakers":
                    System.out.println("$49.99");
                    totalCost = totalCost + itemSelected.get(key) * 49.99;
                    break;

                case "Backpack":
                    System.out.println("$39.99");
                    totalCost = totalCost + itemSelected.get(key) * 39.99;
                    break;

                case "Hat":
                    System.out.println("$9.99");
                    totalCost = totalCost + itemSelected.get(key) * 9.99;
                    break;
            }
        }
        System.out.println();
        System.out.println("Total Cost : $" + totalCost);
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("********** Welcome To Online Shopping **********");
        System.out.println();
        System.out.println();
        System.out.println("Available Products : ");
        System.out.println();
        System.out.println("1. T-Shirt (Price: $15.99)");
        System.out.println("2. Jeans (Price: $29.99)");
        System.out.println("3. Sneakers (Price: $49.99)");
        System.out.println("4. Backpack (Price: $39.99)");
        System.out.println("5. Hat (Price: $9.99)");
        System.out.println();
        System.out.println();

        boolean flag = true;

        while (flag) {
            System.out.print("Enter The Item Number To Add To Your Cart : ");
            itemNumber = sc.nextInt();
            System.out.print("Enter The Quantity : ");
            quantity = sc.nextInt();
            selectItem(itemNumber, quantity);
            System.out.println("Do You Want To Continue Shopping ? (Yes/No)");
            String conString = sc.next();
            System.out.println();
            if (conString.equalsIgnoreCase("Yes")) {
                flag = true;
            } else {
                boolean flag2 = true;
                while (flag2) {

                    myShoppingCart();

                    System.out.println("Do You Want To Remove Any Item ? (Yes/No)");
                    String remString = sc.next();
                    System.out.println();

                    if (remString.equalsIgnoreCase("Yes")) {
                        System.out.print("Enter The Item Number To Remove From Your Cart : ");
                        int removeNumber = sc.nextInt();
                        removeItem(removeNumber);

                        if (itemSelected.isEmpty()) {
                            return;
                        }
                    } else {
                        System.out.println("Proceed To Checkout ? (Yes/No) : ");
                        String procString = sc.next();
                        if (procString.equalsIgnoreCase("Yes")) {
                            System.out.println();
                            System.out.println();
                            System.out.println("Thank You For Shopping With Us!");
                            System.out.println("Your Total Amount Payable Is : " + totalCost + "$");
                            return;
                        } else {
                            System.out.println();
                            flag2 = false;
                        }
                    }
                }
            }
        }
    }
}
