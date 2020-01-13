
import static java.lang.Math.acos;
import java.util.Scanner;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */

public class exercicioC_2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //System.out.println("Introduza a medida do primeiro lado do triângulo (A):");
        int a = input.nextInt();
        while (a < 1) {
            a = input.nextInt();
        }
        //System.out.println("Introduza a medida do segundo lado do triângulo (B):");
        int b = input.nextInt();
        while (b < 1) {
            b = input.nextInt();
        }
        //System.out.println("Introduza a medida do terceiro lado do triângulo (C):");
        int c = input.nextInt();
        while (a < 1) {
            c = input.nextInt();
        }

        if (a >= b+c || b >= a+c || c >= a+b) {
            System.out.println("impossivel");
        } else {
            //System.out.println("Medidas INT em radianos:");
            System.out.println("a="+a);
            System.out.println("b="+b);
            System.out.println("c="+c);
            System.out.println("ang(a,b)=" + (int) Math.toDegrees(calcAng(a, b, c)));
            System.out.println("ang(a,c)=" + (int) Math.toDegrees(calcAng(a, c, b)));
            System.out.println("ang(b,c)=" + (int) Math.toDegrees(calcAng(b, c, a)));
        }
    }

    public static double calcAng(int a, int b, int c) {
        double resultado = acos( (Math.pow(a,2)+Math.pow(b,2)-Math.pow(c,2)) / (2*a*b) );
        return resultado;
    }
}
