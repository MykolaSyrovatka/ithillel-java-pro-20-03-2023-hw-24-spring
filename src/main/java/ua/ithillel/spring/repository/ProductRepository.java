package ua.ithillel.spring.repository;

import org.springframework.stereotype.Component;
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
        productList.add(new Product(2, "Product 2", 20.0));

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
