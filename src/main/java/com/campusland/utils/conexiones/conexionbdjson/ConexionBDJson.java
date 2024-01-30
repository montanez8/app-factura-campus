package com.campusland.utils.conexiones.conexionbdjson;

import com.campusland.respository.models.Cliente;
import com.campusland.respository.models.Factura;
import com.campusland.respository.models.Producto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
public class ConexionBDJson {
    public static ConexionBDJson conexion;
    private List<Cliente> listaClientes;
    private List<Producto> listaProductos;
    private List<Factura> listFacturas;

    public ConexionBDJson() {
        listFacturas = new ArrayList<>();
        listaClientes = new ArrayList<>();
        listaProductos = new ArrayList<>();
    }

    public static ConexionBDJson getConexion() {
        if (conexion == null) {
            conexion = new ConexionBDJson();
        }
        return conexion;
    }

    public List<Cliente> getDataClientes() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            listaClientes = objectMapper.readValue(new File("clientes.json"), new TypeReference<List<Cliente>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaClientes;
    }

    public void saveDateClientes(List<Cliente> listClientesUpdate) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            objectMapper.writeValue(new File("clientes.json"), listClientesUpdate);
            System.out.println("Se guardo los clientes en clientes.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
