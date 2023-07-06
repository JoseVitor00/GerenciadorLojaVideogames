import java.util.Scanner;

public class GerenciadorLojaVideogames {
    public static void inserirProdutos(String[][] estoque, int linhas, int colunas) {
        Scanner scanner = new Scanner(System.in);
        int linha = -1;

        for (int i = 0; i < linhas; i++) {
            if (estoque[i][0] == null) {
                linha = i;
                break;
            }
        }

        if (linha == -1) {
            System.out.println("Não foi possível adicionar o jogo. O estoque está cheio.");
            return;
        }

        System.out.println("Insira o nome do jogo:");
        estoque[linha][0] = scanner.nextLine();

        System.out.println("Insira a plataforma do jogo:");
        estoque[linha][1] = scanner.nextLine();

        System.out.println("Insira o gênero do jogo:");
        estoque[linha][2] = scanner.nextLine();

        System.out.println("Insira a quantidade de cópias do jogo:");
        estoque[linha][3] = Integer.toString(scanner.nextInt());

        System.out.println("Insira o valor do jogo:");
        estoque[linha][4] = Double.toString(scanner.nextDouble());

        System.out.println("Jogo adicionado ao estoque.");
    }

    public static void mostrarProdutos(String[][] estoque, int linhas, int colunas) {
        System.out.println("Estoque de Videogames:");
        System.out.println("Nome | Plataforma | Gênero | Quantidade | Valor");

        for (int i = 0; i < linhas; i++) {
            if (estoque[i][0] != null) {
                for (int j = 0; j < colunas; j++) {
                    System.out.print(estoque[i][j] + " | ");
                }
                System.out.println();
            }
        }
    }

    public static void calcularValorTotal(String[][] estoque, int linhas, int colunas) {
        double valorTotal = 0.0;

        for (int i = 0; i < linhas; i++) {
            if (estoque[i][0] != null) {
                int quantidade = Integer.parseInt(estoque[i][3]);
                double valor = Double.parseDouble(estoque[i][4]);
                valorTotal += quantidade * valor;
            }
        }

        System.out.println("Valor total do estoque de videogames: " + valorTotal + " R$");
    }

    public static void removerProduto(String[][] estoque, int linhas, String nomeJogo) {
        boolean encontrado = false;

        for (int i = 0; i < linhas; i++) {
            if (estoque[i][0] != null && estoque[i][0].equalsIgnoreCase(nomeJogo)) {
                encontrado = true;
                estoque[i][0] = null;
                estoque[i][1] = null;
                estoque[i][2] = null;
                estoque[i][3] = null;
                estoque[i][4] = null;
                break;
            }
        }

        if (encontrado) {
            System.out.println("Jogo removido do estoque.");
        } else {
            System.out.println("Jogo não encontrado.");
        }
    }

    public static void pesquisarJogoPorNome(String[][] estoque, int linhas, String nomeJogo) {
        boolean encontrado = false;

        for (int i = 0; i < linhas; i++) {
            if (estoque[i][0] != null && estoque[i][0].equalsIgnoreCase(nomeJogo)) {
                encontrado = true;
                System.out.println("Detalhes do jogo:");
                System.out.println("Nome: " + estoque[i][0]);
                System.out.println("Plataforma: " + estoque[i][1]);
                System.out.println("Gênero: " + estoque[i][2]);
                System.out.println("Quantidade: " + estoque[i][3]);
                System.out.println("Valor: " + estoque[i][4]);
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Jogo não encontrado.");
        }
    }

    public static void atualizarInformacoesJogo(String[][] estoque, int linhas, String nomeJogo) {
        Scanner scanner = new Scanner(System.in);
        boolean encontrado = false;

        for (int i = 0; i < linhas; i++) {
            if (estoque[i][0] != null && estoque[i][0].equalsIgnoreCase(nomeJogo)) {
                encontrado = true;
                System.out.println("Insira a nova plataforma do jogo:");
                estoque[i][1] = scanner.nextLine();

                System.out.println("Insira o novo gênero do jogo:");
                estoque[i][2] = scanner.nextLine();

                System.out.println("Insira a nova quantidade de cópias do jogo:");
                estoque[i][3] = Integer.toString(scanner.nextInt());

                System.out.println("Insira o novo valor do jogo:");
                estoque[i][4] = Double.toString(scanner.nextDouble());

                System.out.println("Informações do jogo atualizadas.");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Jogo não encontrado.");
        }
    }

    public static void relatorioEstoquePorPlataforma(String[][] estoque, int linhas, String plataforma) {
        System.out.println("Relatório de Estoque por Plataforma: " + plataforma);
        System.out.println("Nome | Gênero | Quantidade | Valor");

        for (int i = 0; i < linhas; i++) {
            if (estoque[i][0] != null && estoque[i][1].equalsIgnoreCase(plataforma)) {
                System.out.println(estoque[i][0] + " | " + estoque[i][2] + " | " + estoque[i][3] + " | " + estoque[i][4]);
            }
        }
    }

    public static void relatorioEstoquePorGenero(String[][] estoque, int linhas, String genero) {
        System.out.println("Relatório de Estoque por Gênero: " + genero);
        System.out.println("Nome | Plataforma | Quantidade | Valor");

        for (int i = 0; i < linhas; i++) {
            if (estoque[i][0] != null && estoque[i][2].equalsIgnoreCase(genero)) {
                System.out.println(estoque[i][0] + " | " + estoque[i][1] + " | " + estoque[i][3] + " | " + estoque[i][4]);
            }
        }
    }

    public static void main(String[] args) {
        int maxProdutos = 10;
        int colunas = 5;
        String[][] estoque = new String[maxProdutos][colunas];
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Mostrar estoque");
            System.out.println("2 - Inserir jogo");
            System.out.println("3 - Calcular valor total do estoque");
            System.out.println("4 - Remover jogo do estoque");
            System.out.println("5 - Pesquisar jogo por nome");
            System.out.println("6 - Atualizar informações de um jogo");
            System.out.println("7 - Gerar relatório de estoque por plataforma");
            System.out.println("8 - Gerar relatório de estoque por gênero");
            System.out.println("0 - Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 0:
                    break;
                case 1:
                    mostrarProdutos(estoque, maxProdutos, colunas);
                    break;
                case 2:
                    inserirProdutos(estoque, maxProdutos, colunas);
                    break;
                case 3:
                    calcularValorTotal(estoque, maxProdutos, colunas);
                    break;
                case 4:
                    System.out.println("Insira o nome do jogo a ser removido:");
                    String nomeJogoRemover = scanner.next();
                    removerProduto(estoque, maxProdutos, nomeJogoRemover);
                    break;
                case 5:
                    System.out.println("Insira o nome do jogo a ser pesquisado:");
                    scanner.nextLine(); // Limpar o buffer
                    String nomeJogoPesquisar = scanner.nextLine();
                    pesquisarJogoPorNome(estoque, maxProdutos, nomeJogoPesquisar);
                    break;
                case 6:
                    System.out.println("Insira o nome do jogo a ser atualizado:");
                    scanner.nextLine(); // Limpar o buffer
                    String nomeJogoAtualizar = scanner.nextLine();
                    atualizarInformacoesJogo(estoque, maxProdutos, nomeJogoAtualizar);
                    break;
                case 7:
                    System.out.println("Insira a plataforma para gerar o relatório de estoque:");
                    scanner.nextLine(); // Limpar o buffer
                    String plataformaRelatorio = scanner.nextLine();
                    relatorioEstoquePorPlataforma(estoque, maxProdutos, plataformaRelatorio);
                    break;
                case 8:
                    System.out.println("Insira o gênero para gerar o relatório de estoque:");
                    scanner.nextLine(); // Limpar o buffer
                    String generoRelatorio = scanner.nextLine();
                    relatorioEstoquePorGenero(estoque, maxProdutos, generoRelatorio);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}
