package recipes;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private final List<Product> products;

    Basket(Product product){
        products = new ArrayList<>();
        addProduct(product);
    }

    private boolean validateProduct(Product product) {
        return products.stream().anyMatch(x-> x.getName().equals(product.getName()));
    }

    private boolean validateProduct(String product) {
        return products.stream().anyMatch(x-> x.getName().equals(product));
    }

    public void addProduct(Product product) {
        if(this.products.contains(product) && validateProduct(product)) {
            throw new IllegalArgumentException("Вы пытаетесь добавить уже существующий продукт");
        } else {
            products.add(product);
        }
    }

    public void addProduct(String name, Double price, Integer quantity) {
        if(validateProduct(name)) {
            throw new IllegalArgumentException("Вы пытаетесь добавить уже существующий продукт");
        } else {
            products.add(new Product(name, price, quantity));
        }
    }
}
