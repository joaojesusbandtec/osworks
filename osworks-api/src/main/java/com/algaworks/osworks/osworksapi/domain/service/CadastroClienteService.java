package com.algaworks.osworks.osworksapi.domain.service;

import com.algaworks.osworks.osworksapi.domain.exception.NegocioException;
import com.algaworks.osworks.osworksapi.domain.model.Cliente;
import com.algaworks.osworks.osworksapi.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    public Cliente salvar(Cliente cliente) {
        Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
        
        if (clienteExistente != null && !clienteExistente.equals(cliente)) {
            throw new NegocioException("Já existe um cliente com este e-mail.");
        }
        
        return clienteRepository.save(cliente);
    }
    
    public void excluir(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }
}
