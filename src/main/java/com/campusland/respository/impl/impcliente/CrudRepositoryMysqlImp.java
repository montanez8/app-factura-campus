package com.campusland.respository.impl.impcliente;

import com.campusland.respository.CrudRepositoryCliente;
import com.campusland.respository.models.Cliente;
import com.campusland.utils.conexiones.conexionbdmysql.ConexionBDMysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrudRepositoryMysqlImp implements CrudRepositoryCliente {

 private Connection getConnection() throws SQLException {
  return ConexionBDMysql.getConnexion();
 }

    @Override
    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Cliente")) {
            while (resultSet.next()) {
                Cliente cliente = getCliente(resultSet);
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    @Override
    public Cliente porDocumento(String documento) {
        Cliente cliente = null;
        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Cliente WHERE documento = " + documento)) {
            while (resultSet.next()) {
                cliente = getCliente(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    @Override
public void crear(Cliente cliente) {
    String sql = "INSERT INTO Cliente (documento, nombre, apellido, email, direccion, celular) VALUES (?, ?, ?, ?, ?, ?)";

    try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
        preparedStatement.setString(1, cliente.getDocumento());
        preparedStatement.setString(2, cliente.getNombre());
        preparedStatement.setString(3, cliente.getApellido());
        preparedStatement.setString(4, cliente.getEmail());
        preparedStatement.setString(5, cliente.getDireccion());
        preparedStatement.setString(6, cliente.getCelular());
        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    @Override
    public void editar(Cliente cliente) {
     String sql = "UPDATE Cliente SET nombre = ?, apellido = ?, email = ?, direccion = ?, celular = ? WHERE documento = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setString(2, cliente.getApellido());
            preparedStatement.setString(3, cliente.getEmail());
            preparedStatement.setString(4, cliente.getDireccion());
            preparedStatement.setString(5, cliente.getCelular());
            preparedStatement.setString(6, cliente.getDocumento());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Cliente cliente) {
        String sql = "DELETE FROM Cliente WHERE documento = " + cliente.getDocumento();
        try (Statement statement = getConnection().createStatement()) {
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static Cliente getCliente(ResultSet resultSet) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setDocumento(resultSet.getString("documento"));
        cliente.setNombre(resultSet.getString("nombre"));
        cliente.setApellido(resultSet.getString("apellido"));
        cliente.setEmail(resultSet.getString("email"));
        cliente.setDireccion(resultSet.getString("direccion"));
        cliente.setCelular(resultSet.getString("celular"));
        return cliente;
    }
}
