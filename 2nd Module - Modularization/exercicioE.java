//package APROG_2019;

import java.util.Scanner;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class exercicioE_2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int maior = 0;
        int parMaior1 = 0;
        int parMaior2 = 0;
        //System.out.println("num:");
        int n = input.nextInt();
        if (n <= 0) {
            //System.out.println("erro");
        } else {
            for (int i = 0; i < n; i++) {
                //System.out.println("introduza 2 nums:");
                int par1 = input.nextInt();
                int par2 = input.nextInt();
                if (qtdNumsMesmaPosicao(par1, par2) >= maior) {
                    maior = qtdNumsMesmaPosicao(par1, par2);
                    parMaior1 = par1;
                    parMaior2 = par2;
                }
            }
            if (maior == 0) {
                System.out.println("sem resultados");
            }
            else{
                System.out.println(parMaior1 + "/" + parMaior2);
            }
        }
    }

    public static int qtdNumsMesmaPosicao(int par1, int par2) {
        int aux1 = par1;
        int aux2 = par2;
        int quantidadeIguais = 0;
        while (aux1 > 0 || aux2 > 0) {
            int digito1 = aux1 % 10;
            int digito2 = aux2 % 10;
            if (digito1 == digito2) {
                quantidadeIguais++;
            }
            aux1 = aux1 / 10;
            aux2 = aux2 / 10;
        }
        return quantidadeIguais;
    }
}
