package Service;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Produto {
    private String title;
    private double price;

    public static TreeSet<String> filtrarImperdiveis(double precoMaximo) throws IOException, InterruptedException {
        ConsomeApi api = new ConsomeApi();
        String jsonResponse = api.consomeApi();
        Gson gson = new Gson();
        List<Produto> produtos = gson.fromJson(jsonResponse, new TypeToken<List<Produto>>() {}.getType());

        return produtos.stream()
                .filter(p -> p.price < precoMaximo)
                .map(p -> "Produto: " + p.title + " - Preço: R$" + p.price)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public static TreeSet<String> filtrarPromocao(double precoMaximo) throws IOException, InterruptedException {
        ConsomeApi api = new ConsomeApi();
        String jsonResponse = api.consomeApi();
        Gson gson = new Gson();
        List<Produto> produtos = gson.fromJson(jsonResponse, new TypeToken<List<Produto>>() {}.getType());

        return produtos.stream()
                .filter(p -> p.price >= precoMaximo)
                .map(p -> "PRODUTO: " + p.title.toUpperCase() + " - PREÇO: R$" + p.price)
                .collect(Collectors.toCollection(TreeSet::new));
    }
}