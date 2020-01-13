//package APROG_2019;

import java.util.Scanner;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class exercicioG_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if(n <= 0){

        }else{
            for(int i= 0; i< n; i++){
                if(checkArmstrong(i) == true && i < n){
                    System.out.println(i);
                }
            }
        }
    }

    public static boolean checkArmstrong(int n){
        int digitos = contadorDigitos(n);
        int digito, soma = 0, copia = n;
        while (n != 0) {
            digito = n % 10;
            soma += Math.pow(digito, digitos);
            n /= 10;
        }
        if(soma == copia){
            return true;
        }
        return false;
    }

    public static int contadorDigitos(int num){
        int contadorDigitos = 0;
        while (num != 0) {
            num /= 10;
            contadorDigitos++;
        }
        return contadorDigitos;
    }
}
