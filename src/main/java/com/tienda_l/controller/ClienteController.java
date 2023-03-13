package com.tienda_l.controller;

import com.tienda_l.domain.Cliente;
import com.tienda_l.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@Controller
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        var clientes=clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        return "/cliente/listado";
    }
     @GetMapping("/nuevo")
    public String clienteNuevo(Cliente cliente) {
        
        return "/cliente/modifica";
}
     @PostMapping("/guardar")
    public String clienteGuardar(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
}
     @GetMapping("/eliminar/{idCliente}")
    public String clienteEliminar(Cliente cliente) {
        clienteService.delete(cliente);
          return "redirect:/cliente/listado ";
}
       @GetMapping("/modificar/{idCliente}")
    public String clienteModificar(Cliente cliente,Model model) {
        cliente=clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
          return "/cliente/modifica";
}
}