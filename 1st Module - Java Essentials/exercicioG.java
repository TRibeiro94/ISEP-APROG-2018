//package APROG_2019;

import java.util.Scanner;

/**
 *
 * @author Tiago Ribeiro
 */
public class exercicioG {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numero = input.nextInt();
        int divisores = 0;
        if(numero < 0){
            //System.out.println("Inseriu um nº negativo.");
        }
        for(int i = 1; i <= numero; i++){
            if(numero % i == 0){
                System.out.println(i);
                divisores++;
            }
        }
        System.out.println("("+divisores+")");
    }
}
