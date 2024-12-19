package practise;

import java.util.*;
import java.util.stream.*;
class Product {
    private String name;
    private String category;
    private int quantity;
    private double price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Product(String name, String category, int quantity, double price) {
		super();
		this.name = name;
		this.category = category;
		this.quantity = quantity;
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", category=" + category + ", quantity=" + quantity + ", price=" + price + "]";
	}
}
public class MostExpensiveProduct {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 5, 1000.0),
            new Product("Smartphone", "Electronics", 0, 800.0),
            new Product("Desk", "Furniture", 10, 200.0),
            new Product("Chair", "Furniture", 0, 100.0),
            new Product("Tablet", "Electronics", 3, 300.0)
        );
        Map<String, Optional<Product>> mostexp=products.stream().filter(n->n.getQuantity()>0).collect(Collectors.groupingBy(Product::getCategory,Collectors.maxBy(Comparator.comparing(Product::getPrice))));
        mostexp.forEach((category,product)->System.out.println("category is : "+ category + " most expensive product is :"+product.orElse(null)));
    }
}