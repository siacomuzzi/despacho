package despacho.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConfiguracionController {

	@RequestMapping("/configuracion")
    public String index() {
        return "configuracion";
    }

}
