package pl.pjatk;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Product product = new Product();
        product.setCode("12345");
        product.setName("Cukier");
        product.setPrice(20.00);
        product.setDiscountPrice(15.00);
        String product_information = product.getCode() + " " + product.getName() + " " + product.getPrice();

        Product product2 = new Product("12346", "Mleko", 6.00, 5.00);
        String product_information2 = product2.getCode() + " " + product2.getName() + " " + product2.getPrice();

        Product product3 = new Product("12347", "Jajka", 12.00, 10.00);

        System.out.println(product_information);
        System.out.println(product_information2);
        System.out.println(product3.toString());

        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product2);
        productList.add(product3);
        productList.add(new Product("12348", "Woda", 4.0, 2.0));
        productList.add(new Product("12349", "Sok", 7.0, 4.0));

        Cart cart = new Cart();
        cart.setProducts(productList);

        CartSystem cartSystem = new CartSystem();

        System.out.println("Cart after discount: ");

        ICanCalculateSpecialOffer discount300Plus = new Discount300Plus();
        ICanCalculateSpecialOffer freeCup = new ApplyFreeCup();
        ICanCalculateSpecialOffer thirdForFree = new ApplyDiscountThirdForFree();
        cart.applyDiscount(discount300Plus);
        cart.applyDiscount(thirdForFree);
        cart.applyDiscount(freeCup);

        System.out.println(cart.toString());
    }
}
