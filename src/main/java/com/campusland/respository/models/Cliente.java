package com.campusland.respository.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

   
    private String nombre;
    private String apellido;
    private String email;
    private String direccion;
    private String celular;   
    private String documento;


    public String getFullName(){
        return this.nombre+" "+this.apellido;

    }

    public void imprimir(){
        StringBuilder imprimir = new StringBuilder();
        imprimir.append("Documento: "+this.getDocumento().concat("\t"));
        imprimir.append("Nombre: "+this.getFullName().concat("\t"));
        imprimir.append("Email: "+this.getEmail().concat("\t"));
        imprimir.append("Celular: "+this.getCelular().concat("\t"));
        imprimir.append("Dirección: "+this.getDireccion().concat("\t"));
        System.out.println(imprimir.toString());

    }



    

    
}
