package product.service;
import java.util.List;
import product.model.Product;
import product.repository.ProductDao;


public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public List<Product> getProducts() {
		return productDao.getProducts();
	}

	public Product createProduct(Product product) {
		return productDao.createProduct(product);
	}

	public String deleteProduct(int productId) {
		return productDao.deleteProduct(productId);
	}

	public Product getSingleById(int pid) {
		return productDao.getSingleById(pid);
	}

	public Product updateProduct(Product product) {
		return productDao.updateProduct(product);
	}
}