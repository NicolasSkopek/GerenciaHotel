package View;

import java.util.InputMismatchException;
import java.util.Scanner;

import Controll.InserirFuncionario;


public class MenuGerenciaFuncionario extends MenuPrincipal{
    static Scanner scanner = new Scanner(System.in);
    
    @Override
    public void Menu(){

        do{
            System.out.println("\n---- Gerenciamento de Funcionário ----");
            System.out.println("[1] - Inserir Dados do Funcionário");
            System.out.println("[2] - Atuaizar Dados do Funcionário");
            System.out.println("[3] - Excluir Dados do Funcionário");
            System.out.println("[4] - Exibir Dados do Funcionário");
            System.out.println("[0] - Voltar");
            System.out.print("Opcão: ");
            try{
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1: // Inserir
                        System.out.print("CPF do Funcionário: ");
                        scanner.nextLine();
                        String cpf = scanner.nextLine();
                        System.out.print("Nome do Funcionário: ");
                        String nome = scanner.nextLine();
                        System.out.print("Cargo do Funcionário: ");
                        String cargo = scanner.nextLine();
                        
                        InserirFuncionario inserirFuncionario = new InserirFuncionario(cpf, nome, cargo);
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
