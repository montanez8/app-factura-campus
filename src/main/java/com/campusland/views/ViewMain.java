package com.campusland.views;

import java.util.Scanner;

import com.campusland.exceptiones.clienteexceptions.ClienteNullException;
import com.campusland.exceptiones.productoeexeptions.ProductoNullException;
import com.campusland.respository.impl.CrudRepositoryFacturaImp;
import com.campusland.respository.impl.CrudRepositoryProductoImp;
import com.campusland.respository.impl.impcliente.CrudRepositoryClienteJsonImp;
import com.campusland.respository.impl.impcliente.CrudRepositoryMysqlImp;
import com.campusland.respository.impl.impcliente.CrudReposotoryClienteImp;
import com.campusland.services.ServiceCliente;
import com.campusland.services.ServiceFactura;
import com.campusland.services.ServiceProducto;
import com.campusland.services.impl.*;


public class ViewMain {

  //  public static final ServiceCliente serviceCliente = new ServiceClienteImpl(new CrudReposotoryClienteImp());
  //  public static final ServiceCliente serviceCliente = new ServiceClienteImpl(new CrudRepositoryClienteJsonImp());
    public static final ServiceCliente serviceCliente = new ServiceClienteImpl(new CrudRepositoryMysqlImp());
    public static final ServiceProducto serviceProducto = new ServiceProductoImp(new CrudRepositoryProductoImp());
    public static final ServiceFactura serviceFactura = new ServiceFacturaImp(new CrudRepositoryFacturaImp());
    public static  Scanner leer = new Scanner(System.in);

    public static void main(String[] args) throws ClienteNullException, ProductoNullException {

        int op = 0;

        do {

            op = menuMain();
            switch (op) {
                case 1:
                    ViewCliente.startMenu();
                    break;
                case 2:
                    ViewProducto.startMenu();
                    break;
                case 3:
                    ViewFactura.startMenu();
                    break;
                default:
                    System.out.println("Fin");
                    break;
            }

        } while (op >= 1 && op < 4);

    }

    public static int menuMain() {
        System.out.println("---Aplicación de Facturación-----");
        System.out.println("1. Modulo de Cliente");
        System.out.println("2. Modulo de Producto");
        System.out.println("3. Modulo de Factura");
        System.out.println("4. Salir:");
        return leer.nextInt();
    }
}