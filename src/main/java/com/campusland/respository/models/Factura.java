package com.campusland.respository.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.campusland.utils.Formato;

import lombok.Data;

@Data
public class Factura {

    private int numeroFactura;
    private LocalDateTime fecha;
    private Cliente cliente;
    private List<ItemFactura> items;
    private static int nextNumeroFactura;

    public Factura(LocalDateTime fecha, Cliente cliente) {
        this.numeroFactura = ++nextNumeroFactura;
        this.fecha = fecha;
        this.cliente = cliente;
        this.items = new ArrayList<>();
    }

    public double getTotalFactura() {
        double totalFactura = 0;
        for (ItemFactura item : items) {
            totalFactura += item.getImporte();
        }
        return totalFactura;
    }

    public void agregarItem(ItemFactura item){
        this.items.add(item);
    }

    public void display() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("Factura: ").append(this.numeroFactura).append("\n");
        sb.append("Cliente: ").append(this.cliente.getFullName()).append("\n");
        sb.append("Fecha: ").append(Formato.formatoFechaHora(this.getFecha())).append("\n");
        sb.append("-----------Detalle Factura----------------------").append("\n");
        for (ItemFactura item : this.items) {
            sb.append("Producto: ").append(item.getProducto().getCodigoNombre()).append("\n");
            sb.append("Cantidad: ").append(item.getCantidad()).append("\n");
            sb.append("Precio: ").append(Formato.formatoMonedaPesos(item.getImporte())).append("\n");
            sb.append("\n");

        }
        sb.append("Total: ").append(Formato.formatoMonedaPesos(this.getTotalFactura())).append("\n");
        sb.append("\n");
        System.out.println(sb.toString());
    }

}
