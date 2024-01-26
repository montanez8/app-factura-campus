package com.campusland.services.impl;

import com.campusland.respository.CrudRepositoryFactura;
import com.campusland.respository.models.Factura;
import com.campusland.services.ServiceFactura;

import java.util.List;

public class ServiceFacturaImp implements ServiceFactura {
    private final CrudRepositoryFactura crudRepositoryFactura;


    public ServiceFacturaImp(CrudRepositoryFactura crudRepositoryFactura){
        this.crudRepositoryFactura = crudRepositoryFactura;
    }
    @Override
    public List<Factura> listar() {
        return crudRepositoryFactura.listar();

    }

    @Override
    public void crear(Factura factura) {
    this.crudRepositoryFactura.crear(factura);
    }
}
