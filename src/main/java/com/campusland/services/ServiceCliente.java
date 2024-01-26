package com.campusland.services;

import java.util.List;

import com.campusland.exceptiones.clienteexceptions.ClienteNullException;
import com.campusland.respository.models.Cliente;

public interface ServiceCliente {

    List<Cliente> listar();

    Cliente porDocumento(String documento)throws ClienteNullException ;

    void crear(Cliente cliente);

    void editar(Cliente cliente);

    void eliminar(String id);

}
