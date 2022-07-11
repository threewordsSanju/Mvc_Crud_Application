package product.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import product.model.Product;
import product.service.ProductServiceImpl;

@Controller
public class MainController {

	@Autowired
	private ProductServiceImpl productdao;

	@RequestMapping("/")
	public String home(Model m) {
		List<Product> products = productdao.getProducts();
		m.addAttribute("product", products);
		return "index";
	}

	// show add product form
	@RequestMapping("/addproduct")
	public String addProduct(Model m) {
		m.addAttribute("title", "Add product");
		return "add_product_form";
	}

	// handle add product form
	@RequestMapping(value = "/handle-product", method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request) {
		System.out.println(product);
		productdao.createProduct(product);
		RedirectView redirectview = new RedirectView();
		redirectview.setUrl(request.getContextPath() + "/");
		return redirectview;
	}

//delete handler
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId, HttpServletRequest request) {
		this.productdao.deleteProduct(productId);
		RedirectView redirectview = new RedirectView();
		redirectview.setUrl(request.getContextPath() + "/");
		return redirectview;
	}

	// update handler
	@RequestMapping("/update/{productId}")
	public String updateProduct(@PathVariable("productId") int pid, Model model) {
		Product product = productdao.getSingleById(pid);
		model.addAttribute("products", product);
		return "update_form";
	}
	
	// handle add product form
	@RequestMapping(value = "/update-product", method = RequestMethod.POST)
	public RedirectView updateProduct(@ModelAttribute Product product, HttpServletRequest request) {
		System.out.println(product);
		productdao.updateProduct(product);
		RedirectView redirectview = new RedirectView();
		redirectview.setUrl(request.getContextPath() + "/");
		return redirectview;
	}
}