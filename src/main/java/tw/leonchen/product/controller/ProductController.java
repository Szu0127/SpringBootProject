package tw.leonchen.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.leonchen.product.model.Product;
import tw.leonchen.product.model.ProductService;

@Controller
@RequestMapping("/product")
@SessionAttributes(names = { "totalPages", "totalElements" })
public class ProductController {

	@Autowired
	private ProductService pService;

	@GetMapping("/findallmainaction.controller")
	public String processFindAll() {
		return "product/productQueryAll";
	}

	@PostMapping("/add")
	@ResponseBody
	public Product processInsertProductAction(@RequestBody Product p) {
		return pService.insertProduct(p);
	}

	@PostMapping("/update")
	@ResponseBody
	public Product processUpdateProductAction(@RequestBody Product p) {
		return pService.updateProduct(p);
	}

	@PostMapping("/delete")
	@ResponseBody
	public void processDeleteProductAction(@RequestBody Product p) {
		pService.deleteProduct(p);
	}

	@PostMapping("/query")
	@ResponseBody
	public Product processQueryByIdproductAction(@RequestParam("pid") int pid) {
		return pService.findById(pid);
	}

	@PostMapping("/queryAll")
	@ResponseBody
	public List<Product> processFindAllProductAction() {
		return pService.findAll();
	}

	@PostMapping("/queryByPage/{pageNo}")
	@ResponseBody
	public List<Product> findAllByPage(@PathVariable("pageNo") int pageNo, Model m) {
		int pageSize = 2;
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		Page<Product> page = pService.findAllByPage(pageable);
		m.addAttribute("totalPages", page.getTotalPages());
		m.addAttribute("totalElements", page.getTotalElements());
		return page.getContent();
	}
}
