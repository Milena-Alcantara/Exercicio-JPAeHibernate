import DAO.ProductDAO;
import repository.ProductRepository;
import service.ProductService;
import view.ProductView;

public class Main {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        ProductRepository productRepository = new ProductRepository(productDAO);
        ProductService productService = new ProductService(productRepository);
        ProductView consoleView = new ProductView(productService);

        consoleView.exibirMenu();
    }
}


