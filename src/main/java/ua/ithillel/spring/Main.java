package ua.ithillel.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.ithillel.spring.repository.Cart;
import ua.ithillel.spring.repository.ProductRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("ua.ithillel.spring.repository");
        Cart cart = applicationContext.getBean(Cart.class);
        ProductRepository productRepository = applicationContext.getBean(Cart.class).getProductRepository();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add to Cart");
            System.out.println("2. Remove from Cart");
            System.out.println("3. Display Cart");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter product ID to add: ");
                long productId = scanner.nextLong();
                Product product = productRepository.getById(productId);
                if (product != null) {
                    cart.addToCart(productId);
                    System.out.println("Product added to cart.");
                } else {
                    System.out.println("Product not found.");
                }
            } else if (choice == 2) {
                System.out.print("Enter product ID to remove: ");
                long productId = scanner.nextLong();
                cart.removeById(productId);
                System.out.println("Product removed from cart.");
            } else if (choice == 3) {
                cart.displayCart();
            } else if (choice == 4) {
                break;
            }
        }
    }
}