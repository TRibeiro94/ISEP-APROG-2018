//package APROG_2019;

import java.util.Scanner;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class exercicioC_3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int[] array = new int[num];

        for (int i = 0; i < num; i++) {
            int n = input.nextInt();
            array[i] = n;
        }
        boolean flag = isCrescente(array);
        System.out.println("sempre crescente = " + flag);

    }

    public static boolean isCrescente(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] >= array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
