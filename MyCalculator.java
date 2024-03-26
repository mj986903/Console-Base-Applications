import java.util.*;
import java.lang.Math;

public class MyCalculator {
    static double prevOp = 0;
    static char op;
    static double newOp = 0;
    static boolean flag = true;
    static Scanner sc = new Scanner(System.in);

    public static void add() {
        System.out.print("Enter Second Operand : ");
        newOp = sc.nextDouble();
        System.out.println(prevOp + " + " + newOp + " = " + (prevOp + newOp));
        System.out.println();
        prevOp = prevOp + newOp;
    }

    public static void substraction() {
        System.out.print("Enter Second Operand : ");
        newOp = sc.nextDouble();
        System.out.println(prevOp + " - " + newOp + " = " + (prevOp - newOp));
        System.out.println();
        prevOp = prevOp - newOp;
    }

    public static void multiplication() {
        System.out.print("Enter Second Operand : ");
        newOp = sc.nextDouble();
        System.out.println(prevOp + " * " + newOp + " = " + (prevOp * newOp));
        System.out.println();
        prevOp = prevOp * newOp;
    }

    public static void division() {
        System.out.print("Enter Second Operand : ");
        newOp = sc.nextDouble();
        if (newOp == 0) {
            System.out.println("Error.");
            System.out.println();
            prevOp = 0;
            return;
        }
        System.out.println(prevOp + " / " + newOp + " = " + (prevOp / newOp));
        System.out.println();
        prevOp = prevOp / newOp;
    }

    public static void modulo() {
        System.out.print("Enter Second Operand : ");
        newOp = sc.nextDouble();
        System.out.println(prevOp + " % " + newOp + " = " + (prevOp % newOp));
        System.out.println();
        prevOp = prevOp % newOp;
    }

    public static void exponential() {
        System.out.print("Enter Second Operand : ");
        newOp = sc.nextDouble();
        System.out.println(prevOp + " ^ " + newOp + " = " + (Math.pow(prevOp, newOp)));
        System.out.println();
        prevOp = Math.pow(prevOp, newOp);
    }

    public static void fact() {
        int fact = 1;
        if (prevOp < 0) {
            System.out.println(prevOp + "!  = 0");
            System.out.println();
            return;
        }
        prevOp = (int) prevOp;
        for (int i = 1; i <= prevOp; i++) {
            fact = fact * i;
        }
        System.out.println(prevOp + "!  = " + fact);
        System.out.println();
        prevOp = fact;
    }

    public static void squreRoot() {
        System.out.println("Squre Root Of " + prevOp + " = " + (Math.sqrt(prevOp)));
        System.out.println();
        prevOp = Math.sqrt(prevOp);
    }

    public static void ln() {
        System.out.println("ln Of " + prevOp + " = " + (Math.log(prevOp)));
        System.out.println();
        prevOp = Math.log(prevOp);
    }

    public static void log() {
        System.out.println("log Of " + prevOp + " = " + (Math.log10(prevOp)));
        System.out.println();
        prevOp = Math.log10(prevOp);
    }

    public static void sine() {
        System.out.println("Sin Of " + prevOp + " = " + (Math.sin(prevOp)));
        System.out.println();
        prevOp = Math.sin(prevOp);
    }

    public static void cose() {
        System.out.println("Cos Of " + prevOp + " = " + (Math.cos(prevOp)));
        System.out.println();
        prevOp = Math.cos(prevOp);
    }

    public static void tane() {
        System.out.println("Tan Of " + prevOp + " = " + (Math.tan(prevOp)));
        System.out.println();
        prevOp = Math.tan(prevOp);
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println("********** Welcome To My Calculator **********");
        System.out.println();
        System.out.println();
        System.out.print("Rules : ");
        System.out.println(" 1. Adition --> +");
        System.out.println("         2. Substraction --> -");
        System.out.println("         3. Multiplication --> *");
        System.out.println("         4. Division --> /");
        System.out.println("         5. Modulo --> %");
        System.out.println("         6. Exponential --> ^");
        System.out.println("         7. Factorial --> !");
        System.out.println("         8. Squre Root --> @");
        System.out.println("         9. ln --> l");
        System.out.println("        10. log --> ~");
        System.out.println("        11. Sin() --> s");
        System.out.println("        12. Cos() --> c");
        System.out.println("        13. Tan() --> t");
        System.out.println("        14. Clear --> C");
        System.out.println("        15. Exit --> e");
        System.out.println();
        System.out.println();

        while (true) {
            flag = true;
            System.out.println("-------------------------------------------------------");
            System.out.print("Enter First Operand : ");
            prevOp = sc.nextDouble();

            while (flag) {
                System.out.print("Enter Operator : ");
                op = sc.next().charAt(0);

                switch (op) {

                    case '1':
                    case '+':
                        add();
                        break;

                    case '2':
                    case '-':
                        substraction();
                        break;

                    case '3':
                    case '*':
                        multiplication();
                        break;

                    case '4':
                    case '/':
                        division();
                        if (prevOp == 0) {
                            flag = false;
                        }
                        break;

                    case '5':
                    case '%':
                        modulo();
                        break;

                    case '6':
                    case '^':
                        exponential();
                        break;

                    case '7':
                    case '!':
                        fact();
                        break;

                    case '8':
                    case '@':
                        squreRoot();
                        break;

                    case '9':
                    case 'l':
                        ln();
                        break;

                    case '~':
                        log();
                        break;

                    case 's':
                        sine();
                        break;

                    case 'c':
                        cose();
                        break;

                    case 't':
                        tane();
                        break;

                    case 'C':
                        flag = false;
                        break;

                    case 'e':
                    case 'E':
                        return;

                    default:
                        System.out.println("Enter Valid Choice.");
                }

            }
        }
    }
}