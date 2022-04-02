package pl.pjatk;

import java.util.List;

public class CartSystem {

    public Product getCheapestOne(List<Product> products) {
        Product temp = new Product();
        temp.setPrice(999);
        for (Product product : products) {
            if (product.getPrice() <= temp.getPrice()) {
                temp = product;
            }
        }
        return temp;
    }

    public Product getExpensiveOne(List<Product> products) {
        Product temp = new Product();
        temp.setPrice(0);
        for (Product product : products) {
            if (product.getPrice() >= temp.getPrice()) {
                temp = product;
            }
        }
        return temp;
    }

    public double getSumOfCart(Cart cart) {
        double totalPrice = 0;
        for (Product product : cart.getProducts()) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}