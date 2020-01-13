//package APROG_2019;

import java.util.Scanner;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class exercicioJ_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numPlayer1 = input.nextInt();
        int numPlayer2;
        int numTentativas = 0;
        if(numPlayer1 < 0 || numPlayer1 > 100){

        }else{
           print30Lines();
           do{
               numPlayer2 = input.nextInt();
               numTentativas++;
               check(numPlayer1, numPlayer2);
           }
           while(numPlayer2 != numPlayer1);
        }
        System.out.println(numTentativas);
    }
    public static void print30Lines(){
        for(int i = 0; i < 30; i++){
            System.out.println();
        }
    }

    public static void check(int p1, int p2){
        if(p1 > p2){
            System.out.println("Tente maior");
        }
        else if(p1 < p2){
            System.out.println("Tente menor");
        }else{
            System.out.println("Acertou");
        }
    }
}
