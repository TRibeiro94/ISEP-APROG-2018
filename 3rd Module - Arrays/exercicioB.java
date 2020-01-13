//package APROG_2019;

import java.util.Scanner;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class exercicioB_3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] array = new int[100];
        int posicao = 0;

        int num = input.nextInt();
        if (num < 0) {
            //System.out.println("invalido: nr negativo");
        } else {
            array[posicao] = num;
            posicao++;
            while (num >= 0) {
                num = input.nextInt();
                if (num >= 0) {
                    array[posicao] = num;
                    posicao++;
                }
            }
            ocorrenciasDoMenor(array, posicao);
        }
    }

    public static void ocorrenciasDoMenor(int[] array, int num) {
        int menor = Integer.MAX_VALUE;
        int ocorrencias = 0;

        // verifica qual é o menor valor no array
        for (int i = 0; i < num; i++) {
            if (array[i] < menor) {
                menor = array[i];
            }
        }
        // conta as ocorrencias do menor numero
        for (int k = 0; k < num; k++) {
            if (array[k] == menor) {
                ocorrencias++;
            }
        }
        System.out.println("menor=" + menor);
        System.out.println("ocorrencias=" + ocorrencias);
    }
}
