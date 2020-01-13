/**
 * PT
 * Este projeto, foi realizado no âmbito da unidade curricular 'Algoritmia e Programação' do Instituto Superior de Engenharia do Porto.
 * (Novembro 2019)
 * 
 * EN
 * This project, was done under the 'Algorithmic and Programming' unit course of Instituto Superior de Engenharia do Porto.
 * (November 2019)
 */
package finalProjectAprog;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

/**
 * @author Tiago Ribeiro
 */
public class Mundial {

    static Scanner input = new Scanner(System.in);
    static Scanner inputString;
    static Formatter formatter = new Formatter(System.out);

    private final static int MAX_EQUIPAS = 40;
    private final static int N_CAMPOS_INFO = 6;
    
    public static void main(String[] args) throws FileNotFoundException {

        int opcao = -1, selecoesPresentes = 0;
        String[] gruposArray = new String[MAX_EQUIPAS];
        String[] selecoesArray = new String[MAX_EQUIPAS];
        int[][] valoresMatrix = new int[MAX_EQUIPAS][N_CAMPOS_INFO];
        int[] pontuacaoEquipas = new int[MAX_EQUIPAS];

        final String fileName = "PracticalWork.csv";
        final String menuContent = menuContent();
        
        mainLoop(fileName, gruposArray, selecoesArray, valoresMatrix, pontuacaoEquipas, selecoesPresentes, menuContent, opcao);
    }
    
    /**
     * Conteúdo do menu
     *
     * @return string que vai ser usada como menu do projeto
     */
    public static String menuContent() {
        return "\n\n\t\t\t\t\tMENU\n-----------------------------------------------------------------------------------------\n"
                + "1. Ler a informação disponível no ficheiro\n"
                + "2. Inserir manualmente informação de uma seleção\n"
                + "3. Calcular e armazenar a pontuação de todas as equipas\n"
                + "4. Calcular e armazenar a classificação de todas as equipas nos respetivos grupos\n"
                + "5. Listar a classificação das equipas por grupo\n"
                + "6. Listar as equipas cujos golos marcados é igual ao máximo de golos marcados\n"
                + "7. Listar as equipas com um determinado número de golos sofridos\n"
                + "8. Listar as equipas que têm mais golos sofridos do que golos marcados (alfabeticamente)\n"
                + "9. Listar o primeiro classificado de cada grupo\n"
                + "10. Listar informação completa de uma equipa\n"
                + "11. Criar ficheiro de texto com estatísticas dos jogos\n"
                + "12. Remover da memória as equipas que não vão disputar a fase seguinte\n"
                + "13. Criar um ficheiro de texto com as equipas que vão disputar a fase seguinte\n"
                + "14. Criar um ficheiro de texto com os jogos da fase final\n"
                + "Escolha uma opção (0 para sair):\n";
    }

    /**
     * Loop do menu e das suas funcionalidades, que é mostrado até o utilizador decidir sair
     *
     * @param fileName nome do ficheiro com o conteúdo dos países
     * @param gruposArray array com os grupos de cada seleção
     * @param selecoesArray array com o nome das seleções
     * @param valoresMatrix matriz com os números de cada seleção (Jogos,V,E,D,marcados,sofridos)
     * @param pontuacaoEquipas array com a pontuacao de cada seleção
     * @param selecoesPresentes selecoes presentes em memória
     * @param menuContent string representativa do menu
     * @param opcao opcao de menu
     * @throws FileNotFoundException
     */
    public static void mainLoop(String fileName, String[] gruposArray, String[] selecoesArray, int[][] valoresMatrix, int[] pontuacaoEquipas, int selecoesPresentes, String menuContent, int opcao) throws FileNotFoundException {

        do {
            formatter.format("%s", menuContent);
            opcao = input.nextInt();
            switch (opcao) {
                case 0:
                    inputString.close();
                    input.close();
                    break;
                case 1:
                    selecoesPresentes = lerFicheiro(fileName, gruposArray, selecoesArray, valoresMatrix);
                    printInfo(gruposArray, selecoesArray, valoresMatrix, selecoesPresentes);
                    if (selecoesPresentes > 0) {
                        System.out.println("\n* Ficheiro lido com sucesso *");
                    }
                    break;
                case 2:
                    selecoesPresentes = adicionarEquipa(gruposArray, selecoesArray, valoresMatrix, selecoesPresentes);
                    //printInfo(gruposArray, selecoesArray, valoresMatrix, selecoesPresentes);
                    break;
                case 3:
                    calcularPontuacoes(pontuacaoEquipas, selecoesPresentes, valoresMatrix);
                    System.out.printf("\n\n---------------------\n%-2s %10s %7s\n---------------------\n", "G", "Seleção", "P");
                    for (int i = 0; i < selecoesPresentes; i++) {
                        System.out.printf("%-2s %-15s %2d %n", gruposArray[i], selecoesArray[i], pontuacaoEquipas[i]);
                    }
                    System.out.println("---------------------\n");
                    break;
                case 4:
                    sortEquipasByPontuacao(pontuacaoEquipas, selecoesPresentes, gruposArray, selecoesArray, valoresMatrix);
                    break;
                case 5:
                    System.out.println("\nEscolha o grupo:");
                    input.nextLine();
                    String grupo = input.nextLine();
                    printEquipasByGrupos(pontuacaoEquipas, selecoesPresentes, gruposArray, selecoesArray, valoresMatrix, grupo);
                    break;
                case 6:
                    printEquipasMaxGolos(pontuacaoEquipas, selecoesPresentes, gruposArray, selecoesArray, valoresMatrix);
                    break;
                case 7:
                    System.out.println("\nInsira um nº de golos sofridos:");
                    int sofridos = input.nextInt();
                    printEquipasGolosSofridos(pontuacaoEquipas, selecoesPresentes, gruposArray, selecoesArray, valoresMatrix, sofridos);
                    break;
                case 8:
                    printEquipasMaisGolosSofridosQueMarcados(pontuacaoEquipas, selecoesPresentes, gruposArray, selecoesArray, valoresMatrix);
                    break;
                case 9:
                    printPrimeiroClassificadoPorGrupo(pontuacaoEquipas, selecoesPresentes, gruposArray, selecoesArray, valoresMatrix);
                    break;
                case 10:
                    System.out.println("\nIntroduza o nome de uma equipa:");
                    input.nextLine();
                    String nome = input.nextLine();
                    listaInfoEquipa(pontuacaoEquipas, selecoesPresentes, gruposArray, selecoesArray, valoresMatrix, nome);
                    break;
                case 11:
                    escreverEmFicheiroTXT(valoresMatrix);
                    break;
                case 12:
                    removerEquipasEliminadas(pontuacaoEquipas, selecoesPresentes, gruposArray, selecoesArray, valoresMatrix);
                    break;
                case 13:
                    escreverEmFicheiroCSV(gruposArray, pontuacaoEquipas, selecoesArray, selecoesPresentes, valoresMatrix);
                    break;
                case 14:
                    System.out.println("\n* Funcionalidade não implementada *");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    /**
     * método responsável pela leitura do ficheiro txt com a informação das selecoes
     *
     * @param fileName nome do ficheiro a ser lido
     * @param gruposArray array com os grupos de cada seleção
     * @param selecoesArray array com o nome das seleções
     * @param valoresMatrix matriz com os números de cada seleção (Jogos,V,E,D,marcados,sofridos)
     * @return numero de equipas lidas, isto é, quantidade de equipas que agora estão em memória
     * @throws FileNotFoundException
     */
    public static int lerFicheiro(String fileName, String[] gruposArray, String[] selecoesArray, int[][] valoresMatrix) throws FileNotFoundException {
        inputString = new Scanner(new File(fileName));

        int numEquipas = 0;

        inputString.nextLine();
        while (inputString.hasNextLine()) {
            String linha = inputString.nextLine();
            String[] valores = linha.split(",");

            gruposArray[numEquipas] = valores[0];
            selecoesArray[numEquipas] = valores[1];

            for (int coluna = 0, valor = 2; valor < valores.length; coluna++, valor++) {
                valoresMatrix[numEquipas][coluna] = Integer.parseInt(valores[valor]);
            }
            numEquipas++;
        }
        return numEquipas;
    }

    /**
     * método utilizado para imprimir a informação das seleções, apenas a título de testes
     *
     * @param gruposArray array com os grupos de cada seleção
     * @param selecoesArray array com o nome das seleções
     * @param valoresMatrix matriz com os números de cada seleção (Jogos,V,E,D,marcados,sofridos)
     * @param selecoesPresentes selecoes presentes em memoria
     * @throws FileNotFoundException
     */
    public static void printInfo(String[] gruposArray, String[] selecoesArray, int[][] valoresMatrix, int selecoesPresentes) throws FileNotFoundException {
        System.out.println("\n");
        for (int i = 0; i < selecoesPresentes; i++) {
            System.out.printf("%-2s %-15s %2d %2d %2d %2d %2d %2d %n", gruposArray[i], selecoesArray[i], valoresMatrix[i][0], valoresMatrix[i][1],
                    valoresMatrix[i][2], valoresMatrix[i][3], valoresMatrix[i][4], valoresMatrix[i][5]);
        }
    }

    /**
     * método responsável por ler o input do utilizador e adicionar uma equipa à memoria
     *
     * @param gruposArray array com os grupos de cada seleção
     * @param selecoesArray array com o nome das seleções
     * @param valoresMatrix matriz com os números de cada seleção (Jogos,V,E,D,marcados,sofridos)
     * @param selecoesPresentes selecoes presentes em memoria
     * @return selecoes presentes em memoria (como é adicionada uma equipa, aumenta o número de selecoes presentes anteriormente)
     * @throws FileNotFoundException
     */
    public static int adicionarEquipa(String[] gruposArray, String[] selecoesArray, int[][] valoresMatrix, int selecoesPresentes) throws FileNotFoundException {

        System.out.println("\nAdicione uma seleção no formato: \nGrupo,Equipa,Jogos,Vitorias,Empates,Derrotas,GolosMarcados,GolosSofridos");
        input.nextLine();
        String texto = input.nextLine();
        String[] novaSelecao = texto.split(",");

        while (novaSelecao.length != 8 || verificarNomeEquipa(selecoesArray, novaSelecao[1].trim(), selecoesPresentes) == true || Integer.parseInt(novaSelecao[3]) + Integer.parseInt(novaSelecao[4]) + Integer.parseInt(novaSelecao[5]) != Integer.parseInt(novaSelecao[2])) {
            if (novaSelecao.length != 8) {
                System.out.println("\nFaltam dados. Tente de novo:");
                texto = input.nextLine();
                novaSelecao = texto.split(",");
            }
            if (Integer.parseInt(novaSelecao[3]) + Integer.parseInt(novaSelecao[4]) + Integer.parseInt(novaSelecao[5]) != Integer.parseInt(novaSelecao[2])) {
                System.out.println("\nDados inválidos. Tente de novo:");
                texto = input.nextLine();
                novaSelecao = texto.split(",");
            }
            if (verificarNomeEquipa(selecoesArray, novaSelecao[1].trim(), selecoesPresentes) == true) {
                System.out.println("\nA seleção '" + novaSelecao[1].trim() + "' já existe. Tente de novo:");
                texto = input.nextLine();
                novaSelecao = texto.split(",");
            }
        }
        gruposArray[selecoesPresentes] = novaSelecao[0];                                            //grupo
        selecoesArray[selecoesPresentes] = novaSelecao[1];                                          //nome
        valoresMatrix[selecoesPresentes][0] = Integer.parseInt(novaSelecao[2]);                     //jogos
        valoresMatrix[selecoesPresentes][1] = Integer.parseInt(novaSelecao[3]);                     //vitórias
        valoresMatrix[selecoesPresentes][2] = Integer.parseInt(novaSelecao[4]);                     //empates
        valoresMatrix[selecoesPresentes][3] = Integer.parseInt(novaSelecao[5]);                     //derrotas
        valoresMatrix[selecoesPresentes][4] = Integer.parseInt(novaSelecao[6]);                     //golos marcados
        valoresMatrix[selecoesPresentes][5] = Integer.parseInt(novaSelecao[7]);                     //golos sofridos
        System.out.println("\n * Seleção de '" + novaSelecao[1] + "' adicionada com sucesso! * ");

        selecoesPresentes++;
        return selecoesPresentes;
    }

    /**
     * método responsável por verificar se a equipa(cujo nome é passado por parametro) já existe em memoria
     *
     * @param selecoesArray array com o nome das seleções
     * @param equipa equipa a verificar
     * @param selecoesPresentes selecoes presentes em memoria
     * @return
     */
    public static boolean verificarNomeEquipa(String[] selecoesArray, String equipa, int selecoesPresentes) {
        for (int i = 0; i < selecoesPresentes; i++) {
            if (selecoesArray[i].equalsIgnoreCase(equipa)) {
                return true;
            }
        }
        return false;
    }

    /**
     * método utilizado para calcular a pontuacao de cada equipa
     *
     * @param pontuacaoEquipas array com a pontuacao de cada seleção
     * @param selecoesPresentes selecoes presentes em memoria
     * @param valoresMatrix matriz com os números de cada seleção (Jogos,V,E,D,marcados,sofridos)
     */
    public static void calcularPontuacoes(int[] pontuacaoEquipas, int selecoesPresentes, int[][] valoresMatrix) {
        for (int i = 0; i < selecoesPresentes; i++) {
            pontuacaoEquipas[i] = valoresMatrix[i][1] * 3 + valoresMatrix[i][2] * 1;
        }
    }

    /**
     * método utilizado para organizar as equipas por grupo
     *
     * @param pontuacaoEquipas array com a pontuacao de cada seleção
     * @param selecoesPresentes selecoes presentes em memoria
     * @param gruposArray array com os grupos de cada seleção
     * @param selecoesArray array com o nome das seleções
     * @param valoresMatrix matriz com os números de cada seleção (Jogos,V,E,D,marcados,sofridos)
     */
    public static void sortEquipasByGrupo(int[] pontuacaoEquipas, int selecoesPresentes, String[] gruposArray, String[] selecoesArray, int[][] valoresMatrix) {

        for (int i = 0; i < selecoesPresentes; i++) {
            for (int j = i + 1; j < selecoesPresentes; j++) {
                if (gruposArray[i].compareTo(gruposArray[j]) > 0) {
                    String aux = gruposArray[i];
                    gruposArray[i] = gruposArray[j];
                    gruposArray[j] = aux;

                    String aux2 = selecoesArray[i];
                    selecoesArray[i] = selecoesArray[j];
                    selecoesArray[j] = aux2;

                    int aux3 = pontuacaoEquipas[i];
                    pontuacaoEquipas[i] = pontuacaoEquipas[j];
                    pontuacaoEquipas[j] = aux3;

                    for (int k = 0; k < valoresMatrix[k].length; k++) {
                        int aux4 = valoresMatrix[i][k];
                        valoresMatrix[i][k] = valoresMatrix[j][k];
                        valoresMatrix[j][k] = aux4;
                    }
                }
            }
        }
    }

    /**
     * método responsável pela ordenação das equipas pela sua pontuação (seguindo os criteiros do enunciado)
     *
     * @param pontuacaoEquipas array com a pontuacao de cada seleção
     * @param selecoesPresentes selecoes presentes em memoria
     * @param gruposArray array com os grupos de cada seleção
     * @param selecoesArray array com o nome das seleções
     * @param valoresMatrix matriz com os números de cada seleção (Jogos,V,E,D,marcados,sofridos)
     */
    public static void sortEquipasByPontuacao(int[] pontuacaoEquipas, int selecoesPresentes, String[] gruposArray, String[] selecoesArray, int[][] valoresMatrix) {

        for (int i = 0; i < selecoesPresentes; i++) {
            for (int j = i + 1; j < selecoesPresentes; j++) {
                if (pontuacaoEquipas[i] < pontuacaoEquipas[j]) {            //pontos diferentes
                    String aux = gruposArray[i];
                    gruposArray[i] = gruposArray[j];
                    gruposArray[j] = aux;

                    String aux2 = selecoesArray[i];
                    selecoesArray[i] = selecoesArray[j];
                    selecoesArray[j] = aux2;

                    int aux3 = pontuacaoEquipas[i];
                    pontuacaoEquipas[i] = pontuacaoEquipas[j];
                    pontuacaoEquipas[j] = aux3;

                    for (int k = 0; k < valoresMatrix[k].length; k++) {
                        int aux4 = valoresMatrix[i][k];
                        valoresMatrix[i][k] = valoresMatrix[j][k];
                        valoresMatrix[j][k] = aux4;
                    }
                } else if (pontuacaoEquipas[i] == pontuacaoEquipas[j] && valoresMatrix[i][4] < valoresMatrix[j][4]) {   //pontos iguais, check golos marcados
                    String aux = gruposArray[i];
                    gruposArray[i] = gruposArray[j];
                    gruposArray[j] = aux;

                    String aux2 = selecoesArray[i];
                    selecoesArray[i] = selecoesArray[j];
                    selecoesArray[j] = aux2;

                    int aux3 = pontuacaoEquipas[i];
                    pontuacaoEquipas[i] = pontuacaoEquipas[j];
                    pontuacaoEquipas[j] = aux3;

                    for (int k = 0; k < valoresMatrix[k].length; k++) {
                        int aux4 = valoresMatrix[i][k];
                        valoresMatrix[i][k] = valoresMatrix[j][k];
                        valoresMatrix[j][k] = aux4;
                    }
                } else if (pontuacaoEquipas[i] == pontuacaoEquipas[j] && valoresMatrix[i][4] == valoresMatrix[j][4] && valoresMatrix[i][5] > valoresMatrix[j][5]) {     //pontos iguais, golos marcados iguais, check golos sofridos
                    String aux = gruposArray[i];
                    gruposArray[i] = gruposArray[j];
                    gruposArray[j] = aux;

                    String aux2 = selecoesArray[i];
                    selecoesArray[i] = selecoesArray[j];
                    selecoesArray[j] = aux2;

                    int aux3 = pontuacaoEquipas[i];
                    pontuacaoEquipas[i] = pontuacaoEquipas[j];
                    pontuacaoEquipas[j] = aux3;

                    for (int k = 0; k < valoresMatrix[k].length; k++) {
                        int aux4 = valoresMatrix[i][k];
                        valoresMatrix[i][k] = valoresMatrix[j][k];
                        valoresMatrix[j][k] = aux4;
                    }
                } else if (pontuacaoEquipas[i] == pontuacaoEquipas[j] && valoresMatrix[i][4] == valoresMatrix[j][4] && valoresMatrix[i][5] == valoresMatrix[j][5] && selecoesArray[i].compareTo(selecoesArray[j]) > 0) {        //pontos iguais, golos iguais, ordena alfabeticamente
                    String aux = gruposArray[i];
                    gruposArray[i] = gruposArray[j];
                    gruposArray[j] = aux;

                    String aux2 = selecoesArray[i];
                    selecoesArray[i] = selecoesArray[j];
                    selecoesArray[j] = aux2;

                    int aux3 = pontuacaoEquipas[i];
                    pontuacaoEquipas[i] = pontuacaoEquipas[j];
                    pontuacaoEquipas[j] = aux3;

                    for (int k = 0; k < valoresMatrix[k].length; k++) {
                        int aux4 = valoresMatrix[i][k];
                        valoresMatrix[i][k] = valoresMatrix[j][k];
                        valoresMatrix[j][k] = aux4;
                    }
                } else if (pontuacaoEquipas[i] == pontuacaoEquipas[i + 1] && valoresMatrix[i][4] == valoresMatrix[i + 1][4] && valoresMatrix[i][5] > valoresMatrix[i + 1][5]) {
                    String aux = gruposArray[i];
                    gruposArray[i] = gruposArray[j];
                    gruposArray[j] = aux;

                    String aux2 = selecoesArray[i];
                    selecoesArray[i] = selecoesArray[j];
                    selecoesArray[j] = aux2;

                    int aux3 = pontuacaoEquipas[i];
                    pontuacaoEquipas[i] = pontuacaoEquipas[j];
                    pontuacaoEquipas[j] = aux3;

                    for (int k = 0; k < valoresMatrix[k].length; k++) {
                        int aux4 = valoresMatrix[i][k];
                        valoresMatrix[i][k] = valoresMatrix[j][k];
                        valoresMatrix[j][k] = aux4;
                    }
                }
            }
        }
//        for(int x = 0; x < selecoesPresentes; x++){
//            System.out.printf("|%-5s |%5d |%-17s |%4d |%4d |%4d |%4d |%4d |%4d |%4d |%4d |%n", gruposArray[x], 1, selecoesArray[x], pontuacaoEquipas[x], valoresMatrix[x][0], valoresMatrix[x][1], valoresMatrix[x][2], valoresMatrix[x][3], valoresMatrix[x][4], valoresMatrix[x][5], (valoresMatrix[x][4] - valoresMatrix[x][5]));
//        }
        System.out.println("\n* Funcionalidade executada com sucesso *");
    }

    /**
     * método utilizado para imprimir na consola o grupo escolhido pelo utilzador
     *
     * @param pontuacaoEquipas array com a pontuacao de cada seleção
     * @param selecoesPresentes selecoes presentes em memoria
     * @param gruposArray array com os grupos de cada seleção
     * @param selecoesArray array com o nome das seleções
     * @param valoresMatrix matriz com os números de cada seleção (Jogos,V,E,D,marcados,sofridos)
     * @param grupo grupo escolhido pelo utilizador
     */
    public static void printEquipasByGrupos(int[] pontuacaoEquipas, int selecoesPresentes, String[] gruposArray, String[] selecoesArray, int[][] valoresMatrix, String grupo) {
        sortEquipasByPontuacao(pontuacaoEquipas, selecoesPresentes, gruposArray, selecoesArray, valoresMatrix);
        System.out.printf("\n\n----------------------------------------------------------------------------------\n|%-5s |%5s |%-17s |%4s |%4s |%4s |%4s |%4s |%4s |%4s |%4s |\n"
                + "==================================================================================\n", "Grp", "Pos", "Equipa", "Pts", "J", "V", "E", "D", "GM", "GS", "GD");
        int pos = 1;
        for (int i = 0; i < selecoesPresentes; i++) {
            if (gruposArray[i].equalsIgnoreCase(grupo.trim())) {
                System.out.printf("|%-5s |%5d |%-17s |%4d |%4d |%4d |%4d |%4d |%4d |%4d |%4d |%n", gruposArray[i], pos, selecoesArray[i], pontuacaoEquipas[i], valoresMatrix[i][0], valoresMatrix[i][1], valoresMatrix[i][2], valoresMatrix[i][3], valoresMatrix[i][4], valoresMatrix[i][5], (valoresMatrix[i][4] - valoresMatrix[i][5]));
                pos++;
            }
        }
    }

    /**
     * método responsável por imprimir as equipas com tantos golos quanto o maior número de golos
     *
     * @param pontuacaoEquipas array com a pontuacao de cada seleção
     * @param selecoesPresentes selecoes presentes em memoria
     * @param gruposArray array com os grupos de cada seleção
     * @param selecoesArray array com o nome das seleções
     * @param valoresMatrix matriz com os números de cada seleção (Jogos,V,E,D,marcados,sofridos)
     */
    public static void printEquipasMaxGolos(int[] pontuacaoEquipas, int selecoesPresentes, String[] gruposArray, String[] selecoesArray, int[][] valoresMatrix) {
        int maxGolos = calcularMaxGolos(selecoesPresentes, valoresMatrix);
        System.out.println("\nMáximo de golos marcados = " + maxGolos + "\n");
        System.out.printf("\n\n---------------------------------------------------------------------------\n|%-5s |%-17s |%4s |%4s |%4s |%4s |%4s |%4s |%4s |%4s |\n"
                + "===========================================================================\n", "Grp", "Equipa", "Pts", "J", "V", "E", "D", "GM", "GS", "GD");
        for (int i = 0; i < selecoesPresentes; i++) {
            if (valoresMatrix[i][4] == maxGolos) {
                System.out.printf("|%-5s |%-17s |%4d |%4d |%4d |%4d |%4d |%4d |%4d |%4d |%n", gruposArray[i], selecoesArray[i], pontuacaoEquipas[i], valoresMatrix[i][0], valoresMatrix[i][1], valoresMatrix[i][2], valoresMatrix[i][3], valoresMatrix[i][4], valoresMatrix[i][5], (valoresMatrix[i][4] - valoresMatrix[i][5]));
            }
        }
    }

    /**
     * método responsável por verificar qual é o maior número de golos
     *
     * @param selecoesPresentes selecoes presentes em memoria
     * @param valoresMatrix matriz com os números de cada seleção (Jogos,V,E,D,marcados,sofridos)
     * @return maior numero de golos
     */
    public static int calcularMaxGolos(int selecoesPresentes, int[][] valoresMatrix) {
        int maxGolos = 0;
        for (int i = 0; i < selecoesPresentes; i++) {
            if (valoresMatrix[i][4] > maxGolos) {
                maxGolos = valoresMatrix[i][4];
            }
        }
        return maxGolos;
    }

    /**
     * método responsável por imprimir as equipas com um determinado número de golos sofridos
     *
     * @param pontuacaoEquipas array com a pontuacao de cada seleção
     * @param selecoesPresentes selecoes presentes em memoria
     * @param gruposArray array com os grupos de cada seleção
     * @param selecoesArray array com o nome das seleções
     * @param valoresMatrix matriz com os números de cada seleção (Jogos,V,E,D,marcados,sofridos)
     * @param sofridos quantidade de golos sofridos definida pelo utilizador
     */
    public static void printEquipasGolosSofridos(int[] pontuacaoEquipas, int selecoesPresentes, String[] gruposArray, String[] selecoesArray, int[][] valoresMatrix, int sofridos) {
        if (sofridos < 0) {
            System.out.println("\nNúmero inválido.");
        } else {
            System.out.printf("\n\n---------------------------------------------------------------------------\n|%-5s |%-17s |%4s |%4s |%4s |%4s |%4s |%4s |%4s |%4s |\n"
                    + "===========================================================================\n", "Grp", "Equipa", "Pts", "J", "V", "E", "D", "GM", "GS", "GD");
            for (int i = 0; i < selecoesPresentes; i++) {
                if (valoresMatrix[i][5] == sofridos) {
                    System.out.printf("|%-5s |%-17s |%4d |%4d |%4d |%4d |%4d |%4d |%4d |%4d |%n", gruposArray[i], selecoesArray[i], pontuacaoEquipas[i], valoresMatrix[i][0], valoresMatrix[i][1], valoresMatrix[i][2], valoresMatrix[i][3], valoresMatrix[i][4], valoresMatrix[i][5], (valoresMatrix[i][4] - valoresMatrix[i][5]));
                }
            }
        }
    }

    /**
     * método responsável por imprimir as equipas com mais golos sofridos que marcados
     *
     * @param pontuacaoEquipas array com a pontuacao de cada seleção
     * @param selecoesPresentes selecoes presentes em memoria
     * @param gruposArray array com os grupos de cada seleção
     * @param selecoesArray array com o nome das seleções
     * @param valoresMatrix matriz com os números de cada seleção (Jogos,V,E,D,marcados,sofridos)
     */
    public static void printEquipasMaisGolosSofridosQueMarcados(int[] pontuacaoEquipas, int selecoesPresentes, String[] gruposArray, String[] selecoesArray, int[][] valoresMatrix) {
        int[] copiaPontuacao = pontuacaoEquipas;
        String[] copiaGrupos = gruposArray;
        String[] copiaSelecoes = selecoesArray;
        int[][] copiaMatriz = valoresMatrix;

        for (int i = 0; i < selecoesPresentes; i++) {
            for (int j = i + 1; j < selecoesPresentes; j++) {
                if (copiaSelecoes[i].compareTo(copiaSelecoes[j]) > 0) {
                    String aux = copiaGrupos[i];
                    copiaGrupos[i] = copiaGrupos[j];
                    copiaGrupos[j] = aux;

                    String aux2 = copiaSelecoes[i];
                    copiaSelecoes[i] = copiaSelecoes[j];
                    copiaSelecoes[j] = aux2;

                    int aux3 = copiaPontuacao[i];
                    copiaPontuacao[i] = copiaPontuacao[j];
                    copiaPontuacao[j] = aux3;

                    for (int k = 0; k < copiaMatriz[k].length; k++) {
                        int aux4 = copiaMatriz[i][k];
                        copiaMatriz[i][k] = copiaMatriz[j][k];
                        copiaMatriz[j][k] = aux4;
                    }
                }
            }
        }
        System.out.printf("\n\n---------------------------------------------------------------------------\n|%-5s |%-17s |%4s |%4s |%4s |%4s |%4s |%4s |%4s |%4s |\n"
                + "===========================================================================\n", "Grp", "Equipa", "Pts", "J", "V", "E", "D", "GM", "GS", "GD");
        for (int i = 0; i < selecoesPresentes; i++) {
            if (copiaMatriz[i][5] > copiaMatriz[i][4]) {
                System.out.printf("|%-5s |%-17s |%4d |%4d |%4d |%4d |%4d |%4d |%4d |%4d |%n", copiaGrupos[i], copiaSelecoes[i], pontuacaoEquipas[i], copiaMatriz[i][0], copiaMatriz[i][1], copiaMatriz[i][2], copiaMatriz[i][3], copiaMatriz[i][4], copiaMatriz[i][5], (copiaMatriz[i][4] - copiaMatriz[i][5]));
            }
        }
        sortEquipasByPontuacao(pontuacaoEquipas, selecoesPresentes, gruposArray, selecoesArray, valoresMatrix);
    }

    /**
     * método responsável por imprimir a primeira equipa de cada grupo
     *
     * @param pontuacaoEquipas array com a pontuacao de cada seleção
     * @param selecoesPresentes selecoes presentes em memoria
     * @param gruposArray array com os grupos de cada seleção
     * @param selecoesArray array com o nome das seleções
     * @param valoresMatrix matriz com os números de cada seleção (Jogos,V,E,D,marcados,sofridos)
     */
    public static void printPrimeiroClassificadoPorGrupo(int[] pontuacaoEquipas, int selecoesPresentes, String[] gruposArray, String[] selecoesArray, int[][] valoresMatrix) {

        int numGrupos = contadorGrupos(pontuacaoEquipas, selecoesPresentes, gruposArray, selecoesArray, valoresMatrix);
        sortEquipasByPontuacao(pontuacaoEquipas, selecoesPresentes, gruposArray, selecoesArray, valoresMatrix);     //ordena por pontuacao

        String[] gruposImpressos = new String[numGrupos];                                 //array que vai armazenar os grupos ja impressos, de modo a nao sairem equipas do mesmo grupo
        int[] indexes = new int[numGrupos];                                               //array que vai guardar o valor de k, para depois com ele, ir buscar toda a info de uma equipa
        int posicao = 0;

        for (int k = 0; k < selecoesPresentes; k++) {
            if (!(gruposArray[k].equalsIgnoreCase(gruposArray[k + 1])) && infoJaPresente(gruposImpressos, gruposArray[k]) == false || infoJaPresente(gruposImpressos, gruposArray[k]) == false && (gruposArray[k].equalsIgnoreCase(gruposArray[k + 1])) && pontuacaoEquipas[k] == pontuacaoEquipas[k + 1]) {

                gruposImpressos[posicao] = gruposArray[k];
                indexes[posicao] = k;
                posicao++;
            }
        }
        System.out.printf("\n\n----------------------------------------------------------------------------------\n|%-5s |%5s |%-17s |%4s |%4s |%4s |%4s |%4s |%4s |%4s |%4s |\n"
                + "==================================================================================\n", "Grp", "Pos", "Equipa", "Pts", "J", "V", "E", "D", "GM", "GS", "GD");
        for (int i = 0; i < numGrupos; i++) {
            System.out.printf("|%-5s |%5d |%-17s |%4d |%4d |%4d |%4d |%4d |%4d |%4d |%4d |%n", gruposImpressos[i], 1, selecoesArray[indexes[i]], pontuacaoEquipas[indexes[i]], valoresMatrix[indexes[i]][0], valoresMatrix[indexes[i]][1], valoresMatrix[indexes[i]][2], valoresMatrix[indexes[i]][3], valoresMatrix[indexes[i]][4], valoresMatrix[indexes[i]][5], (valoresMatrix[indexes[i]][4] - valoresMatrix[indexes[i]][5]));
        }
    }

    /**
     * método responsável por verificar se determinada string passada por parâmetro já se encontra num determinado array (utilitário)
     * (utilitário)
     * @param arrayStrings array de strings
     * @param nome string a verificar
     * @return true se já existir, false se não
     */
    public static boolean infoJaPresente(String[] arrayStrings, String nome) {
        for (int x = 0; x < arrayStrings.length; x++) {
            if (arrayStrings[x] != null && arrayStrings[x].equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }

    /**
     * método responsável por contador a quantidade de grupos únicos existentes (utilitário)
     *
     * @param pontuacaoEquipas array com a pontuacao de cada seleção
     * @param selecoesPresentes selecoes presentes em memoria
     * @param gruposArray array com os grupos de cada seleção
     * @param selecoesArray array com o nome das seleções
     * @param valoresMatrix matriz com os números de cada seleção (Jogos,V,E,D,marcados,sofridos)
     * @return quantidade de grupos
     */
    public static int contadorGrupos(int[] pontuacaoEquipas, int selecoesPresentes, String[] gruposArray, String[] selecoesArray, int[][] valoresMatrix) {
        sortEquipasByGrupo(pontuacaoEquipas, selecoesPresentes, gruposArray, selecoesArray, valoresMatrix);         //ordena equipas por grupo, para contar a quantidade dos mesmos

        int numGrupos = 0;
        for (int i = 0; i < selecoesPresentes; i++) {
            if (!gruposArray[i].equalsIgnoreCase(gruposArray[i + 1])) {
                numGrupos++;
            }
        }
        return numGrupos;
    }

    /**
     * método responsável por imprimir a informação relativa a uma equipa, definida pelo utilizador
     *
     * @param pontuacaoEquipas array com a pontuacao de cada seleção
     * @param selecoesPresentes selecoes presentes em memoria
     * @param gruposArray array com os grupos de cada seleção
     * @param selecoesArray array com o nome das seleções
     * @param valoresMatrix matriz com os números de cada seleção (Jogos,V,E,D,marcados,sofridos)
     * @param nomeEquipa nome da equipa definida pelo utilizador
     */
    public static void listaInfoEquipa(int[] pontuacaoEquipas, int selecoesPresentes, String[] gruposArray, String[] selecoesArray, int[][] valoresMatrix, String nomeEquipa) {
        if (infoJaPresente(selecoesArray, nomeEquipa) == false) {
            System.out.println("A equipa '" + nomeEquipa + "' não existe.");
        } else {
            System.out.printf("\n\n----------------------------------------------------------------------------------\n|%-5s |%-17s |%4s |%4s |%4s |%4s |%4s |%4s |%4s |%4s |\n"
                    + "==================================================================================\n", "Grp", "Equipa", "Pts", "J", "V", "E", "D", "GM", "GS", "GD");
            for (int i = 0; i < selecoesPresentes; i++) {
                if (selecoesArray[i].equalsIgnoreCase(nomeEquipa)) {
                    System.out.printf("|%-5s |%-17s |%4d |%4d |%4d |%4d |%4d |%4d |%4d |%4d |%n", gruposArray[i], selecoesArray[i], pontuacaoEquipas[i], valoresMatrix[i][0], valoresMatrix[i][1], valoresMatrix[i][2], valoresMatrix[i][3], valoresMatrix[i][4], valoresMatrix[i][5], (valoresMatrix[i][4] - valoresMatrix[i][5]));
                }
            }
        }
    }

    /**
     * método responsável por escrever num ficheiro .txt as estatisticas
     *
     * @param valoresMatrix matriz com os números de cada seleção (Jogos,V,E,D,marcados,sofridos)
     * @throws FileNotFoundException
     */
    public static void escreverEmFicheiroTXT(int[][] valoresMatrix) throws FileNotFoundException {

        int totalJogos = returnTotalJogos(valoresMatrix);
        int totalVitorias = returnTotalVitorias(valoresMatrix);
        int totalEmpates = returnTotalEmpates(valoresMatrix);
        int totalDerrotas = returnTotalDerrotas(valoresMatrix);
        int totalGolosMarcados = returnTotalGolosMarcados(valoresMatrix);
        int totalGolosSofridos = returnTotalGolosSofridos(valoresMatrix);
        double mediaGolosMarcados = returnMediaGolosMarcados(totalJogos, totalGolosMarcados);
        double mediaGolosSofridos = returnMediaGolosSofridos(totalJogos, totalGolosSofridos);

        String outputFileName = "Statistics.txt";
        Formatter output = new Formatter(new File(outputFileName));

        output.format("Total de jogos= %d\n", totalJogos);
        output.format("Total de vitorias= %d\n", totalVitorias);
        output.format("Total de empates= %d\n", totalEmpates);
        output.format("Total de derrotas= %d\n", totalDerrotas);
        output.format("Total de golos marcados= %d\n", totalGolosMarcados);
        output.format("Total de golos sofridos= %d\n", totalGolosSofridos);
        output.format("Média de golos marcados por jogo= %.1f\n", mediaGolosMarcados);
        output.format("Média de golos sofridos por jogo= %.1f\n", mediaGolosSofridos);
        System.out.println("\n * Ficheiro escrito com sucesso *");
        output.close();
    }

    /**
     * método que calcula o total de jogos efetuados por todas as equipas (utilitário)
     *
     * @param valoresMatrix matriz com os números de cada seleção (Jogos,V,E,D,marcados,sofridos)
     * @return total de jogos
     */
    public static int returnTotalJogos(int[][] valoresMatrix) {
        int totalJogos = 0;
        for (int i = 0; i < valoresMatrix.length; i++) {
            totalJogos += valoresMatrix[i][0];
        }
        return totalJogos;
    }

    /**
     * método que calcula o total de vitórias alcançadas por todas as equipas (utilitário)
     *
     * @param valoresMatrix matriz com os números de cada seleção (Jogos,V,E,D,marcados,sofridos)
     * @return total de vitorias
     */
    public static int returnTotalVitorias(int[][] valoresMatrix) {
        int totalVitorias = 0;
        for (int i = 0; i < valoresMatrix.length; i++) {
            totalVitorias += valoresMatrix[i][1];
        }
        return totalVitorias;
    }

    /**
     * método que calcula o total de empates alcançados por todas as equipas (utilitário)
     *
     * @param valoresMatrix matriz com os números de cada seleção (Jogos,V,E,D,marcados,sofridos)
     * @return total de empates
     */
    public static int returnTotalEmpates(int[][] valoresMatrix) {
        int totalEmpates = 0;
        for (int i = 0; i < valoresMatrix.length; i++) {
            totalEmpates += valoresMatrix[i][2];
        }
        return totalEmpates;
    }

    /**
     * método que calcula o total de derrotas concedidas por todas as equipas (utilitário)
     *
     * @param valoresMatrix matriz com os números de cada seleção (Jogos,V,E,D,marcados,sofridos)
     * @return total de derrotas
     */
    public static int returnTotalDerrotas(int[][] valoresMatrix) {
        int totalDerrotas = 0;
        for (int i = 0; i < valoresMatrix.length; i++) {
            totalDerrotas += valoresMatrix[i][3];
        }
        return totalDerrotas;
    }

    /**
     * método que calcula o total de golos marcados por todas as equipas (utilitário)
     *
     * @param valoresMatrix matriz com os números de cada seleção (Jogos,V,E,D,marcados,sofridos)
     * @return total de golos marcados
     */
    public static int returnTotalGolosMarcados(int[][] valoresMatrix) {
        int golosMarcados = 0;
        for (int i = 0; i < valoresMatrix.length; i++) {
            golosMarcados += valoresMatrix[i][4];
        }
        return golosMarcados;
    }

    /**
     * método que calcula o total de golos sofridos por todas as equipas (utilitário)
     *
     * @param valoresMatrix matriz com os números de cada seleção (Jogos,V,E,D,marcados,sofridos)
     * @return total de golos sofridos
     */
    public static int returnTotalGolosSofridos(int[][] valoresMatrix) {
        int golosSofridos = 0;
        for (int i = 0; i < valoresMatrix.length; i++) {
            golosSofridos += valoresMatrix[i][5];
        }
        return golosSofridos;
    }

    /**
     * método que calcula a média de golos marcados (utilitário)
     *
     * @param jogos total de jogos efetuados por todas as equipas
     * @param golosMarcados total de golos marcados por todas as equipas
     * @return média de golos marcados
     */
    public static double returnMediaGolosMarcados(int jogos, int golosMarcados) {
        double mediaMarcados;
        if (jogos == 0) {
            return 0;
        } else {
            mediaMarcados = (double) golosMarcados / (double) jogos;
        }
        return mediaMarcados;
    }

    /**
     * método que calcula a média de golos sofridos (utilitário)
     *
     * @param jogos total de jogos efetuados por todas as equipas
     * @param golosSofridos total de golos sofridos por todas as equipas
     * @return média de golos sofridos
     */
    public static double returnMediaGolosSofridos(int jogos, int golosSofridos) {
        double mediaSofridos;
        if (jogos == 0) {
            return 0;
        } else {
            mediaSofridos = (double) golosSofridos / (double) jogos;
        }
        return mediaSofridos;
    }

    /**
     * método responsável por eliminar as equipas que não passaram à fase seguinte (3º's e 4º's classificados)
     *
     * @param pontuacaoEquipas array com a pontuacao de cada seleção
     * @param selecoesPresentes selecoes presentes em memoria
     * @param gruposArray array com os grupos de cada seleção
     * @param selecoesArray array com o nome das seleções
     * @param valoresMatrix matriz com os números de cada seleção (Jogos,V,E,D,marcados,sofridos)
     */
    public static void removerEquipasEliminadas(int[] pontuacaoEquipas, int selecoesPresentes, String[] gruposArray, String[] selecoesArray, int[][] valoresMatrix) {

        //int count = selecoesPresentes;
        int numGrupos = contadorGrupos(pontuacaoEquipas, selecoesPresentes, gruposArray, selecoesArray, valoresMatrix);
        int posicao = 0;

        String[] grupos = new String[numGrupos * 2];      //exemplo: se ha 5 grupos, tem de haver no maximo 10 equipas apuradas (o dobro) - 2 por cada grupo
        String[] arrayEquipas = new String[numGrupos * 2];

        //failsafe para contornar se esta funcionalidade for escolhida antes da funcionalidade 3 e 4
        calcularPontuacoes(pontuacaoEquipas, selecoesPresentes, valoresMatrix);
        sortEquipasByPontuacao(pontuacaoEquipas, selecoesPresentes, gruposArray, selecoesArray, valoresMatrix);

        //guarda as equipas que avançam, para depois eliminar todas as equipas que não sejam estas
        for (int i = 0; i < selecoesPresentes; i++) {
            if ((infoJaPresente(grupos, gruposArray[i]) == false) || (infoJaPresente(grupos, gruposArray[i]) == true && numOcorrencias(grupos, gruposArray[i]) == 1)) {
                grupos[posicao] = gruposArray[i];
                arrayEquipas[posicao] = selecoesArray[i];
                posicao++;
            }
        }

        //remove a informacao que interessa para depois escrever no CSV
        for (int j = 0; j < selecoesPresentes; j++) {
            if (infoJaPresente(arrayEquipas, selecoesArray[j]) == false) {
                selecoesArray[j] = null;
                pontuacaoEquipas[j] = -1;
                gruposArray[j] = null;
            }
        }
//        Teste para imprimir todas as equipas (as que foram eliminadas, vai imprimir como sendo 'null'
//        for(int x = 0; x < selecoesPresentes; x++){
//                System.out.printf("%s,%s,%d%n",gruposArray[x],selecoesArray[x],pontuacaoEquipas[x]);
//        }
    }

    /**
     * método que verifica quantas vezes um determinado elemento existe num array (utilitário)
     *
     * @param arrayStrings array de strings
     * @param nome string a ser verificada
     * @return quantidade de ocorrencias de um determinado elemento
     */
    public static int numOcorrencias(String[] arrayStrings, String nome) {
        int ocorrencias = 0;
        for (int x = 0; x < arrayStrings.length; x++) {
            if (arrayStrings[x] != null && arrayStrings[x].equalsIgnoreCase(nome)) {
                ocorrencias++;
            }
        }
        return ocorrencias;
    }

    /**
     * método responsável por escrever num ficheiro .csv as equipas que foram apuradas para a próxima fase
     *
     * @param gruposArray array com os grupos de cada seleção
     * @param pontuacaoEquipas array com a pontuacao de cada seleção
     * @param selecoesArray array com o nome das seleções
     * @param selecoesPresentes selecoes presentes em memoria
     * @param valoresMatrix matriz com os números de cada seleção (Jogos,V,E,D,marcados,sofridos)
     * @throws FileNotFoundException
     */
    public static void escreverEmFicheiroCSV(String[] gruposArray, int[] pontuacaoEquipas, String[] selecoesArray, int selecoesPresentes, int[][] valoresMatrix) throws FileNotFoundException {
        
        String outputFileName = "FinalStage.csv";
        Formatter output = new Formatter(new File(outputFileName));
        
        String[] arrayAuxiliarGrupos = new String[selecoesPresentes];
        int pos = 0;
        
        for (int i = 0; i < selecoesPresentes; i++) {
            if (selecoesArray[i] != null && gruposArray[i] != null && pontuacaoEquipas[i] != -1 && numOcorrencias(arrayAuxiliarGrupos, gruposArray[i]) == 0) {
                output.format("%s,%d,%s,%d%n", gruposArray[i], 1, selecoesArray[i], pontuacaoEquipas[i]);
                arrayAuxiliarGrupos[pos] = gruposArray[i];
                pos++;
            }else if(selecoesArray[i] != null && gruposArray[i] != null && pontuacaoEquipas[i] != -1 && numOcorrencias(arrayAuxiliarGrupos, gruposArray[i]) == 1){
                output.format("%s,%d,%s,%d%n", gruposArray[i], 2, selecoesArray[i], pontuacaoEquipas[i]);
                arrayAuxiliarGrupos[pos] = gruposArray[i];
                pos++;
            }
        }
        output.close();
        System.out.println("\n * Ficheiro CSV escrito com sucesso * ");
    }
}
