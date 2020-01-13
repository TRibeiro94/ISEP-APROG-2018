//package APROG_2019;

import java.util.Scanner;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class exercicioH_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n, tentativas = 5;
        boolean capicua = false;

            while(capicua == false){
                n = input.nextInt();
                capicua = checkCapicua(n);
                tentativas --;

                if(capicua == true){
                    System.out.println("capicua");
                }else if(tentativas == 0){
                    System.out.println("tentativas excedidas");
                    capicua = true;
                }
            }
    }

    public static boolean checkCapicua(int numero) {
        int resto, invertido = 0, auxiliar = numero;
        while (auxiliar > 0){
            resto = auxiliar % 10;
            invertido = invertido*10 + resto;
            auxiliar /= 10;
        }
        if (invertido == numero) {
            return true;
        }
        return false;
    }
}
