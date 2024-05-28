package View;

import java.util.InputMismatchException;
import java.util.Scanner;

import Controll.InserirHospede;

public class MenuGerenciaHospede{

    static Scanner scanner = new Scanner(System.in);
    
    public int opcao = 0;

    public void menuHospede(){

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
                        scanner.nextLine();
                        String cpf = scanner.nextLine();
                        System.out.print("Nome do Hóspede: ");
                        String nome = scanner.nextLine();
                        System.out.print("Telefone do Hóspede: ");
                        String telefone = scanner.nextLine();
                        System.out.print("Email do Hóspede: ");
                        String email = scanner.nextLine();
                        
                        InserirHospede inserirHospede = new InserirHospede(cpf, nome, telefone, email);
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
