package uz.bunyodbek.onlineshopmain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.bunyodbek.onlineshopmain.dto.ProductDto;
import uz.bunyodbek.onlineshopmain.model.Product;
import uz.bunyodbek.onlineshopmain.model.Result;
import uz.bunyodbek.onlineshopmain.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN' , 'USER')")
    public List<Product> getALl() {
        List<Product> list = productService.getAllProduct();
        return list;
    }


    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Integer id) {
        Product product = productService.getBYIDProduct(id);
        return product;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Result add(@RequestBody ProductDto productDto) {
        Result result = productService.create(productDto);
        return result;
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Result edit(@PathVariable Integer id, @RequestBody ProductDto productDto) {
        Result result = productService.update(id, productDto);
        return result;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Result del(@PathVariable Integer id) {
        Result result = productService.delete(id);
        return result;
    }


}
