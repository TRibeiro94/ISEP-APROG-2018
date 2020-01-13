//package APROG_2019;

import java.util.Scanner;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class exercicioF_3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float[] taxaJuro = new float[6];

        for (int i = 0; i < taxaJuro.length; i++) {
            taxaJuro[i] = input.nextFloat();
        }

        float depInicial = input.nextFloat();

        double valorFinal = depInicial + depInicial * taxaJuro[0];
        for (int i = 1; i < taxaJuro.length; i++) {
            valorFinal = valorFinal + taxaJuro[i] * valorFinal;
        }

        System.out.printf("valor final=%.2f%n", valorFinal);
    }
}
