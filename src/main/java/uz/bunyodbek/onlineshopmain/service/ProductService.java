package uz.bunyodbek.onlineshopmain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.bunyodbek.onlineshopmain.dto.ProductDto;
import uz.bunyodbek.onlineshopmain.model.Product;
import uz.bunyodbek.onlineshopmain.model.Result;
import uz.bunyodbek.onlineshopmain.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProduct() {
        List<Product> productList = productRepository.findAll();
        return productList;
    }

    public Product getBYIDProduct(Integer id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.get();
    }

    public Result create(ProductDto productDto) {

        boolean existsByName = productRepository.existsByName(productDto.getName());

        if (existsByName) {
            return new Result(false, "Bunday product mavjud");
        }

        Product product = new Product();

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setAmount(productDto.getAmount());
        product.setDescription(productDto.getDescription());
        productRepository.save(product);
        return new Result(true, "Saqlandi");
    }

    public Result update(Integer id, ProductDto productDto) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();

            product.setName(productDto.getName());
            product.setPrice(productDto.getPrice());
            product.setAmount(productDto.getAmount());
            product.setDescription(productDto.getDescription());
            productRepository.save(product);
            return new Result(true, "O'zgartirildi");

        }
        return new Result(false, "Product yo'q");
    }

    public Result delete(Integer id) {
        productRepository.deleteById(id);
        return new Result(true, "O'chirildi");

    }


}
