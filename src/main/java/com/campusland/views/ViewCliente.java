package com.campusland.views;

import com.campusland.exceptiones.clienteexceptions.ClienteNullException;
import com.campusland.respository.models.Cliente;

public class ViewCliente extends ViewMain {

    public static void startMenu() {
        int op;
        do {
            op = mostrarMenu();
            switch (op) {
                case 1:
                    crearCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    buscarCliente();
                    break;
                case 4:
                    modificarCliente();
                    break;
                case 5:
                    eliminarCliente();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (op >= 1 && op < 6);
    }

    public static void buscarCliente() {
        Cliente cliente = buscarGetCliente();
        if (cliente != null) {
            cliente.imprimir();
        }
    }

    public static Cliente buscarGetCliente() {
        System.out.println("Busqueda de cliente ");
        leer.nextLine();
        System.out.print("Documento: ");
        String documento = leer.nextLine();

        try {
            return serviceCliente.porDocumento(documento);

        } catch (ClienteNullException e) {

            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void crearCliente() {
        leer.nextLine();
        System.out.print("Nombre: ");
        String nombre = leer.nextLine();
        System.out.print("Apellido: ");
        String apellido = leer.nextLine();
        System.out.print("Email: ");
        String email = leer.nextLine();
        System.out.print("Celular: ");
        String celular = leer.nextLine();
        System.out.print("Dirección: ");
        String direccion = leer.nextLine();
        System.out.print("Documentos: ");
        String documento = leer.nextLine();
        Cliente cliente = new Cliente(nombre, apellido, email, celular, direccion, documento);
        serviceCliente.crear(cliente);
    }

    public static void listarClientes() {
        for (Cliente cliente : serviceCliente.listar()) {
            cliente.imprimir();
        }
    }

    public static void modificarCliente() {
    Cliente clienteActual = buscarGetCliente();
    if (clienteActual != null) {
        System.out.println();
        clienteActual.imprimir();

        String nuevoNombre = obtener("nombre", clienteActual.getNombre());
        clienteActual.setNombre(nuevoNombre);

        String nuevoApellido = obtener("apellido", clienteActual.getApellido());
        clienteActual.setApellido(nuevoApellido);

        String nuevoEmail = obtener("email", clienteActual.getEmail());
        clienteActual.setEmail(nuevoEmail);

        String nuevoCelular = obtener("celular", clienteActual.getCelular());
        clienteActual.setCelular(nuevoCelular);

        String nuevoDireccion = obtener("direccion", clienteActual.getDireccion());
        clienteActual.setDireccion(nuevoDireccion);

        serviceCliente.editar(clienteActual);
    }
}

    public static void eliminarCliente() {
        Cliente clienteActual = buscarGetCliente();
        if (clienteActual != null) {
            clienteActual.imprimir();
            System.out.println("Eliminar cliente: si o no? ");
            String opcion = leer.nextLine();
            if (opcion.equalsIgnoreCase("si")) {
                serviceCliente.eliminar(clienteActual);
            }
        }
    }

    public static int mostrarMenu() {
        System.out.println("----Menu--Cliente----");
        System.out.println("1. Crear cliente.");
        System.out.println("2. Listar cliente.");
        System.out.println("3. Buscar cliente.");
        System.out.println("4. Modificar cliente.");
        System.out.println("5. Eliminar cliente.");
        System.out.println("6. Salir ");
        return leer.nextInt();
    }

    private static String obtener(String campo, String valor) {
    System.out.println("Modificar " + campo + ": si o no? ");
    String opcion = leer.nextLine();
    if (opcion.equalsIgnoreCase("si")) {
        System.out.println(campo + ": ");
        return leer.nextLine();
    }
    return valor;
}
}