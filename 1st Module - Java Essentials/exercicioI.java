//package APROG_2019;

import java.util.Scanner;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class exercicioI {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        int aux;
        if (num1 <= 0 || num2 <= 0) {
            //System.out.println("Inseriu um ou dois números nulos ou negativos.");
        } else {
            if (num1 > num2) {
                aux = num1;
                num1 = num2;
                num2 = aux;
            }
            System.out.println(minimoMultiploComum(num1, num2));
        }
    }

    public static int minimoMultiploComum(int num1, int num2) {
        int resto, aux1=num1, aux2=num2;
        do{
            resto = aux1 % aux2;
            aux1 = aux2;
            aux2 = resto;
        } while (resto != 0);

        return (num1 * num2) / aux1;
    }
}
