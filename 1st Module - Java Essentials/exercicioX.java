//package APROG_2019;

import java.util.Scanner;

/**
 * @author Tiago Ribeiro (1181444)
 */
public class exercicioX {

    public static final String tagHeuer = "Tag Heuer";
    public static final String rolex = "Rolex";
    public static final String omega = "Omega";
    public static final String cartier = "Cartier";
    public static final String bvlgari = "Bvlgari";
    public static final String raymondWeil = "Raymond Weil";
    public static final String invalida = "Marca invalida";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num = input.nextInt();
        switch (num) {
            case 1:
                System.out.println(tagHeuer);
                break;
            case 2:
                System.out.println(rolex);
                break;
            case 3:
                System.out.println(omega);
                break;
            case 4:
                System.out.println(cartier);
                break;
            case 5:
                System.out.println(bvlgari);
                break;
            case 6:
                System.out.println(raymondWeil);
                break;
            default:
                System.out.println(invalida);
        }
    }
}
