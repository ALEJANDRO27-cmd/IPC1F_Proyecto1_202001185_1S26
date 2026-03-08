
package Singleton;

public class SigletonId {
     Private static  final SingletonId instancia = new SingletonId();
     Private int idRopa = 0;
     
     Private SingletonId(){}
     
     public static SingletonId gerInstancia (){
         return instancia;
     }
}
