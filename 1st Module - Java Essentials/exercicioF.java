//package APROG_2019;

import java.util.Scanner;

/**
 * @author Tiago Ribeiro (1181444)
 */
public class exercicioF {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numero = input.nextInt();
        if(numero < 0){
            //System.out.println("Inseriu nº negativo.");
        }
        capicua(numero);
    }

    public static void capicua(int numero) {
        int resto, invertido = 0, auxiliar = numero;
        while (auxiliar > 0){
            resto = auxiliar % 10;
            invertido = invertido*10 + resto;
            auxiliar /= 10;

        }
        if (invertido == numero) {
            System.out.println("capicua");
        } else {
            System.out.println("nao capicua");
        }
    }
}
