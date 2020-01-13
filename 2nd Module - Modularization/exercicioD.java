//package APROG_2019;

import java.util.Scanner;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class exercicioD_2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        if(m >= n){
            combinacoes(m, n);
            permutacoes(m, n);
        }else{

        }

    }

    public static int fatorial(int num) {
        int resultado = 1;
        if(num == 0){
            return resultado;
        }

        for (int i = 1; i <= num; i++) {
            resultado = resultado * i;
        }
        return resultado;
    }

    public static void combinacoes(int m, int n) {
        int k = m - n;
        int fatM = fatorial(m);
        int fatN = fatorial(n);
        int fatK = fatorial(k);
        int resultado = fatM / (fatN * fatK);
        System.out.printf("C(%d,%d)=%d\n", m, n, resultado);
    }

    public static void permutacoes(int m, int n) {
        int k = m - n;
        int fatM = fatorial(m);
        int fatK = fatorial(k);
        int resultado = fatM / fatK;
        System.out.printf("P(%d,%d)=%d\n",m,n,resultado);
    }
}
