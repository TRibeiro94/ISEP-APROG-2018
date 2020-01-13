//package APROG_2019;

import java.util.Scanner;

/**
 * @author Tiago Ribeiro (1181444)
 */
public class exercicioE {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long numeroOctal = input.nextInt();

        if (numeroOctal < 0) {
            //System.out.println("Introduziu de imeadiato um nº negativo.");
        } else {
            while (numeroOctal >= 0) {
                getDecimal(numeroOctal);
                numeroOctal = input.nextInt();
            }
        }
    }

    public static void getDecimal(long numOctal) {
        int decimal = 0;
        int potencia = 0;

        while (true) {
            if (numOctal == 0){
                break;
            } else {
                long temp = numOctal % 10;
                decimal += temp * Math.pow(8, potencia);
                numOctal = numOctal / 10;
                potencia++;
            }
        }
        System.out.println(decimal);
    }
}
