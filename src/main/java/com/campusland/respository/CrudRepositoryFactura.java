package com.campusland.respository;

import com.campusland.respository.models.Factura;

import java.util.List;

public interface CrudRepositoryFactura {
    List<Factura> listar();
    void crear(Factura factura);

}
