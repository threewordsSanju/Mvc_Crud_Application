package product.service;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.lenient;
//import static org.mockito.Mockito.when;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import product.model.Product;
import product.repository.ProductDao;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

	@InjectMocks
	private ProductServiceImpl productServiceImpl;

	@Mock
	private ProductDao productDao;

	List<Product> products = new ArrayList<Product>();

	@Before
	public void setup() {

		Product p1 = new Product();
		Product p2 = new Product();

		p1.setDescription("testing1");
		p1.setId(1);
		p1.setName("demo1");
		p1.setPrice(100);

		p2.setDescription("testing2");
		p2.setId(2);
		p2.setName("demo2");
		p2.setPrice(200);

		products.add(p1);
		products.add(p2);

		lenient().when(productDao.deleteProduct(p1.getId())).thenReturn("deleted successfully");
		lenient().when(productDao.getProducts()).thenReturn(products);
		lenient().when(productDao.getSingleById(1)).thenReturn(p1);

	}

	@Test
	public void testGetProducts() {
		assertEquals(productServiceImpl.getProducts(), products);
	}

	@Test
	public void testGetSingleById() {
		assertEquals(productServiceImpl.getSingleById(1), products.get(0));
	}

	@Test
	public void testCreateProduct() {
		Product p1 = new Product();

		p1.setDescription("testing1");
		p1.setId(1);
		p1.setName("demo1");
		p1.setPrice(100);
		lenient().when(productDao.createProduct(p1)).thenReturn(p1);
		assertEquals(productServiceImpl.createProduct(p1), p1);

	}

	@Test
	public void testDeleteProduct() {
		Product p1 = new Product();

		p1.setDescription("testing1");
		p1.setId(1);
		p1.setName("demo1");
		p1.setPrice(100);
		assertEquals(productServiceImpl.deleteProduct(p1.getId()), "deleted successfully");
	}

	@Test
	public void testUpdateProduct() {
		Product p1 = new Product();

		p1.setDescription("testing1");
		p1.setId(1);
		p1.setName("demo1");
		p1.setPrice(100);

		when(productDao.updateProduct(p1)).thenReturn(p1);
		assertEquals(productServiceImpl.updateProduct(p1), p1);

	}
}