//package APROG_2019;

import java.util.Scanner;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class exercicioB_2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //System.out.println("alunos:");
        int nAlunos = input.nextInt();
        if (nAlunos > 0) {
            //System.out.println("num disciplinas");
            int nDisciplinas = input.nextInt();

            for (int i = 0; i < nDisciplinas; i++) {
                input.nextLine();
                //System.out.println("qual?");
                String disciplina = input.nextLine();

                //System.out.println("aprovados:");
                int aprovados = input.nextInt();
                if(aprovados > nAlunos){
                    //System.out.println("invalido.");
                }else{
                  classificacoes(nAlunos,aprovados,disciplina);
                }
            }
        }
    }

    public static void classificacoes(int nAlunos, int aprovados, String disciplina) {
        int reprovados = nAlunos - aprovados;
        System.out.println("Disciplina: " + disciplina);
        System.out.printf("- Positivas: ");
        for(int i = 0; i< aprovados; i++){
            System.out.printf("*");
        }
        System.out.printf("\n- Negativas: ");
        for(int i = 0; i< reprovados; i++){
            System.out.printf("*");
        }
        System.out.println();
    }
}
