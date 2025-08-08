import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;
import com.google.gson.Gson;

public class ConversorMoedas {

    // chave da API
    private static final String API_KEY = "84dfe40bfc0609a010f168e9";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CONVERSOR DE MOEDAS (Tempo Real) ===");

        while (true) {
            System.out.print("Digite a moeda de origem (ex: USD, BRL, EUR) ou 'sair' para encerrar: ");
            String moedaOrigem = scanner.nextLine().toUpperCase();

            if (moedaOrigem.equalsIgnoreCase("SAIR")) {
                System.out.println("Encerrando o conversor. Até logo!");
                break;
            }

            System.out.print("Digite a moeda de destino (ex: USD, BRL, EUR): ");
            String moedaDestino = scanner.nextLine().toUpperCase();

            System.out.print("Digite o valor que deseja converter: ");
            double valor = scanner.nextDouble();
            scanner.nextLine(); // limpar o buffer

            converter(moedaOrigem, moedaDestino, valor);
            System.out.println();
        }

        scanner.close();
    }

    //Buscando taxas e converter
    public static void converter(String moedaOrigem, String moedaDestino, double valor) {
        try {
            String urlStr = BASE_URL + moedaOrigem;
            URL url = new URL(urlStr);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            StringBuilder resposta = new StringBuilder();
            String linha;
            while ((linha = in.readLine()) != null) {
                resposta.append(linha);
            }
            in.close();

            // Utilizando o Gson para ler o JSON
            Gson gson = new Gson();
            Map<?, ?> json = gson.fromJson(resposta.toString(), Map.class);
            Map<String, Double> taxas = (Map<String, Double>) json.get("conversion_rates");

            if (taxas.containsKey(moedaDestino)) {
                double taxa = taxas.get(moedaDestino);
                double resultado = valor * taxa;
                System.out.printf("Taxa atual %s -> %s: %.4f%n", moedaOrigem, moedaDestino, taxa);
                System.out.printf("Valor convertido: %.2f %s%n", resultado, moedaDestino);
            } else {
                System.out.println("Moeda destino não encontrada.");
            }

        } catch (Exception e) {
            System.out.println("Erro ao obter taxas de câmbio: " + e.getMessage());
        }
    }
}
