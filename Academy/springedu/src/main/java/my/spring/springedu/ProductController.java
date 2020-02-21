package my.spring.springedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import vo.ProductVO;

@Controller
@SessionAttributes({ "psession" })
public class ProductController {
	@ModelAttribute("psession")
	public ProductVO prouctMethod() {
		return new ProductVO();
	}

	@RequestMapping("/product")
	public String handle1(@ModelAttribute("psession") ProductVO vo) {
		return "productView";

	}

	@RequestMapping("/productdel")
	public String handle2(SessionStatus s) {
		s.setComplete();
		return "ProductDel";
	}
}
