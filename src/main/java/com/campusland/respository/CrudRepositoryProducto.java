package com.campusland.respository;

import com.campusland.respository.models.Producto;

import java.util.List;

public interface CrudRepositoryProducto {

    List<Producto> listar();
    Producto porCodigo(int codigo);
    void crear(Producto producto);
    void editar(Producto producto);
    void eliminar(int codigo);



}
