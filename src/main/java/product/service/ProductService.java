package product.service;

import java.util.List;

import product.model.Product;

public interface ProductService {
	public List<Product> getProducts();

	public Product createProduct(Product product);

	public String deleteProduct(int productId);

	public Product getSingleById(int pid);

	public Product updateProduct(Product product);
}
