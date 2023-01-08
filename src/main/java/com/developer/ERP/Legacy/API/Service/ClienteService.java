package com.developer.ERP.Legacy.API.Service;

import com.developer.ERP.Legacy.API.Exceptions.HandlerNotFoundException;
import com.developer.ERP.Legacy.API.Model.Cliente;
import com.developer.ERP.Legacy.API.Repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    public List<Cliente>listAll(){
        return clienteRepository.findAll();
    }
    public ResponseEntity <Cliente> saveCliente(Cliente cliente){
        Cliente saveClientes = clienteRepository.save(cliente);
        return ResponseEntity.ok().body(saveClientes);
    }
    public ResponseEntity <Cliente>findByCliente(Long id){
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(()->  new HandlerNotFoundException("Não foi possivel encontrar esse recurso:" + id));
        return ResponseEntity.ok().body(cliente);
    }
    public Cliente editar(Cliente cliente, Long id){
        Cliente editarOuSalvar = clienteRepository.findById(id).get();
        if (editarOuSalvar == null){
            throw new EmptyResultDataAccessException(1);
        }
        BeanUtils.copyProperties(cliente,editarOuSalvar,"id");
        return clienteRepository.save(editarOuSalvar);
    }
    public ResponseEntity<Map<String, Boolean>>remover(Long id){
        Cliente cliente = clienteRepository.findById(id)
                .orElse(null);
        clienteRepository.delete(cliente);

        Map <String,Boolean>response = new HashMap<>();
        response.put("removido com sucesso!!!!",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
