//package APROG_2019;

import java.util.Scanner;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class exercicioE_3 {
    static Scanner in = new Scanner (System.in);

    public static void main(String[] args) {
       float[]vec = new float [20];
       String [] nomes = new String [20];
       int contador = prencheerArrays(nomes,vec);
       float media = calcularMediaVec(vec,contador);
       print (media,vec,nomes,contador);

    }

    public static int prencheerArrays (String[]nomes, float[]vec){
        int i =0;
        String nome =in.nextLine();
        while (!nome.equalsIgnoreCase("fim")){
            nomes[i] = nome;
            vec[i] = in.nextFloat();
            in.nextLine();
            i++;
            nome=in.nextLine();
        }
        return i;
    }

    public static float calcularMediaVec(float[]vec,int qInseridos){
        float soma=0;
        for(int i = 0;i < qInseridos;i++){
            soma += vec[i];
        }
        float media = soma / qInseridos;
      return media;
    }

    public static void print(float media,float[]vec,String []nomes,int qInseridos){
        System.out.printf("%.1f\n",media);
        for(int i = 0;i < qInseridos ;i++){
            if(media > vec[i]){
                System.out.println(nomes[i]);
            }
        }
    }
}
