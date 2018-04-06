package kr.ac.hansung.cse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.cse.model.Product;
import kr.ac.hansung.cse.service.ProductService;


@Controller
public class ProductController {//이 클래스에 Bin을 자동으로 관리

	//Controller -> service ->dao
	@Autowired
	private ProductService productServices;
	
	@RequestMapping("/products")// url을 보내게 되면 아래의 method가 수행
	public String getProducts(Model model) {
		
		List<Product> products = productServices.getProducts();
		model.addAttribute("products", products); //위의 products를 ("products", products)의 하단부에 
		
		return "products";// viewㅇ's logical name
		
	}
	
	@RequestMapping("/viewProduct/{productId}") 
	public String viewProduct(@PathVariable int productId, Model model) 
	{        
		Product product = productServices.getProductById(productId);
		model.addAttribute("product", product);
        return "viewProduct";     
    }
	
}
