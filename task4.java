import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;   
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class WebScraper {
    public static void main(String[] args) throws IOException {
        String url = "https://www.amazon.com/bestsellers/books/"; 
        String csvFile = "products.csv";
        List<Product> products = extractProducts(url);
        try (FileWriter writer = new FileWriter(csvFile)) {
            writer.append("Name,Price,Rating\n");
            for (Product product : products) {
                writer.append(product.getName() + "," + product.getPrice() + "," + product.getRating() + "\n");
            }
            System.out.println("Data saved to " + csvFile);
        } catch (IOException e) {
            System.out.println("Error writing to CSV file: " + e.getMessage());
        }
    }
    private static List<Product> extractProducts(String url) throws IOException {
        List<Product> products = new ArrayList<>();
        Document doc = Jsoup.connect(url).get();
        Elements productElements = doc.select(".zg-item-immersion");
        for (Element productElement : productElements) {
            String name = productElement.select(".p13n-sc-truncated").text();
            String price = productElement.select(".p13n-sc-price").text();
            String rating = productElement.select(".a-icon-alt").text();
            Product product = new Product(name, price, rating);
            products.add(product);
        }
        return products;
    }
    static class Product {
        private String name;
        private String price;
        private String rating;
        public Product(String name, String price, String rating) {
            this.name = name;
            this.price = price;
            this.rating = rating;
        }
        public String getName() {
            return name;
        }
        public String getPrice() {
            return price;
        }
        public String getRating() {
            return rating;   
        }
    }
}
