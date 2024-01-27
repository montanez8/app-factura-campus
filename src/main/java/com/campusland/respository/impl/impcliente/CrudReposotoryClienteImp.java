package com.campusland.respository.impl.impcliente;

import java.util.List;

import com.campusland.respository.CrudRepositoryCliente;
import com.campusland.respository.models.Cliente;
import com.campusland.utils.conexiones.conexionbdlist.ConexionBDList;

import static com.campusland.respository.impl.impcliente.CrudRepositoryClienteJsonImp.asiganar;

public class CrudReposotoryClienteImp implements CrudRepositoryCliente {

    ConexionBDList conexion = ConexionBDList.getConexion();

    @Override
    public List<Cliente> listar() {
        return conexion.getListaClientes();
    }

    @Override
    public Cliente porDocumento(String documento) {
        Cliente resultado = null;
        for (Cliente cliente : conexion.getListaClientes()) {
            if (cliente.getDocumento().equals(documento)) {
                resultado = cliente;
                break;
            }
        }
        return resultado;

    }

    @Override
    public void crear(Cliente cliente) {
        conexion.getListaClientes().add(cliente);
    }

    @Override
    public void editar(Cliente cliente) {
        for (Cliente clienteCurrent : conexion.getListaClientes()) {
            if (asiganar(cliente, clienteCurrent)) break;
        }

    }

    @Override
    public void eliminar(Cliente cliente) {
        for (Cliente clienteCurrent : conexion.getListaClientes()) {
            if (clienteCurrent.getDocumento().equals(cliente.getDocumento())) {
                conexion.getListaClientes().remove(clienteCurrent);
                break;
            }
        }

    }


}
