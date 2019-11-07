package maintenance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	@RequestMapping(value = { "/", "/home", "index" })
	private ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting","welcome to Spring web mcv"); 
		return mv;
	}
}
