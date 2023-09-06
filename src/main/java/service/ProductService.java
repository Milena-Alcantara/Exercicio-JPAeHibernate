package service;

import model.ProductModel;
import repository.ProductRepository;

import java.util.List;
public class ProductService {
    private ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saveProduct(ProductModel product){
        productRepository.saveProduct(product);
        System.out.println("O Produto: "+product.getNameProduct()+" foi inserido com sucesso!");
    }

    public ProductModel findProductById(int id){
        return productRepository.findProductById(id);
    }

    public List<ProductModel> getAllProducts(){
        return productRepository.getAllProducts();
    }

    public void updateProduct(ProductModel product){
        productRepository.updateProduct(product);
        System.out.println("Produto atualizado com sucesso!");
    }
    public void deleteProduct(int id){
        productRepository.deleteProduct(id);
        System.out.println("Produto excluído com sucesso!");
    }
}
