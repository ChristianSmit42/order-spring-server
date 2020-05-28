package de.neuefische.orderspringserver.db;

import de.neuefische.orderspringserver.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class ProductDb {
    private ArrayList<Product> products = new ArrayList<>();

    public ProductDb(){
       /* products.add(new Product("1", "Karotte"));
        products.add(new Product("2", "Tomate"));
        products.add(new Product("3", "Kiwi"));
        products.add(new Product("4", "karpfen"));*/
    }


    public Collection<Product> listAll() {
        return Collections.unmodifiableCollection(products);
    }

    public Collection<Product> getProducts(String searchParameter) {
        ArrayList<Product> matchingProducts= new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().startsWith(searchParameter.toLowerCase()) || product.getId().toLowerCase().startsWith(searchParameter.toLowerCase())) {
                matchingProducts.add(product);
            }
        }
        return matchingProducts;
    }
    public Optional<Product> findProductById(String id){
        for(Product product:products){
            if(product.getId().equals(id)){
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }
}
