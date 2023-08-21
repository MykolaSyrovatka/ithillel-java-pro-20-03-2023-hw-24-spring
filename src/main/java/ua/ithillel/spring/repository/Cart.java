package ua.ithillel.spring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ua.ithillel.spring.Product;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {

    @Autowired
    private ProductRepository productRepository;

    private List<Product> cartList = new ArrayList<>();

    public void addToCart(long id) {
        cartList.add(productRepository.getById(id));
    }

    public void removeById(long id) {
        for (Product prod : cartList) {
            if (prod.getId() == id) {
                cartList.remove(id);
                break;
            }
        }
    }

    public void displayCart() {
        System.out.println("Cart list:");
        for (Product product : cartList) {
            System.out.println(product.getName() + " - $" + product.getPrice());
        }
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }
}
