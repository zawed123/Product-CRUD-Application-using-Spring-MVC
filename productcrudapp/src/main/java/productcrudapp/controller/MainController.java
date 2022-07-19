package productcrudapp.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcrudapp.dao.ProductDao;
import productcrudapp.model.Product;

@Controller
public class MainController {

	@Autowired
	private ProductDao productDao;

	@RequestMapping("/")
	public String home(Model m) {

		List<Product> products = productDao.getAllProducts();
		m.addAttribute("product", products);
		return "index";
	}

	@RequestMapping("/add-product")
	public String addProduct(Model model) {
		model.addAttribute("title", "Add Product");
		return "add_product_form";
	}

	@RequestMapping(path = "/handel-product", method = RequestMethod.POST)
	public RedirectView handelProduct(@ModelAttribute Product product, HttpServletRequest request) {
		System.out.println(product);
		this.productDao.createProduct(product);
		RedirectView redirectView = new RedirectView();

		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}

	@RequestMapping("/delete-product/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId, HttpServletRequest request) {
		
		this.productDao.deleteProduct(productId);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}

}
