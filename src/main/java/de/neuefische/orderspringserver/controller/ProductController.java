package de.neuefische.orderspringserver.controller;

import de.neuefische.orderspringserver.model.Product;
import de.neuefische.orderspringserver.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;


@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("product")
public class ProductController {
    private ProductService productService = new ProductService();

    @GetMapping("allProducts")
    public Collection<Product> listAll(){
        return Collections.unmodifiableCollection(productService.listAll());
    }

    @GetMapping("{searchParameter}")
    public Collection<Product> findProducts(@PathVariable() String searchParameter){
        return Collections.unmodifiableCollection(productService.searchProducts(searchParameter));
    }
    @GetMapping("findproductbyid")
    public Product getProductById(@RequestParam(name ="id",required = false) String id){
        System.out.println("");
        return productService.findProductById(id);

    }

}
