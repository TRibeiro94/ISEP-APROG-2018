//package APROG_2019;

import java.util.Scanner;

/**
 * @author Tiago Ribeiro (1181444)
 */
public class exercicioJ {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double maiorPercentagem = 0.0;
        int num;
        int N = input.nextInt();
        if (N < 0) {
            //System.out.println("numero negativo inserido.");
        } else {
            for (int i = 0; i < N; i++) {
                num = input.nextInt();
                double percentagem = ((double) contadorDivisores(num) / (double) contadorDigitos(num)) * 100.0;
                System.out.println(String.format("%.2f", percentagem) + "%");
                if (percentagem > maiorPercentagem) {
                    maiorPercentagem = percentagem;
                }
            }
            System.out.println(String.format("(%.2f", maiorPercentagem) + "%)");
        }
    }

    // conta digitos de um número
    public static int contadorDigitos(int num) {
        int contadorDigitos = 0;
        while (num != 0) {
            num /= 10;
            contadorDigitos++;
        }
        return contadorDigitos;
    }

    // conta divisores de um número
    public static int contadorDivisores(int num) {
        int numOriginal = num;
        int contadorDivisores = 0, digito;
        while (num > 0) {
            digito = num % 10;
            if (digito != 0) {
                if (numOriginal % digito == 0) {
                    contadorDivisores++;
                }
            }
            num = num / 10;
        }
        return contadorDivisores;
    }
}
