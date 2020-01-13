//package APROG_2019;

import java.util.Scanner;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class exercicioG_3 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

    int limite = input.nextInt();
        if (limite > 0) {
            int[] numeros = new int[limite];

            fillArray(numeros, limite);
            printArray(invertArray(numeros, limite));

        }
    }

    public static void fillArray(int[] array, int limite) {
        for (int i = 0; i < limite; i++) {
            array[i] = input.nextInt();
        }
    }

    public static int[] invertArray(int[] array, int limite) {
        int j = limite;
        int[] numInvertido = new int[limite];

        for (int i = 0; i < limite; i++) {
            numInvertido[j - 1] = array[i];
            j--;
        }
        return numInvertido;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
