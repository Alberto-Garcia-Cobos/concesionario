/**
 *Clase vehiculo donde se implantan todos los metodos para coger los datos del nuevo vehiculo
 * a introducir en el concesionario.
 * Ejercicio 1 Programación Tema 8
 * @author Alberto García Cobos
 * @version 12.1 13/03/2021
 */
package progr09_Ejerc1.Vehiculo;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Clase vehiculo donde se generan las variables a utilizar y donde se implementa
 * la interfaz Comparable.
 * @author cobos
 */
public class Vehiculo implements Serializable, Comparable<Vehiculo> {
            //generamos variables
    private String marca;
    private String matricula;
    private int numKm;
    private String descripcion;
    private float precio;
    private String propietario;
    private  String DNI;
    private LocalDate fechaMatriculacion;
    
    
/**
 * Constructor de la clase Vehículo, donde le da valor a las variables.
 * @param marca
 * @param matricula
 * @param numKm
 * @param f_matriculacion
 * @param descripcion
 * @param precio
 * @param propietario
 * @param dni 
 */

    public Vehiculo(String marca, String matricula, int numKm, LocalDate f_matriculacion, String descripcion, 
            float precio, String propietario, String dni) {
        
        this.marca=marca;
        this.matricula=matricula;
        this.numKm=numKm;
        this.fechaMatriculacion=f_matriculacion;
        this.descripcion=descripcion;
        this.precio=precio;
        this.propietario=propietario;
        this.DNI=dni;
        
    }


    //Implementamos métodos
/**
 * Método get de la fecha de matriculación
 * @return fechaMatriculacion
 */
    public LocalDate getFechaMatriculacion() {
        return fechaMatriculacion;
    }
/**
 * Método set de fechaMatriculacion
 * @param fechaMatriculacion 
 */
    public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
        this.fechaMatriculacion = fechaMatriculacion;
    }
    
    /**
     * Método get Marca
     * @return marca
     */
    public String getMarca() {
        return marca;
    }
    /**
     * Método set marca
     * @param marca 
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }
    /**
     * Método get matricula
     * @return matricula
     */
    public String getMatricula() {  
        return matricula;
    }
    /**
     * Método set matricula
     * @param matricula 
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
        }
    
    /**
     * Método get Num_Km
     * @return numn_Km
     */
    public int getNum_Km() {
        return numKm;
    }
    /**
     * Método set num_Km
     * @param numKm 
     */
    public void setNum_Km(int numKm) {
        this.numKm = numKm;
    }
    /**
     * Método get Descripcion
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * Método set descripcion
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Método get precio
     * @return precio
     */
    public float getPrecio() {
        return precio;
    }
    /**
     * Método set precio
     * @param precio 
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    /**
     * Método get nombre
     * @return nombre
     */
    public String getPropietario() {
        return propietario;
    }
    /**
     * Método set Nombre
     * @param propietario
     */
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
    /**
     * Método get DNI
     * @return DNI
     */
    public String getDNI() {

        return DNI;
    }
    /**
     * Método set DNI
     * @param DNI 
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    
    /**
     * Método toString donde ponta el valor de todas las variables.
     * @return 
     */
    @Override
    public String toString(){
        return "El coche de marca: " + marca+ "\n Número de matricula: "
        + matricula+ "\n Precio: "+ precio + "\n Número de KM: "+ numKm + "\n Propietario: "
                + propietario+ "\n Descripción del venículo: "+descripcion;
    }

    /**
     * Método compareTo de la interfaz comparable, para ordenar los vehiculos
     * por la matricula insertada.
     * @param v
     * @return 
     */
    @Override
    public int compareTo(Vehiculo v) {
  
       return this.matricula.compareTo(v.matricula);
    }

}

