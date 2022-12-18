package recipes;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private final List<Product> products;
    private String recipeName;
    private Double cost;

    Recipe(String recipeName, Product product){
        products = new ArrayList<>();
        setRecipeName(recipeName);
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
            this.cost += product.getPrice();
            products.add(product);
        }
    }

    public void addProduct(String name, Double price, Integer quantity) {
        if(validateProduct(name)) {
            throw new IllegalArgumentException("Вы пытаетесь добавить уже существующий продукт");
        } else {
            this.cost += price;
            products.add(new Product(name, price, quantity));
        }
    }

    public void setRecipeName(String recipeName) {
        if(recipeName == null || recipeName.isEmpty()) {
            throw new IllegalArgumentException("Название не должно быть пустым");
        }

        this.recipeName = recipeName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public Double getCost() {
        return cost;
    }
}
