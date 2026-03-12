
package proyecto.pkg1.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import proyecto.pkg1.model.RopaModel;

public class RopaController {
    
    public static RopaModel[] datosRopa = new RopaModel [100];
    
    public void agregarRopa (int id, String nombre, int cantidad, Date caducidad, String categoria, int precio){
        // Añadir datos al arreglo
           
            for (int i = 0;  i< datosRopa.length; i++){
                if (datosRopa [i] == null){
                    RopaModel rop = new RopaModel();
                    
                    rop.setId(id);
                    rop.setNombre(nombre);
                    rop.setCantidad(cantidad);
                    rop.setCaducidad(caducidad);
                    rop.setCategoria(categoria);
                    rop.setPrecio(precio);
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
                System.out.println(rop.getCategoria());
                System.out.println(rop.getPrecio());
                System.out.println("-------------------------------");
            }
        }
    }
    public void generarHTML() throws IOException{
        StringBuilder filas = new StringBuilder();
        
        for(RopaModel m: datosRopa){
            if(m==null) continue;
            
            filas.append("<tr>")
                    .append("<td>").append(m.getId()).append("</td>")
                    .append("<td>").append(m.getNombre()).append("</td>")
                    .append("<td>").append(m.getCantidad()).append("</td>")
                    .append("<td>").append(m.getCategoria()).append("</td>")
                    .append("<td>").append(m.getPrecio()).append("</td>")
                    .append("</td>");
        }
        
        String html =
                """
                <!doctype html>
                <html lang="es">
                    <head><meta charset="utf-8"><title>Reporte de Stock en tienda</title></head>
                    <body>
                        <h1>REPORTE DEL STOCK EN TIENDA</h1>
                        <p>GENERANDO REPORTE DEL STOCK</p>
                        <table>
                            <thead>
                             <tr><th>ID</th><th>Nombre</th><th>Cantidad</th><th>Categoria</th><th>precio</th></tr>
                            </thead>
                            <tbody>"""+
                filas+
                "</tbody>\n"
                +"</table>\n"
                +"</html>\n"
                ;
        
        
        java.time.LocalDateTime fecha = java.time.LocalDateTime.now();
        String nombre = String.format("%02d_%02d_%04d_%02d_%02d_%02d_Stock.html",
        fecha.getDayOfMonth(), fecha.getMonthValue(), fecha.getYear(),
        fecha.getHour(), fecha.getMinute(), fecha.getSecond());
        
        Files.write(Paths.get(nombre), html.getBytes(StandardCharsets.UTF_8));
        System.out.println("Se generó el html exitosamente!");
    }
}