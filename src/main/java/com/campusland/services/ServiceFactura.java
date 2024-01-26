package com.campusland.services;

import com.campusland.respository.models.Factura;

import java.util.List;

public interface ServiceFactura {
    List<Factura> listar();
    void crear(Factura factura);
}
