package View;

import java.util.InputMismatchException;
import java.util.Scanner;

import Controll.InserirTipo;

public class MenuGerenciaTipo {
    static Scanner scanner = new Scanner(System.in);

    private static int opcao = 0;
    
    public static void MenuTipo(){

        do{
            System.out.println("\n---- Gerenciamento de Tipos de Quarto ----");
            System.out.println("[1] - Inserir Dados do Tipo do Quarto");
            System.out.println("[2] - Atuaizar Dados do Tipo do Quarto");
            System.out.println("[3] - Excluir Dados do Tipo do Quarto");
            System.out.println("[4] - Exibir Dados do Tipo do Quarto");
            System.out.println("[0] - Voltar");
            System.out.print("Opcão: ");
            try{
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1: // Inserir
                        System.out.print("ID do Tipo do Quarto: ");
                        int id = scanner.nextInt();
                        System.out.print("Descrição: ");
                        scanner.nextLine();
                        String descricao = scanner.nextLine();
                        
                        InserirTipo InserirTipo = new InserirTipo(id, descricao);
                        break;
                    case 2: // Atualizar
                        
                        break;
                    case 3: // Excluir
                        
                        break;
                    case 4: // Exibir
                
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("NÚMERO INVÁLIDO. INSIRA UM VALOR ENTRE 0 E 4");
                        break;
                }
            }
            catch(InputMismatchException e){
                System.out.println("ERRO: DADO INVÁLIDO");
                return;
            }
            
        }while(opcao != 0);

    }
}
