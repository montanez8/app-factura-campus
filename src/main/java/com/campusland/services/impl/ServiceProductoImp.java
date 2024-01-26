package com.campusland.services.impl;

import com.campusland.respository.CrudRepositoryProducto;
import com.campusland.respository.models.Producto;
import com.campusland.services.ServiceProducto;
import java.util.List;

public class ServiceProductoImp implements ServiceProducto {
    private final CrudRepositoryProducto crudRepositoryProducto;

    public ServiceProductoImp(CrudRepositoryProducto crudRepositoryProducto) {
        this.crudRepositoryProducto = crudRepositoryProducto;
    }

    @Override
    public List<Producto> listar() {
        return this.crudRepositoryProducto.listar();
    }

    @Override
    public Producto porCodigo(int codigo) {
        Producto producto = this.crudRepositoryProducto.porCodigo(codigo);
        if (producto != null) {
            return producto;
        } else {
            return null;
        }


    }
    @Override
    public void crear(Producto producto) {
        this.crudRepositoryProducto.crear(producto);

    }

    @Override
    public void editar(Producto producto) {
        this.crudRepositoryProducto.editar(producto);

    }

    @Override
    public void eliminar(int codigo) {
        this.crudRepositoryProducto.eliminar(codigo);
    }
}
