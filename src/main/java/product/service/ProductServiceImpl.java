package product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import product.model.Product;
import product.repository.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> getProducts() {
		return productDao.getProducts();

	}

	@Override
	public Product createProduct(Product product) {
		return productDao.createProduct(product);
	}

	@Override
	public String deleteProduct(int productId) {
		return productDao.deleteProduct(productId);
	}

	@Override
	public Product getSingleById(int pid) {
		return productDao.getSingleById(pid);
	}

	@Override
	public Product updateProduct(Product product) {
		return productDao.updateProduct(product);
	}

}