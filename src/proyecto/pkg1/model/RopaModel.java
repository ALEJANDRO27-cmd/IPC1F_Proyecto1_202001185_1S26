
package proyecto.pkg1.model;

import java.util.Date;

public class RopaModel {
    
   private int id;
   private String nombre;
   private int cantidad;
   private Date caducidad;
   private int precio;
   private String categoria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(Date caducidad) {
        this.caducidad = caducidad;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
     public String getCategoria() {
        return categoria;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
     public int getPrecio() {
        return precio;
    }


}