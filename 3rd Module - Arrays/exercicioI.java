//package APROG_2019;

import java.util.Scanner;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class exercicioI_3 {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        String[][] nome = new String[3][4];
        int[][] numEntrada = new int[3][4];
        int[][] numPiso = new int[3][4];
        prencheerMatriz(nome, numEntrada, numPiso);
        //System.out.println("nome a procurar :\n");
        String nomeP = input.nextLine();
        encontraProprietario(nomeP, nome, numEntrada, numPiso);
    }

    public static void prencheerMatriz(String[][] nome, int[][] numEntrada, int[][] numPiso) {
        for (int i = 0; i < nome.length; i++) {
            for (int j = 0; j < nome[0].length; j++) {
                nome[i][j] = input.nextLine();
                numEntrada[i][j] = i;
                numPiso[i][j] = j;
            }
        }
    }

    public static void encontraProprietario(String nomeP, String[][] nome, int[][] numEntrada, int[][] numPiso) {
        int count = 0;
        for (int i = 0; i < nome.length; i++) {
            for (int j = 0; j < nome[0].length; j++) {
                if (nome[i][j].equalsIgnoreCase(nomeP)) {
                    System.out.println("nome=" + nome[i][j]);
                    System.out.println("entrada=" + numEntrada[i][j]);
                    System.out.println("piso=" + numPiso[i][j]);
                    count++;
                }
            }
        }
        if (count == 0) {
            System.out.println("Nao mora no predio");
        }
    }
}
