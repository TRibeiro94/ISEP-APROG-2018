//package APROG_2019;

import java.util.Scanner;

/**
 * @author Tiago Ribeiro (1181444)
 */
public class exercicioH {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int divisores = 0, qtdDivisoresDePrimos = 2;
        int numero = input.nextInt();
        if (numero < 0) {
            //System.out.println("Inseriu um nº negativo.");
        } else {
            for (int i = 2; i < numero; i++) {
                if (numero % i != 0) {
                    divisores++;
                }
            }
            if (divisores == numero - qtdDivisoresDePrimos) {
                System.out.println("primo");
            } else {
                System.out.println("nao e primo");
            }
        }
    }
}
