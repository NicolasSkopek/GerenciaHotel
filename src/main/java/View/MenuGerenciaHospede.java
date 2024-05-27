package View;

import Controll.InserirHospede;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuGerenciaHospede {

    static Scanner scanner = new Scanner(System.in);

    private static int opcao = 0;
    
    public static void MenuHospede(){

        do{
            System.out.println("\n---- Gerenciamento de Hóspedes ----");
            System.out.println("[1] - Inserir Dados do Hóspede");
            System.out.println("[2] - Atuaizar Dados do Hóspede");
            System.out.println("[3] - Excluir Dados do Hóspede");
            System.out.println("[4] - Exibir Dados do Hóspede");
            System.out.println("[0] - Voltar");
            System.out.print("Opcão: ");
            try{
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1: // Inserir
                        System.out.print("CPF do Hóspede: ");
                        String cpf = scanner.nextLine();
                        System.out.print("Nome do Hóspede: ");
                        scanner.nextLine();
                        String nome = scanner.nextLine();
                        System.out.print("Telefone do Hóspede: ");
                        String telefone = scanner.nextLine();
                        System.out.print("Email do Hóspede: ");
                        String email = scanner.nextLine();
                        System.out.print("Status: ");
                        int status = scanner.nextInt();
                        
                        InserirHospede inserirHospede = new InserirHospede(cpf, nome, telefone, email, status);
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
