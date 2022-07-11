package product.repository;

import java.util.List;

import javax.transaction.Transactional;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import product.model.Product;

@Component
public class ProductDao {
	@Autowired
	private HibernateTemplate hibernatetemplate;

	// create
	@Transactional
	public Product createProduct(Product product) {
		hibernatetemplate.save(product);
		return product;
	}

	// update
	@Transactional
	public Product updateProduct(Product product) {
		hibernatetemplate.update(product);
		return product;
	}

	@Transactional
	// get all products
	public List<Product> getProducts() {
		List<Product> products = hibernatetemplate.loadAll(Product.class);
		return products;
	}

	@Transactional
	// delete single product
	public String deleteProduct(int pid) {
		Product p = hibernatetemplate.load(Product.class, pid);
		hibernatetemplate.delete(p);
		return "deleted successfully";
	}

	@Transactional
	// get the single product
	public Product getSingleById(int pid) {
		Product findProduct = hibernatetemplate.get(Product.class, pid);
		return findProduct;
	}

}