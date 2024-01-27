package com.campusland.respository.impl.impcliente;

import com.campusland.respository.CrudRepositoryCliente;
import com.campusland.respository.models.Cliente;
import com.campusland.utils.conexiones.conexionbdjson.ConexionBDJson;

import java.util.List;

public class CrudRepositoryClienteJsonImp implements CrudRepositoryCliente {

    ConexionBDJson conexion = ConexionBDJson.getConexion();

    @Override
    public List<Cliente> listar() {
        return conexion.getDataClientes();
    }

    @Override
    public Cliente porDocumento(String documento) {
        Cliente resultado = null;
        for (Cliente cliente : conexion.getDataClientes()) {
            if (cliente.getDocumento().equals(documento)) {
                resultado = cliente;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void crear(Cliente cliente) {
        List<Cliente> clientes = conexion.getDataClientes();
        clientes.add(cliente);
        conexion.saveDateClientes(clientes);

    }

    @Override
    public void editar(Cliente cliente) {
        List<Cliente> clientes = conexion.getDataClientes();
        for (Cliente clienteCurrent : clientes) {
            if (asiganar(cliente, clienteCurrent)) break;
        }
        conexion.saveDateClientes(clientes);

    }

    static boolean asiganar(Cliente cliente, Cliente clienteCurrent) {
        if (clienteCurrent.getDocumento().equals(cliente.getDocumento())) {
            clienteCurrent.setNombre(cliente.getNombre());
            clienteCurrent.setApellido(cliente.getApellido());
            clienteCurrent.setDireccion(cliente.getDireccion());
            clienteCurrent.setEmail(cliente.getEmail());
            clienteCurrent.setCelular(cliente.getCelular());
            return true;
        }
        return false;
    }

    @Override
    public void eliminar(Cliente cliente) {
        List<Cliente> clientes = conexion.getDataClientes();
        for (Cliente clienteCurrent : clientes) {
            if (clienteCurrent.getDocumento().equals(cliente.getDocumento())) {
                clientes.remove(clienteCurrent);
                break;
            }
        }
        conexion.saveDateClientes(clientes);
    }
}
