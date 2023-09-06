package DAO;

import model.ProductModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProductDAO {
    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public ProductDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void saveProduct(ProductModel product) {
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
    }

    public ProductModel findProductById(int id) {
        return entityManager.find(ProductModel.class, id);
    }

    public List<ProductModel> getAllProducts() {
        String sql = "SELECT p FROM ProductModel p";
        return entityManager.createQuery(sql, ProductModel.class).getResultList();
    }

    public void updateProduct(ProductModel product) {
        entityManager.getTransaction().begin();
        entityManager.merge(product);
        entityManager.getTransaction().commit();
    }

    public void deleteProduct(int id) {
        entityManager.getTransaction().begin();
        ProductModel product = entityManager.find(ProductModel.class, id);
        entityManager.remove(product);
        entityManager.getTransaction().commit();
    }
}


