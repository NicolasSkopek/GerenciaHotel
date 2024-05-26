package View;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal {
    static Scanner scanner = new Scanner(System.in);

    private static int opcao = 0;
    
    public static void Menu(){

        do{
            System.out.println("\n---- Gerenciamento do Hotel ----");
            System.out.println("[1] - Gerenciamento de Hóspedes");
            System.out.println("[2] - Gerenciamento de Funcionários");
            System.out.println("[3] - Gerenciamento de Reservas");
            System.out.println("[4] - Gerenciamento de Quartos da Reserva");
            System.out.println("[5] - Gerenciamento de Tipos de Quarto");
            System.out.println("[0] - Sair do Programa");
            System.out.print("Opcão: ");
            try{
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1: // Gerenciamento de Hóspedes
                        MenuGerenciaHospede.MenuHospede();
                        break;
                    case 2: // Gerenciamento de Funcionários
                        MenuGerenciaFuncionario.MenuFuncionario();
                        break;
                    case 3: // Gerenciamento de Reservas
                        MenuGerenciaReserva.MenuReserva();
                        break;
                    case 4: // Gerenciamento de Quarto
                        MenuGerenciaQuartos.MenuQuarto();
                        break;  
                    case 5: // Gerenciamento de Tipo do Quarto
                        MenuGerenciaTipo.MenuTipo();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("NÚMERO INVÁLIDO. INSIRA UM VALOR ENTRE 0 E 5");
                        break;
                }
            }
            catch(InputMismatchException e){
                System.out.println("ERRO: DADO INVÁLIDO");
            }
            
        }while(opcao != 0);

    }


}
