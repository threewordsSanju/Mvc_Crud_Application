package product.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import product.model.Product;

@Component
public class ProductDao {

	private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//	SessionFactory sessionfactory=

	// create
	public Product createProduct(Product product) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(product);
		session.getTransaction().commit();
		session.close();		return product;
	}

	
	// update
	public Product updateProduct(Product product) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(product);
		session.getTransaction().commit();
		session.close();
		return product;
	}

//	 get all products
	public List<Product> getProducts() {
		Session session = sessionFactory.openSession();
		String hql = "From Product p";
		Query query = session.createQuery(hql);
		List<Product> resultList = query.list();
		return resultList;
	}

	// delete single product
	public String deleteProduct(int pid) {

		Session session = sessionFactory.openSession();
		Product p = session.load(Product.class, pid);
		session.beginTransaction();
		session.delete(p);
		session.getTransaction().commit();
		session.close();
		return "deleted successfully";
	}

	// get the single product
	public Product getSingleById(int pid) {
		Session session = sessionFactory.openSession();
		Product p = session.find(Product.class, pid);
		return p;
	}
}