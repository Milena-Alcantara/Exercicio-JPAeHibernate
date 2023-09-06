package view;

import model.ProductModel;
import service.ProductService;

import java.util.List;
import java.util.Scanner;

public class ProductView {
    private ProductService productService;
    private Scanner scanner;

    public ProductView(ProductService productService) {
        this.productService = productService;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        while (true) {
            System.out.println("===== Menu de Produtos =====");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Encontrar Produto por ID");
            System.out.println("3. Listar Todos os Produtos");
            System.out.println("4. Atualizar Produto");
            System.out.println("5. Excluir Produto");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    encontrarProdutoPorId();
                    break;
                case 3:
                    listarTodosOsProdutos();
                    break;
                case 4:
                    atualizarProduto();
                    break;
                case 5:
                    excluirProduto();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void adicionarProduto() {
        System.out.print("Nome do Produto: ");
        String nome = scanner.nextLine();
        System.out.print("Preço do Produto: ");
        Double preco = scanner.nextDouble();
        scanner.nextLine();

        ProductModel novoProduto = new ProductModel();
        novoProduto.setNameProduct(nome);
        novoProduto.setPrice(preco);

        productService.saveProduct(novoProduto);
    }

    private void encontrarProdutoPorId() {
        System.out.print("Digite o ID do Produto: ");
        int id = scanner.nextInt();

        ProductModel produto = productService.findProductById(id);

        if (produto != null) {
            System.out.println("Produto encontrado:");
            System.out.println("ID: " + produto.getId());
            System.out.println("Nome: " + produto.getNameProduct());
            System.out.println("Preço: " + produto.getPrice());
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private void listarTodosOsProdutos() {
        List<ProductModel> produtos = productService.getAllProducts();

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
        } else {
            System.out.println("Lista de Produtos:");
            for (ProductModel produto : produtos) {
                System.out.println("ID: " + produto.getId());
                System.out.println("Nome: " + produto.getNameProduct());
                System.out.println("Preço: " + produto.getPrice());
                System.out.println("===============");
            }
        }
    }

    private void atualizarProduto() {
        System.out.print("Digite o ID do Produto que deseja atualizar: ");
        int id = scanner.nextInt();

        ProductModel produtoExistente = productService.findProductById(id);

        if (produtoExistente != null) {
            System.out.println("Novo Nome do Produto: ");
            String novoNome = scanner.next();
            System.out.println("Novo Preço do Produto: ");
            Double novoPreco = scanner.nextDouble();
            scanner.nextLine();

            produtoExistente.setNameProduct(novoNome);
            produtoExistente.setPrice(novoPreco);

            productService.updateProduct(produtoExistente);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private void excluirProduto() {
        System.out.print("Digite o ID do Produto que deseja excluir: ");
        int id = scanner.nextInt();

        productService.deleteProduct(id);
    }
}


