package View;

import java.util.InputMismatchException;
import java.util.Scanner;

import Controll.InserirQuarto;

public class MenuGerenciaQuartos {
    static Scanner scanner = new Scanner(System.in);

    private static int opcao = 0;
    
    public static void MenuQuarto(){

        do{
            System.out.println("\n---- Gerenciamento de Quartos ----");
            System.out.println("[1] - Inserir Dados da Quartos");
            System.out.println("[2] - Atuaizar Dados da Quartos");
            System.out.println("[3] - Excluir Dados da Quartos");
            System.out.println("[4] - Exibir Dados da Quartos");
            System.out.println("[0] - Voltar");
            System.out.print("Opcão: ");
            try{
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1: // Inserir
                        System.out.print("ID do Quarto: ");
                        int id = scanner.nextInt();
                        System.out.print("ID da Reserva: ");
                        int idReserva = scanner.nextInt();
                        System.out.print("ID do Tipo do Quarto: ");
                        int idTipo = scanner.nextInt();

                        InserirQuarto InserirQuarto= new InserirQuarto(id, idReserva, idTipo);
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
