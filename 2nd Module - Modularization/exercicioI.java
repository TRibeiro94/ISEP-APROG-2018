//package APROG_2019;

import static java.lang.System.exit;
import java.util.Scanner;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class exercicioI_2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if (n < 0) {

        } else {
            elemFibonaci(n);
        }
    }

    public static void elemFibonaci(int n) {
        if (n == 0 || n == 1) {
            System.out.println("e de Fibonacci");
            exit(0);
        }

        int n1 = 0, n2 = 1, n3;
        for (int i = 2; i < n; ++i) {
            n3 = n1 + n2;
            if (n == n3) {
                System.out.println("e de Fibonacci");
                exit(0);
            }
            n1 = n2;
            n2 = n3;
        }
        System.out.println("nao e de Fibonacci");
    }
}
