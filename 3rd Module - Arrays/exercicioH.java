//package APROG_2019;

import java.util.Scanner;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class exercicioH_3 {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int limite = input.nextInt();
        if (limite > 0) {
            int[] numeros = new int[limite];

            inserirNums(numeros);
            String escolha = input.next();
            while (!escolha.toUpperCase().equals("SAIR")) {
                if (escolha.toLowerCase().equals("direita")) {
                    rotateRight(numeros);
                    listarNums(numeros);
                } else if (escolha.toLowerCase().equals("esquerda")) {
                    rotateLeft(numeros);
                    listarNums(numeros);
                }
                escolha = input.next();
            }
        }
    }

    public static void inserirNums(int[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = input.nextInt();
        }
    }

    public static void listarNums(int[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
            System.out.printf("[%d]", numeros[i]);
        }
        System.out.println("");
    }

    public static void rotateRight(int[] numeros) {
        int last = numeros[numeros.length - 1];
        for (int i = numeros.length - 1; i > 0; i--) {
            numeros[i] = numeros[i - 1];
        }
        numeros[0] = last;
    }

    public static void rotateLeft(int[] numeros) {
        int first = numeros[0];
        for (int i = 0; i < numeros.length - 1; i++) {
            numeros[i] = numeros[i + 1];
        }
        numeros[numeros.length - 1] = first;
    }
}
