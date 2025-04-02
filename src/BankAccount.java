import java.util.ArrayList;
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
        System.out.println("""
                Digite o seu nome \
                e em seguida o tipo da sua conta:\s
                
                """);
        Map<String, Object> customerData = getCustomerData();
        System.out.println(customerData.get("mensagem"));
        optionsMenu(customerData);

        scan.close();
    }

    public static Map<String, Object> getCustomerData(){
        String name = scan.nextLine();
        String accountType = scan.nextLine();
        double openingBalance = 0.00;
        String message = "\n\n***********************";
        message += "\nNome do cliente: " + name;
        message += "\nTipo da conta: " + accountType;
        message += "\n***********************";

        Map<String, Object> customerData = new HashMap<>();
        customerData.put("nome", name);
        customerData.put("tipoConta", accountType);
        customerData.put("saldoInicial", openingBalance);
        customerData.put("mensagem", message);
        customerData.put("historicoTransacoes", new ArrayList<String>()); // Adicionando lista para o histórico

        ((ArrayList<String>) customerData.get("historicoTransacoes"))
                .add(String.format("Saldo inicial: %.2f R$", openingBalance)); // Primeira entrada no extrato

        return customerData;
    }

    public static void optionsMenu(Map<String, Object> customerData){
        int option = 0;

        while (option != 5){
            System.out.println("\n" + MENU); // Linha em branco para separar
            try {
                option = scan.nextInt();
                scan.nextLine(); // Limpar o 'buffer' antes de usar 'nextLine' novamente

                switch (option){
                    case 1 -> displayBalance(customerData);
                    case 2 -> receiveValue(customerData);
                    case 3 -> transferValue(customerData);
                    case 4 -> displayStatement(customerData);
                    case 5 -> System.out.println("Até a próxima!");
                    default -> System.out.println("Opção inválida. Tente novamente.");
                }
            }catch (Exception e){
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scan.nextLine(); // Limpa o scanner em caso de erro
            }
        }
    }

    public static void displayBalance(Map<String, Object> customerData){
        double saldo = (double) customerData.get("saldoInicial");
        System.out.printf("Atualmente seu saldo é %.2f R$ %n%n", saldo);
    }

    public static void receiveValue(Map<String, Object> customerData) {
        System.out.println("Informe o valor a receber: ");
        double amountToReceive = scan.nextDouble();
        scan.nextLine();
        double balance = (double) customerData.get("saldoInicial") + amountToReceive;
        customerData.put("saldoInicial", balance);

        // Adicionar transação ao histórico
        ((ArrayList<String>) customerData.get("historicoTransacoes"))
                .add(String.format("Recebimento: +%.2f R$ (Saldo atual: %.2f R$)", amountToReceive, balance));

        System.out.printf("Valor recebido! Seu saldo é %.2f R$ %n", balance);
    }

    public static void transferValue(Map<String, Object> customerData){
        System.out.println("Informe o valor que deseja transferir: ");
        double valueToTransfer = scan.nextDouble();
        double balance = (double) customerData.get("saldoInicial");
        if (valueToTransfer > balance) {
            System.out.printf("Saldo insuficiente. Seu saldo é %.2f R$ %n", balance);
        } else {
            balance -= valueToTransfer;
            customerData.put("saldoInicial", balance);

            // Adicionar transação ao histórico
            ((ArrayList<String>) customerData.get("historicoTransacoes"))
                    .add(String.format("Transferência: -%.2f R$ (Saldo atual: %.2f R$)", valueToTransfer, balance));

            System.out.printf("Transferência concluída. Saldo atual: %.2f R$ %n", balance);
        }
    }

    public static void displayStatement(Map<String, Object> customerData) {
        System.out.println("\n***********************");
        System.out.println("Extrato da sua conta:");
        ArrayList<String> historico = (ArrayList<String>) customerData.get("historicoTransacoes");
        for (String transaction : historico) {
            System.out.println(transaction);
        }
        System.out.println("***********************");
    }
}

