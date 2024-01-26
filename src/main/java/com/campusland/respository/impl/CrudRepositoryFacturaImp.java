package com.campusland.respository.impl;

import com.campusland.respository.CrudRepositoryFactura;
import com.campusland.respository.models.Factura;
import com.campusland.utils.ConexionBDList;

import java.util.List;

public class CrudRepositoryFacturaImp implements CrudRepositoryFactura {

    ConexionBDList conexion = ConexionBDList.getConexion();
    @Override
    public List<Factura> listar() {
        return conexion.getListFacturas();
    }

    @Override
    public void crear(Factura factura) {
        conexion.getListFacturas().add(factura);

    }
}
