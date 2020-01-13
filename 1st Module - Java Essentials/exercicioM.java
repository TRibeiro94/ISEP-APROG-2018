//package APROG_2019;

import java.util.Scanner;

/**
 * @author Tiago Ribeiro (1181444)
 */
public class exercicioM {

    public static void main(String args[]) {
        int n1 = 0, n2 = 1, n3;
        Scanner input = new Scanner(System.in);
        int numero = input.nextInt();
        if (numero <= 0) {
            //System.out.println("inseriu 0 ou um nº negativo.");
        }else if(numero == 1){
            System.out.println(n1);
        }else {
            System.out.println(n1);
            System.out.println(n2);

            for (int i = 2; i < numero; ++i) {
                n3 = n1 + n2;
                System.out.println(n3);
                n1 = n2;
                n2 = n3;
            }
        }
    }
}
