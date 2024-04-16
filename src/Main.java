import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConversorQuery query = new ConversorQuery();
        System.out.println("""
                    *********************************************
                    Welcome to the Currency Converter!""");

        int option = 1;
        while (option != 2) {
            System.out.println("""
                    Convert from which currency:
                    1) Dollar
                    2) Argentine Peso
                    3) Brazilian Real
                    4) Colombian Peso
                    """);
            String from = menuOptions();

            try {
                ExchangeRateAPI gsonExchangeRate = query.rate(from);
                ExchangeRate exchangeRate = new ExchangeRate(gsonExchangeRate);

                System.out.println("*********************************************\n"
                        + "Convert from " + from + " to which currency?");
                System.out.println("""
                        Convert to this currency:
                        1) Dollar
                        2) Argentine Peso
                        3) Brazilian Real
                        4) Colombian Peso
                        """);
                String to = menuOptions();

                System.out.println("*********************************************\n"
                        + "Convert from " + from + " to " + to + ":");
                System.out.println("How much do you want to convert?");
                Double currency = checkDouble();

                Double newCurrency = currency * exchangeRate.getValue(to);

                System.out.println("*********************************************\n"
                        + "Converting $ " + currency + " " + from + " to " + to + ":");
                System.out.println("$" + newCurrency + " " + to);
                System.out.println("""
                        
                        What would you like to do next?
                        1) Try a new conversion
                        2) Exit
                        """);
                option = checkInput();
                if (option == 2) {
                    System.out.println("Thanks for trusting in our software.");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static Double checkDouble() {
        Scanner prompt = new Scanner(System.in);

        while (true) {
            if (prompt.hasNextDouble()) {
                return prompt.nextDouble();
            } else {
                System.out.println("Invalid input. Please enter a valid number:");
                prompt.next();
            }
        }
    }

    public static Integer checkInput() {
        Scanner prompt = new Scanner(System.in);

        while (true) {
            if (prompt.hasNextInt()) {
                return prompt.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a valid number:");
                prompt.next();
            }
        }
    }

    public static String menuOptions() {
        int selectedOption = checkInput();
        while (true) {
            switch (selectedOption) {
                case 1:
                    return "USD";
                case 2:
                    return "ARS";
                case 3:
                    return "BRL";
                case 4:
                    return "COP";
                default:
                    System.out.println("Invalid option, please try again:");
                    selectedOption = checkInput();
            }
        }
    }
}