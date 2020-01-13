//package APROG_2019;

import java.util.Scanner;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class exercicioD_3 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        //System.out.println("Introduza o nº alunos:");
        int numAlunos = input.nextInt();
        int[] array = new int[numAlunos];
        prencheerArray(array);
        int [] frequencias = determinarNotas(array);
        mostrarFrequencias(frequencias);

    }

    public static void prencheerArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            //System.out.println("Introduzca a nota obtida pelo aluno");
            int nota = input.nextInt();
            array[i] = nota;
        }
    }

    public static int [] determinarNotas(int[] array) {
        int [] frequencias = new int [21];
        for (int j = 0; j < frequencias.length; j++) {
            int count = 0;
            for (int k = 0; k < array.length; k++) {
               if(j == array[k]){
                   count ++;
               }
            }
           frequencias[j]=count;
        }
        return frequencias;
    }

    public static void mostrarFrequencias (int [] frequencias){
        for(int i = 0; i < 21; i++){
            System.out.println(i + " " + frequencias[i]);
        }
    }
}
