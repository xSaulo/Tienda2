package com.tienda_l.controller;



import com.tienda_l.domain.Cliente;
import com.tienda_l.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@Controller

public class IndexController {
    @Autowired
    private ArticuloService articuloService;
    @GetMapping("/")
    public String inicio(Model model) {
     var articulos=articuloService.getArticulos(true);
        model.addAttribute("articulos", articulos);
       
          return "index";
}
}