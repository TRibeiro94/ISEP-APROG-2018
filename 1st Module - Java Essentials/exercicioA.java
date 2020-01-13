//package APROG_2019;

import java.util.Scanner;
/**
 * @author Tiago Ribeiro (1181444)
 */
public class exercicioA {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        long numero = input.nextLong();
        existePares(numero);
    }

    public static void existePares(long numero) {
        long auxiliar, soma = 0;
        while (numero > 0){
            auxiliar = numero % 10;
            if (auxiliar % 2 == 0) {
                soma += auxiliar;
                numero = numero / 10;
            }else{
                numero = numero / 10;
            }
        }
        System.out.println(soma);
    }
}
