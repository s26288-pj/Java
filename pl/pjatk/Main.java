package pl.pjatk;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Pierwszy sposób ustawiania produktu
        Product product = new Product();
        product.setCode("12345");
        product.setName("Cukier");
        product.setPrice(20.00);
        product.setDiscountPrice(15.00);
        String product_information = product.getCode() + " " + product.getName() + " " + product.getPrice();

        // Drugi sposób ustawiania produktu
        Product product2 = new Product("12346", "Mleko", 6.00, 5.00);
        Product product3 = new Product("12347", "Jajka", 12.00, 10.00);

        // Tworzenie listy z produkatami
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product2);
        productList.add(product3);
        productList.add(new Product("12348", "Woda", 4.0, 2.0));
        productList.add(new Product("12349", "Sok", 7.0, 4.0));

        // Tworzenie koszyka i wysyłanie do niego listy produktów
        Cart cart = new Cart();
        cart.setProducts(productList);

        // Wywołanie koszyka
        CartSystem cartSystem = new CartSystem();

        System.out.println("Cart after discount: ");

        ICanCalculateSpecialOffer discount300Plus = new Discount300Plus();
        ICanCalculateSpecialOffer freeCup = new ApplyFreeCup();
        ICanCalculateSpecialOffer thirdForFree = new ApplyDiscountThirdForFree();
        cart.applyDiscount(discount300Plus);
        cart.applyDiscount(thirdForFree);
        cart.applyDiscount(freeCup);

        System.out.println(cart.toString());

        Invoice invoice = new Invoice();
        invoice.addPosition(new Product("produkt 1", "TV", 1000));
        invoice.addPosition(new Product("produkt 2", "TV", 1200));
        invoice.addPosition(new Product("produkt 3", "Radio", 100));
        invoice.addPosition(new Product("produkt 4", "Sluchawki", 250));
        invoice.addPosition(new Product("produkt 5", "Myszka", 80));
        printoutInvoice(invoice);

    }

    private static void printoutInvoice(Invoice invoice) {
        System.out.println("| NAZWA\t | ILOSC\t | CENA\t | CENA NETTO\t | CENA BRUTTO\t | STAWKA VAT\t | PODATEK\t |");
        System.out.println("****************************************************************************************");
        for(InvoicePosition p : invoice.getPositions()) {
            System.out.print("| " + p.getProduct().getName() + "\t | ");
            System.out.print(p.getCount() + "\t | ");
            System.out.print(p.getNettoPrice() + "\t | ");
            System.out.print(p.getGrossPrice() + "\t | ");
            System.out.print(p.getTax() + "\t | ");
            System.out.println(p.getTaxValue() + "\t |");
        }
        System.out.println("****************************************************************************************");
    }
}
