package ua.ithillel.spring.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ua.ithillel.spring.Product;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> productList = new ArrayList<>();

    public List<Product> getAllProducts() {
        return productList;
    }


    public void init() {

        productList.add(new Product(1, "Product 1", 10.0));
        productList.add(new Product(2, "Product 2", 19.0));
        productList.add(new Product(3, "Product 3", 23.0));
        productList.add(new Product(4, "Product 4", 9.0));
        productList.add(new Product(5, "Product 5", 11.0));
        productList.add(new Product(6, "Product 6", 57.0));
        productList.add(new Product(7, "Product 7", 33.0));
        productList.add(new Product(8, "Product 8", 8.0));

    }

    public ProductRepository() {
        init();
    }

    public Product getById(long id) {
        Product product = null;
        for (Product prod: productList){
            if (prod.getId() ==id){
                product = prod;
                break;
            }
        }
        return product;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
