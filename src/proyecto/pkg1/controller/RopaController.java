
package proyecto.pkg1.controller;

import java.util.Date;
import proyecto.pkg1.model.RopaModel;

public class RopaController {
    
    public static RopaModel[] datosRopa = new RopaModel [100];
    
    public void agregarRopa (int id, String nombre, int cantidad,Date caducidad){
        // Añadir datos al arreglo
           
            for (int i = 0;  i< datosRopa.length; i++){
                if (datosRopa [i] == null){
                    RopaModel rop = new RopaModel();
                    
                    rop.setId(id);
                    rop.setNombre(nombre);
                    rop.setCantidad(cantidad);
                    rop.setCaducidad (caducidad);
                    datosRopa [i] = rop;
                    
                    System.out.println("Se agrego la prenda con ID " + id + " exitosamente!" );
                    
                    return;
                            
                }
            }
    }
    
    public void verRopa(){
        
        for (RopaModel rop: datosRopa){
            if (rop != null ){
                System.out.println("-------------------------------");
                System.out.println(rop.getId ());
                System.out.println(rop.getNombre());
                System.out.println(rop.getCaducidad());
                System.out.println("-------------------------------");
            }
        }
    }
}