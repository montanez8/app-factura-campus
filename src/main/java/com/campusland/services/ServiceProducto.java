package com.campusland.services;

import com.campusland.exceptiones.productoeexeptions.ProductoNullException;
import com.campusland.respository.models.Producto;

import java.util.List;

public interface ServiceProducto {

    List<Producto> listar();
    Producto porCodigo(int codigo) throws ProductoNullException;
    void crear(Producto producto);
    void editar(Producto producto);
    void eliminar(int codigo);



}
