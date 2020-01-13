//package APROG_2019;

import java.util.Scanner;

/**
 * @author Tiago Ribeiro (1181444)
 */
public class exercicioZ {

    public static void main(String[] args) {
        int digito, contadorPares = 0, copia;
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        copia = num;

        while (num > 0) {
            digito = num % 10;
            if (digito % 2 == 0 || digito == 0) {
                contadorPares++;
            }
            num = num/10;
        }
        double percent = ((double)contadorPares/contadorDigitos(copia))*100.0;
        System.out.println(String.format("%.2f",percent)+"%");
        maxImpar(copia);
    }
    // ve o maior digito impar de um numero
    public static void maxImpar(int num) {
        int maxAtual = 0, digito;
        while (num > 0) {
            digito = num % 10;

            if (digito % 2 != 0) {
                if (digito > maxAtual) {
                    maxAtual = digito;
                }
            }
            num = num / 10;
        }
        if(maxAtual != 0){
            System.out.println(maxAtual);
        }else{
            System.out.println("nao ha algarismos impares");
        }
    }
    // conta digitos de um número
    public static int contadorDigitos(int num){
        int contadorDigitos = 0;
        while (num != 0) {
            num /= 10;
            contadorDigitos++;
        }
        return contadorDigitos;
    }
}
