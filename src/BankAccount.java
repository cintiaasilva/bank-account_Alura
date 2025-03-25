import java.util.Scanner;

public class BankAccount {

    static Scanner scan = new Scanner(System.in);
    static final String MENU = """
                ** Digite sua opção **
                1 - Consultar saldo
                2 - Transferir valor
                3 - Receber valor 
                4 - Sair

                """;


    public static void main(String[] args) {
        System.out.println(getCustomerData());
        optionsMenu();
    }

    public static String getCustomerData(){

        // Inicializar dados do cliente - HARDCODE
        String name = "Jacqueline Oliveira";
        String accountType = "Corrente";
        double openingBalance = 2500.00;

        String message = "***********************";
        message += "\nNome do cliente: " + name;
        message += "\nTipo conta: " + accountType;
        message += "\nSaldo atual: " + openingBalance;
        message += "\n***********************";

        return message; // Usar variável intermediária traz uma melhor legibilidade e falicita a manutenção
                        // Para ficar mais conciso(abreviado) para este caso simples, poderia ser utilizado diretamente
                        // no return
    }

    public static void optionsMenu(){
        int option = 0;

        while (option != 4){
            System.out.println(MENU);
            option = scan.nextInt();

            switch (option){
                case 1:
                    System.out.println("caso 1");
                    break;
                case 2:
                    System.out.println("caso 2");
                    break;
                case 3:
                    System.out.println("caso 3");
                    break;
                case 4:
                    System.out.println("caso 4");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }
}