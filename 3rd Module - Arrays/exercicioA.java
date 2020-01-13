//package APROG_2019;

import java.util.Scanner;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class exercicioA_3 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int numAlunos = input.nextInt();
        if (numAlunos <= 0) {
            //System.out.println("invalido: nulo ou negativo");
        } else {
            int[] notas = new int[numAlunos];

            for (int i = 0; i < numAlunos; i++) {
                notas[i] = input.nextInt();
            }

            double media = media(notas);
            int reprovados = reprovados(notas);

            System.out.printf("media=%.1f\n", media);
            System.out.printf("reprovacoes=%d\n", reprovados);
        }
    }

    public static double media(int[] notas) {
        int soma = 0;
        double media;
        for (int i = 0; i < notas.length; i++) {
            soma += notas[i];
        }
        media = (double) soma / (double) notas.length;
        return media;
    }

    public static int reprovados(int[] notas) {
        int reprovados = 0;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] < 10) {
                reprovados++;
            }
        }
        return reprovados;
    }
}
