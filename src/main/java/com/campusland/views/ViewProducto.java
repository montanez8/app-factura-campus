package com.campusland.views;
import com.campusland.exceptiones.productoeexeptions.ProductoNullException;
import com.campusland.respository.models.Producto;
public class ViewProducto extends ViewMain{


    public static void startMenu() {

        int op = 0;

        do {

            op = mostrarMenu();
            switch (op) {
                case 1:
                    crearProducto();
                    break;
                case 2:
                    listarProductos();
                    break;
                case 3:
                    buscarGetProducto();
                    break;
                case 4:
                    modificarProducto();
                    break;
                case 5:
                    eliminarProducto();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (op >= 1 && op < 6);

    }

    private static void eliminarProducto() {
        Producto producto = buscarGetProducto();
        if (producto != null) {
            System.out.println();
            System.out.println("Desea eliminar el producto si o no");
            leer.nextLine();
            String opcion = leer.nextLine().toLowerCase();
            if (opcion.equalsIgnoreCase("si")){
                serviceProducto.eliminar(producto.getCodigo());
            }
        }
    }

    private static Producto buscarGetProducto() {
        System.out.println("Búsqueda de producto ");
        leer.nextLine();
        System.out.print("Codigo: ");
        int codigo = leer.nextInt();

        try {
            Producto producto = serviceProducto.porCodigo(codigo);
            System.out.println();
            producto.imprimir();
            return producto;
        } catch (ProductoNullException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    private static void modificarProducto() {
        Producto producto = buscarGetProducto();
        if (producto != null) {
            System.out.println();
            producto.imprimir();

            producto.setNombre(getInputActualizar("Desea modificar el nombre Producto si o no",
                    "Nombre: ", producto.getNombre()));
            producto.setPrecioVenta(Double.parseDouble(getInputActualizar("Desea modificar el precio de venta si o no",
                    "Precio Venta: ", String.valueOf(producto.getPrecioVenta()))));
            producto.setPrecioCompra(Double.parseDouble(getInputActualizar("Desea modificar el precio de compra si o no",
                    "Precio Compra: ", String.valueOf(producto.getPrecioCompra()))));
            producto.setDescripcion(getInputActualizar("Desea modificar la descripcion si o no",
                    "Descripcion: ", producto.getDescripcion()));

            serviceProducto.editar(producto);
        }
    }

    private static String getInputActualizar(String respuesta, String valor, String valorActual) {
        System.out.println(respuesta);
        leer.nextLine();
        String opcion = leer.nextLine().toLowerCase();
        if (opcion.equalsIgnoreCase("si")){
            System.out.println(valor);
            return leer.nextLine();
        }
        return valorActual;
    }
    
    private static void listarProductos() {
        System.out.println("Listado de productos");
        System.out.println();
        serviceProducto.listar().forEach(producto -> producto.imprimir());
    }

    private static void crearProducto() {
        System.out.println("Creacion de producto");
        leer.nextLine();
        System.out.print("Nombre: ");
        String nombre = leer.nextLine();
        System.out.println("Precio Venta: ");
        double precioVenta = leer.nextDouble();
        System.out.println("Precio Compra: ");
        double precioCompra = leer.nextDouble();
        System.out.println("Descripcion: ");
        leer.nextLine();
        String descripcion = leer.nextLine();
        Producto producto = new Producto(nombre, precioVenta, precioCompra, descripcion);
        serviceProducto.crear(producto);
    }

    public static int mostrarMenu() {
        System.out.println("---Modulo de Producto-----");
        System.out.println("1. Crear Producto");
        System.out.println("2. Listar Productos");
        System.out.println("3. Buscar Producto");
        System.out.println("4. Modificar Producto");
        System.out.println("5. Eliminar Producto");
        System.out.println("6. Salir:");
        return leer.nextInt();
    }
}
