package despacho.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/configuracion")
public class ConfiguracionController {

	@RequestMapping("/")
	public String index() {
		return "configuracion/index";
	}
}
