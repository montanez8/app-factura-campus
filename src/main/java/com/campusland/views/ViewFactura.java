package com.campusland.views;

import com.campusland.exceptiones.clienteexceptions.ClienteNullException;
import com.campusland.exceptiones.productoeexeptions.ProductoNullException;
import com.campusland.respository.models.*;

import java.time.LocalDateTime;

public class ViewFactura extends ViewMain {
    public static void startMenu() throws ClienteNullException, ProductoNullException {
        int op;
        while ((op = mostrarMenu()) >= 1 && op < 6) {
            if (op == 1)
                crearFactura();
            else if (op == 2)
                listarFactura();
            else if (op == 3)
                break;

            else
                System.out.println("Opcion no valida");
        }
    }

    private static void crearFactura() throws ClienteNullException, ProductoNullException {
        Cliente cliente = getCliente();
        if (cliente != null) {
            Factura factura = new Factura(LocalDateTime.now(), cliente);
            Producto producto = getProducto();
            if (producto != null) {
                factura.agregarItem(createItemFactura(producto));
                serviceFactura.crear(factura);
                System.out.println("\nFactura creada con exito\n");
            }
        }
    }

    private static Cliente getCliente() throws ClienteNullException {
        listarClientes();
        System.out.println("Ingrese el codigo del cliente");
        Cliente cliente = serviceCliente.porDocumento(leer.next());
        if (cliente == null)
            System.out.println("El cliente no existe");
        return cliente;
    }

    private static Producto getProducto() throws ProductoNullException {
        listarProductos();
        System.out.println("Ingrese el codigo del producto");
        Producto producto = serviceProducto.porCodigo(leer.nextInt());
        if (producto == null)
            System.out.println("El producto no existe");
        return producto;
    }

    private static ItemFactura createItemFactura(Producto producto) {
        ItemFactura itemFactura = new ItemFactura();
        itemFactura.setProducto(producto);
        System.out.println("Ingrese la cantidad");
        itemFactura.setCantidad(leer.nextInt());
        return itemFactura;
    }

    public static int mostrarMenu() {
        System.out.println("----Menu--Factura----\n1. Crear factura.\n2. Listar factura.\n3. Salir");
        return leer.nextInt();
    }

    public static void listarFactura() {
        System.out.println("Lista de Facturas");
        serviceFactura.listar().forEach(factura -> {
            factura.display();
            System.out.println();
        });
    }

    private static void listarProductos() {
        System.out.println("Listado de productos\n");
        serviceProducto.listar().forEach(Producto::imprimir);
    }

    public static void listarClientes() {
        System.out.println("Lista de Clientes");
        serviceCliente.listar().forEach(cliente -> {
            cliente.imprimir();
            System.out.println();
        });
    }
}