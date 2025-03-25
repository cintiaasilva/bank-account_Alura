import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankAccount {

    static Scanner scan = new Scanner(System.in);
    static final String MENU = """
                ** Digite sua opção **
                1 - Consultar saldo
                2 - Receber valor
                3 - Transferir valor
                4 - Extrato
                5 - Sair

                """;

    public static void main(String[] args) {
        System.out.println("Digite o seu nome " +
                "e em seguida o tipo da sua conta: ");
        Map<String, Object> customerData = getCustomerData();
        System.out.println(customerData.get("mensagem"));
        optionsMenu(customerData);

        scan.close();
    }

    public static Map<String, Object> getCustomerData(){
        String name = scan.nextLine();
        String accountType = scan.nextLine();
        double openingBalance = 0.00;
        String message = "***********************";
        message += "\nNome do cliente: " + name;
        message += "\nTipo conta: " + accountType;
        message += "\n***********************";

        Map<String, Object> costumerData = new HashMap<>();
        costumerData.put("nome", name);
        costumerData.put("tipoConta", accountType);
        costumerData.put("saldoInicial", openingBalance);
        costumerData.put("mensagem", message);

        return costumerData;
    }

    public static void optionsMenu(Map<String, Object> customerData){
        int option = 0;

        while (option != 5){
            System.out.println(MENU);
            option = scan.nextInt();
            scan.nextLine(); // Limpar o buffer antes de usar `nextLine` novamente

            switch (option){
                case 1:
                    // Visualização do saldo
                    Object saldo = customerData.get("saldoInicial");
                    System.out.printf("Atualmente seu saldo está %.2f R$ %n%n", saldo);
                    break;
                case 2:
                    // Receber valor
                    System.out.println("Informe o valor a receber: ");
                    break;
                case 3:
                    // Enviar valor
                    System.out.println("Informe o valor que deseja transferir: ");
                    break;
                case 4:
                    // Extrato
                    System.out.println("Extrato da sua conta");
                    break;
                case 5:
                    // Sair
                    System.out.println("Sair do sistema");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }
    //TODO: Checklist: Visualização do saldo ,   Enviar valor ,   Receber valor
}

