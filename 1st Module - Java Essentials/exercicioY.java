//package APROG_2019;

import java.util.Scanner;

/**
 * @author Tiago Ribeiro(1181444)
 */
public class exercicioY {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int qtd = 0;
        int num = input.nextInt();
        if(num <= 0){
            //System.out.println("introduziu 0 ou negativo.");
        }else{
            for(int i=1; i< num; i++){
                if(num % i == 0){
                    if(i % 3 == 0){
                        System.out.println(i);
                        qtd++;
                    }
                }
            }
            if(qtd == 0){
                System.out.println("sem divisores multiplos de 3");
            }
        }
    }
}
