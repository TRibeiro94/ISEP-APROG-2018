//package APROG_2019;

import java.util.Scanner;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class exercicioA_2 {
    public static void main(String[] args) {
        int cont = -1;
        String name;
        Scanner input = new Scanner(System.in);
        do{
            name = input.nextLine();
            cont++;
        }while(palindrome(name) != true);

        System.out.println(cont);
    }

    public static boolean palindrome(String name){
        int i = 0, j = name.length() - 1;

        while (i < j) {

            if (name.charAt(i) != name.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
