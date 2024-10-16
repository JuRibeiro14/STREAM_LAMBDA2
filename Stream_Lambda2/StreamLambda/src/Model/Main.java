package Model;
import Service.Produto;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o preço máximo: ");
        double precoMaximo = scanner.nextDouble();

        TreeSet<String> produtosImperdiveis = Produto.filtrarImperdiveis(precoMaximo);
        TreeSet<String> produtosPromocao = Produto.filtrarPromocao(precoMaximo);

        System.out.println("\nProdutos imperdíveis até R$" + precoMaximo + ":");
        produtosImperdiveis.forEach(System.out::println);

        System.out.println("\nProdutos em promoção acima ou igual a R$" + precoMaximo + ":");
        produtosPromocao.forEach(System.out::println);
    }
}