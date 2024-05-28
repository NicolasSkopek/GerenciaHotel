package View;

import java.util.InputMismatchException;
import java.util.Scanner;

import Controller.InserirReserva;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MenuGerenciaReserva{

    static Scanner scanner = new Scanner(System.in);
    
    public int opcao = 0;
    
    public void menuReserva(){

        do{
            System.out.println("\n---- Gerenciamento de Reserva ----");
            System.out.println("[1] - Inserir Dados da Reserva");
            System.out.println("[2] - Atuaizar Dados da Reserva");
            System.out.println("[3] - Excluir Dados da Reserva");
            System.out.println("[4] - Exibir Dados da Reserva");
            System.out.println("[0] - Voltar");
            System.out.print("Opcão: ");
            try{
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1: // Inserir
                        System.out.print("ID da Reserva: ");
                        int id = scanner.nextInt();
                        System.out.print("Data de entrada: ");
                        LocalDate dataEntrada = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        System.out.print("Data de retirada: ");
                        LocalDate dataRetirada = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        System.out.print("CPF do Hóspede: ");
                        scanner.nextLine();
                        String cpfHospede = scanner.nextLine();
                        System.out.print("CPF do Funcionário: ");
                        String cpfFuncionario = scanner.nextLine();

                        System.out.print("iD (0 - INATIVO / 1 - ATIVO): ");
                        int status = scanner.nextInt();

                                      
                        InserirReserva InserirReserva = new InserirReserva(id, dataEntrada, dataRetirada, cpfHospede, cpfFuncionario, status);
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
