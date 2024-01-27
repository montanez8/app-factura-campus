package com.campusland.respository.impl;

import com.campusland.respository.CrudRepositoryProducto;
import com.campusland.respository.models.Producto;
import com.campusland.utils.conexiones.conexionbdlist.ConexionBDList;

import java.util.List;

public class CrudRepositoryProductoImp implements CrudRepositoryProducto {

    ConexionBDList conexion = ConexionBDList.getConexion();
    @Override
    public List<Producto> listar() {
        return conexion.getListaProductos();
    }

    @Override
    public Producto porCodigo(int codigo) {
           Producto resultado = null;
            for (Producto producto : conexion.getListaProductos()) {
                if (producto.getCodigo() == codigo) {
                    resultado = producto;
                    break;
                }
            }
            return resultado;

    }

    @Override
    public void crear(Producto producto) {
        conexion.getListaProductos().add(producto);

    }

    @Override
    public void editar(Producto producto) {
        for (Producto product : conexion.getListaProductos()) {
            if (product.getCodigo() == producto.getCodigo()) {
                product.setNombre(producto.getNombre());
                product.setDescripcion(producto.getDescripcion());
                product.setPrecioCompra(producto.getPrecioCompra());
                break;
            }
        }

    }

    @Override
    public void eliminar(int codigo) {
        for (Producto producto : conexion.getListaProductos()) {
            if (producto.getCodigo() == codigo) {
                conexion.getListaProductos().remove(producto);
                break;
            }

        }

    }
}
