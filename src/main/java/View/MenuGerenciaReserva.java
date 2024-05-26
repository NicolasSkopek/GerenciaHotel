package View;

import java.util.InputMismatchException;
import java.util.Scanner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Controll.InserirReserva;

public class MenuGerenciaReserva {

    static Scanner scanner = new Scanner(System.in);

    private static int opcao = 0;
    
    public static void MenuReserva(){

        do{
            System.out.println("---- Gerenciamento de Reserva ----");
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
                        long cpfHospede = scanner.nextLong();
                        System.out.print("CPF do Funcionário: ");
                        long cpfFuncionario = scanner.nextLong();
                        
                        InserirReserva InserirReserva = new InserirReserva(id, dataEntrada, dataRetirada, cpfHospede, cpfFuncionario);
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
