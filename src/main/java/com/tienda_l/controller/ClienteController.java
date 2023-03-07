package com.tienda_l.controller;

import com.tienda_l.domain.Cliente;
import com.tienda_l.dao.ClienteDao;
import com.tienda_l.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@Controller
@Slf4j
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping("/")
    public String inicio(Model model) {
        var clientes=clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        return "index";
    }
     @GetMapping("/cliente/nuevo")
    public String clienteNuevo(Cliente cliente) {
        
        return "modificaCliente";
}
     @PostMapping("/cliente/guardar")
    public String clienteGuardar(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/ ";
}
     @GetMapping("/cliente/eliminar/{idCliente}")
    public String clienteEliminar(Cliente cliente) {
        clienteService.delete(cliente);
          return "redirect:/ ";
}
       @GetMapping("/cliente/modificar/{idCliente}")
    public String clienteModificar(Cliente cliente,Model model) {
        cliente=clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
          return "modificaCliente";
}
}