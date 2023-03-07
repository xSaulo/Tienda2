
package com.tienda_l.service.impl;

import com.tienda_l.dao.ClienteDao;
import com.tienda_l.domain.Cliente;
import com.tienda_l.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteDao clienteDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Cliente> getClientes() {
       return (List<Cliente>)clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Cliente getCliente(Cliente cliente) {
      return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
     @Transactional
    public void save(Cliente cliente) {
      clienteDao.save(cliente);
    }

    @Override
     @Transactional
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }
    
}
