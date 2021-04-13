package progr09_Ejerci1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;
import progr09_Ejerc1.Vehiculo.Vehiculo;

/**
 *Clase Concesionario donde se implantan los métodos necesarios para el funcionamiento
 * del programa. Corresponde a la tarea del tema 8 de programación.
 * @author Alberto García Cobos
 * @version 12.1 13/03/2021
 */


/**
 * Clase Concesionario, donde se pasan parametros y se crea el arrayList para guardar
 * todos los objetos vehículo.
 * @author cobos
 */
public class Concesionario implements Serializable {

    //Atributos
    /*Creamos el ArrayList por su fácil manejo y versatilidad, a demás quería poder darle 
    una oportunidad a esta lista. Su manejo y facilidad de ordenar y de implementar me han resultado
    muy sencillas y manejables para futuros. 
    A demás tiene la ventaja de que no te limita en el acceso de objeto adaptandose
    a la cantidad que se vaya introduciendo.
    */
    ArrayList<Vehiculo> vehiculos=new ArrayList<Vehiculo>();
    private int numVehiculos;
   
/**
 * Metodo getVehiculos del array vehiculo
 * @return vehiculos
 */   
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
/**
 * Método setVehiculo del array vehiculo
 * @param vehiculos 
 */
    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    

 /**
  * Constructor de la clase Concesionario
  */   
    public Concesionario(){
         
         
    }

/**
 * Método buscaVehiculo se encarga de verificar y encontrar el vehiculo en 
 * el concesionario, de no encontrarse el vehiculo devuelve null.
 * @param matricula
 * @return El vehiculo encontrado o null.
 */   
    public String buscaVehiculo(String matricula){
                    
                    for(Vehiculo veh:vehiculos){
                    if(veh!=null && matricula.equals(veh.getMatricula())){                       
                        return veh.toString();
                  
    }
    }return null;
    }   
/**
 * Método insertarVehiculo encargado de recibir y guardar todos los parametros
 * del vehiculo nuevo a ingresar, instanciado de la clase Vehiculo.
 * En el caso de ingresar el vehiculo con exito devuelve 0, si esta lleno el concesionario
 * devuelve -1 y si ya existe esa matricula -2.
 * @param marca
 * @param matricula
 * @param numKm
 * @param f_matriculacion
 * @param descripcion
 * @param precio
 * @param propietario
 * @param dni
 * @return 
 */
    public int insertarVehiculo(String marca, String matricula,int numKm, 
            LocalDate f_matriculacion,String descripcion, float precio, String propietario, String dni){
        int num = 0;
        Vehiculo veh=new Vehiculo(marca, matricula, numKm, f_matriculacion, descripcion, precio, propietario, dni);  
            vehiculos.add(veh);  //Asigna el vehiculo a la estructura de datos.
            
            Collections.sort(vehiculos);//Se indica la ordenación natural
            
        //Creamos condiciones para devolver en cada caso su número
                    for(Vehiculo art:vehiculos){                   
                    if(matricula.equals(art.getMatricula())){                       
                        return -2;
                    }else if(numVehiculos==50){
                        return -1;
                    }else if(veh != null){
                        return 0;
                    }
                        
        }
        return num;
    }
    

    
 /**
  * Método listaVehiculos se encarga de listar todos los vehículos ingresados
  * en el concesionario.
  */ 
    public void listaVehiculos(){
                    
                    for(Vehiculo veh:vehiculos){
                    if(veh!=null){ 
                        System.out.println(veh.toString());
                    };
                    
    }
    
}
/**
 * Método actualizaKm se encargar de recibir una matricula y los nuevos Km para
 * actualizarlos en el concesionario. 
 * En el caso de recibirlos correctamente devuelve true en el caso de no existir
 * esa matricula devuelve false.
 * @param matricula
 * @param kmNuevos
 * @return 
 */
    public boolean actualizaKm(String matricula, int kmNuevos){
                    
                    for(Vehiculo veh:vehiculos){
                    if(matricula.equals(veh.getMatricula())){
                        veh.setNum_Km(kmNuevos);
                        return true;
                    }
                    }return false;  
            
    }
    
    public void borraVehiculo(String matricula){
        
                for(Vehiculo veh:vehiculos){
                    if(matricula.equals(matricula)){
                        vehiculos.remove(veh);
                    }
                }
    }
}

