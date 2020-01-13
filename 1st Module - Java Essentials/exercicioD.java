//package APROG_2019;

import java.util.Scanner;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class exercicioD {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long numero = input.nextInt();

        if (numero < 0) {
            //System.out.println("Introduziu de imeadiato um nº negativo.");
        } else {
            while (numero >= 0){
                existeImpares(numero);
                numero = input.nextInt();
            }
        }
    }

    public static void existeImpares(long numero) {
        long auxiliar, produto = 1;
        if (numero > 0) {
            while (numero > 0) {
                auxiliar = numero % 10;
                if (auxiliar % 2 != 0) {
                    produto *= auxiliar;
                    numero = numero / 10;
                } else {
                    numero = numero / 10;
                }
            }
            if(produto != 1){
                System.out.println(produto);
            }else{
                System.out.println("nao ha algarismos impares");
            }
        }
    }
}
