package kr.ac.hansung.cse.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.hansung.cse.model.Product;
import kr.ac.hansung.cse.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired // controller는 service레이어를 설정해야함
	private ProductService productService;

	@RequestMapping // /admin이 실행됬을때 아래 함수가 호출
	public String adminPage() {
		return "admin";
	}

	@RequestMapping("/productInventory")
	public String getProducts(Model model) { // controller -> model -> view
		List<Product> products = productService.getProducts();
		model.addAttribute("products", products);

		return "productInventory";
	}

	@RequestMapping(value = "/productInventory/addProduct", method = RequestMethod.GET)
	public String addProduct(Model model) {
		// model은 key value로 이루어져 있는데 key값으로 넘겨준다.

		Product product = new Product();
		product.setCategory("컴퓨터");

		model.addAttribute("product", product);

		return "addProduct";
	}

	@RequestMapping(value = "/productInventory/addProduct", method = RequestMethod.POST)
	public String addProductPost(@Valid Product product, BindingResult result) {

		if (result.hasErrors()) {

			System.out.println("From data has some errors");
			List<ObjectError> errors = result.getAllErrors();

			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());

			}
			return "addProduct";
		}

		productService.addProduct(product);
		
		return "redirect:/admin/productInventory";// redirect를 안해주면 반영이 안된다.
	}

	@RequestMapping(value = "/productInventory/deleteProduct/{id}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable int id) {

		Product product = productService.getProductById(id);
		
		productService.deleteProduct(product);

		return "redirect:/admin/productInventory";

	}

	@RequestMapping(value = "/productInventory/updateProduct/{id}", method = RequestMethod.GET)
	public String updateProduct(@PathVariable int id, Model model) {// model 객체를 생성

		Product product = productService.getProductById(id);

		model.addAttribute("product", product);

		return "updateProduct";

	}

	@RequestMapping(value = "/productInventory/updateProduct", method = RequestMethod.POST)
	public String updateProductPost(@Valid Product product, BindingResult result) {

		// System.out.println(product);

		if (result.hasErrors()) {

			System.out.println("From data has some errors");
			List<ObjectError> errors = result.getAllErrors();

			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());

			}
			return "updateProduct";
		}

		productService.updateProduct(product);
			
		return "redirect:/admin/productInventory";// redirect를 안해주면 반영이 안된다.
	}

}
