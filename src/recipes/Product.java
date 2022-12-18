package recipes;

public class Product {
    private String name;
    private Double price;
    private Integer quantity;

    public Product(String name, Double price, Integer quantity) {
        setName(name);
        setPrice(price);
        setQuantity(quantity);
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не должно быть пустым");
        }

        this.name = name;
    }

    public void setPrice(Double price) {
        if(price == null || price <= 0) {
            throw new IllegalArgumentException("Цена не должна быть меньше нуля или пустой");
        }

        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        if(quantity == null || quantity <= 0) {
            throw new IllegalArgumentException("Количество не должно быть меньше нуля или пустой");
        }

        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
