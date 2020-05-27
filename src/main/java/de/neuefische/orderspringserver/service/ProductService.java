package de.neuefische.orderspringserver.service;

import de.neuefische.orderspringserver.db.ProductDb;
import de.neuefische.orderspringserver.model.Product;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;


@NoArgsConstructor
@Service
public class ProductService {
    private ProductDb productDb = new ProductDb();

    public Collection<Product> listAll(){
        return Collections.unmodifiableCollection(productDb.listAll());
    }

    public Collection<Product> searchProducts(String searchParameter){
        return Collections.unmodifiableCollection(productDb.getProducts(searchParameter));
    }

    public Product findProductById(String id){
        Optional<Product> product = productDb.findProductById(id);
        if(product.isPresent()){
            return product.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}


