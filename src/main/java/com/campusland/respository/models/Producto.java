package com.campusland.respository.models;

import com.campusland.utils.Formato;

import lombok.Data;


@Data
public class Producto {

    private int codigo;
    private String nombre;
    private String descripcion;
    private double precioVenta;
    private double precioCompra;
    private static int nextCodigo = 1;

    public Producto() {
        this.codigo = ++nextCodigo;
    }

    public Producto(String nombre, double precioVenta, double precioCompra, String descripcion) {
        this.codigo = ++nextCodigo;
        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
        this.descripcion = descripcion;
    }

    public double getUtilidad() {
        return this.precioVenta - this.precioCompra;
    }

    @Override
    public String toString() {
        return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", precioVenta=" + precioVenta + ", precioCompra="
                + precioCompra + "descripcion=" + descripcion + "]";
    }

    public String getCodigoNombre() {
        return this.codigo + " " + this.nombre + " " + Formato.formatoMonedaPesos(this.precioVenta);
    }


    public void imprimir() {
        StringBuilder imprimir = new StringBuilder();
        imprimir.append("Codigo: " + this.codigo + "\n");
        imprimir.append("Nombre: " + this.nombre + "\n");
        imprimir.append("Precio Venta: " + Formato.formatoMonedaPesos(this.precioVenta) + "\n");
        imprimir.append("Precio Compra: " + Formato.formatoMonedaPesos(this.precioCompra) + "\n");
        imprimir.append("Descripcion: " + this.descripcion + "\n");
        System.out.println(imprimir.toString());
    }

}
