package repository;

import DAO.ProductDAO;
import model.ProductModel;

import java.util.List;

public class ProductRepository {
    private ProductDAO productDAO;
    public ProductRepository(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }
    public void saveProduct(ProductModel product){
        productDAO.saveProduct(product);
    }
    public ProductModel findProductById(int id){
        return productDAO.findProductById(id);
    }
    public List<ProductModel> getAllProducts(){
        return productDAO.getAllProducts();
    }
    public void updateProduct(ProductModel product){
        productDAO.updateProduct(product);
    }
    public void deleteProduct(int id){
        productDAO.deleteProduct(id);
    }
}
