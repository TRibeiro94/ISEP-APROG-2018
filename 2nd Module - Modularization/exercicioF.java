//package APROG_2019;

import java.util.Scanner;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class exercicioF_2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String solido;
        float raio = 0, altura = 0;

        //System.out.println("Insira um sólido");
        solido = input.nextLine();
        while (!solido.equalsIgnoreCase("FIM")) {
            if (solido.equalsIgnoreCase("esfera")) {
                //System.out.println("raio:");
                raio = input.nextFloat();
                calculo(raio, altura, solido);
            } else if(solido.equalsIgnoreCase("cone") || solido.equalsIgnoreCase("cilindro")){
                //System.out.println("raio e altura:");
                raio = input.nextFloat();
                altura = input.nextFloat();
                calculo(raio, altura, solido);
            }
            //System.out.println("solido nao reconhecido");
            solido = input.nextLine();
        }
    }

    public static void calculo(float raio, float altura, String solido) {
        float Vcilindro, Vcone, Vesfera;
        switch (solido) {
            case "cilindro":
                Vcilindro = (float) (Math.PI * Math.pow(raio, 2) * (altura));
                System.out.printf("%.2f\n",Vcilindro);
                break;
            case "cone":
                Vcone = (float) ((Math.PI * Math.pow(raio, 2) * altura)/3.0);
                System.out.printf("%.2f\n",Vcone);
                break;
            case "esfera":
                Vesfera = (float) ((4.0 * Math.PI * Math.pow(raio, 3)) / 3.0);
                System.out.printf("%.2f\n",Vesfera);
                break;
            default:
                //System.out.println("O sólido inserido não é reconhecido.");
                break;
        }
    }
}
